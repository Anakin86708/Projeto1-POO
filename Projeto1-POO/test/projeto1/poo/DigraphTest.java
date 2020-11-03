package projeto1.poo;

import java.util.List;
import java.util.SortedMap;
import static org.junit.Assert.*;
import org.junit.Test;
import static projeto1.poo.TestResources.generateResultSortedMap;

/**
 * Testa o funcionamento do digrafo, recebendo os parâmetros de forma artificial
 * e comparando as respectivas saídas com resultados esperados.
 *
 * @author Ariel Tadeu
 * @author Enzo Fujimoto
 * @author Guilherme Lopes
 * @author Leonardo Teixeira
 */
public class DigraphTest {

    /**
     * Test of getAdjMap method, of class Digraph.
     */
    @Test
    public void testGetAdjMap() {
        System.out.println("getAdjMap");
        String[] array = {"john", "who", "loved", "marry", "who", "loved", "julio", "that", "loved", "no", "one"};
        Digraph instance = new Digraph(array);
        SortedMap<String, List<String>> expResult = generateResultSortedMap();
        SortedMap<String, List<String>> result = instance.getAdjMap();
        System.out.println("Expected:  " + expResult);
        System.out.println("Result: " + result);
        assertEquals(expResult, result);
    }
}
