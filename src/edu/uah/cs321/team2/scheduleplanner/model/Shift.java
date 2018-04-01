package edu.uah.cs321.team2.scheduleplanner.model;

/**
 *
 * @author Roger Ellson
 */
import java.util.*;

public class Shift {
    
   public static final int DAY_SUNDAY = 0;
   public static final int DAY_MONDAY = 1;
   public static final int DAY_TUESDAY = 2;
   public static final int DAY_WEDNESDAY = 3;
   public static final int DAY_THURSDAY = 4;
   public static final int DAY_FRIDAY = 5;
   public static final int DAY_SATURDAY = 6;
   
   public static final int HOUR_0 = 0;
   public static final int HOUR_1 = 1;
   public static final int HOUR_2 = 2;
   public static final int HOUR_3 = 3;
   public static final int HOUR_4 = 4;
   public static final int HOUR_5 = 5;
   public static final int HOUR_6 = 6;
   public static final int HOUR_7 = 7;
   public static final int HOUR_8 = 8;
   public static final int HOUR_9 = 9;
   public static final int HOUR_10 = 10;
   public static final int HOUR_11 = 11;
   public static final int HOUR_12 = 12;
   public static final int HOUR_13 = 13;
   public static final int HOUR_14 = 14;
   public static final int HOUR_15 = 15;
   public static final int HOUR_16 = 16;
   public static final int HOUR_17 = 17;
   public static final int HOUR_18 = 18;
   public static final int HOUR_19 = 19;
   public static final int HOUR_20 = 20;
   public static final int HOUR_21 = 21;
   public static final int HOUR_22 = 22;
   public static final int HOUR_23 = 23;
   
   public Shift(int day, int startTime, int endTime) {
       this.day = day;
       this.startTime = startTime;
       this.endTime = endTime;
   }
   
   public int getDay(){
       return day;
   }
   
   public int getStartTime() {
       return startTime;
   }
   
   public int getEndTime() {
       return endTime;
   }
   /*
   public ArrayList<Person> getPeople() {
       return (ArrayList<Person>) people.clone();
   }
   
   public void addPersonToList(Person newPerson) {
       people.add(newPerson);
   }
   
   public void removePersonFromList(Person oldPerson) {
       people.remove(oldPerson);
   }
   */
   private int day = 0;
   private int startTime = 0;
   private int endTime = 0;
   //private ArrayList<Person> people = new ArrayList<Person>();
}
