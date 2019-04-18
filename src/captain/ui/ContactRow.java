package captain.ui;

import captain.models.Contact;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.function.Consumer;

public class ContactRow extends Component {
    private static final int NAME_LENGTH = 20;
    private static final int EMAIL_LENGTH = 30;
    private static final int NUMBER_LENGTH = 15;

    // The callbacks
    private static Consumer<ContactRow> copyCb;
    private static Consumer<ContactRow> editCb;
    private static Consumer<ContactRow> deleteCb;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private JLabel label;
    private JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPopupMenu menu = new JPopupMenu();

    public static void onDidCopy(Consumer<ContactRow> cb) {
        ContactRow.copyCb = cb;
    }

    public static void onDidEdit(Consumer<ContactRow> cb) {
        ContactRow.editCb = cb;
    }

    public static void onDidDelete(Consumer<ContactRow> cb) {
        ContactRow.deleteCb = cb;
    }

    private ContactRow(String firstName, String lastName, String email, String phoneNumber) {
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

        copy.addActionListener(e -> ContactRow.copyCb.accept(this));
        edit.addActionListener(e -> ContactRow.editCb.accept(this));
        delete.addActionListener(e -> ContactRow.deleteCb.accept(this));

        this.createLabel();
    }

    private static String padRight(String string, int length) {
        return String.format("%-" + length + "s", string);
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        this.createLabel();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        this.createLabel();
    }

    public void setEmail(String email) {
        this.email = email;
        this.createLabel();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.createLabel();
    }

    public Contact getContact() {
        return new Contact()
                .setEmail(this.getEmail())
                .setFirstName(this.getFirstName())
                .setLastName(this.getLastName())
                .setPhoneNumber(this.getPhoneNumber());
    }

    public void setContact(Contact contact) {
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
        name = ContactRow.padRight(name, ContactRow.NAME_LENGTH);
        email = ContactRow.padRight(email, ContactRow.EMAIL_LENGTH);
        phoneNumber = ContactRow.padRight(phoneNumber, ContactRow.NUMBER_LENGTH);

        this.label = new JLabel(name + email + phoneNumber);
        label.setFont(new Font("monospaced", Font.PLAIN, 12));

        this.panel.add(this.label);
        this.panel.revalidate();
    }

    public static ContactRow fromContact(Contact contact) {
        return new ContactRow(
                contact.getFirstName(),
                contact.getLastName(),
                contact.getEmail(),
                contact.getPhoneNumber()
        );
    }
}
