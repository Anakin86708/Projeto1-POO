package projeto1.poo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import static org.junit.Assert.*;

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
        BufferedReader expectedBufferedReader = null;
        BufferedReader actualBufferedReader = null;
        try {
            expectedBufferedReader = new BufferedReader(new FileReader(fileNameExpected));
            actualBufferedReader = new BufferedReader(new FileReader(fileNameActual));
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found!\n" + fileNotFoundException.getMessage());
            }
        
        String expectedLine = expectedBufferedReader.readLine();
        String actualLine = actualBufferedReader.readLine();
        
        while(expectedLine != null && actualLine != null) {
            Object[] expectedObjects = convertToKeyLine(expectedLine);
            Object[] actualObjects = convertToKeyLine(actualLine);
            
            assertEquals(expectedObjects[0], actualObjects[0]);  // Compares two keys
            assertSetContains((Set)expectedObjects[1], (Set)actualObjects[1]);  // Compares two Sets with values
            
            expectedLine = expectedBufferedReader.readLine();
            actualLine = actualBufferedReader.readLine();
        }
        
    }

    private static Object[] convertToKeyLine(String line) {
        String[] splitedLine = line.split(",", 2);
        String expectedKey = splitedLine[0];
        Set set = new TreeSet();
        Collections.addAll(set, splitedLine[1].split(","));
        return new Object[] {expectedKey, set};
    }
    
    private static void assertSetContains(Set expectedObjects, Set actualObjects) {
        assertTrue(expectedObjects.containsAll(actualObjects));
        assertTrue(actualObjects.containsAll(expectedObjects));
    }
    
}
