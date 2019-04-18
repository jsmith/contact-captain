package captain.commands;

import captain.sorters.ContactSorter;
import captain.ui.ContactRow;
import captain.ui.ContactList;

import java.util.ArrayList;
import java.util.List;

public class SortCommand implements Command {
    private ContactSorter sorter;
    private List<ContactRow> oldContactRows;
    private ContactList contactList;

    public SortCommand(ContactSorter sorter, ContactList contactList) {
        this.sorter = sorter;
        this.contactList = contactList;
        this.oldContactRows = new ArrayList<>(contactList.getContactRows());
    }

    @Override
    public void execute() {
        this.contactList.sort(this.sorter);
    }

    @Override
    public void unexecute() {
        this.contactList.setContactRows(this.oldContactRows);
    }
}
