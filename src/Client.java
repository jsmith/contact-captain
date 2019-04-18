import captain.ui.MenuBar;
import captain.ui.ContactCaptain;
import captain.CaptainFacade;

import javax.swing.*;
import java.awt.*;

public class Client {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}

            JFrame frame = new JFrame("Contact Captain");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ContactCaptain captain = new ContactCaptain();

            JPanel panel = captain.getComponent();
            frame.add(panel);

            CaptainFacade facade = new CaptainFacade(captain);

            // this is called when they click the button
            captain.onDidAddContact(e -> facade.newContact());
            frame.setJMenuBar(new MenuBar(facade));

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setFocusable(true);
            frame.setVisible(true);
        });
    }
}
