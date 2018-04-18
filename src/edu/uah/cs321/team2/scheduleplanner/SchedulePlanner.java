package edu.uah.cs321.team2.scheduleplanner;

import edu.uah.cs321.team2.scheduleplanner.view.CompositeScheduleViewController;
import edu.uah.cs321.team2.scheduleplanner.view.PeopleListViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import edu.uah.cs321.team2.scheduleplanner.model.CompositeSchedule;

/**
 *
 * @author Team 2
 */
public class SchedulePlanner extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        //create composite schedule instances and default shifts
        CompositeSchedule compositeSchedule = new CompositeSchedule();
        // Just create defaults for now
        compositeSchedule.createDefaultShifts();
        
        // Load root Border Pane
        FXMLLoader rootLoader = new FXMLLoader();
        rootLoader.setLocation(SchedulePlanner.class.getResource("view/RootBorder.fxml"));
        BorderPane root = (BorderPane) rootLoader.load();
        
        // Load Composite Schedule view into center pane
        FXMLLoader compositeLoader = new FXMLLoader();
        compositeLoader.setLocation(SchedulePlanner.class.getResource("view/CompositeSchedule.fxml"));
        GridPane compositeSchedulePane = (GridPane) compositeLoader.load();
        
        CompositeScheduleViewController scheduleController = (CompositeScheduleViewController) compositeLoader.getController();
        scheduleController.setCompositeSchedule(compositeSchedule);
        
        root.setCenter(compositeSchedulePane);
                
        // Load People List view into right pane
        FXMLLoader peopleLoader = new FXMLLoader();
        peopleLoader.setLocation(SchedulePlanner.class.getResource("view/PeopleList.fxml"));
        VBox peopleList = (VBox) peopleLoader.load();
        
        PeopleListViewController peopleController = (PeopleListViewController) peopleLoader.getController();
        peopleController.setAllPersons(compositeSchedule.getPeople());
        peopleController.setDelegate(compositeSchedule);
        
        root.setRight(peopleList);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        scheduleController.refreshView();
        peopleController.refreshView();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
