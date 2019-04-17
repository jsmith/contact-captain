import commands.*;
import files.ContactFile;
import files.ContactFileProxy;
import models.Memento;
import models.SimpleContact;
import sorters.FirstNameSorter;
import sorters.LastNameSorter;
import ui.Contact;
import ui.ContactCaptain;
import ui.ContactCreator;
import ui.ContactList;

import java.util.List;

class SystemFacade {
    private ContactList contactList;
    private InvokerInterface invoker = new InvokerAdapter();
    private ContactFile contactFile = new ContactFileProxy();

    SystemFacade(ContactCaptain captain) {
        this.contactList = captain.getContactList();
        Contact.onDidCopy(this::copyContact);
        Contact.onDidEdit(this::editContact);
        Contact.onDidDelete(this::deleteContact);
    }

    void newContact() {
        ContactCreator creator = ContactCreator.newContact();
        Contact contact = creator.getContact();

        // contact is null if user cancels
        if (contact == null) {
            return;
        }

        this.addContact(contact);
    }

    private void addContact(Contact contact) {
        this.invoker.invoke(new AddContactCommand(this.contactList, contact));
    }

    private void deleteContact(Contact contact) {
        this.invoker.invoke(new DeleteContactCommand(this.contactList, contact));
    }

    private void copyContact(Contact contact) {
        this.insertContact(contact.copy(), this.contactList.indexOf(contact) + 1);
    }

    private void insertContact(Contact contact, int i) {
        this.invoker.invoke(new InsertContactCommand(this.contactList, contact, i));
    }

    private void editContact(Contact contact) {
        ContactCreator creator = new ContactCreator(
                contact.getFirstName(),
                contact.getLastName(),
                contact.getEmail(),
                contact.getPhoneNumber()
        );

        Contact newContact = creator.getContact();

        // contact is null if user cancels
        if (newContact == null) {
            return;
        }

        this.invoker.invoke(new EditContactCommand(contact, newContact.makeSimpleContact()));
    }

    void save() {
        this.contactFile.save(this.contactList.getMemento());
    }

    void open() {
        Memento<List<SimpleContact>> memento = this.contactFile.load();
        if (memento == null) {
            return;
        }

        this.invoker.invoke(new LoadCommand(this.contactList, memento));
    }

    void sortFirstName() {
        this.invoker.invoke(new SortCommand(new FirstNameSorter(), this.contactList));
    }

    void sortLastName() {
        this.invoker.invoke(new SortCommand(new LastNameSorter(), this.contactList));
    }

    void undo() {
        this.invoker.undo();
    }

    void redo() {
        this.invoker.redo();
    }
}
