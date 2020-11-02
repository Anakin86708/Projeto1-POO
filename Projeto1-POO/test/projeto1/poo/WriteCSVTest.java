package projeto1.poo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.SortedMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.junit.Test;
import static projeto1.poo.TestResources.generateResultSortedMap;
import static projeto1.poo.TestResources.compareFiles;


/**
 *
 * @author Leo
 */
public class WriteCSVTest {
    

    @Test
    public void testSomeMethod() {
        try {
            SortedMap<String,List<String>> adjMap = generateResultSortedMap();
            new WriteCSV(adjMap, "test/resources/result.csv");

            compareFiles();
            
        } catch (IOException ex) {
            Logger.getLogger(WriteCSVTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
