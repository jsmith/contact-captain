package captain.ui;

import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public interface Subject {
    void attach(final Consumer<ActionEvent> parent);
}
