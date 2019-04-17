package captain.sorters;

import captain.ui.ContactRow;

public class EmailSorter extends ContactSorter {
    @Override
    int compare(ContactRow one, ContactRow two) {
        return one.getEmail().compareTo(two.getEmail());
    }
}
