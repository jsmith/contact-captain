package sorters;

import ui.Contact;

public class LastNameSorter extends ContactSorter {
    @Override
    int compare(Contact one, Contact two) {
        return one.getLastName().compareTo(two.getLastName());
    }
}
