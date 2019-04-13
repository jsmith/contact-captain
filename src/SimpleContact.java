import java.io.Serializable;

public class SimpleContact implements Serializable {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    SimpleContact setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    SimpleContact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    SimpleContact setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    SimpleContact setEmail(String email) {
        this.email = email;
        return this;
    }
}
