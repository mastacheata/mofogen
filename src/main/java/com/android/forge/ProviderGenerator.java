package com.android.forge;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.cayenne.CayenneDataObject;

public abstract class ProviderGenerator {
	int create = 0;
	int update = 0;
	int delete = 0;
	
	protected HashMap<String, ArrayList<CayenneDataObject>> providers = new HashMap<String, ArrayList<CayenneDataObject>>();
	protected ArrayList<CayenneDataObject> created = new ArrayList<CayenneDataObject>();
	protected HashMap<CayenneDataObject, ArrayList<CayenneDataObject>> updated = new HashMap<CayenneDataObject, ArrayList<CayenneDataObject>>();
	protected ArrayList<CayenneDataObject> deleted = new ArrayList<CayenneDataObject>();
	
	public ProviderGenerator() {}
	
	public ProviderGenerator(int create, int update, int delete) {
		super();
		this.create = create;
		this.update = update;
		this.delete = delete;
	}
	
	public void generate() {
		while (create > 0) {
			create();
			create--;
		}
		DataGenerator.context.commitChanges();
		
		while (update > 0) {
			update();
			update--;
		}
		DataGenerator.context.commitChanges();
		
		while (delete > 0) {
			delete();
			delete--;
		}
		DataGenerator.context.deleteObjects(deleted);
		DataGenerator.context.commitChanges();
	}
	
	public abstract void create();
	
	public abstract void update();
	
	public abstract void delete();
	
	protected abstract void readDb();
	
	@Override
	public String toString() {
		String className = this.getClass().getName();
		String stringrep = "<" + className + ">\n\t";
		
		for (CayenneDataObject item : created) {
			stringrep += "<created>\n\t";	
			stringrep += item.toString();
			stringrep += "\n</created>";
		}
		
		for (CayenneDataObject item : updated.keySet()) {
			stringrep += "<updated>\n\t";
			stringrep += item.toString();
			stringrep += "\n</updated>";
		}
		
		for (CayenneDataObject item : deleted) {
			stringrep += "<deleted>\n\t";
			stringrep += item.toString();
			stringrep += "\n</deleted>";
		}
		
		for (String type : providers.keySet()) {
			stringrep += "<current>\n\t";

			for (CayenneDataObject item : providers.get(type)) {
				stringrep += "<" + type + ">\n\t";
				stringrep += item.toString();
				stringrep += "\n</" + type + ">";
			}
			
			stringrep += "\n</current>";
		}
		
		stringrep += "\n<" + className + ">";
		
		return stringrep;
	}
}
