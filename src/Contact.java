import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Contact extends Component {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private JPanel panel = new JPanel();
    private JPopupMenu menu = new JPopupMenu();
    private JMenuItem copy = new JMenuItem("Copy");

    Contact(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;

        this.panel.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
        this.panel.add(new JLabel(firstName));
        this.menu.add(copy);
    }

    Contact copy() {
        return new Contact(
                this.firstName,
                this.lastName,
                this.email,
                this.phoneNumber
        );
    }

    protected JPopupMenu getJPopupMenu() {
        return menu;
    }

    String getFirstName() {
        return this.firstName;
    }

    String getLastName() {
        return this.lastName;
    }

    String getEmail() {
        return this.email;
    }

    String getPhoneNumber() {
        return this.phoneNumber;
    }

    void onCopy(ActionListener al) {
        this.copy.addActionListener(al);
    }

    @Override
    public JComponent makeComponent() {
        return this.panel;
    }
}
