package org.example.mobile;
import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        this.myContacts = (contacts != null) ? new ArrayList<>(contacts) : new ArrayList<>();
        ;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return (ArrayList<Contact>) myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    public int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equalsIgnoreCase(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        int existingPosition = findContact(contact.getName());
        if (existingPosition >= 0) {
            this.myContacts.remove(existingPosition);
            return true;
        }
        return false;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    public Contact printContact() {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact currentContact = this.myContacts.get(i);
            System.out.println((i + 1) + ". " + currentContact.getName() + " -> " + currentContact.getPhoneNumber());
        }
        return null;
    }
}
