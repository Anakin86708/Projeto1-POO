package projeto1.poo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static projeto1.poo.TestResources.compareFiles;

public class ControlTest {
    
    public ControlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        List<String> inputTest = new ArrayList<>();
        String[] fileNamesStrings = {"test/resources/Ex1_WantedAndWild.txt", "test/resources/Ex3_LuarDoSertao.txt"};
        Collections.addAll(inputTest, fileNamesStrings);
        Control instance = new Control(inputTest);
        String[] outputStrings = {"test/resources/SolEx1_WantedAndWild.csv", "test/resources/SolEx3_LuarDoSertao.csv"};
        try {
            for (int i = 0; i < outputStrings.length; i++) {
                compareFiles(outputStrings[i], fileNamesStrings[i].replace(".txt", ".csv"));
            }
        } catch (IOException ex) {
            Logger.getLogger(ControlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testSomeMethod() {
        
    }
    
}
