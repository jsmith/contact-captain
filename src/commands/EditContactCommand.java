package commands;

import models.SimpleContact;
import ui.Contact;

public class EditContactCommand implements Command {
    private SimpleContact oldContact;
    private SimpleContact newContact;
    private Contact contact;

    public EditContactCommand(Contact currentContact, SimpleContact newContact) {
        this.oldContact = currentContact.makeSimpleContact();
        this.newContact = newContact;
        this.contact = currentContact;
    }

    @Override
    public void execute() {
        this.contact.setSimpleContact(this.newContact);
    }

    @Override
    public void unexecute() {
        this.contact.setSimpleContact(this.oldContact);
    }
}
