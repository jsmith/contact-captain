import javax.swing.*;
import java.awt.*;

class ContactCaptain extends JPanel {
    private DefaultListModel<String> model;
    private int counter = 15;

    ContactCaptain() {
        setLayout(new BorderLayout());
        model = new DefaultListModel<>();
        JList<String> list = new JList<>(model);
        JScrollPane pane = new JScrollPane(list);
        JButton addButton = new JButton("Add Element");
        JButton removeButton = new JButton("Remove Element");
        for (int i = 0; i < 15; i++) {
            model.addElement("Element " + i);
        }

        addButton.addActionListener(e -> {
            model.addElement("Element " + counter);
            counter++;
        });
        removeButton.addActionListener(e -> {
            if (model.getSize() > 0) {
                model.removeElementAt(0);
            }

        });

        add(pane, BorderLayout.NORTH);
        add(addButton, BorderLayout.WEST);
        add(removeButton, BorderLayout.EAST);
    }
}
