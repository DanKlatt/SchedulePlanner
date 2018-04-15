/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uah.cs321.team2.scheduleplanner.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert.*;
import edu.uah.cs321.team2.scheduleplanner.model.Person;
import edu.uah.cs321.team2.scheduleplanner.model.Role;
import edu.uah.cs321.team2.scheduleplanner.PersonDelegate;
//import javafx.collections.ObservableList;
import javafx.stage.Stage;

/**
 *
 * @author Melissa
 */
public class AddEditPersonController {
    
    private PersonDelegate delegate;
    
    //Person object to be set by setPerson function if controller is used for editing a person
    private Person aPerson = null;
    
    private String fName;
    private String lName;
    private String phone;
    private String roleName;
    private Role role;
    private RadioButton selectedRadioButton;
    
    //set note above selectedRadioButton in handleSaveButtonAction
    //private boolean roleSelectedStatus;
         
    
    //text field for the first name
    @FXML
    private TextField firstName;
    
    //text field for the last name
    @FXML
    private TextField lastName;
    
    //test field for the phone number
    @FXML
    private TextField phoneNum;
    
    @FXML
    private ToggleGroup roles;
    
    @FXML
    private RadioButton Worker;
    
    @FXML
    private RadioButton Manager;
    
       
    @FXML
    public void initialize() {
        //the case that a person was 
        if(aPerson != null){
            firstName.setText(aPerson.getFirstName());
            lastName.setText(aPerson.getLastName());
            phoneNum.setText(aPerson.getPhone());
            roleName = aPerson.getRole();
            if(roleName.equals("Worker")){
                Worker.setSelected(true);
            }
            else{
                Manager.setSelected(true);
            }
        }
    }
    public void setPerson(Person person){
        this.aPerson = person;
    }
    //function to handle when the save button is pressed
    @FXML
    public void handleSaveButtonAction(ActionEvent event) {
        
        fName = firstName.getText().trim();
        lName = lastName.getText().trim();
        phone = phoneNum.getText().trim();
        
        //I hoping if no radio button is selected then in returns null
        //otherwise I will need to use function isRadioButtonSelected I created
        selectedRadioButton = (RadioButton)roles.getSelectedToggle();
        
        //handles the case that any of the fields are empty -- see note above about selectedRadioButton, it may error
        if (fName.isEmpty() || lName.isEmpty() || phone.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR, "All fields require an entry.");
            alert.show();
        }
        //case that all field had values
        else {            
            //get the role from the selected radio button
            roleName = selectedRadioButton.getText();
            
            if(roleName.equals("Worker")){
                role = new Role(Role.TYPE_WORKER);
            }
            else{
                role = new Role(Role.TYPE_MANAGER);
            }
            //check if aPerson is null and therefore in add mode
            if(aPerson==null){ 
                //send the data out
                aPerson = new Person(fName, lName, phone, role);
                delegate.addPerson(aPerson);
            }
            //case that the aPerson was set and therefore in edit mode
            else{
                aPerson.setFirstName(fName);
                aPerson.setLastName(lName);
                aPerson.setPhone(phone);
                aPerson.setRole(role);
                delegate.editPerson(aPerson);
            }
            
        }
    }
    
    //function to handle when the save button is pressed
    @FXML
    private void handleCancelButtonAction(ActionEvent event){
    //make this action act like pressing the x button
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    
    /*function used to check if a radio button is selected. I can't find
    a way for java to check if a no selection is made so I just wrote my 
    own function. Hopefully a toggleGroup.getselectedToggle returns null, then
    I won't have to use this function
    private boolean isRadioButtonSelected (ToggleGroup T){
        boolean selected = false;
        //loop thru all the radio buttons that belong to the given toggle group
        //and see if they are selected
        for(Toggle t : T.getToggles()){
            //will set selected to true if any button is selected 
            if(selected==false){
                selected = t.isSelected();
            }
        }
        return selected;
        
    } */    
}
