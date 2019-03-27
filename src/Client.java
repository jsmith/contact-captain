import javax.swing.*;
import java.awt.*;

public class Client {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}

            JFrame frame = new JFrame("Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ContactCaptain captain = new ContactCaptain();

            JPanel panel = captain.getComponent();
            frame.add(panel);

            Store store = new Store(captain);

            captain.addContact(e -> store.addContact());
            frame.setJMenuBar(new CaptainMenuBar(store));

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
