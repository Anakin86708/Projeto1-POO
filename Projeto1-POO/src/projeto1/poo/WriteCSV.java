package projeto1.poo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

/**
 * Responsible for outputting a {@link Digraph Digraph} in a text file in .csv
 * format.
 *
 * @author Ariel Tadeu
 * @author Enzo Fujimoto
 * @author Guilherme Lopes
 * @author Leonardo Teixeira
 */
public class WriteCSV {

    /**
     * Make the method call if it contains a {@code fileName} with .csv 
     * extension.
     * {@link WriteCSV#writeFile(java.util.SortedMap, java.lang.String) WriteCSV}
     *
     *
     * @param adjMap Representation of the adjacency list.
     * @param fileName Name used as output file. It must be a .csv extesion.
     */
    public WriteCSV(SortedMap<String, List<String>> adjMap, String fileName) {
        try {
            if (!fileName.endsWith(".csv")) // Checks for .csv as file extension
            {
                throw new Exception(fileName + "isn`t a valid .csv file.");
            }
            writeFile(adjMap, fileName);
        } catch (Exception ex) {
            System.err.println("Invalid file!\n" + ex.getLocalizedMessage());
        }
    }

    /**
     * Write the entire {@link adjMap} in the {@link fileName} file in .csv 
     * format.
     *
     * @param adjMap Representation of the adjacency list.
     * @param fileName Name used as output file. It must be a .csv extesion.
     */
    private void writeFile(SortedMap<String, List<String>> adjMap, String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file, Charset.forName("UTF-8"));
            System.out.println("Writing file " + fileName);

            writeEachLine(adjMap, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException iOException) {
            System.err.println("File " + fileName + " cannot be written!\n" + iOException.getLocalizedMessage());
        }
    }

    /**
     * For each key in {@link adjMap} creates a line and writes the entire 
     * contents of
     * {@link fileName}
     * 
     * @param adjMap Representation of the adjacency list.
     * @param fileName Name used as output file. It must be a .csv extesion.
     * 
     * @throws IOException 
     */
    private void writeEachLine(SortedMap<String, List<String>> adjMap, FileWriter fileWriter) throws IOException {
        for (Map.Entry<String, List<String>> entry : adjMap.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            fileWriter.write(key);
            for (String string : value) {
                fileWriter.write(", " + string);
            }
            fileWriter.write("\n");
        }
    }

}
