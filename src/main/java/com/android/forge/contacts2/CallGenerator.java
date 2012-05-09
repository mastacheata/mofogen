package com.android.forge.contacts2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.query.SelectQuery;

import com.android.forge.DataGenerator;
import com.android.forge.ProviderGenerator;

public class CallGenerator extends ProviderGenerator {

	public CallGenerator(int create, int update, int delete) {
		super(create, update, delete);
		readDb();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void readDb() {
		SelectQuery selectCalls = new SelectQuery(Calls.class);
		List calls = DataGenerator.context.performQuery(selectCalls);
		providers.put(Calls.class.getName(), new ArrayList<CayenneDataObject>(calls));
	}
	
	@Override
	public void create() {
		Calls newCall = DataGenerator.context.newObject(Calls.class);
		newCall.generate();
		created.add(newCall);
	}

	@Override
	public void update() {
		readDb();
		Random rnd = new Random();
		
		ArrayList<CayenneDataObject> calls = providers.get(Calls.class.getName());	
		Calls newCall =	(Calls) calls.get(rnd.nextInt(calls.size()));
		Calls oldCall = (Calls) newCall.clone();
		newCall.generate();
		
		ArrayList<CayenneDataObject> updatedList;
		
		if (updated.containsKey(oldCall)) {
			updatedList = updated.get(oldCall);
			updated.remove(oldCall);
		} else {
			updatedList = new ArrayList<CayenneDataObject>();
		}
		
		updatedList.add(oldCall);
		updated.put(newCall, updatedList);
	}

	@Override
	public void delete() {
		readDb();
		Random rnd = new Random();
		ArrayList<CayenneDataObject> calls = providers.get(Calls.class.getName());
		deleted.add(calls.get(rnd.nextInt(calls.size())));
	}
}