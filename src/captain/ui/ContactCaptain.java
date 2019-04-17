package captain.ui;

import captain.events.EventBus;

import javax.swing.*;
import java.awt.*;

public class ContactCaptain extends captain.ui.Component<JPanel> {
    private JPanel panel = new JPanel();
    private ContactList list = new ContactList();

    public ContactCaptain(EventBus bus) {
        this.panel.setLayout(new BorderLayout());
        this.panel.add(new ScrollPaneDecorator(this.list.getComponent()).getComponent());
        this.panel.setPreferredSize(new Dimension(500, 400));
        JButton add = new JButton("Add ContactRow");
        this.panel.add(add, BorderLayout.SOUTH);
        add.addActionListener(e -> bus.emit("addContact", e));
    }

    public ContactList getContactList() {
        return this.list;
    }

    @Override
    protected JPanel makeComponent() {
        return this.panel;
    }
}
