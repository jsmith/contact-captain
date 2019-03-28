import javax.swing.*;

class CaptainMenuBar extends JMenuBar {
    CaptainMenuBar(Store store) {
        // FILE
        JMenu menu = new JMenu("File");
        this.add(menu);

        JMenuItem save = new JMenuItem("Save");
        menu.add(save);
        save.addActionListener(e -> store.save());

        JMenuItem saveAs = new JMenuItem("Save As");
        menu.add(saveAs);
        saveAs.addActionListener(e -> store.saveAs());

        JMenuItem open = new JMenuItem("Open");
        menu.add(open);
        save.addActionListener(e -> store.open());

        // EDIT
        menu = new JMenu("Edit");
        this.add(menu);

        JMenuItem undo = new JMenuItem("Undo");
        menu.add(undo);
        undo.addActionListener(e -> store.undo());

        JMenuItem redo = new JMenuItem("Redo");
        menu.add(redo);
        redo.addActionListener(e -> store.redo());
    }
}
