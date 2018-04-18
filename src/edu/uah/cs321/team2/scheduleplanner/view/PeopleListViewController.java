package edu.uah.cs321.team2.scheduleplanner.view;

import edu.uah.cs321.team2.scheduleplanner.SchedulePlanner;
import edu.uah.cs321.team2.scheduleplanner.PersonDelegate;
import edu.uah.cs321.team2.scheduleplanner.model.Person;
import edu.uah.cs321.team2.scheduleplanner.PersonListener;
import java.io.IOException;
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
import java.util.Optional;

/**
 * View Controller Class to handle editing, adding, and deleting
 * persons name, role, and phone number from list view of people 
 * 
 * @author Team 2
 */
public class PeopleListViewController implements PersonListener {
    private int Type_Worker;
    private int Type_Manager;
    private Object People;
    
    @FXML 
    private VBox rootNode;
    
    @FXML
    public void initialize() {
        
    }
        // Delegate setter
    public void setDelegate(PersonDelegate newDelegate) {
        this.delegate = newDelegate;
    }
/**
 * Setting the person's data from the array list of people to people list
 * 
 * @param people: array of persons
 */
    public void setAllPersons(ArrayList<Person> people) {
        this.allPersons = people;
    }
    
    /**
     * This function populates the people list GUI
     */
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
        if(this.allPersons.size() == MAX_PEOPLE) {
            vboxa.setVisible(false);
        }
        else {
            vboxa.setVisible(true);
        }
        
        // Loop through all persons array
        for (int i = 0; i < MAX_PEOPLE; i += 1) {
            // Construct the identifier set in fx:id property
            String identifier = "#vbox_" + i;
            VBox vbox = (VBox) scene.lookup(identifier);

            if (i < this.allPersons.size()) {
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
               
                // Find each edit button by its string ID 
                identifier = "#edit_" + i;
                Button edit_button = (Button) scene.lookup(identifier);
                
                // Now set the people identifier to the unique ID associated with a person
                edit_button.getProperties().put(ID_KEY, Long.toString(staff.getIdentifier()));
                
                // Find each delete button by its string ID
                identifier = "#delete_" + i;
                Button del_button = (Button) scene.lookup(identifier);
                // Now set the people identifier to the unique ID associated with a person
                del_button.getProperties().put(ID_KEY, Long.toString(staff.getIdentifier()));           
            } else {
                vbox.setVisible(false);
            }
        }
    }
/**
 * This method is called when an edit button is pressed
 * @param event is the ActionEvent
 */
    public void EditPerson(ActionEvent event) { 
        //We know that this action is always by the press of an edit button
        //so get the actual button
        Button btn = (Button) event.getSource();
        
        //Get the button ID as a string and convert to integer
    //    String id = btn.getId();
    //    int i= Integer.parseInt(id);
        //System.out.println("Here " + i);
        
        Person e = null;
        // Retrieve the ID_KEY from the edit button
        String identifierValue = (String) btn.getProperties().get(ID_KEY);
        // Convert the identifier value string to a long to get the actual identifier
        // of the person associated with this edit key
        long personIdentifier = Long.parseLong(identifierValue);
        // Find person with identifier
        for (Person person : this.allPersons) {
            if (person.getIdentifier() == personIdentifier) {
                e = person;
                break;
            }
        }
        //Get the actual person being edited by the index from the button id
        // e = this.allPersons.get(i);
        //System.out.println("Here " + i);  
        
        //load the edit person GUI
        FXMLLoader editpersonLoader = new FXMLLoader();
        editpersonLoader.setLocation(SchedulePlanner.class.getResource("view/AddEditPerson.fxml"));
        
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
        
        if(e != null) {
            this.delegate.editPerson(e);
            this.refreshView();
        }
    }
    
    /**
     * This method is called when the Add button is pressed
     * @param event is the ActionEvent
     */
    public void AddPerson(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PeopleListViewController.class.getResource("AddEditPerson.fxml"));
            VBox page = (VBox) loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(rootNode.getScene().getWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            AddEditPersonController controller = loader.getController();
            controller.setDelegate(this.delegate);
            
            dialogStage.show();
        } catch (IOException e) {}
    }
    
    /**
     * This method is called when a delete button is pressed
     * @param event is the ActionEvent
     */
    public void DeletePerson(ActionEvent event) { 
        //Get the delete button
        Button btn = (Button) event.getSource();
        
        //Get the button ID as a string and convert to integer
        //String id = btn.getId();
        //int i= Integer.parseInt(id);
        //System.out.println("Here " + i);
        
        Person e = null;
  
        //Get the actual person being deleted by the index from the button id
        //e = this.allPersons.get(i);
        
        // Retrieve the person identifier key from ID_KEY
        String identifierValue = (String) btn.getProperties().get(ID_KEY);
        // Convert the identifier value string to a long to get the actual identifier
        // of the person associated with this delete key
        long personIdentifier = Long.parseLong(identifierValue);
        // Find person with identifier
        for (Person person : this.allPersons) {
            if (person.getIdentifier() == personIdentifier) {
                e = person;
                break;
            }
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Person");
        alert.setContentText("Are you sure?  Press OK to confirm, or cancel to Back out.");
        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.isPresent() && (result.get() == ButtonType.OK))  {
             if(e != null) {
            this.delegate.deletePerson(e);
            this.refreshView();
             }
        }
    }
    
    @Override
    public void peopleUpdated()
    {
        this.refreshView();
    }
    
    private static final String ID_KEY = "personIdentifier";
    private ArrayList<Person> allPersons;
    private PersonDelegate delegate;
    private static final int MAX_PEOPLE = 10;    
}
    
