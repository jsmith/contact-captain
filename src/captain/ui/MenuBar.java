package captain.ui;

import captain.SystemFacade;
import captain.transformations.UppercaseVisitor;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    public MenuBar(SystemFacade facade) {
        // FILE
        JMenu menu = new JMenu("File");
        this.add(menu);

        JMenuItem save = new JMenuItem("Save");
        menu.add(save);
        save.addActionListener(e -> facade.save());

        JMenuItem open = new JMenuItem("Open");
        menu.add(open);
        open.addActionListener(e -> facade.open());

        // EDIT
        menu = new JMenu("Edit");
        this.add(menu);

        JMenuItem undo = new JMenuItem("Undo");
        menu.add(undo);
        undo.addActionListener(e -> facade.undo());

        JMenuItem redo = new JMenuItem("Redo");
        menu.add(redo);
        redo.addActionListener(e -> facade.redo());

        menu = new JMenu("Sort");
        this.add(menu);

        JMenuItem firstName = new JMenuItem("First Name");
        menu.add(firstName);
        firstName.addActionListener(e -> facade.sortFirstName());

        JMenuItem lastName = new JMenuItem("Last Name");
        menu.add(lastName);
        lastName.addActionListener(e -> facade.sortLastName());

        menu = new JMenu("Transformations");
        this.add(menu);

        JMenuItem uppercase = new JMenuItem("Uppercase");
        menu.add(uppercase);
        uppercase.addActionListener(e -> facade.transformUppercase());

        JMenuItem lowercase = new JMenuItem("Lowercase");
        menu.add(lowercase);
        lowercase.addActionListener(e -> facade.transformLowercase());
    }
}
