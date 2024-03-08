package seedu.address.model.patient;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents the Hospital ID of the Patient
 */
public class HospitalId {

    public static final String MESSAGE_CONSTRAINTS =
            "HospitalId should only contain alphabetical characters, and it should not be blank";

    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum}]*";

    public final String hospitalId;

    /**
     * Constructs a {@code HospitalId}.
     *
     * @param hospitalId A valid name.
     */
    public HospitalId(String hospitalId) {
        requireNonNull(hospitalId);
        checkArgument(isValidName(hospitalId), MESSAGE_CONSTRAINTS);
        this.hospitalId = hospitalId;
    }

    /**
     * Returns true if a given string is a valid Hospital Id
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

        HospitalId other = (HospitalId) o;
        return this.hospitalId.equals(other.hospitalId);
    }
}
