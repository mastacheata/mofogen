package com.android.forge.randomnames;

import com.android.forge.randomnames.auto._Randomnames;

public class Randomnames extends _Randomnames {

    private static Randomnames instance;

    private Randomnames() {}

    public static Randomnames getInstance() {
        if(instance == null) {
            instance = new Randomnames();
        }

        return instance;
    }
}
