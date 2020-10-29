/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1.poo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author enzoj
 */
public class DigrafoTest {
    
    public DigrafoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     * Test of getAdjMap method, of class Digrafo.
     */
    @Test
    public void testGetAdjMap() {
        System.out.println("getAdjMap");
        String[] array = {"john", "who", "loved", "marry", "who", "loved", "julio", "that", "loved", "no", "one"};
        Digrafo instance = new Digrafo(array);
        TreeMap<String, List<String>> expResult = generateResult();
        TreeMap<String, List<String>> result = instance.getAdjMap();
        System.out.println("Esperado:  " + expResult);
        System.out.println("Resultado: " + result);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    // método para treemap
    private TreeMap<String, List<String>> generateResult(){
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
    
}
