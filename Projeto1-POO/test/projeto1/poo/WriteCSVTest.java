/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1.poo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author Leo
 */
public class WriteCSVTest {
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    public WriteCSVTest() {
    }

    @Test
    public void testSomeMethod() {
        try {
            TreeMap<String,List<String>> adjMap = DigrafoTest.generateResult();
            WriteCSV instance = new WriteCSV(adjMap, "result.csv");

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
