import javax.swing.*;
import java.awt.*;

class ContactCreator {
    private JTextField field1 = new JTextField("");
    private JTextField field2 = new JTextField("");

    private void getContact() {
        String[] items = {"One", "Two", "Three", "Four", "Five"};
        JComboBox<String> combo = new JComboBox<>(items);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(combo);
        panel.add(new JLabel("First Name"));
        panel.add(field1);
        panel.add(new JLabel("Last Name"));
        panel.add(field2);
        int result = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Create Contact",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            System.out.println(combo.getSelectedItem()
                    + " " + field1.getText()
                    + " " + field2.getText());
        } else {
            System.out.println("Cancelled");
        }
    }
}