package seedu.address.model.patient;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents Important Dates for a Patient
 */
public class ImportantDate {
    public static final String MESSAGE_CONSTRAINTS =
            "Dates should be in the format: DD-MM-YYYY, HH:mm - HH:mm, OR if there is no time period,"
            + "in the format: DD-MM-YYYY";
    public static final String DATE_PATTERN = "dd-MM-yyyy";
    public static final String TIME_PATTERN = "HH:mm";



    /** The name of the Important Date */
    public final String name;
    /** The Date of the Important Date */
    public final String importantDate;
    /** The Start Time of the Important Date, null if there is no specific start time */
    public final String startTime;
    /** The End Time of the Important Date, null if there is no specific end time */
    public final String endTime;




    /**
     * Constructs a {@Code ImportantDate}
     *
     * @param importantDate
     */
    public ImportantDate(String name, String importantDate) {
        requireNonNull(name);
        this.name = name;

        importantDate = importantDate.strip();
        requireNonNull(importantDate);
        checkArgument(isValidImportantDate(importantDate), MESSAGE_CONSTRAINTS);

        String[] args = extractDateTimeArgs(importantDate);
        this.importantDate = args[0];
        this.startTime = args[1];
        this.endTime = args[2];
    }

    /**
     * Returns true if the given string is a valid Date / Datetime String
     *
     * @param test the given string
     * @return true if the {@param test} is valid,
     *         false is the {@param test} is not valid
     */
    public static boolean isValidImportantDate(String test) {
        String[] args = test.split(",");

        try {
            LocalDate.parse(args[0].trim(), DateTimeFormatter.ofPattern(DATE_PATTERN));
        } catch (DateTimeParseException e) {
            return false;
        }

        if (args.length > 1) {
            return isValidDateTimeStr(args[1]);
        }

        return true;
    }


    /**
     * Returns true if the given string is a valid time String
     *
     * @param timeStr the given string
     * @return true if the {@param timeStr} is valid,
     *         false is the {@param timeStr} is not valid
     */
    public static boolean isValidDateTimeStr(String timeStr) {
        String[] args = timeStr.split("-");
        try {
            LocalTime.parse(args[0].trim(), DateTimeFormatter.ofPattern(TIME_PATTERN)); // start time
            LocalTime.parse(args[1].trim(), DateTimeFormatter.ofPattern(TIME_PATTERN)); // end time
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }


    /**
     * Extracts the date and/or time arguments from the user input
     *
     * @param userInput
     * @return a String[] of the arguments extracted
     */
    public static String[] extractDateTimeArgs(String userInput) {
        String[] args = userInput.split(",");
        args[0] = args[0].strip();

        String[] temp = new String[2];
        if (args.length > 1) {
            temp = args[1].split("-");
            temp[0] = temp[0].strip();
            temp[1] = temp[1].strip();
        } else {
            temp[0] = null;
            temp[1] = null;
        }

        return new String[] {args[0], temp[0], temp[1]};
    }


    @Override
    public String toString() {
        // If there is a start time, there must be a end time
        if (this.startTime != null) {
            return String.format("%s (%s, from %s to %s)", this.name, this.importantDate, this.startTime, this.endTime);
        }

        return String.format("%s (%s)", this.name, this.importantDate);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof ImportantDate)) {
            return false;
        }

        ImportantDate otherImportantDate = (ImportantDate) other;
        if (this.startTime == null) {
            return this.name.equals(otherImportantDate.name)
                    && this.importantDate.equals(otherImportantDate.importantDate);
        }

        return this.name.equals(otherImportantDate.name)
                && this.importantDate.equals(otherImportantDate.importantDate)
                && this.startTime.equals(otherImportantDate.startTime)
                && this.endTime.equals(otherImportantDate.endTime);
    }

    @Override
    public int hashCode() {
        return importantDate.hashCode();
    }
}
