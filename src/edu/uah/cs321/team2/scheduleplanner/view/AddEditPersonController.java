package edu.uah.cs321.team2.scheduleplanner.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert.*;
import edu.uah.cs321.team2.scheduleplanner.model.Person;
import edu.uah.cs321.team2.scheduleplanner.model.Role;
import edu.uah.cs321.team2.scheduleplanner.PersonDelegate;
import javafx.stage.Stage;

/**
 * Controller class used to handle adding or editing a Person on the PeopleList 
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
    private void initialize(){
    }
    
    /**
     * Populates the view with a Person's information if its available
     */
    public void refreshView() {
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
    
    /**
     * sets the existing person to the passed in parameter
     * @param person the Person to be edited
     */
    public void setPerson(Person person){
        this.aPerson = person;
    }
    
    /**
     * sets the existing delegate to the passed in parameter
     * @param delegate the delegate used to handle information passing
     */
    public void setDelegate(PersonDelegate delegate) {
        this.delegate = delegate;
    }
    
    @FXML
    private void handleSaveButtonAction(ActionEvent event) {
    //method to handle when the save button is pressed    
        //get the infomation from the text fields and radio button
        fName = firstName.getText().trim();
        lName = lastName.getText().trim();
        phone = phoneNum.getText().trim();
        selectedRadioButton = (RadioButton)roles.getSelectedToggle();
        
        //handles the case that any of the fields are empty
        //will throw an error if any of the fields are empty
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
                //create new Person and send the data out
                aPerson = new Person(fName, lName, phone, role);
                delegate.addPerson(aPerson);
                closeSelf();
            }
            //case that the aPerson was set and therefore in edit mode
            else{
                aPerson.setFirstName(fName);
                aPerson.setLastName(lName);
                aPerson.setPhone(phone);
                aPerson.setRole(role);
                delegate.editPerson(aPerson);
                closeSelf();
            }
        }
    }
    
    
    @FXML
    private void handleCancelButtonAction(){
    //function to handle when the cancel button is pressed    
        closeSelf();
    }
    
    private void closeSelf() {
        Stage stage  = (Stage) firstName.getScene().getWindow();
        stage.close();
    }
}
