package captain.transformations;

import captain.ui.ContactRow;

public class UppercaseVisitor extends Visitor {
    @Override
    public void visit(ContactRow contactRow) {
        contactRow.setFirstName(contactRow.getFirstName().toUpperCase());
        contactRow.setLastName(contactRow.getLastName().toUpperCase());
        contactRow.setPhoneNumber(contactRow.getPhoneNumber().toUpperCase());
        contactRow.setEmail(contactRow.getEmail().toUpperCase());
    }
}
