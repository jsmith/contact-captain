import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class ContactList extends Component {
    private JPanel list = new JPanel(new GridBagLayout());
    private List<Contact> contacts = new ArrayList<>();

    ContactList() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        this.list.add(new JPanel(), gbc);
    }

    void add(Contact contact) {
        this.insert(contact, this.contacts.size());
    }

    void pop() {
        this.remove(this.contacts.size() - 1);
    }

    void remove(int i) {
        this.list.remove(i);
        this.contacts.remove(i);
        this.list.revalidate();
        this.list.repaint();
    }

    int size() {
        return this.contacts.size();
    }

    void insert(Contact contact, int i) {
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridwidth = GridBagConstraints.REMAINDER;
        gbc1.weightx = 1;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        this.list.add(contact.getComponent(), gbc1, i);
        this.contacts.add(contact);
        this.list.revalidate();
        this.list.repaint();
    }

    Momento<List<SimpleContact>> getMemento() {
        List<SimpleContact> simpleContacts = this.contacts
                .stream()
                .map(contact -> new SimpleContact()
                        .setEmail(contact.getEmail())
                        .setFirstName(contact.getFirstName())
                        .setLastName(contact.getLastName())
                        .setPhoneNumber(contact.getPhoneNumber())
                ).collect(Collectors.toList());

        return new Momento<>(simpleContacts);
    }

    void setMemento(Momento<List<SimpleContact>> memento) {
        this.removeAll();
        List<Contact> contacts = memento.getState()
                .stream()
                .map(simple -> new Contact(
                        simple.getFirstName(),
                        simple.getLastName(),
                        simple.getEmail(),
                        simple.getPhoneNumber()
                ))
                .collect(Collectors.toList());

        contacts.forEach(this::add);
    }

    void sort(ContactSorter sorter) {
        List<Contact> sorted = sorter.sort(this.contacts);
        this.removeAll();
        sorted.forEach(this::add);
    }

    private void removeAll() {
        for (int i = this.contacts.size() - 1; i >= 0; i--) {
            this.remove(i);
        }
    }

    @Override
    protected JComponent makeComponent() {
        return this.list;
    }
}
