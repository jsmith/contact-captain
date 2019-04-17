package sorters;

import ui.Contact;
import utils.ContactIterator;

import java.util.ArrayList;
import java.util.List;

public abstract class ContactSorter {
    public List<Contact> sort(List<Contact> contacts) {
        List<Contact> slice =  new ArrayList<>( contacts);
        ContactIterator iterator = new ContactIterator(slice);

        // Perform insertion sort
        // Make sure to use the iterator class
        for (int i = 0; i < slice.size() - 1; i++) {
            int min = i;

            int j = i + 1;
            for (iterator.initialize(j); !iterator.isDone(); iterator.next(), j++) {
                Contact current = iterator.getCurrent();
                if (this.compare(current, slice.get(min)) < 0) {
                    min = j;
                }
            }

            if (i != min) {
                Contact temp = slice.get(min);
                slice.set(min, slice.get(i));
                slice.set(i, temp);
            }
        }

        return slice;
    }

    abstract int compare(Contact one, Contact two);
}
