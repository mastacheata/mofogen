package com.android.forge;

import java.util.ArrayList;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;

public class DataGenerator {

	public static long startDate, endDate;
	public static ObjectContext context;
	
	private ArrayList<ProviderGenerator> generators = new ArrayList<ProviderGenerator>();

	public DataGenerator(long startDate, long endDate) {
		DataGenerator.startDate = startDate;
		DataGenerator.endDate = endDate;
		ServerRuntime cayenneRuntime = new ServerRuntime("cayenne-AndroidForGe.xml");
		DataGenerator.context = cayenneRuntime.getContext();
	}
	
	public void register(ProviderGenerator gen) {
		generators.add(gen);
	}
	
	public void generate() {	
		for (ProviderGenerator gen : generators) {
			gen.generate();
			context.commitChanges();
		}
	}

	@Override
	public String toString() {
		String stringrep = "<DataGenerators>\n\t";
		
		for (ProviderGenerator gen : generators) {
			stringrep += gen.toString();
		}
		
		stringrep += "\n</DataGenerators>";
		
		return stringrep;
	}
	
}