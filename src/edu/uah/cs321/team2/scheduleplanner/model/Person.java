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

    public Person(String name, String phone, Role role){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getRole(){
        //return roleName;
    }
    public void setRole(Role role){
        this.role = role;
    }
    
    
    
    
    
    private String name;
    private String phone;
    private Role role;
    
    
}
