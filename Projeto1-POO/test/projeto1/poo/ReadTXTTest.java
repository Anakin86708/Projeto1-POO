package projeto1.poo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author silva
 */
public class ReadTXTTest {
    
    /**
     * Test of getTreatedTextArrayList method, of class ReadTXT.
     */
    @Test
    public void testGetTreatedTextArrayList() {
        System.out.println("getTreatedTextArrayList");
        String fileNameString = "test/resources/test1.txt";
        String[] c = {"joão","amava","maria","que","amava","júlio","que","não","amava","ninguém"}; 
        setupTestClass(fileNameString, c);
    }
    
    @Test
    public void englishTestGetTreatedTextArrayList() {
        System.out.println("getTreatedTextArrayList");
        String fileNameString = "test/resources/test2.txt";
        String[] c = {"john", "who", "loved", "marry", "who", "loved", "julio", "that", "loved", "no", "one"}; 
        setupTestClass(fileNameString, c);
    }
    
    @Test
    public void ex3Test() {
        System.out.println("ex1Test");
        String filenameString = "test/resources/Ex3_LuarDoSertao.txt";
        String[] c = {"não","há","ó","gente","ó","não","luar","como","esse","do",
        "sertão","não","há","ó","gente","ó","não","luar","como","esse","do",
        "sertão","oh","que","saudade","do","luar","da","minha","terra","lá","na",
        "serra","branquejando","folhas","secas","pelo","chão","este","luar","cá",
        "da","cidade","tão","escuro","não","tem","aquela","saudade","do","luar",
        "lá","do","sertão","não","há","ó","gente","ó","não","luar","como","esse",
        "do","sertão","não","há","ó","gente","ó","não","luar","como","esse","do",
        "sertão"};
        setupTestClass(filenameString, c);
    }

    private void setupTestClass(String fileNameString, String[] c) {
        ReadTXT instance = new ReadTXT(fileNameString);
        ArrayList<String> expResult = new ArrayList<> ();
        Collections.addAll(expResult, c);
        List<String> result = instance.getTreatedTextArrayList();
        assertEquals(expResult, result);
    }
    
}
