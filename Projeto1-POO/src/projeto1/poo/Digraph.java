package projeto1.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
/**
 * Responsible for creating a digraph, containg key values and it respective 
 * values
 * 
 * @author Guilherme Lopes
 */
public class Digraph {

    private final SortedMap<String,List<String>> adjMap;
    
    /**
     * Creates an object of TreeMap type. 
     * <br>
     * Call createTreeMap method using treatedText as parameter.
     * @param treatedText - Text with words splitted, lowercase applied and
     * without punctuation.
     */
    public Digraph(String[] treatedText) {
        adjMap = new TreeMap<>();
        createTreeMap(treatedText);
    }

    /**
     * Adds a key for every string from treatedText to adjMap, creating a new
     * ArrayList.
     * <br>
     * Repeated keys are filtered and are not include in adjMap.
     * <br>
     * For each string, insertTreeMap method is called, using treatedText as 
     * parameter.
     * @param treatedText - Text with words splitted, lowercase applied and
     * without punctuation.
     */
    private void createTreeMap(String[] treatedText) {
        for (int i = 0; i < treatedText.length-1; i++) {
            if (!adjMap.containsKey(treatedText[i])) {
                adjMap.put(treatedText[i], new ArrayList<>());
            }
            
            insertTreeMap(treatedText, i);
        }
    }

    /**
     * Add a value to a respective key from adjMap.
     * <br>
     * Verifies if it contains the same value in the posterior index.
     * <br>
     * @param treatedText - Text with words splitted, lowercase applied 
     * without punctuation.
     * @param i - Index reference to treatedText.
     */
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
