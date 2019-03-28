import javax.swing.*;

class CaptainMenuBar extends JMenuBar {
    CaptainMenuBar(SystemFacade facade) {
        // FILE
        JMenu menu = new JMenu("File");
        this.add(menu);

        JMenuItem save = new JMenuItem("Save");
        menu.add(save);
        save.addActionListener(e -> facade.save());

        JMenuItem open = new JMenuItem("Open");
        menu.add(open);
        save.addActionListener(e -> facade.open());

        // EDIT
        menu = new JMenu("Edit");
        this.add(menu);

        JMenuItem undo = new JMenuItem("Undo");
        menu.add(undo);
        undo.addActionListener(e -> facade.undo());

        JMenuItem redo = new JMenuItem("Redo");
        menu.add(redo);
        redo.addActionListener(e -> facade.redo());
    }
}
