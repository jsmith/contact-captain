import javax.swing.*;
import java.awt.*;

class ContactCreator {
    private JTextField first = new JTextField("");
    private JTextField last = new JTextField("");
    private JTextField email = new JTextField("");
    private JTextField phoneNumber = new JTextField("");

    Contact getContact() {
        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.add(new JLabel("First Name"));
        panel.add(first);
        panel.add(new JLabel("Last Name"));
        panel.add(last);
        panel.add(new JLabel("Email"));
        panel.add(email);
        panel.add(new JLabel("Phone Number"));
        panel.add(phoneNumber);

        int result = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Create Contact",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result != JOptionPane.OK_OPTION) {
            return null;
        }

        return new Contact(
                first.getText(),
                last.getText(),
                email.getText(),
                phoneNumber.getText()
        );
    }
}