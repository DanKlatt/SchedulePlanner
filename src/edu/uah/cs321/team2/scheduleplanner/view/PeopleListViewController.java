package edu.uah.cs321.team2.scheduleplanner.view;

import edu.uah.cs321.team2.scheduleplanner.SchedulePlanner;
import edu.uah.cs321.team2.scheduleplanner.model.Person;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.geometry.Pos;

/**
 * View Controller Class to handle editing, adding, and deleting
 * persons name, role, and phone number from list view of people 
 * 
 * @author Team 2
 */
public class PeopleListViewController {
    private int Type_Worker;
    private int Type_Manager;
    private Object People;
    
    @FXML 
    private VBox rootNode;
    
    @FXML
    public void initialize() {
        
    }
    
/**
 * Setting the person's data from the array list of people to people list
 * 
 * @param people 
 */
    public void setAllPersons(ArrayList<Person> people) {
        this.allPersons = people;
    }
    
    public void refreshView() {
        // Gets the scene so node elements can be accessed
        Scene scene = rootNode.getScene();
        for (int i = 0; i < 10; i++) {
            String identifier = "#vbox_" + i;
            VBox vbox = (VBox) scene.lookup(identifier);
            if(vbox == null)
            vbox.setVisible(false);
        }
        
        // Either hide/show the Add button at the bottom of
        // the people list
        String ident = "#vbox_add";
        VBox vboxa = (VBox) scene.lookup(ident);       
        if(this.allPersons.size() == 10) {
            vboxa.setVisible(false);
        }
        else {
            vboxa.setVisible(true);
        }
        
        // Loop through all persons array
        for (int i = 0; i < this.allPersons.size(); i += 1) {
            // Construct the identifier set in fx:id property
            String identifier = "#vbox_" + i;
            VBox vbox = (VBox) scene.lookup(identifier);
            vbox.setVisible(true);
            
            identifier = "#personName_" + i;          
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

    public void EditPerson(ActionEvent event) { 
        //We know that this action is always by the press of an edit button
        //so get the actual button
        Button btn = (Button) event.getSource();
        
        //Get the button ID as a string and convert to integer
        String id = btn.getId();
        int i= Integer.parseInt(id);
        //System.out.println("Here " + i);
        
        Person e = null;
  
        //Get the actual person being edited by the index from the button id
        e = this.allPersons.get(i);
        //System.out.println("Here " + i);  
        
        //load the edit person GUI
        FXMLLoader editpersonLoader = new FXMLLoader();
        editpersonLoader.setLocation(SchedulePlanner.class.getResource("view/EditPerson.fxml"));
        
        //display a dialogue showing the Edit Person GUI
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);

        //needed a try-catch block to make the compiler happy
        try {
            //get the VBox containing the GUI
            VBox vbox = (VBox) editpersonLoader.load();
            
            //get the Edit Person controller
            AddEditPersonController eCont = editpersonLoader.getController();
            
            if(e != null) {
                //setting the person for the controller
                 eCont.setPerson(e);
            }
            
            //Initializing the person for the controller
            //(the initialize function crashes so I have 
            //temporarily commented it out)
            //eCont.initialize();
            
            vbox.setAlignment(Pos.CENTER);

            dialogStage.setScene(new Scene(vbox));
            dialogStage.show();
        }
            catch(Exception e1) {
        }
    }
    public void AddPerson(ActionEvent event) {
        //Load the edit person GUI
        FXMLLoader editpersonLoader = new FXMLLoader();
        editpersonLoader.setLocation(SchedulePlanner.class.getResource("view/EditPerson.fxml"));
        
        //Display a dialogue showing the Edit Person GUI
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);

        //Needed a try-catch block to make the compiler happy
        try {
            //Get the VBox containing the GUI
            VBox vbox = (VBox) editpersonLoader.load();
            
            //Get the Edit Person controller
            AddEditPersonController eCont = editpersonLoader.getController();
      
            vbox.setAlignment(Pos.CENTER);

            dialogStage.setScene(new Scene(vbox));
            dialogStage.show();
        }
            catch(Exception e1) {
        }   
        
        this.refreshView();
    }
    public void DeletePerson() {
        
    }
    
    private ArrayList<Person> allPersons;
    
}
    
