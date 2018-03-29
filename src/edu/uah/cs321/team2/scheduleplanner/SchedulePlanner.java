package edu.uah.cs321.team2.scheduleplanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Team 2
 */
public class SchedulePlanner extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        // When working on your spcific view, change file name here
        Parent root = FXMLLoader.load(getClass().getResource("/edu/uah/cs321/team2/scheduleplanner/view/PeopleList.fxml"));
        
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
