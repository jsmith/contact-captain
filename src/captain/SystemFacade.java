package captain;

import captain.commands.*;
import captain.files.ContactFile;
import captain.files.ContactFileProxy;
import captain.models.Memento;
import captain.models.Contact;
import captain.sorters.FirstNameSorter;
import captain.sorters.LastNameSorter;
import captain.transformations.LowercaseVisitor;
import captain.transformations.UppercaseVisitor;
import captain.ui.ContactRow;
import captain.ui.ContactCaptain;
import captain.ui.ContactCreator;
import captain.ui.ContactList;

import java.util.List;

public class SystemFacade {
    private ContactList contactList;
    private InvokerInterface invoker = new InvokerAdapter();
    private ContactFile contactFile = new ContactFileProxy();

    public SystemFacade(ContactCaptain captain) {
        this.contactList = captain.getContactList();
        ContactRow.onDidCopy(this::copyContact);
        ContactRow.onDidEdit(this::editContact);
        ContactRow.onDidDelete(this::deleteContact);
    }

    public void newContact() {
        ContactCreator creator = ContactCreator.newContact();
        ContactRow contactRow = creator.getContact();

        // contactRow is null if user cancels
        if (contactRow == null) {
            return;
        }

        this.addContact(contactRow);
    }

    private void addContact(ContactRow contactRow) {
        this.invoker.invoke(new AddContactCommand(this.contactList, contactRow));
    }

    private void deleteContact(ContactRow contactRow) {
        this.invoker.invoke(new DeleteContactCommand(this.contactList, contactRow));
    }

    private void copyContact(ContactRow contactRow) {
        this.insertContact(contactRow.copy(), this.contactList.indexOf(contactRow) + 1);
    }

    private void insertContact(ContactRow contactRow, int i) {
        this.invoker.invoke(new InsertContactCommand(this.contactList, contactRow, i));
    }

    private void editContact(ContactRow contactRow) {
        ContactCreator creator = new ContactCreator(
                contactRow.getFirstName(),
                contactRow.getLastName(),
                contactRow.getEmail(),
                contactRow.getPhoneNumber()
        );

        ContactRow newContactRow = creator.getContact();

        // contactRow is null if user cancels
        if (newContactRow == null) {
            return;
        }

        this.invoker.invoke(new EditContactCommand(contactRow, newContactRow.makeContact()));
    }

    public void save() {
        this.contactFile.save(this.contactList.getMemento());
    }

    public void open() {
        Memento<List<Contact>> memento = this.contactFile.load();
        if (memento == null) {
            return;
        }

        this.invoker.invoke(new LoadCommand(this.contactList, memento));
    }

    public void sortFirstName() {
        this.invoker.invoke(new SortCommand(new FirstNameSorter(), this.contactList));
    }

    public void sortLastName() {
        this.invoker.invoke(new SortCommand(new LastNameSorter(), this.contactList));
    }

    public void transformUppercase() {
        this.invoker.invoke(new TransformationCommand(this.contactList, new UppercaseVisitor()));
    }

    public void transformLowercase() {
        this.invoker.invoke(new TransformationCommand(this.contactList, new LowercaseVisitor()));
    }

    public void undo() {
        this.invoker.undo();
    }

    public void redo() {
        this.invoker.redo();
    }
}
