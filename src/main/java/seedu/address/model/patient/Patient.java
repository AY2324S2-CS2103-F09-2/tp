package seedu.address.model.patient;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Represents a Patient in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Patient {

    // Identity fields
    private final PatientHospitalId patientHospitalId;
    private final Name name;
    private final PreferredName preferredName;

    // Data fields
    private final FoodPreference foodPreference;
    private final FamilyCondition familyCondition;
    private final Hobby hobby;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Patient(PatientHospitalId patientHospitalId, Name name, PreferredName preferredName,
                   FoodPreference foodPreference, FamilyCondition familyCondition, Hobby hobby,
                   Set<Tag> tags) {
        requireAllNonNull(patientHospitalId, name, preferredName, foodPreference, familyCondition, hobby, tags);
        this.patientHospitalId = patientHospitalId;
        this.name = name;
        this.preferredName = preferredName;
        this.foodPreference = foodPreference;
        this.familyCondition = familyCondition;
        this.hobby = hobby;
        this.tags.addAll(tags);
    }

    public PatientHospitalId getPatientHospitalId() {
        return patientHospitalId;
    }

    public Name getName() {
        return name;
    }

    public PreferredName getPreferredName() {
        return preferredName;
    }

    public FamilyCondition getFamilyCondition() {
        return familyCondition;
    }

    public FoodPreference getFoodPreference() {
        return foodPreference;
    }

    public Hobby getHobby() {
        return hobby;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both patients have the same name.
     * This defines a weaker notion of equality between two patients.
     */
    public boolean isSamePatient(Patient otherPatient) {
        if (otherPatient == this) {
            return true;
        }

        return otherPatient != null
                && otherPatient.getName().equals(getName());
    }

    /**
     * Returns true if both patients have the same identity and data fields.
     * This defines a stronger notion of equality between two patients.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Patient)) {
            return false;
        }

        Patient otherPatient = (Patient) other;
        return patientHospitalId.equals(otherPatient.patientHospitalId)
                && name.equals(otherPatient.name)
                && preferredName.equals(otherPatient.preferredName)
                && foodPreference.equals(otherPatient.foodPreference)
                && familyCondition.equals(otherPatient.familyCondition)
                && hobby.equals(otherPatient.hobby)
                && tags.equals(otherPatient.tags);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(patientHospitalId, name, preferredName, foodPreference, familyCondition, hobby, tags);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .add("patient_hospital_id", patientHospitalId)
            .add("name", name)
            .add("preferred_name", preferredName)
            .add("food_preference", foodPreference)
            .add("family_condition", familyCondition)
            .add("hobby", hobby)
            .add("tags", tags)
            .toString();
    }

}
