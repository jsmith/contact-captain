package captain.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Button extends Component implements Subject {
    private final List<Consumer<ActionEvent>> observers = new ArrayList<>();
    private JButton button = new JButton(this.text);
    private String text;

    Button(String text) {
        this.text = text;
        this.button.addActionListener(this::notify);
    }

    private void notify(final ActionEvent event) {
        for (final Consumer<ActionEvent> parent : this.observers) {
            parent.accept(event);
        }
    }

    public void attach(final Consumer<ActionEvent> parent) {
        this.observers.add(parent);
    }

    @Override
    protected JComponent makeComponent() {
        return this.button;
    }
}
