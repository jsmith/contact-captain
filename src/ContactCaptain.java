import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class ContactCaptain extends Component<JPanel> {
    private JPanel panel = new JPanel();
    private ContactList list = new ContactList();
    private JButton add = new JButton("Add Contact");

    ContactCaptain() {
        this.panel.setLayout(new BorderLayout());
        this.panel.add(new ScrollPaneDecorator(this.list.getComponent()).getComponent());
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
    protected JPanel makeComponent() {
        return this.panel;
    }
}
