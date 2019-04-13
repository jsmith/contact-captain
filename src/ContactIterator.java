import java.util.List;

class ContactIterator {
    private int currentIndex = -1;
    private List<Contact> contacts;

    ContactIterator(List<Contact> contacts) {
        this.contacts = contacts;
    }

    void initialize() {
        this.currentIndex = 0;
    }

    void initialize(int index) {
        this.currentIndex = index;
    }

    void next() {
        this.currentIndex++;
    }

    boolean isDone() {
        return this.contacts.size() >= this.currentIndex;
    }

    Contact getCurrent() {
        return this.contacts.get(this.currentIndex);
    }
}
