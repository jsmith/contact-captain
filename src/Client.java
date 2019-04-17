import ui.ContactCaptain;

import javax.swing.*;
import java.awt.*;

public class Client {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}

            JFrame frame = new JFrame("ui.Contact Captain");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ContactCaptain captain = new ContactCaptain();

            JPanel panel = captain.getComponent();
            frame.add(panel);

            SystemFacade facade = new SystemFacade(captain);

            captain.onDidAddContact(e -> facade.newContact());
            frame.setJMenuBar(new CaptainMenuBar(facade));

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setFocusable(true);
            frame.setVisible(true);
        });
    }
}
