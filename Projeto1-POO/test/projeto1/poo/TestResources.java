package projeto1.poo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author silva
 */
public class TestResources {
    // método para treemap
    public static SortedMap<String, List<String>> generateResultSortedMap(){
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
