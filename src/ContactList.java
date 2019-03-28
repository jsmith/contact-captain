import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

class ContactList implements Component {
    private JPanel list = new JPanel(new GridBagLayout());
    private List<Contact> contacts = new ArrayList<>();
    private JScrollPane pane;

    ContactList() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        this.list.add(new JPanel(), gbc);
        this.pane = new JScrollPane(this.list);
    }

    void add(Contact contact) {
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridwidth = GridBagConstraints.REMAINDER;
        gbc1.weightx = 1;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        this.list.add(contact.getComponent(), gbc1, this.contacts.size());
        this.contacts.add(contact);
        this.list.revalidate();
        this.list.repaint();
    }

    void pop() {
        int i = this.contacts.size() - 1;
        this.list.remove(i);
        this.contacts.remove(i);
        this.list.revalidate();
        this.list.repaint();
    }

    int size() {
        return this.contacts.size();
    }

    @Override
    public JComponent getComponent() {
        return this.pane;
    }
}
