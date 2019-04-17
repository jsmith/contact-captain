package commands;

import ui.Contact;
import ui.ContactList;

public class InsertContactCommand implements Command {
    private ContactList contactList;
    private Contact contact;
    private int i;

    public InsertContactCommand(ContactList list, Contact contact, int i) {
        this.contactList = list;
        this.contact = contact;
        this.i = i;
    }

    @Override
    public void execute() {
        this.contactList.insert(this.contact, i);
    }

    @Override
    public void unexecute() {
        this.contactList.remove(i);
    }
}
