package edu.uah.cs321.team2.scheduleplanner;

import edu.uah.cs321.team2.scheduleplanner.model.CompositeSchedule;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Utility class for saving and loading CompositeSchedule objects to a default file location
 * 
 * @author Team 2
 */
public class DataSerializer {
    
    /**
     * Class method for saving a composite schedule to the default file location
     * @param schedule The composite schedule to be serialized and saved
     */
    public static void saveCompositeSchedule(CompositeSchedule schedule) {        
        try {
            // binary output file stream
            FileOutputStream fileOutput = new FileOutputStream(filename);
 
            // object output stream converts to binary that file stream needs 
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
 
            // writing schedule to object stream
            objectOutput.writeObject(schedule);
            objectOutput.flush();
            objectOutput.close();
        } catch (FileNotFoundException fileEx) {
            System.out.println(fileEx.getMessage());
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
    }
    
    /**
     * Class method for loading a composite schedule from the default file location
     * @return Either a CompositeSchedule object or null
     */
    public static CompositeSchedule loadCompositeSchedule() {
        try {
            // binary input file stream
            FileInputStream fileInput = new FileInputStream(filename);
            
            // object input stream converts from binary that file stream uses
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            
            // reading object steam value as CompositeSchedule class
            CompositeSchedule schedule = (CompositeSchedule) objectInput.readObject();
            objectInput.close();
                        
            return schedule;
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        } catch (ClassNotFoundException classEx) {
            System.out.println(classEx.getMessage());
        }
        
        return null;
    }
    
    private static final String filename = "ScheduleData.ser";
}
