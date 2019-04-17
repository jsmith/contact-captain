package commands;

import ui.Contact;
import ui.ContactList;

public class AddContactCommand implements Command {
    private ContactList contactList;
    private Contact contact;

    public AddContactCommand(ContactList list, Contact contact) {
        this.contactList = list;
        this.contact = contact;
    }

    @Override
    public void execute() {
        this.contactList.add(this.contact);
    }

    @Override
    public void unexecute() {
        this.contactList.pop();
    }
}
