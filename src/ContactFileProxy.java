import java.util.List;

public class ContactFileProxy implements ContactFile {
    private ContactFileConcrete contactFile;

    @Override
    public Momento<List<SimpleContact>> load() {
        if (contactFile == null) {
            contactFile = new ContactFileConcrete();
        }

        return contactFile.load();
    }

    @Override
    public void save(Momento<List<SimpleContact>> memento) {
        if (contactFile == null) {
            contactFile = new ContactFileConcrete();
        }

        contactFile.save(memento);
    }
}
