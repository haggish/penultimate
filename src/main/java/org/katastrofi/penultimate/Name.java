package org.katastrofi.penultimate;

/**
 * Character name.
 */
class Name {

    private final String firstName;

    private final String secondName;

    private final String lastName;

    Name(String firstName, String secondName, String lastName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
    }

    Name(String firstName, String lastName) {
        this(firstName, null, lastName);
    }

    String firstName() {
        return firstName;
    }

    String secondName() {
        return secondName;
    }

    String lastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;

        Name name = (Name) o;

        if (!firstName.equals(name.firstName)) return false;
        if (secondName != null ? !secondName.equals(name.secondName) : name.secondName != null)
            return false;
        return !(lastName != null ? !lastName.equals(name.lastName) : name.lastName != null);

    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
