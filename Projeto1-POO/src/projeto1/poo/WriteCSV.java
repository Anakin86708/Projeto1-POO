package projeto1.poo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class WriteCSV {

    public WriteCSV(SortedMap<String, List<String>> adjMap, String fileName) {
        writeFile(adjMap, fileName);
    }

    private void writeFile(SortedMap<String, List<String>> adjMap, String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, Charset.forName("UTF-8"));
            System.out.println("Writing file " + fileName);
            for (Map.Entry<String, List<String>> entry : adjMap.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                fileWriter.write(key);
                for (String string : value) {
                    fileWriter.write(", " + string);
                }
                fileWriter.write("\n");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException iOException) {
            System.err.println("Não foi\n" +iOException.getMessage());
        }
    }

}
