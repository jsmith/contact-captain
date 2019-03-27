import javax.swing.*;

public class Contact implements Component {
    private String name;
    private JPanel panel = new JPanel();

    Contact(String name) {
        this.name = name;
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
