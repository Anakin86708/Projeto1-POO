package projeto1.poo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ReadTXT {

    private List<String> treatedTextArrayList;    

    /**
     * Creates an object of File type and splits words from their content
     * @param fileNameString - .txt file name
     */
    public ReadTXT(String fileNameString) {
        try {
            if (!validateFileName(fileNameString))
                throw new Exception(fileNameString + "isn`t a valid .txt file\n");
            
            File file = new File(fileNameString);
            treatedTextArrayList = splitWords(file);
        } catch (Exception e) {
            System.err.println("Invalid file!\n" + e.getLocalizedMessage());
        }
    }
    
    private boolean validateFileName(String fileName) {
        return fileName.endsWith(".txt");
    }

    public List<String> getTreatedTextList() {
        return treatedTextArrayList;
    }

    /**
     * Receives a file, treat it and add all lines to ArrayList
     * @param file .txt archive loaded before
     * @return A arrayList with words splitted and without punctuation
     */
    private List<String> splitWords(File file) {
        List<String> arrayList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file, "utf-8");
            while (scanner.hasNext()) {
                String splitedLine = removePunctuation(lowerWords(scanner.next()));
                if (!splitedLine.equals(""))
                    arrayList.add(splitedLine);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File " + file.getName() + " not found!\n" + ex.getLocalizedMessage());
        }
        return arrayList;
    }
    
    /**
     * Receives a string and transform it to lowercase
     * @param toTreat loaded string
     * @return string with lowercase characters
     */
    private String lowerWords(String toTreat) {
        return toTreat.toLowerCase();
    }

    /**
     * Receives a string and applies a filter replacing any non-letter character
     * @param toTreat string carregada
     * @return string filtrada
     */
    private String removePunctuation(String toTreat) {
        String regexToReplace = "([^\\p{L}\\d\\s_'-.\\x{2026}%⁃]|(\\s-|-\\s|,|\\.|\\(|\\)))";  // Regex removing ponctuation, but keeping some characteres
        return toTreat.replaceAll(regexToReplace, "");
    }

}
