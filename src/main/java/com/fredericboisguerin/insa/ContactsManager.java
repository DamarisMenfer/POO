package com.fredericboisguerin.insa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactsManager {

    List<Contact> contactList = new ArrayList<Contact>();

    public void addContact(String name, String email, String phoneNumber) {
        Contact newcontact = new Contact(name,email,phoneNumber);
        contactList.add(newcontact);
    }

    public void printAllContacts() {
        for (Iterator<Contact> iter = contactList.iterator();iter.hasNext();){
            iter.next().printContact();

        }

    }

    public void searchContactByName(String name) {
        //System.out.printf("%s",name);

        for (Iterator<Contact> iter = contactList.iterator();iter.hasNext();){

            if (iter.next().getName() == name){
                iter.next().printContact();
            }
        }

    }
}
