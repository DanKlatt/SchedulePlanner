package edu.uah.cs321.team2.scheduleplanner.view;

import edu.uah.cs321.team2.scheduleplanner.model.Person;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class PeopleListViewController {
    private int Type_Worker;
    private int Type_Manager;
    private Object People;
    
    @FXML 
    private VBox rootNode;
    //label for person's name
    @FXML
    private Label Name;
    //label for person's role
    @FXML
    private Label role;
    //label for person's phone number
    @FXML
    private Label phoneNum;
    
    @FXML 
    private Button Edit;
    
    @FXML
    private Button Delete;
    
    @FXML
    private Button Add;
    
    //method to fill dummy data of people's information
       // People List setter
    public void setAllPersons(ArrayList<Person> people) {
        this.allPersons = people;
    }
    
    @FXML
    public void initialize() {
        
    }
    
    public void refreshView() {
        // Gets the scene so node elements can be accessed
        Scene scene = rootNode.getScene();
        
        if(this.allPersons.size() == 0) {
            rootNode.setVisible(false);
            return;
        }
        
        rootNode.setVisible(true);
        
        // Loop through all persons array
        for (int i = 0; i < this.allPersons.size(); i += 1) {
            // Construct the identifier set in fx:id property
            String identifier = "#personName_" + i;          
            Label name = (Label) scene.lookup(identifier);

            identifier = "#roleLabel_" + i;
            Label role = (Label) scene.lookup(identifier);
            
            identifier = "#phoneLabel_" + i;
            Label phone = (Label) scene.lookup(identifier);
            
            // Gets the person from the list of all people
            Person staff = this.allPersons.get(i);
            
            // Set all necessary properties to corresponding person values
            name.setText(staff.getName());
            role.setText(staff.getRole());
            phone.setText(staff.getPhone());
        }
    }


    public void EditPerson() {
        
}
    public void AddPerson() {
    
}
    public void DeletePerson() {
        
    }
    public void GettingScene() {
    //    Scene scene = <rootNode>.getScene();
    }
    
    private ArrayList<Person> allPersons;
    
}
    
