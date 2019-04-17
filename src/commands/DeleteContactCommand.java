package commands;

import ui.Contact;
import ui.ContactList;

public class DeleteContactCommand implements Command {
    private ContactList contactList;
    private Contact contact;
    private int i;

    public DeleteContactCommand(ContactList contactList, Contact contact) {
        this.contactList = contactList;
        this.i = this.contactList.indexOf(contact);
        this.contact = contact;
    }

    @Override
    public void execute() {
        this.contactList.remove(this.i);
    }

    @Override
    public void unexecute() {
        this.contactList.insert(this.contact, this.i);
    }
}
