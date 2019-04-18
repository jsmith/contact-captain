package captain.sorters;

import captain.ui.ContactRow;

import java.util.ArrayList;
import java.util.List;

public abstract class ContactSorter {
    public List<ContactRow> sort(List<ContactRow> contactRows) {
        List<ContactRow> slice =  new ArrayList<>(contactRows);

        // Perform insertion sort
        // Make sure to use the iterator class
        for (int i = 0; i < slice.size() - 1; i++) {
            int min = i;

            for (int j = i + 1; j < slice.size(); j++) {
                ContactRow current = slice.get(j);
                if (this.compare(current, slice.get(min)) < 0) {
                    min = j;
                }
            }

            if (i != min) {
                ContactRow temp = slice.get(min);
                slice.set(min, slice.get(i));
                slice.set(i, temp);
            }
        }

        return slice;
    }

    abstract int compare(ContactRow one, ContactRow two);
}
