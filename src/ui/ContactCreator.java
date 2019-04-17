package ui;

import javax.swing.*;
import java.awt.*;

public class ContactCreator {
    private JTextField first = new JTextField("");
    private JTextField last = new JTextField("");
    private JTextField email = new JTextField("");
    private JTextField phoneNumber = new JTextField("");

    public static ContactCreator newContact() {
        return new ContactCreator("", "", "", "");
    }

    public ContactCreator(String firstName, String lastName, String email, String phoneNumber) {
        this.first.setText(firstName);
        this.last.setText(lastName);
        this.email.setText(email);
        this.phoneNumber.setText(phoneNumber);
    }

    public Contact getContact() {
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
                "Create ui.Contact",
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