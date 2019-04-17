package files;

import models.Memento;
import models.SimpleContact;

import java.util.List;

public class ContactFileProxy implements ContactFile {
    private ContactFileConcrete contactFile;

    @Override
    public Memento<List<SimpleContact>> load() {
        if (contactFile == null) {
            contactFile = new ContactFileConcrete();
        }

        return contactFile.load();
    }

    @Override
    public void save(Memento<List<SimpleContact>> memento) {
        if (contactFile == null) {
            contactFile = new ContactFileConcrete();
        }

        contactFile.save(memento);
    }
}
