package commands;

import models.Memento;
import models.SimpleContact;
import ui.Contact;
import ui.ContactList;

import java.util.List;
import java.util.stream.Collectors;

public class LoadCommand implements Command {
    private ContactList contactList;
    private List<Contact> oldContacts;
    private List<Contact> newContacts;

    public LoadCommand(ContactList contactList, Memento<List<SimpleContact>> newContacts) {
        this.contactList = contactList;
        this.oldContacts = contactList.getContacts();
        this.newContacts = newContacts.getState().stream().map(Contact::fromSimple).collect(Collectors.toList());
    }

    @Override
    public void execute() {
        this.contactList.setContacts(this.newContacts);

    }

    @Override
    public void unexecute() {
        this.contactList.setContacts(this.oldContacts);
    }
}
