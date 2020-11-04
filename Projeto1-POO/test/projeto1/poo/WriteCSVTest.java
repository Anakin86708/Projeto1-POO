package projeto1.poo;

import java.io.IOException;
import java.util.List;
import java.util.SortedMap;
import static org.junit.Assert.fail;
import org.junit.Test;
import static projeto1.poo.TestResources.generateResultSortedMap;
import static projeto1.poo.TestResources.compareFiles;


/**
 * Performs tests for the {@link WriteCSV} class.
 *
 * @author Ariel Tadeu
 * @author Enzo Fujimoto
 * @author Guilherme Lopes
 * @author Leonardo Teixeira
 */
public class WriteCSVTest {
    
    /**
     * Writes the .csv file using WriteCSV and compares it to the expected file
     * 
     */
    @Test
    public void testFileOutput() {
        try {
            SortedMap<String,List<String>> adjMap = generateResultSortedMap();
            new WriteCSV(adjMap, "test/resources/result.csv");

            compareFiles("test/resources/expected.csv", "test/resources/result.csv");
            
        } catch (IOException ex) {
            System.err.println("Invalid file\n" + ex.getLocalizedMessage());
            fail("Invalid file\n" + ex.getLocalizedMessage());
        }
    }
    
}
