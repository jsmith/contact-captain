package captain.data;

import captain.models.Memento;
import captain.models.Contact;

import java.util.List;

public class FileSystemProxy implements FileSystem {
    private FileSystemConcrete contactFile;

    @Override
    public Memento<List<Contact>> load() {
        if (contactFile == null) {
            contactFile = new FileSystemConcrete();
        }

        return contactFile.load();
    }

    @Override
    public void save(Memento<List<Contact>> memento) {
        if (contactFile == null) {
            contactFile = new FileSystemConcrete();
        }

        contactFile.save(memento);
    }
}
