/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uah.cs321.team2.scheduleplanner.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Melissa
 */
public class Person implements Serializable {

    public Person(String firstName, String lastName, String phone, Role role){
        this(new Date().getTime(),firstName,lastName,phone,role);
    }
    
    public Person(long id, String first, String last, String phone, Role role) {
        this.identifier = id;
        this.firstName = first;
        this.lastName = last;
        this.phone = phone;
        this.role = role;
    }
    
    public String getName(){
        return firstName + " " + lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getRole(){
        return role.getName();
    }
    public void setRole(Role role){
        this.role = role;
    }
    public long getIdentifier(){
        return identifier;
    }
    
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
