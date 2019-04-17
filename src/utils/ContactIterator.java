package utils;

import ui.Contact;

import java.util.List;

public class ContactIterator {
    private int currentIndex = -1;
    private List<Contact> contacts;

    public ContactIterator(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void initialize() {
        this.currentIndex = 0;
    }

    public void initialize(int index) {
        this.currentIndex = index;
    }

    public void next() {
        this.currentIndex++;
    }

    public boolean isDone() {
        return this.contacts.size() <= this.currentIndex;
    }

    public Contact getCurrent() {
        return this.contacts.get(this.currentIndex);
    }
}
