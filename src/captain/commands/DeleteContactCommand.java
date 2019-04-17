package captain.commands;

import captain.ui.ContactRow;
import captain.ui.ContactList;

public class DeleteContactCommand implements Command {
    private ContactList contactList;
    private ContactRow contactRow;
    private int i;

    public DeleteContactCommand(ContactList contactList, ContactRow contactRow) {
        this.contactList = contactList;
        this.i = this.contactList.indexOf(contactRow);
        this.contactRow = contactRow;
    }

    @Override
    public void execute() {
        this.contactList.remove(this.i);
    }

    @Override
    public void unexecute() {
        this.contactList.insert(this.contactRow, this.i);
    }
}
