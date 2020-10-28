package projeto1.poo;

import java.util.ArrayList;
import java.util.TreeMap;

public class Digrafo {

    private TreeMap<String,ArrayList<String>> adjMap;

    public Digrafo(String[] treatedText) {
        adjMap = new TreeMap<>();
        for (int i = 0; i < treatedText.length-1; i++) {
            if (!adjMap.containsKey(treatedText[i])) {
                adjMap.put(treatedText[i], new ArrayList<>());
            }
            adjMap.get(treatedText[i]).add(treatedText[i+1]);
        }
        System.out.println("");
    }
    
    

}
