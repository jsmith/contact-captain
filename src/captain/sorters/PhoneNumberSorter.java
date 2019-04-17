package captain.sorters;

import captain.ui.ContactRow;

public class PhoneNumberSorter extends ContactSorter {
    @Override
    int compare(ContactRow one, ContactRow two) {
        return one.getPhoneNumber().compareTo(two.getPhoneNumber());
    }
}
