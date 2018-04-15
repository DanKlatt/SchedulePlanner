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
public class DataSerializier {
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
            
        } catch (IOException ioEx) {
            
        }
    }
    
    public static CompositeSchedule loadCompositeSchedule() {
        CompositeSchedule schedule = null;
        try {
            // binary input file stream
            FileInputStream fileInput = new FileInputStream(filename);
            
            // object input stream converts from binary that file stream uses
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            
            // reading object steam value as CompositeSchedule class
            schedule = (CompositeSchedule) objectInput.readObject();
            objectInput.close();
        } catch (FileNotFoundException fileEx) {
            
        } catch (IOException ioEx) {
            
        } catch (ClassNotFoundException classEx) {
            
        }
        
        return schedule;
    }
    
    private static final String filename = "ScheduleData.ser";
}
