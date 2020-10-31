package projeto1.poo;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import static org.junit.Assert.*;
import org.junit.Test;
import static projeto1.poo.TestResources.generateResultSortedMap;

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
        SortedMap<String, List<String>> expResult = generateResultSortedMap();
        SortedMap<String, List<String>> result = instance.getAdjMap();
        System.out.println("Esperado:  " + expResult);
        System.out.println("Resultado: " + result);
        assertEquals(expResult, result);
    }
}
