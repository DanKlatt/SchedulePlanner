/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sameerawarsi
 */

package edu.uah.cs321.team2.scheduleplanner.model;

public class Role {
    public static final int Type_Manager = 1;
    public static final int Type_Worker = 0;
    
    private String name;
    private int type;
    
    public Role() {
        type = Type_Worker;
        name = "Worker";
    }

    public Role(int Type) {
        type = Type;
        if(type==Type_Manager) {
            name = "Manager";
        }
        else if(type==Type_Worker) {
            name = "Worker";
        }
    }
    public String getName() {
        return name;
    }
    public void setRole(int type) {
        if(type!= Type_Manager || 
           type!= Type_Worker) {
            System.out.println("Incorrect type for SetRole\n");
            return;
        }
        if (type == Type_Manager) {
            name = "Manager";
        } else if (type == Type_Worker) {
            name = "Worker";
        }
    }
    //get role
    public int getRole() {
        return type;
    }
}
