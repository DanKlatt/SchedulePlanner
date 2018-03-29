package edu.uah.cs321.team2.scheduleplanner.model;

import java.util.ArrayList;

/**
 * The model that contains the collections of data that make up
 * a composite schedule
 * @author Team 2
 */
public class CompositeSchedule {
    /**
     * Constructs a CompositeSchedule object with empty lists
     */
    public CompositeSchedule() {
        /*
        this.people = new ArrayList<Person>();
        this.shifts = new ArrayList<Shift>();
        */
    }
    
    /**
     * Retrieves a copy of the people list
     * 
     * @return A copy of people
     */
    /*
    public ArrayList<Person> getPeople() {
        // TODO: make this a deep copy
        return new ArrayList<Person>(this.people);
    }
    */
    
    /**
     * Retrieves a copy of the shifts list
     * 
     * @return A copy of shifts
     */
    /*
    public ArrayList<Shift> getShifts() {
        // TODO: make this a deep copy
        return new ArrayList<Shift>(this.shifts);
    }
    */
    
    /**
     * Adds a person to the collection of available people
     * 
     * @param newPerson The new person who will be added to the list of people
     */
    /*
    public void addPersonToPeople(Person newPerson) {
        this.people.add(newPerson);
        // send out a notification?
    }
    */
    
    /**
     * Adds a shift to the collection of available shifts
     * 
     * @param newShift The new shift that will be added to the list of shifts
     */
    /*
    public void addShiftToShifts(Shift newShift) {
        this.shifts.add(newShift);
        // send out a notification?
    }
    */
    
    // These fields will have to wait until the other models are in place...
    // private ArrayList<Person> people;
    // private ArrayList<Shift> shifts;
}
