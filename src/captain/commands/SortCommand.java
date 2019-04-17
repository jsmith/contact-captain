package captain.commands;

import captain.sorters.ContactSorter;
import captain.ui.ContactRow;
import captain.ui.ContactList;

import java.util.List;

public class SortCommand implements Command {
    private ContactSorter sorter;
    private List<ContactRow> oldContactRows;
    private ContactList contactList;

    public SortCommand(ContactSorter sorter, ContactList contactList) {
        this.sorter = sorter;
        this.contactList = contactList;
    }

    @Override
    public void execute() {
        this.oldContactRows = this.contactList.getContactRows();
        this.contactList.sort(this.sorter);
    }

    @Override
    public void unexecute() {
        this.contactList.setContactRows(this.oldContactRows);
    }
}
