package edu.uah.cs321.team2.scheduleplanner;

/**
 * Interface that allows interested classes to be notified whenever a change occurs
 * to one or more shifts within the data store
 * @author Team 2
 */
public interface ShiftListener {
    /**
     * Method to inform listeners that a change has occurred
     */
    void shiftsUpdated();
}
