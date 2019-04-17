package captain.events;

import captain.models.Contact;

public class ContactAddEvent {
    Contact contact;

    ContactAddEvent(Contact contact) {
        this.contact = contact;
    }

    public Contact getContact() {
        return this.contact;
    }
}
