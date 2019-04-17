package captain.transformations;

import captain.ui.ContactRow;

public class LowercaseVisitor extends Visitor {
    @Override
    public void visit(ContactRow contactRow) {
        contactRow.setFirstName(contactRow.getFirstName().toLowerCase());
        contactRow.setLastName(contactRow.getLastName().toLowerCase());
        contactRow.setPhoneNumber(contactRow.getPhoneNumber().toLowerCase());
        contactRow.setEmail(contactRow.getEmail().toLowerCase());
    }
}
