package edu.uah.cs321.team2.scheduleplanner;

import edu.uah.cs321.team2.scheduleplanner.model.Person;

/**
 * Interface that allows Person objects to be passed from places where they are
 * created, updated, or deleted back to the main data storage class
 * @author Team 2
 */
public interface PersonDelegate {
    /**
     * Method for adding a new person to the data store
     * @param newPerson The new person to add to the data store
     */
    void addPerson(Person newPerson);
    
    /**
     * Method for updating an existing person within the data store
     * @param updatedPerson The new information for the updated person
     */
    void editPersonWithID(Person updatedPerson);
    
    /**
     * Method to remove a person from the data store
     * @param person Person to be removed from the data store
     */
    void deletePersonWithID(Person person);
}
