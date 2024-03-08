package seedu.address.model.patient;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents the Preferred Name of the Patient
 */
public class PreferredName {

    public static final String MESSAGE_CONSTRAINTS =
            "Names should only contain alphanumeric characters and spaces, and it should not be blank";

    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String preferredName;

    /**
     * Constructs a {@code PreferredName}.
     *
     * @param preferredName A valid name.
     */
    public PreferredName(String preferredName) {
        requireNonNull(preferredName);
        checkArgument(isValidName(preferredName), MESSAGE_CONSTRAINTS);
        this.preferredName = preferredName;
    }

    /**
     * Returns true if a given string is a valid preferred name.
     */
    public static boolean isValidName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return this.preferredName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof PreferredName)) {
            return false;
        }

        PreferredName otherName = (PreferredName) o;
        return preferredName.equals(otherName.preferredName);
    }
}
