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


/**
 *
 * @author Leo
 */
public class WriteCSVTest {
    

    @Test
    public void testSomeMethod() {
        try {
            SortedMap<String,List<String>> adjMap = generateResultSortedMap();
            new WriteCSV(adjMap, "result.csv");

            List<String> file1 = Files.readAllLines(Paths.get("expected.csv"));
            List<String> file2 = Files.readAllLines(Paths.get("result.csv"));
            
            assertEquals(file1.size(), file2.size());
            
            for(int i = 0; i < file1.size(); i++) {
                System.out.println("Comparing line: " + i);
                assertEquals(file1.get(i), file2.get(i));
            }
            
        } catch (IOException ex) {
            Logger.getLogger(WriteCSVTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
