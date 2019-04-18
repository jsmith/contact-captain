package captain.commands;

import captain.models.Contact;
import captain.transformations.Visitor;
import captain.ui.ContactRow;
import captain.ui.ContactList;

import java.util.List;
import java.util.stream.Collectors;

public class TransformationCommand implements Command {
    private Visitor visitor;
    private List<ContactRow> contactRows;
    private List<Contact> oldContacts;

    public TransformationCommand(ContactList contactList, Visitor visitor) {
        this.visitor = visitor;
        this.contactRows = contactList.getContactRows();
        this.oldContacts = this.contactRows.stream().map(ContactRow::getContact).collect(Collectors.toList());
    }

    @Override
    public void execute() {
        this.visitor.traverse(this.contactRows);
    }

    @Override
    public void unexecute() {
        for(int i = 0; i < this.contactRows.size(); i++) {
            this.contactRows.get(i).setContact(this.oldContacts.get(i));
        }
    }
}
