package com.android.forge.contacts2;

import com.android.forge.contacts2.auto._Contacts2;

public class Contacts2 extends _Contacts2 {

    private static Contacts2 instance;

    private Contacts2() {}

    public static Contacts2 getInstance() {
        if(instance == null) {
            instance = new Contacts2();
        }

        return instance;
    }
}
