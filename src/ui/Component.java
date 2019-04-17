package ui;

import javax.swing.*;

abstract class Component<T extends JComponent> {
    protected abstract T makeComponent();

    public T getComponent() {
        T component = this.makeComponent();
        component.setComponentPopupMenu(this.getJPopupMenu());
        return component;
    }

    protected JPopupMenu getJPopupMenu() {
        return null;
    }
}
