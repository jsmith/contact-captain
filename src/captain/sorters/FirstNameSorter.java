package captain.sorters;

import captain.ui.ContactRow;

public class FirstNameSorter extends ContactSorter {
    @Override
    public int compare(ContactRow o1, ContactRow o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
