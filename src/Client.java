import captain.events.EventBus;
import captain.ui.MenuBar;
import captain.ui.ContactCaptain;
import captain.SystemFacade;

import javax.swing.*;
import java.awt.*;

public class Client {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}

            JFrame frame = new JFrame("ContactRow Captain");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            EventBus eventBus = new EventBus();
            ContactCaptain captain = new ContactCaptain(eventBus);

            JPanel panel = captain.getComponent();
            frame.add(panel);

            SystemFacade facade = new SystemFacade(captain);

            // this is called when they click the button
//            captain.onDidAddContact(e -> facade.newContact());
            frame.setJMenuBar(new MenuBar(facade));

            eventBus.on("contactAdd", e -> facade.newContact());

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setFocusable(true);
            frame.setVisible(true);
        });
    }
}
