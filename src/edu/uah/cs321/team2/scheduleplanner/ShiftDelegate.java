package edu.uah.cs321.team2.scheduleplanner;

import edu.uah.cs321.team2.scheduleplanner.model.Shift;

/**
 * Interface that allows Shift objects to be passed from places where they are updated
 * to where they are stored back to the main data storage class
 * @author Team 2
 */
public interface ShiftDelegate {
    /**
     * Method for updating an existing shift within the data store
     * @param identifier Unique ID of the shift to be updated
     * @param updatedShift The new information for the shift to be updated
     */
    void updateShiftWithID(int identifier, Shift updatedShift);
}
