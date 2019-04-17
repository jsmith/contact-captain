package sorters;

import ui.Contact;

public class EmailSorter extends ContactSorter {
    @Override
    int compare(Contact one, Contact two) {
        return one.getEmail().compareTo(two.getEmail());
    }
}
