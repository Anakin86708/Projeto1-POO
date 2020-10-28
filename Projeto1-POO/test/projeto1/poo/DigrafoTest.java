/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1.poo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        TreeMap<String, ArrayList<String>> expResult = generateResult();
        TreeMap<String, ArrayList<String>> result = instance.getAdjMap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    // método para treemap
    private TreeMap<String, ArrayList<String>> generateResult(){
        TreeMap<String, ArrayList<String>> expResult = new TreeMap<>();
        String[] arrayJohn = {"who"};
        String[] arrayWho = {"loved"};
        String[] arrayLoved = {"marry", "julio", "no"};
        String[] arrayMarry = {"who"};
        String[] arrayJulio = {"that"};
        String[] arrayThat = {"loved"};
        String[] arrayNo = {"one"};
        ArrayList<String> listJohn = addArrayList(arrayJohn);
        ArrayList<String> listWho = addArrayList(arrayWho);
        ArrayList<String> listLoved = addArrayList(arrayLoved);
        ArrayList<String> listMarry = addArrayList(arrayMarry);
        ArrayList<String> listJulio = addArrayList(arrayJulio);
        ArrayList<String> listThat = addArrayList(arrayThat);
        ArrayList<String> listNo = addArrayList(arrayNo);
        expResult.put("john", listJohn);
        expResult.put("who", listWho);
        expResult.put("loved", listLoved);
        expResult.put("marry", listMarry);
        expResult.put("who", listJulio);
        expResult.put("that", listThat);
        expResult.put("no", listNo);
        
        return expResult;
    }
    
    private ArrayList<String> addArrayList(String[]array){
        ArrayList<String> arrayList = new ArrayList();
        Collections.addAll(arrayList, array);
        return arrayList;
    }
    
}
