import javax.swing.*;
import java.awt.event.KeyEvent;

class CaptainMenuBar extends JMenuBar {
    CaptainMenuBar(Store store) {
        // FILE
        JMenu menu = new JMenu("File");
        this.add(menu);

        JMenuItem save = new JMenuItem("Save", KeyEvent.VK_T);
        menu.add(save);
        save.addActionListener(e -> store.save());

        JMenuItem saveAs = new JMenuItem("Save As", KeyEvent.VK_T);
        menu.add(saveAs);
        saveAs.addActionListener(e -> store.saveAs());

        JMenuItem open = new JMenuItem("Open", KeyEvent.VK_T);
        menu.add(open);
        save.addActionListener(e -> store.open());

        // EDIT
        menu = new JMenu("Edit");
        this.add(menu);

        JMenuItem undo = new JMenuItem("Undo", KeyEvent.VK_T);
        menu.add(undo);
        undo.addActionListener(e -> store.undo());

        JMenuItem redo = new JMenuItem("Redo", KeyEvent.VK_T);
        menu.add(redo);
        undo.addActionListener(e -> store.redo());
    }
}
