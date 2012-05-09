package com.android.forge.calendar;

import com.android.forge.calendar.auto._CalendarMap;

public class CalendarMap extends _CalendarMap {

    private static CalendarMap instance;

    private CalendarMap() {}

    public static CalendarMap getInstance() {
        if(instance == null) {
            instance = new CalendarMap();
        }

        return instance;
    }
}
