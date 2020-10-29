package projeto1.poo;

import java.util.List;
import java.util.TreeMap;
import static org.junit.Assert.*;
import org.junit.Test;
import static projeto1.poo.TestResources.generateResultTreeMap;

/**
 *
 * @author enzoj
 */
public class DigrafoTest {
    
    /**
     * Test of getAdjMap method, of class Digrafo.
     */
    @Test
    public void testGetAdjMap() {
        System.out.println("getAdjMap");
        String[] array = {"john", "who", "loved", "marry", "who", "loved", "julio", "that", "loved", "no", "one"};
        Digrafo instance = new Digrafo(array);
        TreeMap<String, List<String>> expResult = generateResultTreeMap();
        TreeMap<String, List<String>> result = instance.getAdjMap();
        System.out.println("Esperado:  " + expResult);
        System.out.println("Resultado: " + result);
        assertEquals(expResult, result);
    }
}
