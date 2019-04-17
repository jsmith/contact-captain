package sorters;

import ui.Contact;

public class FirstNameSorter extends ContactSorter {
    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
