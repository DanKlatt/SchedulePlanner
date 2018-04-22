package edu.uah.cs321.team2.scheduleplanner.model;

import java.io.Serializable;
import java.util.*;

/**
 * A class for creating and managing shift objects
 * @author Team 2
 */

public class Shift implements Serializable {
   /**
    * Day enumeration containing all days of the week
    */
   public enum Day {
       Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday
   }
   
   /**
    * Hour enumeration containing every hour in a day, in 24H format
    */
   public enum Hour {
       ZERO("00:00"),
       ONE("01:00"),
       TWO("02:00"),
       THREE("03:00"),
       FOUR("04:00"),
       FIVE("05:00"),
       SIX("06:00"),
       SEVEN("07:00"),
       EIGHT("08:00"),
       NINE("09:00"),
       TEN("10:00"),
       ELEVEN("11:00"),
       TWELVE("12:00"),
       THIRTEEN("13:00"),
       FOURTEEN("14:00"),
       FIFTEEN("15:00"),
       SIXTEEN("16:00"),
       SEVENTEEN("17:00"),
       EIGHTEEN("18:00"),
       NINETEEN("19:00"),
       TWENTY("20:00"),
       TWENTY_ONE("21:00"),
       TWENTY_TWO("22:00"),
       TWENTY_THREE("23:00");
   
       private String time;
       
       Hour(String readableTime) {
           this.time = readableTime;
       }
       
       /**
        * Getter for the human readable time property of the Hour enumeration
        * @return String representation of the Hour
        */
       public String getTime() {
           return time;
       }
   }
   
    /**
     * Constructs a shift object
     * @param day Day the shift is on
     * @param startTime Start time of the shift
     * @param endTime End time of the shift
     */
    public Shift(Day day, Hour startTime, Hour endTime) {
       this(new Date().getTime(),day,startTime,endTime);
   }
   
    /**
     * Constructs a shift object with a shift identifier
     * @param id Shift identifier
     * @param day Day the shift is on
     * @param start Start time of the shift
     * @param end End time of the shift
     */
    public Shift(long id, Day day, Hour start, Hour end) {
       this.identifier = id;
       this.day = day;
       this.startTime = start;
       this.endTime = end;
       this.people = new ArrayList<>();
   }
   
    /**
     * Getter for shift identifier
     * @return Shift identifier
     */
    public long getIdentifier() {
       return this.identifier;
   }
   
    /**
     * Getter for shift day
     * @return Shift day
     */
    public Day getDay(){
       return day;
   }
   
    /**
     * Getter for shift start time
     * @return Shift start time
     */
    public Hour getStartTime() {
       return startTime;
   }
   
    /**
     * Getter for shift start time in string format
     * @return Shift start time in string format
     */
    public String getReadableStartTime() {
       return startTime.getTime();
   }
   
    /**
     * Getter for shift end time
     * @return Shift end time
     */
    public Hour getEndTime() {
       return endTime;
   }
   
    /**
     * Getter for shift end time in string format
     * @return Shift end time in string format
     */
    public String getReadableEndTime() {
       return endTime.getTime();
   }
   
    /**
     * Getter for people assigned to a shift
     * @return People assigned to a shift
     */
    public ArrayList<Person> getPeople() {
       return this.people;
   }
   
    /**
     * Setter for adding a person to a shift
     * @param newPerson Person to be added to a shift
     */
    public void addPersonToList(Person newPerson) {
       people.add(newPerson);
   }
   
    /**
     * Setter for removing someone from a shift
     * @param oldPerson Person to be removed from a shift
     */
    public void removePersonFromList(Person oldPerson) {
       if (!people.isEmpty() && people.contains(oldPerson)) {
           people.remove(oldPerson);
       }
   }
   
    /**
     * Update a person already assigned to a shift
     * @param updatedPerson Person to be updated
     */
    public void changePersonInList(Person updatedPerson) {
       if(!people.isEmpty()) {
           for(Person person : this.people) {
               if(person.getIdentifier() == updatedPerson.getIdentifier()) {
                   int index = this.people.indexOf(person);
                   this.people.set(index, updatedPerson);
               }
           }
       }
   }
   
    /**
     * Remove all people from a shift
     */
    public void removeAllPeopleFromShift() {
       this.people = new ArrayList<>();
   }
   
    /**
     * Getter for the number of managers assigned to a shift
     * @return The count of managers assigned to a shift
     */
    public int getManagerCount() {
       int managerCount = 0;
       for (Person employee : this.people) {
           if (employee.getRole().equals("Manager")) {
               managerCount += 1;
           }
       }
       return managerCount;
   }
   
    /**
     * Getter for the number of workers assigned to a shift
     * @return The count of managers assigned to a shift
     */
    public int getWorkerCount() {
       int workerCount = 0;
       for (Person employee : this.people) {
           if (employee.getRole().equals("Worker")) {
               workerCount += 1;
           }
       }
       return workerCount;
   }
   
     /**
     * Getter for a summary of shift information in string format
     * @return String containing a summary of shift information
     */
   @Override
   public String toString() {
       return "Shift [shiftID=" + this.identifier
               + ", shiftDay=" + this.day
               + ", shiftStartTime=" + this.getReadableStartTime()
               + ", shiftEndTime=" + this.getReadableEndTime()
               + ", shiftPersons=" + this.people + "]";
   }
   
   private static final long serialVersionUID = 4L;
   private long identifier;
   private Day day;
   private Hour startTime;
   private Hour endTime;
   private ArrayList<Person> people;
}
