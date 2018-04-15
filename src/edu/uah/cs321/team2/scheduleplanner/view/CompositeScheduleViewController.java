package edu.uah.cs321.team2.scheduleplanner.view;

import edu.uah.cs321.team2.scheduleplanner.PersonListener;
import edu.uah.cs321.team2.scheduleplanner.model.CompositeSchedule;
import edu.uah.cs321.team2.scheduleplanner.model.Shift;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Team 2
 */
public class CompositeScheduleViewController implements PersonListener {
    @FXML
    private GridPane rootNode;
    
    @FXML
    private void initialize() {
        
    }
    
    public void setCompositeSchedule(CompositeSchedule newSchedule) {
        this.schedule = newSchedule;
    }
    
    public void refreshView() {
        // Gets the scene so node elements can be accessed
        Scene scene = rootNode.getScene();
        // Loop through all shifts and bind data to them
        ArrayList<Shift> shifts = this.schedule.getShifts();
        int max_shifts = 14;
        for(int i=0;i<max_shifts;i+=1) {
            Shift shift = shifts.get(i);
            // Construct the identifier set in fx:id property
            String shiftBoxID = "#compositeShift_" + i;
            String managerLabelID = "#shiftManagers_" + i;
            String workerLabelID = "#shiftWorkers_" + i;
            // Get shift vbox, set regular ID property to value of shift ID
            VBox shiftBox = (VBox) scene.lookup(shiftBoxID);
            // Get managers label, set value to return of shift manager count method
            Label managerLabel = (Label) scene.lookup(managerLabelID);
            // Get workers label, set value to return of shift worker count method
            Label workerLabel = (Label) scene.lookup(workerLabelID);
        }
    }
    
    // PersonListener methods
    @Override
    public void peopleUpdated() {
        // Refresh view
    }
    
    private CompositeSchedule schedule;
}
