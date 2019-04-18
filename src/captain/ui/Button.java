package captain.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Button extends Component implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private JButton button = new JButton();

    Button(String text) {
        this.button.setText(text);
        this.button.addActionListener(this::notify);
    }

    private void notify(final ActionEvent event) {
        for (final Observer observer : this.observers) {
            observer.notify(event);
        }
    }

    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    protected JComponent makeComponent() {
        return this.button;
    }
}
