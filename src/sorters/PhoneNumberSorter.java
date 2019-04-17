package sorters;

import ui.Contact;

public class PhoneNumberSorter extends ContactSorter {
    @Override
    int compare(Contact one, Contact two) {
        return one.getPhoneNumber().compareTo(two.getPhoneNumber());
    }
}
