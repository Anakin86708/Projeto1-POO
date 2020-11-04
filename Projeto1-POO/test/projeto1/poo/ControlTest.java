package projeto1.poo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.fail;
import org.junit.Test;
import static projeto1.poo.TestResources.compareFiles;

/**
 * Realizes tests to {@link Control} class
 * 
 * @author Ariel Tadeu
 * @author Enzo Fujimoto
 * @author Guilherme Lopes
 * @author Leonardo Teixeira
 */
public class ControlTest {

    
    /**
     * Tests the whole integration between classes
     * 
     * @see ReadTXT
     * @see Digraph
     * @see WriteCSV
     */
    @Test
    public void testSetUpClass() {
        List<String> inputTest = new ArrayList<>();
        String[] fileNamesStrings = {
            "test/resources/Ex1_WantedAndWild.txt",
            "test/resources/Ex2_AMascaraDaMorteRubra.txt",
            "test/resources/Ex3_LuarDoSertao.txt",
            "test/resources/Ex4_Parabens.txt",
            "test/resources/Ex5_TresMotivosParaVacinarSeuPet.txt"
        };
        Collections.addAll(inputTest, fileNamesStrings);
        Control instance = new Control(inputTest);
        String[] outputStrings = {
            "test/resources/SolEx1_WantedAndWild.txt",
            "test/resources/SolEx2_AMascaraDaMorteRubra.txt",
            "test/resources/SolEx3_LuarDoSertao.txt",
            "test/resources/SolEx4_Parabens.txt",
            "test/resources/SolEx5_TresMotivosParaVacinarSeuPet.txt"
        };
        
        try {
            for (int i = 0; i < outputStrings.length; i++) {
                System.out.println("Comparing: " + outputStrings[i]);
                compareFiles(outputStrings[i].replace(".txt", ".csv"), fileNamesStrings[i].replace(".txt", ".csv"));
            }
        } catch (IOException ex) {
            System.err.println(ex.getLocalizedMessage());
            fail(ex.getLocalizedMessage());
        }
    }
    
    /**
     * Testing using a valid file.
     */
    @Test
    public void testValidFile() {
        String fileNameExpected = "test/resources/SolEx2_AMascaraDaMorteRubra.csv";
        String fileNameActual = "test/resources/Ex2_AMascaraDaMorteRubra.txt";
        List<String> inputTest = new ArrayList<>();
        inputTest.add(fileNameActual);
        Control instance = new Control(inputTest);
        
        try {
            compareFiles(fileNameExpected, fileNameActual.replace(".txt", ".csv"));
        } catch (IOException ex) {
            System.err.println(ex.getLocalizedMessage());
            fail(ex.getLocalizedMessage());
        }
    }

    /**
     * Tests the generated exception for a file without format .txt
     */
    @Test(expected = Exception.class)
    public void testInvalidFile() {
        List<String> inputTest = new ArrayList<>();
        String[] fileNamesStrings = {
            "test/resources/Ex1_WantedAndWild.txt",
            "test/resources/Ex2_AMascaraDaMorteRubra.doc",
        };
        Collections.addAll(inputTest, fileNamesStrings);
        Control instance = new Control(inputTest);
        System.out.println("An error is expected: ");
        
    }
    
}
