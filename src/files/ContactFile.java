package files;

import models.Memento;
import models.SimpleContact;

import java.util.List;

public interface ContactFile {
    Memento<List<SimpleContact>> load();
    void save(Memento<List<SimpleContact>> memento);
}
