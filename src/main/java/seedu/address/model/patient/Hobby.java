package seedu.address.model.patient;


import static java.util.Objects.requireNonNull;

/**
 * Represents the Hobby of the Patient
 */
public class Hobby {
    public final String hobby;

    /**
     * Constructs a {@code Hobby}.
     *
     * @param hobby A valid name.
     */
    public Hobby(String hobby) {
        requireNonNull(hobby);
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return this.hobby;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(o instanceof Hobby)) {
            return false;
        }

        Hobby other = (Hobby) o;
        return this.hobby.equals(other.hobby);
    }
}
