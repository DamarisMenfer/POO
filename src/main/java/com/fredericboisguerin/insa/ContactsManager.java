package com.fredericboisguerin.insa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactsManager {

    List<Contact> contactList = new ArrayList<Contact>();

    public void addContact(String name, String email, String phoneNumber) throws InvalidContactNameException, InvalidEmailException {
        if(name == null || name == "")
            throw new InvalidContactNameException();

        if(email != null && !email.contains("@")) {
            throw new InvalidEmailException();
        }

        Contact newcontact = new Contact(name, email, phoneNumber);
        contactList.add(newcontact);

    }

    public void printAllContacts() {
        for (Iterator<Contact> iter = contactList.iterator();iter.hasNext();){
            iter.next().printContact();

        }

    }

    public void searchContactByName(String name) {

        for (Iterator<Contact> iter = contactList.iterator();iter.hasNext();){
            Contact cont =  iter.next();
            if (cont.getName().toLowerCase().contains(name.toLowerCase())){
                cont.printContact();
                System.out.println();
            }
        }

    }

    public Contact getContactByName(String name) {

        for (Iterator<Contact> iter = contactList.iterator();iter.hasNext();){
            Contact cont =  iter.next();
            if (cont.getName().toLowerCase().contains(name.toLowerCase())){
                cont.printContact();
                System.out.println();
                return (cont);
            }
        }
        Contact cont2 = null;
        return (cont2);
    }

    public void deleteContactByName(String name) {

        for (Iterator<Contact> iter = contactList.iterator();iter.hasNext();){
            Contact cont =  iter.next();
            if (cont.getName().toLowerCase().contains(name.toLowerCase())){
                cont.printContact();
                System.out.println();
                iter.remove();
            }
        }
    }

}
