package projeto1.poo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

/**
 * Responável por realizar a saída de um {@link Digraph Digraph} em um arquivo
 * de texto em formato .csv
 *
 * @author Ariel Tadeu
 * @author Enzo Fujimoto
 * @author Guilherme Lopes
 * @author Leonardo Teixeira
 */
public class WriteCSV {

    /**
     * Realiza a chamada do método caso contenha um {@code fileName} com 
     * extensão .csv
     * {@link WriteCSV#writeFile(java.util.SortedMap, java.lang.String) WriteCSV}
     *
     *
     * @param adjMap Representação da lista de adjacência
     * @param fileName Nome utilizado como arquivo de saida, necessáriamente com
     * extensão .csv
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
     * Escreve todo o {@link adjMap} no arquivo {@link fileName} em formato .csv
     *
     * @param adjMap Representação da lista de adjacência
     * @param fileName Nome utilizado como arquivo de saida, necessáriamente
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
     * Para cada chave em {@link adjMap} cria uma linha e escreve todo o conteúdo
     * de {@link fileName}
     * 
     * @param adjMap Representação da lista de adjacência
     * @param fileName Nome utilizado como arquivo de saida, necessáriamente
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
