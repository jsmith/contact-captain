class SystemFacade extends Invoker {
    private ContactList contactList;
    private ContactFile contactFile = new ContactFileProxy();

    SystemFacade(ContactCaptain captain) {
        this.contactList = captain.getContactList();
    }

    void newContact() {
        ContactCreator creator = new ContactCreator();
        Contact contact = creator.getContact();

        // contact is null if user cancels
        if (contact == null) {
            return;
        }

        this.addContact(contact);
    }

    private void addContact(Contact contact) {
        int i = this.contactList.size() + 1;
        contact.onCopy(e -> this.insertContact(contact.copy(), i));

        this.invoke(new AddContactCommand(this.contactList, contact));
    }

    private void insertContact(Contact contact, int i) {
        this.invoke(new InsertContactCommand(this.contactList, contact, i));
    }

    void save() {
        this.contactFile.save(this.contactList.getMemento());
    }

    void open() {
        this.contactList.setMemento(this.contactFile.load());
    }

    void sortFirstName() {
        this.invoke(new SortCommand(new FirstNameSorter(), this.contactList));
    }

    void sortLastName() {
        this.invoke(new SortCommand(new LastNameSorter(), this.contactList));
    }
}
