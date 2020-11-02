package projeto1.poo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import static org.junit.Assert.*;

/**
 *
 * @author silva
 */
public class TestResources {
    // método para treemap
    public static SortedMap<String, List<String>> generateResultSortedMap(){
        TreeMap<String, List<String>> expResult = new TreeMap<>();
        String[] keys = {"john", "who", "loved", "marry", "julio", "that", "no"};
        
        List<String[]> values = new ArrayList<>();
        values.add(new String [] {"who"});
        values.add(new String [] {"loved"});
        values.add(new String [] {"marry", "julio", "no"});
        values.add(new String [] {"who"});
        values.add(new String [] {"that"});
        values.add(new String [] {"loved"});
        values.add(new String [] {"one"});
        
        for (int i = 0; i < keys.length; i++) {
            expResult.put(keys[i], Arrays.asList(values.get(i)));            
        }   
     
       return expResult;
    }
    
    public static void compareFiles(String fileNameExpected, String fileNameActual) throws IOException {
        List<String> fileExpected = Files.readAllLines(Paths.get(fileNameExpected));
        List<String> fileActual = Files.readAllLines(Paths.get(fileNameActual));
        
        assertEquals(fileExpected.size(), fileActual.size());
        for(int i = 0; i < fileExpected.size(); i++) {
            System.out.println("Comparing line: " + i);
            assertEquals(fileExpected.get(i), fileActual.get(i));
        }
    }
    
}
