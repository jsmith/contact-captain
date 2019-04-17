package ui;

import models.Memento;
import models.SimpleContact;
import sorters.ContactSorter;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ContactList extends ui.Component {
    private JPanel list = new JPanel(new GridBagLayout());
    private List<Contact> contacts = new ArrayList<>();

    ContactList() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        this.list.add(new JPanel(), gbc);
    }

    public void add(Contact contact) {
        this.insert(contact, this.contacts.size());
    }

    public void pop() {
        this.remove(this.contacts.size() - 1);
    }

    public void remove(int i) {
        this.list.remove(i);
        this.contacts.remove(i);
        this.list.revalidate();
        this.list.repaint();
    }

    public void insert(Contact contact, int i) {
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridwidth = GridBagConstraints.REMAINDER;
        gbc1.weightx = 1;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        this.list.add(contact.getComponent(), gbc1, i);
        this.contacts.add(i, contact);
        this.list.revalidate();
        this.list.repaint();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public Memento<List<SimpleContact>> getMemento() {
        List<SimpleContact> simpleContacts = this.contacts
                .stream()
                .map(Contact::makeSimpleContact).collect(Collectors.toList());

        return new Memento<>(simpleContacts);
    }

    public void sort(ContactSorter sorter) {
        List<Contact> sorted = sorter.sort(this.contacts);
        this.removeAll();
        sorted.forEach(this::add);
    }

    public int indexOf(Contact contact) {
        return this.contacts.indexOf(contact);
    }

    private void removeAll() {
        for (int i = this.contacts.size() - 1; i >= 0; i--) {
            this.remove(i);
        }
    }

    @Override
    protected JComponent makeComponent() {
        return this.list;
    }

    public void setContacts(List<Contact> newContacts) {
        this.removeAll();
        newContacts.forEach(this::add);
    }
}
