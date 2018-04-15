/**
 *
 * @author Team 2
 */

package edu.uah.cs321.team2.scheduleplanner.model;

import java.io.Serializable;

public class Role implements Serializable {
    public static final int TYPE_MANAGER = 1;
    public static final int TYPE_WORKER = 0;
    
    private String name;
    private static final long serialVersionUID = 3L;
    
    public Role(int type) {
        if(type==TYPE_MANAGER) {
            this.name = "Manager";
        }
        else {
            this.name = "Worker";
        }
    }
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "Role [roleName=" + this.name + "]";
    }
}
