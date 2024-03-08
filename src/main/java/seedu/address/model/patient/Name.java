package seedu.address.model.patient;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents the name of the Patient in the address book
 */
public class Name {

    public static final String MESSAGE_CONSTRAINTS =
            "Names should only contain alphabetical characters and spaces, and it should not be blank";

    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String fullName;

    /**
     * Constructs a {@code Name}.
     *
     * @param fullName A valid name.
     */
    public Name(String fullName) {
        requireNonNull(fullName);
        checkArgument(isValidName(fullName), MESSAGE_CONSTRAINTS);
        this.fullName = fullName;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Name)) {
            return false;
        }

        Name otherName = (Name) o;
        return fullName.equals(otherName.fullName);
    }
}
