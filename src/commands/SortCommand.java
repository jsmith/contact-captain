package commands;

import sorters.ContactSorter;
import ui.Contact;
import ui.ContactList;

import java.util.List;

public class SortCommand implements Command {
    private ContactSorter sorter;
    private List<Contact> oldContacts;
    private ContactList contactList;

    public SortCommand(ContactSorter sorter, ContactList contactList) {
        this.sorter = sorter;
        this.contactList = contactList;
    }

    @Override
    public void execute() {
        this.oldContacts = this.contactList.getContacts();
        this.contactList.sort(this.sorter);
    }

    @Override
    public void unexecute() {
        this.contactList.setContacts(this.oldContacts);
    }
}
