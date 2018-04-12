/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uah.cs321.team2.scheduleplanner.model;

/**
 *
 * @author Melissa
 */
public class Person {

    public Person(String firstName, String lastName, String phone, Role role){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.role = role;
        
        //set this to something meaningful later. maybe to the date in millisecs
        //so that the identifier is unique for each person
        identifier=0;
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
    public int getIdentifier(){
        return identifier;
    }
              
    private String firstName;
    private String lastName;
    private String phone;
    private Role role;
    private int identifier;
     
}
