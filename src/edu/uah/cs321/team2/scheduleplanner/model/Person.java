package edu.uah.cs321.team2.scheduleplanner.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Person class manages the data associated with a person
 * @author Team 2
 */
public class Person implements Serializable {

    /**
     * Convenience constructor for a Person that sets the identifier to the current date in milliseconds
     * @param firstName String containing the first name
     * @param lastName String containing the last name
     * @param phone String containing the phone number
     * @param role Role object containing the role
     */
    public Person(String firstName, String lastName, String phone, Role role){
        this(new Date().getTime(),firstName,lastName,phone,role);
    }
    
    /**
     * Constructor for a Person that allows the identifier to be set
     * @param id Long integer representing a unique identifier for the person
     * @param first String containing the first name
     * @param last String containing the last name
     * @param phone String containing the phone number
     * @param role Role object containing the role
     */
    public Person(long id, String first, String last, String phone, Role role) {
        this.identifier = id;
        this.firstName = first;
        this.lastName = last;
        this.phone = phone;
        this.role = role;
    }
    
    /**
     * Getter for the combined name
     * Uses first name and last name
     * @return String representing complete name in format "first last"
     */
    public String getName(){
        return firstName + " " + lastName;
    }
    
    /**
     * Getter for the first name
     * @return String of the first name field
     */
    public String getFirstName(){
        return firstName;
    }
    
    /**
     * Getter for the last name
     * @return String of the last name field
     */
    public String getLastName(){
        return lastName;
    }
    
    /**
     * Setter for the first name
     * @param firstName String representing the new first name
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    /**
     * Setter for the last name
     * @param lastName String representing the new last name
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    /**
     * Getter for the phone number
     * @return String of the phone field
     */
    public String getPhone(){
        return phone;
    }
    
    /**
     * Setter for the phone number
     * @param phone String representing the new phone number
     */
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    /**
     * Getter for the name of the role field
     * @return String name from the role field
     */
    public String getRole(){
        return role.getName();
    }
    
    /**
     * Setter for the role
     * @param role Role object representing the new role
     */
    public void setRole(Role role){
        this.role = role;
    }
    
    /**
     * Getter for the identifier
     * @return Long integer representing the identifier field
     */
    public long getIdentifier(){
        return identifier;
    }
    
    /**
     * Overridden toString method for displaying a Person object
     * @return String representation of a Person object
     */
    @Override
    public String toString() {
        return "Person [personID=" + this.identifier
                + ", personFirstName=" + this.firstName
                + ", personLastName=" + this.lastName
                + ", personPhone=" + this.phone
                + ", personRole=" + this.role + "]";
    }
    
    private static final long serialVersionUID = 2L;
    private String firstName;
    private String lastName;
    private String phone;
    private Role role;
    private long identifier;
     
}
