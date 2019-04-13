class SystemFacade extends Invoker {
    private ContactList contactList;
    private ContactFile contactFile = new ContactFileProxy();

    SystemFacade(ContactCaptain captain) {
        this.contactList = captain.getContactList();
    }

    void newContact() {
        Contact contact = new Contact("Contact " + this.contactList.size());
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
        this.contactFile.save(this.contactList.getMomento());
    }

    void open() {
        this.contactList.setMomento(this.contactFile.load());
    }
}
