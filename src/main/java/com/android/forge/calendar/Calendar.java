package com.android.forge.calendar;

import com.android.forge.calendar.auto._Calendar;

public class Calendar extends _Calendar {

    private static Calendar instance;

    private Calendar() {}

    public static Calendar getInstance() {
        if(instance == null) {
            instance = new Calendar();
        }

        return instance;
    }
}
