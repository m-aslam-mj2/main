package seedu.address.model.classroom;

import static java.util.Objects.requireNonNull;

import javax.xml.bind.annotation.XmlElement;



/**
 * Represents an enrollment size for the class in the app.
 */
public class Enrollment {
    @XmlElement
    private String value;

    public Enrollment() {
    }

    public Enrollment(String className) {
        requireNonNull(className);
        value = className;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Enrollment // instanceof handles nulls
                && value.equals(((Enrollment) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
