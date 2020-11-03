package projeto1.poo;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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

            compareFiles("test/resources/expected.csv", "test/resources/result.csv");
            
        } catch (IOException ex) {
            System.err.println("Invalid file\n" + ex.getLocalizedMessage());
        }
    }
    
}
