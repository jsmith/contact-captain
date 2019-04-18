package captain.transformations;

import captain.ui.ContactRow;

public class UppercaseVisitor extends Visitor {
    private static final Visitor visitor = new UppercaseVisitor();

    public static Visitor Instance() {
        return UppercaseVisitor.visitor;
    }

    private UppercaseVisitor() {
        // make constructor private
    }

    @Override
    public void visit(ContactRow contactRow) {
        contactRow.setFirstName(contactRow.getFirstName().toUpperCase());
        contactRow.setLastName(contactRow.getLastName().toUpperCase());
        contactRow.setPhoneNumber(contactRow.getPhoneNumber().toUpperCase());
        contactRow.setEmail(contactRow.getEmail().toUpperCase());
    }
}
