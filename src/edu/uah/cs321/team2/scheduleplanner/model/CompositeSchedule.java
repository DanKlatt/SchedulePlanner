package edu.uah.cs321.team2.scheduleplanner.model;

import java.io.Serializable;
import java.util.ArrayList;
import edu.uah.cs321.team2.scheduleplanner.PersonDelegate;
import edu.uah.cs321.team2.scheduleplanner.ShiftDelegate;
import edu.uah.cs321.team2.scheduleplanner.PersonListener;
import edu.uah.cs321.team2.scheduleplanner.ShiftListener;

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
        this.personListeners = new ArrayList<>();
        this.shiftListeners = new ArrayList<>();
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
        this.notifyPersonListeners();
    }
    
    /**
     * Adds a shift to the collection of available shifts
     * 
     * @param newShift The new shift that will be added to the list of shifts
     */
    public void addShiftToShifts(Shift newShift) {
        this.shifts.add(newShift);
        this.notifyShiftListeners();
    }
    
    /**
     * Adds a person listener to the collection of listeners to be notified when person changes occur
     * 
     * @param newListener The new listener to be notified when changes to persons occur
     */
    public void addListenerToPersonListeners(PersonListener newListener) {
        this.personListeners.add(newListener);
    }
    
    public void addListenerToShiftListeners(ShiftListener newListener) {
        this.shiftListeners.add(newListener);
    }
    
    // Section for PersonDelegate methods
    @Override
    public void addPerson(Person newPerson) {
        this.addPersonToPeople(newPerson);
        this.notifyPersonListeners();
    }
    
    @Override
    public void editPerson(Person updatedPerson) {
        // Find Person by ID
        int index = indexOfPersonByID(updatedPerson.getIdentifier());
        // Replace Person in people
        if (index != UNKNOWN_INDEX) {
            this.people.set(index, updatedPerson);
            this.notifyPersonListeners();
        }
    }
    
    @Override
    public void deletePerson(Person person) {
        // Find Person by ID
        int index = indexOfPersonByID(person.getIdentifier());
        // Remove Person from people
        if (index != UNKNOWN_INDEX) {
            this.people.remove(index);
            this.notifyPersonListeners();
        }
    }
    
    // Section for ShiftDelegate methods
    @Override
    public void updateShift(Shift updatedShift) {
        // FInd Shift by ID
        int index = indexOfShiftByID(updatedShift.getIdentifier());
        // Replace Shift in shifts
        if (index != UNKNOWN_INDEX) {
            this.shifts.set(index, updatedShift);
            this.notifyShiftListeners();
        }
    }
    
    private int indexOfPersonByID(long searchID) {
        for(Person person : this.people) {
            if (person.getIdentifier() == searchID) {
                return this.people.indexOf(person);
            }
        }
        return UNKNOWN_INDEX;
    }
    
    private int indexOfShiftByID(long searchID) {
        for(Shift shift : this.shifts) {
            if(shift.getIdentifier() == searchID) {
                return this.shifts.indexOf(shift);
            }
        }
        return UNKNOWN_INDEX;
    }
    
    private void notifyPersonListeners() {
        for(PersonListener listener : this.personListeners) {
            listener.peopleUpdated();
        }
    }
    
    private void notifyShiftListeners() {
        for(ShiftListener listener : this.shiftListeners) {
            listener.shiftsUpdated();
        }
    }
    
    @Override
    public String toString() {
        return "CompositeSchedule [schedulePeople=" + this.people
                + ", scheduleShifts=" + this.shifts + "]";
    }
    
    private static final int UNKNOWN_INDEX = -1;
    private static final long serialVersionUID = 1L;
    private ArrayList<Person> people;
    private ArrayList<Shift> shifts;
    private ArrayList<PersonListener> personListeners;
    private ArrayList<ShiftListener> shiftListeners;
}
