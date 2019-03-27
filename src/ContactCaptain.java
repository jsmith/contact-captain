import javax.swing.*;
import java.awt.*;

class ContactCaptain implements Component {
    private DefaultListModel<String> model = new DefaultListModel<>();
    private JPanel panel = new JPanel();
    private int counter = 15;

    ContactCaptain() {
        ContactList contacts = new ContactList();

        JButton addButton = new JButton("Add Element");
        JButton removeButton = new JButton("Remove Element");

        addButton.addActionListener(e -> {
            model.addElement("Element " + counter);
            counter++;
        });
        removeButton.addActionListener(e -> {
            if (model.getSize() > 0) {
                model.removeElementAt(0);
            }
        });

        this.panel.setLayout(new BorderLayout());
        this.panel.add(contacts.getComponent(), BorderLayout.NORTH);
        this.panel.add(addButton, BorderLayout.WEST);
        this.panel.add(removeButton, BorderLayout.EAST);
    }

    @Override
    public JPanel getComponent() {
        return this.panel;
    }
}
