import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Contact extends Component {
    private String name;
    private JPanel panel = new JPanel();
    private JPopupMenu menu = new JPopupMenu();
    private JMenuItem copy = new JMenuItem("Copy");

    Contact(String name) {
        this.name = name;
        this.panel.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
        this.panel.add(new JLabel(name));

        this.menu.add(copy);
    }

    public Contact copy() {
        return new Contact(this.name);
    }

    protected JPopupMenu getJPopupMenu() {
        return menu;
    }

    public void onCopy(ActionListener al) {
        this.copy.addActionListener(al);
    }

    @Override
    public JComponent makeComponent() {
        return this.panel;
    }
}
