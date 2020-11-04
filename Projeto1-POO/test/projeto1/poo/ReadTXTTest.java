package projeto1.poo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Realizes tests by comparing generated and expected results using input files
 * 
 * @author Ariel Tadeu
 * @author Enzo Fujimoto
 * @author Guilherme Lopes
 * @author Leonardo Teixeira
 */
public class ReadTXTTest {

    /**
     * Test of portuguese language getTreatedTextArrayList method, of class
     * ReadTXT.
     */
    @Test
    public void testGetTreatedTextList() {
        System.out.println("getTreatedTextArrayList");
        String fileNameString = "test/resources/test1.txt";
        String[] c = {"joão", "amava", "maria", "que", "amava", "júlio", "que", "não", "amava", "ninguém"};
        setupTestClass(fileNameString, c);
    }

    /**
     * Test of english language getTreatedTextArrayList method, of class
     * ReadTXT.
     */
    @Test
    public void englishTestGetTreatedTextArrayList() {
        System.out.println("getTreatedTextArrayList");
        String fileNameString = "test/resources/test2.txt";
        String[] c = {"john", "who", "loved", "marry", "who", "loved", "julio", "that", "loved", "no", "one"};
        setupTestClass(fileNameString, c);
    }

    /**
     * Testing validation files.
     */
    @Test
    public void ex3Test() {
        System.out.println("ex1Test");
        String filenameString = "test/resources/Ex3_LuarDoSertao.txt";
        String[] c = {"não", "há", "ó", "gente", "ó", "não", "luar", "como", "esse", "do",
            "sertão", "não", "há", "ó", "gente", "ó", "não", "luar", "como", "esse", "do",
            "sertão", "oh", "que", "saudade", "do", "luar", "da", "minha", "terra", "lá", "na",
            "serra", "branquejando", "folhas", "secas", "pelo", "chão", "este", "luar", "cá",
            "da", "cidade", "tão", "escuro", "não", "tem", "aquela", "saudade", "do", "luar",
            "lá", "do", "sertão", "não", "há", "ó", "gente", "ó", "não", "luar", "como", "esse",
            "do", "sertão", "não", "há", "ó", "gente", "ó", "não", "luar", "como", "esse", "do",
            "sertão"};
        setupTestClass(filenameString, c);
    }

    /**
     * Used to generate ArrayList easily.
     * 
     * @param fileNameString filename .txt.
     * @param c Collection added to ArrayList as expected result.
     */
    private void setupTestClass(String fileNameString, String[] c) {
        ReadTXT instance = new ReadTXT(fileNameString);
        ArrayList<String> expResult = new ArrayList<>();
        Collections.addAll(expResult, c);
        List<String> result = instance.getTreatedTextList();
        assertEquals(expResult, result);
    }

}
