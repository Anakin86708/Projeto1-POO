/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto1.poo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author silva
 */
public class ReadTXTTest {
    
    public ReadTXTTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getTreatedTextArrayList method, of class ReadTXT.
     */
    @Test
    public void testGetTreatedTextArrayList() {
        System.out.println("getTreatedTextArrayList");
        String fileNameString = "test/projeto1/poo/test1.txt";
        ReadTXT instance = new ReadTXT(fileNameString);
        String[] c = {"joão","amava","maria","que","amava","júlio","que","não","amava","ninguém"}; 
        ArrayList<String> expResult = new ArrayList<> ();
        Collections.addAll(expResult, c);
        ArrayList<String> result = instance.getTreatedTextArrayList();
        assertEquals(expResult, result);
    }
    
    @Test
    public void TRUMPtestGetTreatedTextArrayList() {
        System.out.println("getTreatedTextArrayList");
        String fileNameString = "test/projeto1/poo/testTrump.txt";
        ReadTXT instance = new ReadTXT(fileNameString);
        String[] c = {"john", "who", "loved", "marry", "who", "loved", "julio", "that", "loved", "no", "one"}; 
        ArrayList<String> expResult = new ArrayList<> ();
        Collections.addAll(expResult, c);
        ArrayList<String> result = instance.getTreatedTextArrayList();
        assertEquals(expResult, result);
    }
    
}
