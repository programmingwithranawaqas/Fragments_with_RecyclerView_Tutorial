package com.example.fragmentswithrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class ContactsData extends Application {
    public static ArrayList<Person> contacts;

    @Override
    public void onCreate() {
        super.onCreate();
        contacts = new ArrayList<>();
        contacts.add(new Person("Ali", "03004123215"));
        contacts.add(new Person("Akbar", "03004121122"));
        contacts.add(new Person("Hashim", "03004120000"));
    }
}
