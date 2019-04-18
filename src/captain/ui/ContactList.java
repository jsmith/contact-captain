package captain.ui;

import captain.models.Memento;
import captain.models.Contact;
import captain.sorters.ContactSorter;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ContactList extends captain.ui.Component {
    private JPanel list = new JPanel(new GridBagLayout());
    private List<ContactRow> contactRows = new ArrayList<>();

    ContactList() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        this.list.add(new JPanel(), gbc);
    }

    public void add(ContactRow contactRow) {
        this.insert(contactRow, this.contactRows.size());
    }

    public void pop() {
        this.remove(this.contactRows.size() - 1);
    }

    public void remove(int i) {
        this.list.remove(i);
        this.contactRows.remove(i);
        this.list.revalidate();
        this.list.repaint();
    }

    public void insert(ContactRow contactRow, int i) {
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridwidth = GridBagConstraints.REMAINDER;
        gbc1.weightx = 1;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        this.list.add(contactRow.getComponent(), gbc1, i);
        this.contactRows.add(i, contactRow);
        this.list.revalidate();
        this.list.repaint();
    }

    public List<ContactRow> getContactRows() {
        return contactRows;
    }

    public Memento<List<Contact>> getMemento() {
        List<Contact> contacts = this.contactRows
                .stream()
                .map(ContactRow::getContact).collect(Collectors.toList());

        return new Memento<>(contacts);
    }

    public void sort(ContactSorter sorter) {
        List<ContactRow> sorted = sorter.sort(this.contactRows);
        this.removeAll();
        sorted.forEach(this::add);
    }

    public int indexOf(ContactRow contactRow) {
        return this.contactRows.indexOf(contactRow);
    }

    private void removeAll() {
        for (int i = this.contactRows.size() - 1; i >= 0; i--) {
            this.remove(i);
        }
    }

    @Override
    protected JComponent makeComponent() {
        return this.list;
    }

    public void setContactRows(List<ContactRow> newContactRows) {
        this.removeAll();
        newContactRows.forEach(this::add);
    }
}
