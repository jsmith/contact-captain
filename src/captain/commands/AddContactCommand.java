package captain.commands;

import captain.ui.ContactRow;
import captain.ui.ContactList;

public class AddContactCommand implements Command {
    private ContactList contactList;
    private ContactRow contactRow;

    public AddContactCommand(ContactList list, ContactRow contactRow) {
        this.contactList = list;
        this.contactRow = contactRow;
    }

    @Override
    public void execute() {
        this.contactList.add(this.contactRow);
    }

    @Override
    public void unexecute() {
        this.contactList.pop();
    }
}
