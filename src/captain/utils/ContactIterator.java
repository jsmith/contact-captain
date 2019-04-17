package captain.utils;

import captain.ui.ContactRow;

import java.util.List;

public class ContactIterator {
    private int currentIndex = -1;
    private List<ContactRow> contactRows;

    public ContactIterator(List<ContactRow> contactRows) {
        this.contactRows = contactRows;
    }

    public void initialize() {
        this.currentIndex = 0;
    }

    public void initialize(int index) {
        this.currentIndex = index;
    }

    public void next() {
        this.currentIndex++;
    }

    public boolean isDone() {
        return this.contactRows.size() <= this.currentIndex;
    }

    public ContactRow getCurrent() {
        return this.contactRows.get(this.currentIndex);
    }
}
