public class ContactFileProxy implements ContactFile {
    private ContactFileConcrete contactFile;

    @Override
    public void load() {
        if (contactFile == null) {
            contactFile = new ContactFileConcrete();
        }

    }

    @Override
    public void save() {
        if (contactFile == null) {
            contactFile = new ContactFileConcrete();
        }


    }
}
