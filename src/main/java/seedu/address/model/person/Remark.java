package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Person's remark in the address book.
 * Guarantees: immutable; is always valid
 */
public class Remark {
    public final String value;

    /**
     * Constructs a Remark object with the specified string value.
     *
     * @param remark The string value representing the remark.
     * @throws NullPointerException if the provided remark is null.
     */
    public Remark(String remark) {
        requireNonNull(remark);
        value = remark;
    }

    /**
     * Returns the string representation of the remark.
     *
     * @return The string value of the remark.
     */
    @Override
    public String toString() {
        return value;
    }

    /**
     * Checks if this Remark is equal to another object.
     *
     * @param other The object to compare with this Remark.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Remark // instanceof handles nulls
                && value.equals(((Remark) other).value)); // state check
    }

    /**
     * Generates a hash code for this Remark.
     *
     * @return The hash code for this Remark.
     */
    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
