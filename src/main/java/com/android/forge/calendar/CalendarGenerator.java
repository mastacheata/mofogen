package com.android.forge.calendar;

import java.util.Random;

import com.android.forge.ProviderGenerator;

public class CalendarGenerator extends ProviderGenerator {

	public CalendarGenerator(int create, int update, int delete) {
		super(create, update, delete);
	}
	
	@Override
	public void create() {
//		CalendarProvider tmpCalendar = new CalendarProvider();
//		tmpCalendar.create();
//		providers.add(tmpCalendar);
//		created.add(tmpCalendar);
	}

	@Override
	public void update() {
//		Random rnd = new Random();
//		CalendarProvider tmpCalendar = (CalendarProvider) providers.get(rnd.nextInt(providers.size()));
//		providers.remove(tmpCalendar);
//		tmpCalendar.update();
//		updated.add(tmpCalendar);
//		providers.add(tmpCalendar);
	}

	@Override
	public void delete() {
//		Random rnd = new Random();
//		CalendarProvider tmpCalendar = (CalendarProvider) providers.get(rnd.nextInt(providers.size()));
//		tmpCalendar.delete();
//		deleted.add(tmpCalendar);
//		providers.remove(tmpCalendar);
	}

	@Override
	protected void readDb() {
		// TODO Auto-generated method stub
		
	}

}
