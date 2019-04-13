import java.util.List;

public class FirstNameSorter extends ContactSorter {
    FirstNameSorter(List<Contact> contacts) {
        super(contacts);
    }

    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
