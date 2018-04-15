package edu.uah.cs321.team2.scheduleplanner;

//import edu.uah.cs321.team2.scheduleplanner.view.EditShiftViewController;
//import edu.uah.cs321.team2.scheduleplanner.view.PeopleListViewController;
import edu.uah.cs321.team2.scheduleplanner.model.Shift;
//import edu.uah.cs321.team2.scheduleplanner.model.Person;
//import edu.uah.cs321.team2.scheduleplanner.model.Role;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import edu.uah.cs321.team2.scheduleplanner.model.CompositeSchedule;
//import java.util.ArrayList;

/**
 *
 * @author Team 2
 */
public class SchedulePlanner extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        //create composite schedule instances and default shifts
        CompositeSchedule compSched = new CompositeSchedule();
        Shift monMorning = new Shift(Shift.Day.Monday, Shift.Hour.FOUR, Shift.Hour.TWELVE);
        Shift monEvening = new Shift(Shift.Day.Monday, Shift.Hour.TWELVE, Shift.Hour.EIGHT);
        Shift tueMorning = new Shift(Shift.Day.Tuesday, Shift.Hour.FOUR, Shift.Hour.TWELVE);
        Shift tueEvening = new Shift(Shift.Day.Tuesday, Shift.Hour.TWELVE, Shift.Hour.EIGHT);
        Shift wedMorning = new Shift(Shift.Day.Wednesday, Shift.Hour.FOUR, Shift.Hour.TWELVE);
        Shift wedEvening = new Shift(Shift.Day.Wednesday, Shift.Hour.TWELVE, Shift.Hour.EIGHT);
        Shift thuMorning = new Shift(Shift.Day.Thursday, Shift.Hour.FOUR, Shift.Hour.TWELVE);
        Shift thuEvening = new Shift(Shift.Day.Thursday, Shift.Hour.TWELVE, Shift.Hour.EIGHT);
        Shift friMorning = new Shift(Shift.Day.Friday, Shift.Hour.FOUR, Shift.Hour.TWELVE);
        Shift friEvening = new Shift(Shift.Day.Friday, Shift.Hour.TWELVE, Shift.Hour.EIGHT);
        
        compSched.addShiftToShifts(monMorning);
        compSched.addShiftToShifts(monEvening);
        compSched.addShiftToShifts(tueMorning);
        compSched.addShiftToShifts(tueEvening);
        compSched.addShiftToShifts(wedMorning);
        compSched.addShiftToShifts(wedEvening);
        compSched.addShiftToShifts(thuMorning);
        compSched.addShiftToShifts(thuEvening);
        compSched.addShiftToShifts(friMorning);
        compSched.addShiftToShifts(friEvening);
        
        
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
       
        
        /*
        FXMLLoader testLoader = new FXMLLoader();
        testLoader.setLocation(SchedulePlanner.class.getResource("view/EditShift.fxml"));
        Parent root = testLoader.load();
        
        EditShiftViewController controller = testLoader.getController();
        
        Shift testShift = new Shift(Shift.Day.Sunday,Shift.Hour.ZERO,Shift.Hour.SEVEN);
        Role testWorker = new Role(Role.TYPE_WORKER);
        Role testManager = new Role(Role.TYPE_MANAGER);
        Person testPerson1 = new Person("Person","1","123-4567",testManager);
        Person testPerson2 = new Person("Person","2","123-4568",testWorker);
        Person testPerson3 = new Person("Person","3","123-4569",testWorker);
        Person testPerson4 = new Person("Person","4","123-4570",testWorker);
        Person testPerson5 = new Person("Person","5","123-4571",testWorker);
        testShift.addPersonToList(testPerson1);
        testShift.addPersonToList(testPerson2);
        testShift.addPersonToList(testPerson3);
        testShift.addPersonToList(testPerson4);
        testShift.addPersonToList(testPerson5);
        Person testPerson6 = new Person("Person","6","123-4572",testWorker);
        Person testPerson7 = new Person("Person","7","123-4573",testWorker);
        Person testPerson8 = new Person("Person","8","123-4574",testWorker);
        
        ArrayList<Person> testPeople = new ArrayList<>();
        testPeople.add(testPerson1);
        testPeople.add(testPerson2);
        testPeople.add(testPerson3);
        testPeople.add(testPerson4);
        testPeople.add(testPerson5);
        testPeople.add(testPerson6);
        testPeople.add(testPerson7);
        testPeople.add(testPerson8);
        
        controller.setAllPersons(testPeople);
        controller.setShift(testShift);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        controller.refreshView();
        */
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
