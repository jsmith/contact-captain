public class LastNameSorter extends ContactSorter {
    @Override
    int compare(Contact one, Contact two) {
        return one.getFirstName().compareTo(two.getFirstName());
    }
}
