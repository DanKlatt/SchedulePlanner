/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uah.cs321.team2.scheduleplanner.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
//import javafx.fxml.Initializable;
import javafx.scene.control.Alert.*;


/**
 *
 * @author Melissa
 */
public class AddEditPersonController {
    
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
    private Button saveButton;
    
    @FXML
    private Button cancelButton;
    
    @FXML
    public void initialize() {
        //not sure what to put here
    }
    
    //function to handle when the save button is pressed
    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
        
        String fName = firstName.getText().trim();
        String lName = lastName.getText().trim();
        String phone = phoneNum.getText().trim();
        
        //handles the case that any of the fields are empty
        if( fName.isEmpty() || lName.isEmpty() || phone.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR, "All fields require an entry.");
            alert.show();
        }
        else {
            //send the data out
        }
    }
    
    //function to handle when the save button is pressed
    @FXML
    private void handleCancelButtonAction(ActionEvent event){
    //make this action act like pressing the x button
    }
       
    
    //scheduleData.getInstance().addPerson(new Person(fName,lName, phone, role_type));
   
    
}
