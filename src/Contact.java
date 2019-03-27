import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class Contact implements Component {
    private String name;
    private JPanel panel = new JPanel();

    Contact(String name) {
        this.name = name;
        this.panel.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
        this.panel.add(new JLabel(name));
    }

    public Contact clone() {
        return new Contact(this.name);
    }

    @Override
    public JComponent getComponent() {
        return this.panel;
    }
}
