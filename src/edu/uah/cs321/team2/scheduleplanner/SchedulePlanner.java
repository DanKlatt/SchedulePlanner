package edu.uah.cs321.team2.scheduleplanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Team 2
 */
public class SchedulePlanner extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        // Load root Border Pane
        FXMLLoader rootLoader = new FXMLLoader();
        rootLoader.setLocation(SchedulePlanner.class.getResource("view/RootBorder.fxml"));
        BorderPane root = (BorderPane) rootLoader.load();
        
        // Load Composite Schedule view into center pane
        FXMLLoader compositeLoader = new FXMLLoader();
        compositeLoader.setLocation(SchedulePlanner.class.getResource("view/CompositeSchedule.fxml"));
        GridPane compositeSchedule = (GridPane) compositeLoader.load();
        
        root.setCenter(compositeSchedule);
        
        // Load People List view into right pane
        FXMLLoader peopleLoader = new FXMLLoader();
        peopleLoader.setLocation(SchedulePlanner.class.getResource("view/PeopleList.fxml"));
        VBox peopleList = (VBox) peopleLoader.load();
        
        root.setRight(peopleList);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
