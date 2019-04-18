package captain.commands;

import captain.models.Contact;
import captain.ui.ContactRow;

public class EditContactCommand implements Command {
    private Contact oldContact;
    private Contact newContact;
    private ContactRow contactRow;

    public EditContactCommand(ContactRow currentContactRow, Contact newContact) {
        this.oldContact = currentContactRow.getContact();
        this.newContact = newContact;
        this.contactRow = currentContactRow;
    }

    @Override
    public void execute() {
        this.contactRow.setContact(this.newContact);
    }

    @Override
    public void unexecute() {
        this.contactRow.setContact(this.oldContact);
    }
}
