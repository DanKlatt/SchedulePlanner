package edu.uah.cs321.team2.scheduleplanner.view;

import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.ArrayList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import edu.uah.cs321.team2.scheduleplanner.model.Shift;
import edu.uah.cs321.team2.scheduleplanner.model.Person;
import edu.uah.cs321.team2.scheduleplanner.ShiftDelegate;

/**
 * View Controller Class to handle viewing single shifts and adding/removing
 * persons from a shift
 *
 * @author Team 2
 */
public class EditShiftViewController {
    @FXML
    private DialogPane rootNode;
    
    @FXML
    private void initialize() {
        
    }
    
    /**
     * Setter for the Shift object to display/edit
     * @param newShift Shift object representing the shift to be viewed
     */
    public void setShift(Shift newShift) {
        this.shift = newShift;
    }
    
    /**
     * Setter for the list of all Persons
     * @param people ArrayList of Person objects representing all people
     */
    public void setAllPersons(ArrayList<Person> people) {
        this.allPersons = people;
    }
    
    /**
     * Setter for delegate that implements the ShiftDelegate interface for passing data out of the controller
     * @param newDelegate ShiftDelegate object representing the new delegate
     */
    public void setDelegate(ShiftDelegate newDelegate) {
        this.delegate = newDelegate;
    }
    
    /**
     * Updates the view with the data currently assigned to the controller
     */
    public void refreshView() {
        // Gets the scene so node elements can be accessed
        Scene scene = rootNode.getScene();
        // Bind shift values
        Label dayLabel = (Label) scene.lookup("#shiftDay");
        dayLabel.setText(this.shift.getDay().toString());
        Label startLabel = (Label) scene.lookup("#shiftStart");
        startLabel.setText(this.shift.getReadableStartTime());
        Label endLabel = (Label) scene.lookup("#shiftEnd");
        endLabel.setText(this.shift.getReadableEndTime());
        // Loop through all ten elements
        for (int i=0;i<MAX_PEOPLE;i+=1) {
            // Construct the identifier set in fx:id property
            String identifier = "#personName_" + i;
            // Get element with specified ID from scene
            CheckBox element = (CheckBox) scene.lookup(identifier);
            // Looks to see if there are fewer than ten people
            if (i < this.allPersons.size()) {
                // Gets the person from the list of all people
                Person staff = this.allPersons.get(i);
                // Set all necessary properties to corresponding person values
                element.setText(staff.getName());
                element.getProperties().put(ID_KEY, Long.toString(staff.getIdentifier()));
                // Check to see if this person is assigned to this shift
                if (this.shift.getPeople().contains(staff)) {
                    element.setSelected(true);
                } else {
                    element.setSelected(false);
                }
            } else {
                // Hide any extra chackboxes
                element.setSelected(false);
                element.setVisible(false);
            }
            
        }
    }
    
    // Save action
    @FXML
    private void handleSave() {
        this.shift.removeAllPeopleFromShift();
        // Gets the scene so node elements can be accessed
        Scene scene = rootNode.getScene();
        // Loop through all ten elements
        for (int i=0;i<MAX_PEOPLE;i+=1) {
            // Construct the identifier set in fx:id property
            String identifier = "#personName_" + i;
            // Get element with specified ID from scene
            CheckBox element = (CheckBox) scene.lookup(identifier);
            if (element.isSelected()) {
                // Get person identifier from ID field of checkbox
                String identifierValue = (String) element.getProperties().get(ID_KEY);
                long personIdentifier = Long.parseLong(identifierValue);
                // Find person with identifier, add to shift
                for(Person person : this.allPersons) {
                    if (person.getIdentifier() == personIdentifier) {
                        this.shift.addPersonToList(person);
                    }
                }
            }
        }
        this.delegate.updateShift(this.shift);
        closeSelf();
    }
    
    // Cancel action
    @FXML
    private void handleCancel() {
        closeSelf();
    }
    
    private void closeSelf() {
        Stage stage  = (Stage) rootNode.getScene().getWindow();
        stage.close();
    }
    
    private static final String ID_KEY = "personIdentifier";
    private static final int MAX_PEOPLE = 10;
    private Shift shift;
    private ArrayList<Person> allPersons;
    private ShiftDelegate delegate;
}
