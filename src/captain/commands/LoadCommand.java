package captain.commands;

import captain.models.Memento;
import captain.models.Contact;
import captain.ui.ContactRow;
import captain.ui.ContactList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LoadCommand implements Command {
    private ContactList contactList;
    private List<ContactRow> oldContactRows;
    private List<ContactRow> newContactRows;

    public LoadCommand(ContactList contactList, Memento<List<Contact>> newContacts) {
        this.contactList = contactList;
        this.oldContactRows = new ArrayList<>(contactList.getContactRows());
        this.newContactRows = newContacts.getState().stream().map(ContactRow::fromContact).collect(Collectors.toList());
    }

    @Override
    public void execute() {
        this.contactList.setContactRows(this.newContactRows);

    }

    @Override
    public void unexecute() {
        this.contactList.setContactRows(this.oldContactRows);
    }
}
