package captain.data;

import captain.models.Memento;
import captain.models.Contact;

import java.util.List;

public interface FileSystem {
    Memento<List<Contact>> load();
    void save(Memento<List<Contact>> memento);
}
