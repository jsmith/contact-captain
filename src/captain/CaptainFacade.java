package captain;

import captain.commands.*;
import captain.data.FileSystem;
import captain.data.FileSystemProxy;
import captain.models.Memento;
import captain.models.Contact;
import captain.sorters.EmailSorter;
import captain.sorters.FirstNameSorter;
import captain.sorters.LastNameSorter;
import captain.sorters.PhoneNumberSorter;
import captain.transformations.LowercaseVisitor;
import captain.transformations.UppercaseVisitor;
import captain.ui.ContactRow;
import captain.ui.ContactCaptain;
import captain.ui.ContactCreator;
import captain.ui.ContactList;

import java.util.List;

public class CaptainFacade {
    private ContactList contactList;
    private InvokerInterface invoker = new InvokerAdapter();
    private FileSystem localFile = new FileSystemProxy();

    public CaptainFacade(ContactCaptain captain) {
        this.contactList = captain.getContactList();
        ContactRow.onDidCopy(this::copyContact);
        ContactRow.onDidEdit(this::editContact);
        ContactRow.onDidDelete(this::deleteContact);
    }

    public void newContact() {
        ContactCreator creator = ContactCreator.newContact();
        Contact contact = creator.getContact();

        // contact is null if user cancels
        if (contact == null) {
            return;
        }

        this.addContact(ContactRow.fromContact(contact));
    }

    private void addContact(ContactRow contactRow) {
        this.invoker.invoke(new AddContactCommand(this.contactList, contactRow));
    }

    private void deleteContact(ContactRow contactRow) {
        this.invoker.invoke(new DeleteContactCommand(this.contactList, contactRow));
    }

    private void copyContact(ContactRow contactRow) {
        this.insertContact(contactRow.getContact().clone(), this.contactList.indexOf(contactRow) + 1);
    }

    private void insertContact(Contact contact, int i) {
        this.invoker.invoke(new InsertContactCommand(this.contactList, ContactRow.fromContact(contact), i));
    }

    private void editContact(ContactRow contactRow) {
        ContactCreator creator = ContactCreator.fromContact(contactRow.getContact());

        Contact contact = creator.getContact();

        // contact is null if user cancels
        if (contact == null) {
            return;
        }

        this.invoker.invoke(new EditContactCommand(contactRow, contact));
    }

    public void save() {
        this.localFile.save(this.contactList.getMemento());
    }

    public void open() {
        Memento<List<Contact>> memento = this.localFile.load();
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

    public void sortPhoneNumber() {
        this.invoker.invoke(new SortCommand(new PhoneNumberSorter(), this.contactList));
    }

    public void sortEmail() {
        this.invoker.invoke(new SortCommand(new EmailSorter(), this.contactList));
    }

    public void transformUppercase() {
        this.invoker.invoke(new TransformationCommand(this.contactList, UppercaseVisitor.Instance()));
    }

    public void transformLowercase() {
        this.invoker.invoke(new TransformationCommand(this.contactList, LowercaseVisitor.Instance()));
    }

    public void undo() {
        this.invoker.undo();
    }

    public void redo() {
        this.invoker.redo();
    }
}
