package edu.uah.cs321.team2.scheduleplanner.model;

import java.io.Serializable;

/**
 * A class for creating and managing work role objects
 * @author Team 2
 */

public class Role implements Serializable {

    /**
     * Declares the type of role as a final static integer
     */
    public static final int TYPE_MANAGER = 1;
    public static final int TYPE_WORKER = 0;
    
    private String name;
    private static final long serialVersionUID = 3L;
    
    /**
     * Constructs a role object
     * @param type The type of work role
     */
    public Role(int type) {
        if(type==TYPE_MANAGER) {
            this.name = "Manager";
        }
        else {
            this.name = "Worker";
        }
    }

    /**
     * Getting the role name
     * @return Role name
     */
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "Role [roleName=" + this.name + "]";
    }
}
