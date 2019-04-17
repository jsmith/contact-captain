package captain.files;

import captain.models.Memento;
import captain.models.Contact;

import java.util.List;

public class ContactFileProxy implements ContactFile {
    private ContactFileConcrete contactFile;

    @Override
    public Memento<List<Contact>> load() {
        if (contactFile == null) {
            contactFile = new ContactFileConcrete();
        }

        return contactFile.load();
    }

    @Override
    public void save(Memento<List<Contact>> memento) {
        if (contactFile == null) {
            contactFile = new ContactFileConcrete();
        }

        contactFile.save(memento);
    }
}
