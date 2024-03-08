package seedu.address.model.patient;

import static java.util.Objects.requireNonNull;

/**
 * Represents the Family Condition of the Patient
 */
public class FamilyCondition {
    public final String familyCondition;

    /**
     * Constructs a {@code FamilyCondition}.
     *
     * @param familyCondition A valid name.
     */
    public FamilyCondition(String familyCondition) {
        requireNonNull(familyCondition);
        this.familyCondition = familyCondition;
    }

    @Override
    public String toString() {
        return this.familyCondition;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(o instanceof FamilyCondition)) {
            return false;
        }

        FamilyCondition other = (FamilyCondition) o;
        return this.familyCondition.equals(other.familyCondition);
    }
}
