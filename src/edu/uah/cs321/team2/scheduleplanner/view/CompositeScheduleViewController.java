package edu.uah.cs321.team2.scheduleplanner.view;

import edu.uah.cs321.team2.scheduleplanner.PersonListener;
import edu.uah.cs321.team2.scheduleplanner.ShiftListener;
import edu.uah.cs321.team2.scheduleplanner.model.CompositeSchedule;
import edu.uah.cs321.team2.scheduleplanner.model.Shift;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * View Controller class to handle displaying all the shifts associated with a composite schedule
 * 
 * @author Team 2
 */
public class CompositeScheduleViewController implements PersonListener, ShiftListener {
    @FXML
    private GridPane scheduleRootNode;
    
    @FXML
    private void initialize() {
        
    }
    
    /**
     * Setter for the CompositeSchedule to be displayed
     * @param newSchedule CompositeSchedule representing the schedule to display
     */
    public void setCompositeSchedule(CompositeSchedule newSchedule) {
        this.schedule = newSchedule;
    }
    
    /**
     * Updates the view with the data currently assigned to the controller
     */
    public void refreshView() {
        // Gets the scene so node elements can be accessed
        Scene scene = scheduleRootNode.getScene();
        // Loop through all shifts and bind data to them
        ArrayList<Shift> shifts = this.schedule.getShifts();
        int max_shifts = 14;
        for(int i=0;i<max_shifts;i+=1) {
            Shift shift = shifts.get(i);
            // Construct the identifier set in fx:id property
            String shiftButtonID = "#shiftButton_" + i;
            String managerLabelID = "#shiftManagers_" + i;
            String workerLabelID = "#shiftWorkers_" + i;
            // Get shift button, set special ID property to value of shift ID
            Button shiftButton = (Button) scene.lookup(shiftButtonID);
            shiftButton.getProperties().put(ID_KEY, Long.toString(shift.getIdentifier()));
            // Get managers label, set value to return of shift manager count method
            Label managerLabel = (Label) scene.lookup(managerLabelID);
            managerLabel.setText(Integer.toString(shift.getManagerCount()));
            // Get workers label, set value to return of shift worker count method
            Label workerLabel = (Label) scene.lookup(workerLabelID);
            workerLabel.setText(Integer.toString(shift.getWorkerCount()));
        }
    }
    
    // PersonListener methods
    @Override
    public void peopleUpdated() {
        this.refreshView();
    }
    
    // ShiftListener methods
    @Override
    public void shiftsUpdated() {
        this.refreshView();
    }
    
    @FXML
    private void selectShift(ActionEvent event) {
        // Get button from the event
        Button selectedButton = (Button) event.getSource();
        // Retrieve identifier associated with button
        long shiftID = Long.parseLong((String) selectedButton.getProperties().get(ID_KEY));
        // Get shift with identifier
        Shift selectedShift = this.schedule.findShiftByID(shiftID);
        if (selectedShift != null) {
            try {
                // Load the edit shift view
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(CompositeScheduleViewController.class.getResource("EditShift.fxml"));
                DialogPane page = (DialogPane) loader.load();

                // Make it a modal window
                Stage dialogStage = new Stage();
                dialogStage.setTitle("Edit Shift");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(scheduleRootNode.getScene().getWindow());
                Scene scene = new Scene(page);
                dialogStage.setScene(scene);

                // Set the controller properties with appropriate data
                EditShiftViewController controller = loader.getController();
                controller.setShift(selectedShift);
                controller.setAllPersons(this.schedule.getPeople());
                controller.setDelegate(schedule);

                dialogStage.show();

                // Refresh view AFTER calling shoq
                controller.refreshView();
            } catch (IOException e) {}
        }
    }
    
    private static final String ID_KEY = "shiftIdentifier";
    private CompositeSchedule schedule;
}
