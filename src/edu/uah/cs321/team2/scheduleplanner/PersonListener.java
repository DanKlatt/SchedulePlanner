package edu.uah.cs321.team2.scheduleplanner;

/**
 * Interface that allows interested classes to be notified whenever a change occurs
 * to one or more persons within the data store
 * @author stark
 */
public interface PersonListener {
    /**
     * Method to inform listeners that a change has occurred
     */
    void peopleUpdated();
}
