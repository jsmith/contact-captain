package captain.data;

import captain.models.Memento;
import captain.models.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSystemConcrete implements FileSystem {
    private final static String FILE_NAME = "contacts.b";

    @Override
    public Memento<List<Contact>> load() {
        List<Contact> contacts;

        try {
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);

            //noinspection unchecked
            contacts = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException ioe) {
            ioe.printStackTrace();
            return null;
        }

        return new Memento<>(contacts);
    }

    @Override
    public void save(Memento<List<Contact>> memento) {
        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(memento.getState());
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            // IGNORE ERROR FOR NOW
            // THERE IS NO ERROR HANDLING MECHANISM
            ioe.printStackTrace();
        }
    }
}
