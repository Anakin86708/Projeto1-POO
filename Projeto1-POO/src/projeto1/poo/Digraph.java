package projeto1.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class Digraph {

    private final SortedMap<String,List<String>> adjMap;

    public Digraph(String[] treatedText) {
        adjMap = new TreeMap<>();
        createTreeMap(treatedText);
    }

    private void createTreeMap(String[] treatedText) {
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
    
    public SortedMap<String, List<String>> getAdjMap() {
        return adjMap;
    }    
}
