package seedu.address.model.patient;

import static java.util.Objects.requireNonNull;

/**
 * Represents the Food Preferrence of the Patient
 */
public class FoodPreference {
    public final String foodPreference;

    /**
     * Constructs a {@code FoodPreference}.
     *
     * @param foodPreference A valid name.
     */
    public FoodPreference(String foodPreference) {
        requireNonNull(foodPreference);
        this.foodPreference = foodPreference;
    }

    @Override
    public String toString() {
        return this.foodPreference;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FoodPreference)) {
            return false;
        }

        FoodPreference otherPreference = (FoodPreference) other;
        return this.foodPreference.equals(otherPreference.foodPreference);
    }
}
