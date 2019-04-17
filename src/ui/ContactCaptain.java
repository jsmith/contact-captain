package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ContactCaptain extends ui.Component<JPanel> {
    private JPanel panel = new JPanel();
    private ContactList list = new ContactList();
    private JButton add = new JButton("Add ui.Contact");

    public ContactCaptain() {
        this.panel.setLayout(new BorderLayout());
        this.panel.add(new ScrollPaneDecorator(this.list.getComponent()).getComponent());
        this.panel.setPreferredSize(new Dimension(500, 400));
        this.panel.add(add, BorderLayout.SOUTH);
    }

    public ContactList getContactList() {
        return this.list;
    }

    public void onDidAddContact(ActionListener listener) {
        this.add.addActionListener(listener);
    }

    @Override
    protected JPanel makeComponent() {
        return this.panel;
    }
}
