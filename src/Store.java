class Store extends Invoker {
    private ContactList contactList;

    Store(ContactCaptain captain) {
        this.contactList = captain.getContactList();
    }

    void addContact() {
        this.invoke(new AddContactCommand(this.contactList));
    }

    void save() {
        //
    }

    void open() {
        //
    }

    void saveAs() {
        //
    }
}
