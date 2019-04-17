package captain.commands;

import captain.ui.ContactRow;
import captain.ui.ContactList;

public class InsertContactCommand implements Command {
    private ContactList contactList;
    private ContactRow contactRow;
    private int i;

    public InsertContactCommand(ContactList list, ContactRow contactRow, int i) {
        this.contactList = list;
        this.contactRow = contactRow;
        this.i = i;
    }

    @Override
    public void execute() {
        this.contactList.insert(this.contactRow, i);
    }

    @Override
    public void unexecute() {
        this.contactList.remove(i);
    }
}
