import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class ContactCaptain implements Component {
    private JPanel panel = new JPanel();
    private ContactList list = new ContactList();
    private JButton add = new JButton("Add Contact");

    ContactCaptain() {
        this.panel.setLayout(new BorderLayout());
        this.panel.add(this.list.getComponent());

//        add.addActionListener(e -> {
//            Contact contact = new Contact("Contact");
//            this.list.add(contact);
//            this.panel.validate();
//            this.panel.repaint();
//        });

        this.panel.setPreferredSize(new Dimension(200, 200));
        this.panel.add(add, BorderLayout.SOUTH);
    }

    ContactList getContactList() {
        return this.list;
    }

    void addContact(ActionListener listener) {
        this.add.addActionListener(listener);
    }

    @Override
    public JPanel getComponent() {
        return this.panel;
    }
}
