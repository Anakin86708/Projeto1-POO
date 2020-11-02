package projeto1.poo;

import java.util.List;
import java.util.SortedMap;

/**
 * Responsible for managing data between the classes.
 *
 * @author Ariel Tadeu
 * @author Enzo Fujimoto
 * @author Guilherme Lopes
 * @author Leonardo Teixeira
 */
public class Control {

    /**
     * Receives a list and for each element, reads the file, processes and
     * writes into a CSV file.
     *
     * @param lista List with all the words within the input file.
     */
    public Control(List<String> lista) {
        lista.forEach(fileNameItem -> {
            List<String> textReaded = read(fileNameItem);
            SortedMap<String, List<String>> processedDigraph = process(textReaded);
            write(processedDigraph, fileNameItem);
        });
    }

    /**
     * Receives a file and returns it using the method
     * {@link ReadTXT#getTreatedTextList getTreatedTextList} treating it.
     *
     * @param fileName Name to the file input.
     * @return The treated file.
     */
    private List<String> read(String fileName) {
        ReadTXT reading = new ReadTXT(fileName);
        return reading.getTreatedTextList();
    }

    /**
     * Receives a List of string creating a digraph and returning it using the
     * method {@link Digraph#getAdjMap getAdjMap}
     *
     * @param textReaded A list with the treated text.
     * @return Treated Digraph.
     */
    private SortedMap<String, List<String>> process(List<String> textReaded) {
        Digraph digraph = new Digraph(textReaded.stream().toArray(String[]::new));
        return digraph.getAdjMap();
    }

    /**
     * Receives a SortedMap, the treated digraph and the name of the file in
     * which it must be written.
     *
     * @param processedDigraph O digrafo tratado ?????????????
     * @param fileName Name to the file. ??????????????
     */
    private void write(SortedMap<String, List<String>> processedDigraph, String fileName) {
        WriteCSV csv = new WriteCSV(processedDigraph, fileName.replace(".txt", ".csv"));
    }

}
