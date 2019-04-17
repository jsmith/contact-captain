import java.util.List;

public class SortCommand implements Command {
    private ContactSorter sorter;
    private Momento<List<SimpleContact>> memento;
    private ContactList contactList;

    SortCommand(ContactSorter sorter, ContactList contactList) {
        this.sorter = sorter;
        this.contactList = contactList;
    }

    @Override
    public void execute() {
        this.memento = this.contactList.getMemento();
        this.contactList.sort(this.sorter);
    }

    @Override
    public void unexecute() {
        this.contactList.setMemento(this.memento);
        this.memento = null;
    }
}
