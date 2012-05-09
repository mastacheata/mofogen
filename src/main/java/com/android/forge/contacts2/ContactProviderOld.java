package com.android.forge.contacts2;

import java.util.ArrayList;

import com.android.forge.CombinedProvider;
import com.android.forge.Provider;

public class ContactProviderOld implements CombinedProvider{
	private ArrayList<Provider> containedItems = new ArrayList<Provider>();
	
	public ContactProviderOld() {}
	
//	public ContactProvider(RawContact rawContact, Contact contact, ArrayList<Data> data) {
//		containedItems.add(rawContact);
//		containedItems.add(contact);
//		for (Data item : data) {
//			containedItems.add(item);
//		}
//	}
	
	public ContactProviderOld create() {
//		RawContact rawContact = new RawContact().create();
//		int rcid = rawContact.getId();
//		
//		containedItems.add(rawContact);
//		containedItems.add(new Contact(rcid).create());
//		containedItems.add(new Data(rcid, Data.STRUCTURED_NAME).create());
//		containedItems.add(new Data(rcid, Data.EMAIL).create());
//		containedItems.add(new Data(rcid, Data.STRUCTURED_POSTAL).create());
//		containedItems.add(new Data(rcid, Data.PHONE).create());
		
		return this;
	}
	
	public ContactProviderOld update() {
		for (Provider item : containedItems) {
			item.update();
		}
		return this;
	}
	
	public ContactProviderOld delete() {
		for (Provider item : containedItems) {
			item.delete();
		}
		return this;
	}
}
