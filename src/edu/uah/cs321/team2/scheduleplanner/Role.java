/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sameerawarsi
 */

public class Role {
    public static final int Type_Manager = 1;
    public static final int Type_Worker = 0;
    
    private String name;
    private int type;
    
    public Role() {
        type = Type_Worker;
    }
    public Role(String Name) {
        name = Name;
        type = Type_Worker;
    }
    public Role(int Type) {
        type = Type;
    }
    public void setName(String Name) {
        name = Name;
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
    }
    public int getRole() {
        return type;
    }
}
