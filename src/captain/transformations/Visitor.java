package captain.transformations;

import captain.ui.ContactRow;
import captain.utils.ContactIterator;

import java.util.List;

public abstract class Visitor {
    public void traverse(List<ContactRow> contactRowList) {
        ContactIterator iterator = new ContactIterator(contactRowList);
        for(iterator.initialize(); !iterator.isDone(); iterator.next()) {
            this.visit(iterator.getCurrent());
        }
    }

    abstract public void visit(ContactRow contactRow);
}
