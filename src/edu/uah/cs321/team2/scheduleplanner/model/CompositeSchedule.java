package edu.uah.cs321.team2.scheduleplanner.model;

import java.io.Serializable;
import java.util.ArrayList;
import edu.uah.cs321.team2.scheduleplanner.PersonDelegate;
import edu.uah.cs321.team2.scheduleplanner.ShiftDelegate;

/**
 * The model that contains the collections of data that make up
 * a composite schedule
 * @author Team 2
 */
public class CompositeSchedule implements Serializable, PersonDelegate, ShiftDelegate {
    /**
     * Constructs a CompositeSchedule object with empty lists
     */
    public CompositeSchedule() {
        this.people = new ArrayList<>();
        this.shifts = new ArrayList<>();
    }
    
    /**
     * Retrieves a copy of the people list
     * 
     * @return A copy of people
     */
    public ArrayList<Person> getPeople() {
        return (ArrayList<Person>) this.people.clone();
    }
    
    /**
     * Retrieves a copy of the shifts list
     * 
     * @return A copy of shifts
     */
    public ArrayList<Shift> getShifts() {
        return (ArrayList<Shift>) this.shifts.clone();
    }
    
    /**
     * Adds a person to the collection of available people
     * 
     * @param newPerson The new person who will be added to the list of people
     */
    public void addPersonToPeople(Person newPerson) {
        this.people.add(newPerson);
        // send out a notification?
    }
    
    /**
     * Adds a shift to the collection of available shifts
     * 
     * @param newShift The new shift that will be added to the list of shifts
     */
    public void addShiftToShifts(Shift newShift) {
        this.shifts.add(newShift);
        // send out a notification?
    }
    
    // Section for PersonDelegate methods
    @Override
    public void addPerson(Person newPerson) {
        this.addPersonToPeople(newPerson);
    }
    
    @Override
    public void editPerson(Person updatedPerson) {
        // Find Person by ID
        // Replace Person in people
    }
    
    @Override
    public void deletePerson(Person person) {
        // Find Person by ID
        // Remove Person from people
    }
    
    // Section for ShiftDelegate methods
    @Override
    public void updateShift(Shift updatedShift) {
        // FInd Shift by ID
        // Replace Shift in shifts
    }
    
    public int indexOfPersonByID(long searchID) {
        for(Person person : this.people) {
            if (person.getIdentifier() == searchID) {
                return this.people.indexOf(person);
            }
        }
        return -1;
    }
    
    @Override
    public String toString() {
        return "CompositeSchedule [schedulePeople=" + this.people
                + ", scheduleShifts=" + this.shifts + "]";
    }
    
    private static final long serialVersionUID = 1L;
    private ArrayList<Person> people;
    private ArrayList<Shift> shifts;
}
