package captain.files;

import captain.models.Memento;
import captain.models.Contact;

import java.util.List;

public interface ContactFile {
    Memento<List<Contact>> load();
    void save(Memento<List<Contact>> memento);
}
