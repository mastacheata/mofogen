package com.android.forge.contacts2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.exp.ExpressionFactory;
import org.apache.cayenne.query.SelectQuery;

import com.android.forge.DataGenerator;
import com.android.forge.ProviderGenerator;

public class ContactGenerator extends ProviderGenerator {

	public ContactGenerator(int create, int update, int delete) {
		super(create, update, delete);
		readDb();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void readDb() {
		// Read raw_contacts table into objects
		SelectQuery selectRawContacts = new SelectQuery(RawContacts.class);
		List rawContacts = DataGenerator.context.performQuery(selectRawContacts);
		providers.put(RawContacts.class.getName(), new ArrayList<CayenneDataObject>(rawContacts));
		
		// Read contacts table into objects
		SelectQuery selectContacts = new SelectQuery(Contacts.class);
		List contacts = DataGenerator.context.performQuery(selectContacts);
		providers.put(Contacts.class.getName(), new ArrayList<CayenneDataObject>(contacts));
		
		// Read data table into objects
		SelectQuery selectData = new SelectQuery(Data.class);
		List data = DataGenerator.context.performQuery(selectData);
		providers.put(Data.class.getName(), new ArrayList<CayenneDataObject>(data));
	}
	
	@Override
	public void create() {
		RawContacts rawContact = DataGenerator.context.newObject(RawContacts.class);
		rawContact.generate();
		created.add(rawContact);
		// Add created object to providers list
		providers.get(rawContact.getClass().getName()).add(rawContact);
		
		Contacts contact = DataGenerator.context.newObject(Contacts.class);
		contact.setRawContact(rawContact);
		contact.generate();
		created.add(contact);
		providers.get(contact.getClass().getName()).add(contact);
	
		// Select MIME Types needed for generation of Data Objects
		SelectQuery selectMimetypes = new SelectQuery(Mimetypes.class);
		Expression types = ExpressionFactory.inExp("mimetype", "vnd.android.cursor.item/postal-address_v2", "vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/organization", "vnd.android.cursor.item/name"); 
		selectMimetypes.andQualifier(types);
		List<Mimetypes> mimetypes = DataGenerator.context.performQuery(selectMimetypes);
		
		ArrayList<Data> tmpData = new ArrayList<Data>();
		Data dataObj;
		for (Mimetypes type : mimetypes) {
			dataObj = DataGenerator.context.newObject(Data.class);
			dataObj.setMimetype(type);
			dataObj.setRawContacts(rawContact);
			dataObj.generate();
			tmpData.add(dataObj);
		}
		created.addAll(tmpData);
		providers.get(Data.class.getName()).addAll(tmpData);
	}

	@Override
	public void update() {
		readDb();
		ArrayList<CayenneDataObject> rawContacts = providers.get(RawContacts.class.getName());
		Random rnd = new Random();
		RawContacts rawContact = (RawContacts) rawContacts.get(rnd.nextInt(rawContacts.size()));
		
		try {
			RawContacts oldContact = (RawContacts) rawContact.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		rawContact.generate();
		
		Contacts contact = rawContact.getContact();
		
		//TODO save old object by cloning
		contact.generate();
		
		List<Data> data = rawContact.getData();
		for (Data item : data) {
			
			//TODO save old object by cloning
			item.generate();
		}
	}

	@Override
	public void delete() {
		readDb();
		ArrayList<CayenneDataObject> rawContacts = providers.get(RawContacts.class.getName());
		Random rnd = new Random();
		RawContacts rawContact = (RawContacts) rawContacts.get(rnd.nextInt(rawContacts.size()));
		
		DataGenerator.context.deleteObjects(rawContact.getContact());
		DataGenerator.context.deleteObjects(rawContact.getData());
		DataGenerator.context.deleteObjects(rawContact);
	}
}
