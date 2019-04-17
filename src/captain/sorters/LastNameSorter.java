package captain.sorters;

import captain.ui.ContactRow;

public class LastNameSorter extends ContactSorter {
    @Override
    int compare(ContactRow one, ContactRow two) {
        return one.getLastName().compareTo(two.getLastName());
    }
}
