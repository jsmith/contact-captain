package ui;

import models.SimpleContact;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.function.Consumer;

public class Contact extends Component {
    private static final int NAME_LENGTH = 20;
    private static final int EMAIL_LENGTH = 30;
    private static final int NUMBER_LENGTH = 15;

    // The callbacks
    private static Consumer<Contact> copyCb;
    private static Consumer<Contact> editCb;
    private static Consumer<Contact> deleteCb;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private JLabel label;
    private JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPopupMenu menu = new JPopupMenu();

    public static void onDidCopy(Consumer<Contact> cb) {
        Contact.copyCb = cb;
    }

    public static void onDidEdit(Consumer<Contact> cb) {
        Contact.editCb = cb;
    }

    public static void onDidDelete(Consumer<Contact> cb) {
        Contact.deleteCb = cb;
    }

    Contact(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;

        this.panel.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));

        JMenuItem copy = new JMenuItem("Copy");
        this.menu.add(copy);
        JMenuItem delete = new JMenuItem("Delete");
        this.menu.add(delete);
        JMenuItem edit = new JMenuItem("Edit");
        this.menu.add(edit);

        copy.addActionListener(e -> Contact.copyCb.accept(this));
        edit.addActionListener(e -> Contact.editCb.accept(this));
        delete.addActionListener(e -> Contact.deleteCb.accept(this));

        this.createLabel();
    }

    private static String padRight(String string, int length) {
        return String.format("%-" + length + "s", string);
    }

    public Contact copy() {
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

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
        this.createLabel();
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
        this.createLabel();
    }

    private void setEmail(String email) {
        this.email = email;
        this.createLabel();
    }

    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.createLabel();
    }

    public SimpleContact makeSimpleContact() {
        return new SimpleContact()
                .setEmail(this.getEmail())
                .setFirstName(this.getFirstName())
                .setLastName(this.getLastName())
                .setPhoneNumber(this.getPhoneNumber());
    }

    public void setSimpleContact(SimpleContact contact) {
        this.setFirstName(contact.getFirstName());
        this.setLastName(contact.getLastName());
        this.setEmail(contact.getEmail());
        this.setPhoneNumber(contact.getPhoneNumber());
    }

    @Override
    public JComponent makeComponent() {
        return this.panel;
    }

    private void createLabel() {
        if (this.label != null) {
            this.panel.remove(this.label);
        }

        String name = this.firstName + " " +  this.lastName;
        name = Contact.padRight(name, Contact.NAME_LENGTH);
        email = Contact.padRight(email, Contact.EMAIL_LENGTH);
        phoneNumber = Contact.padRight(phoneNumber, Contact.NUMBER_LENGTH);

        this.label = new JLabel(name + email + phoneNumber);
        label.setFont(new Font("monospaced", Font.PLAIN, 12));

        this.panel.add(this.label);
        this.panel.revalidate();
    }

    public static Contact fromSimple(SimpleContact contact) {
        return new Contact(
                contact.getFirstName(),
                contact.getLastName(),
                contact.getEmail(),
                contact.getPhoneNumber()
        );
    }
}
