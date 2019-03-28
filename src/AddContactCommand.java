class AddContactCommand implements Command {
    private ContactList contactList;

    AddContactCommand(ContactList list) {
        this.contactList = list;
    }

    @Override
    public void execute() {
        Contact contact = new Contact("Contact " + this.contactList.size());
        this.contactList.add(contact);
    }

    @Override
    public void unexecute() {
        this.contactList.pop();
    }
}
