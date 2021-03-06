package captain.ui;

import javax.swing.*;
import java.awt.*;

public class ContactCaptain extends captain.ui.Component<JPanel> {
    private JPanel panel = new JPanel();
    private ContactList list = new ContactList();
    private Button add = new Button("Add Contact");

    public ContactCaptain() {
        this.panel.setLayout(new BorderLayout());
        this.panel.add(new ScrollPaneDecorator(this.list.getComponent()).getComponent());
        this.panel.setPreferredSize(new Dimension(500, 400));
        this.panel.add(this.add.getComponent(), BorderLayout.SOUTH);
    }

    public ContactList getContactList() {
        return this.list;
    }

    public void onDidAddContact(Observer observer) {
        this.add.attach(observer);
    }

    @Override
    protected JPanel makeComponent() {
        return this.panel;
    }
}
