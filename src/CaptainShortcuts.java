import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CaptainShortcuts implements KeyListener {
    Store store;

    CaptainShortcuts(Store store) {
        this.store = store;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        System.out.println(keyEvent.isControlDown());

        if (!keyEvent.isControlDown()) {
            return;
        }

        if (keyEvent.isShiftDown()) {
            switch (keyEvent.getKeyChar()) {
                case 'z':
                    this.store.redo();
                    break;
                case 's':
                    this.store.saveAs();
                    break;
            }
            return;
        }

        switch (keyEvent.getKeyChar()) {
            case 'z':
                this.store.undo();
                break;
            case 'y':
                this.store.undo();
                break;
            case 's':
                this.store.save();
                break;
            case 'o':
                this.store.open();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
