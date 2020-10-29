package projeto1.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Digrafo {

    private TreeMap<String,List<String>> adjMap;

    public Digrafo(String[] treatedText) {
        createTreeMap(treatedText);
    }

    private void createTreeMap(String[] treatedText) {
        adjMap = new TreeMap<>();
        for (int i = 0; i < treatedText.length-1; i++) {
            if (!adjMap.containsKey(treatedText[i])) {
                adjMap.put(treatedText[i], new ArrayList<>());
            }
            
            insertTreeMap(treatedText, i);
        }
    }

    private void insertTreeMap(String[] treatedText, int i) {
        boolean alreadyExist = adjMap.get(treatedText[i]).contains(treatedText[i+1]);
        if(!alreadyExist){
            adjMap.get(treatedText[i]).add(treatedText[i+1]);
        }
    }
    
    public TreeMap<String, List<String>> getAdjMap() {
        return adjMap;
    }    
}
