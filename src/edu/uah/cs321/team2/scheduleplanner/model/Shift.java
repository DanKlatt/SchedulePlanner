package edu.uah.cs321.team2.scheduleplanner.model;

/**
 *
 * @author Roger Ellson
 */
import java.util.*;

public class Shift {
   public enum Day {
       Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday
   }
   
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
       
       public String getTime() {
           return time;
       }
   }
   
   public Shift(Day day, Hour startTime, Hour endTime) {
       this.day = day;
       this.startTime = startTime;
       this.endTime = endTime;
       this.people = new ArrayList<>();
   }
   
   public Day getDay(){
       return day;
   }
   
   public Hour getStartTime() {
       return startTime;
   }
   
   public String getReadableStartTime() {
       return startTime.getTime();
   }
   
   public Hour getEndTime() {
       return endTime;
   }
   
   public String getReadableEndTime() {
       return endTime.getTime();
   }
   
   public ArrayList<Person> getPeople() {
       return (ArrayList<Person>) people.clone();
   }
   
   public void addPersonToList(Person newPerson) {
       people.add(newPerson);
   }
   
   public void removePersonFromList(Person oldPerson) {
       if (!people.isEmpty() && people.contains(oldPerson)) {
           people.remove(oldPerson);
       }
   }
   
   public void removeAllPeopleFromShift() {
       this.people = new ArrayList<>();
   }
   
   private Day day;
   private Hour startTime;
   private Hour endTime;
   private ArrayList<Person> people;
}
