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
     * Retrieves a reference to the people list
     * 
     * @return A reference to people
     */
    public ArrayList<Person> getPeople() {
        return this.people;
    }
    
    /**
     * Retrieves a reference to the shifts list
     * 
     * @return A reference to shifts
     */
    public ArrayList<Shift> getShifts() {
        return this.shifts;
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
    
    /**
     * Adds a shift listener to the collection of listeners to be notified when shift changes occur
     * 
     * @param newListener The new listener to be notified when changes to shifts occur
     */
    public void addListenerToShiftListeners(ShiftListener newListener) {
        this.shiftListeners.add(newListener);
    }
    
    /**
     * Finds a shift with a given identifier and returns the shift or null
     * @param identifier ID of the shift to find
     * @return Shift with given ID if found, null otherwise
     */
    public Shift findShiftByID(long identifier) {
        int index = indexOfShiftByID(identifier);
        if (index != UNKNOWN_INDEX) {
            return this.shifts.get(index);
        } else {
            return null;
        }
    }
    
    public void createDefaultShifts() {
        Shift monMorning = new Shift(Shift.Day.Monday, Shift.Hour.EIGHT, Shift.Hour.THIRTEEN);
        Shift monEvening = new Shift(Shift.Day.Monday, Shift.Hour.FIFTEEN, Shift.Hour.TWENTY);
        Shift tueMorning = new Shift(Shift.Day.Tuesday, Shift.Hour.EIGHT, Shift.Hour.THIRTEEN);
        Shift tueEvening = new Shift(Shift.Day.Tuesday, Shift.Hour.FIFTEEN, Shift.Hour.TWENTY);
        Shift wedMorning = new Shift(Shift.Day.Wednesday, Shift.Hour.EIGHT, Shift.Hour.THIRTEEN);
        Shift wedEvening = new Shift(Shift.Day.Wednesday, Shift.Hour.FIFTEEN, Shift.Hour.TWENTY);
        Shift thuMorning = new Shift(Shift.Day.Thursday, Shift.Hour.EIGHT, Shift.Hour.THIRTEEN);
        Shift thuEvening = new Shift(Shift.Day.Thursday, Shift.Hour.FIFTEEN, Shift.Hour.TWENTY);
        Shift friMorning = new Shift(Shift.Day.Friday, Shift.Hour.EIGHT, Shift.Hour.THIRTEEN);
        Shift friEvening = new Shift(Shift.Day.Friday, Shift.Hour.FIFTEEN, Shift.Hour.TWENTY);
        Shift satMorning = new Shift(Shift.Day.Saturday, Shift.Hour.EIGHT, Shift.Hour.THIRTEEN);
        Shift satEvening = new Shift(Shift.Day.Saturday, Shift.Hour.FIFTEEN, Shift.Hour.TWENTY);
        Shift sunMorning = new Shift(Shift.Day.Sunday, Shift.Hour.EIGHT, Shift.Hour.THIRTEEN);
        Shift sunEvening = new Shift(Shift.Day.Sunday, Shift.Hour.FIFTEEN, Shift.Hour.TWENTY);
        
        this.shifts.add(monMorning);
        this.shifts.add(monEvening);
        this.shifts.add(tueMorning);
        this.shifts.add(tueEvening);
        this.shifts.add(wedMorning);
        this.shifts.add(wedEvening);
        this.shifts.add(thuMorning);
        this.shifts.add(thuEvening);
        this.shifts.add(friMorning);
        this.shifts.add(friEvening);
        this.shifts.add(satMorning);
        this.shifts.add(satEvening);
        this.shifts.add(sunMorning);
        this.shifts.add(sunEvening);
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
        // Find Shift by ID
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
