package captain.transformations;

import captain.ui.ContactRow;

import java.util.List;

public abstract class Visitor {
    public void traverse(List<ContactRow> contactRowList) {
        contactRowList.forEach(this::visit);
    }

    abstract public void visit(ContactRow contactRow);
}
