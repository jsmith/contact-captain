import javax.swing.*;

public class ScrollPaneDecorator extends Component<JScrollPane> {
    private JComponent component;

    ScrollPaneDecorator(JComponent component) {
        this.component = component;
    }

    @Override
    protected JScrollPane makeComponent() {
        return new JScrollPane(this.component);
    }
}
