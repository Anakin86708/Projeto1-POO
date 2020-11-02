package projeto1.poo;

import java.util.List;
import java.util.SortedMap;

public class Control {

    public Control(List<String> lista) {
        lista.forEach(fileNameItem -> {
            List<String> textReaded = read(fileNameItem);
            SortedMap<String, List<String>> processedDigraph = process(textReaded);
            write(processedDigraph, fileNameItem);
        });    
    }
        
    private List<String> read(String fileName) {
        ReadTXT reading = new ReadTXT(fileName);
        return reading.getTreatedTextList();
    }

    private SortedMap<String, List<String>> process(List<String> textReaded) {
        Digrafo digraph = new Digrafo(textReaded.stream().toArray(String []:: new));
        return digraph.getAdjMap();
    }

    private void write(SortedMap<String, List<String>> processedDigraph, String fileName) {
        WriteCSV csv = new WriteCSV(processedDigraph, fileName.replace(".txt", ".csv"));
    }

}
