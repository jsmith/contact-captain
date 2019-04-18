package captain.models;

import java.io.Serializable;

public class Contact implements Serializable, Prototype<Contact> {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public Contact setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Contact setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public Contact clone() {
        return new Contact()
                .setFirstName(this.firstName)
                .setLastName(this.lastName)
                .setEmail(this.email)
                .setPhoneNumber(this.phoneNumber);
    }
}
