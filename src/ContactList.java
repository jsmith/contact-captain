import javax.swing.*;
import java.awt.*;

class ContactList implements Component {
    private JPanel panel;
    private JScrollPane pane;

    ContactList() {
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.pane = new JScrollPane(panel);
        panel.setPreferredSize(new Dimension(260, 500));


        for (int i = 0; i < 15; i++) {
            this.panel.add(new Contact("Element " + i).getComponent());
        }
    }

    public void add(Contact contact) {
        this.panel.add(contact.getComponent());
    }

    @Override
    public JComponent getComponent() {
        return this.pane;
    }
}
