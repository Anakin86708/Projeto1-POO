package projeto1.poo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Recebe o arquivo .txt, removendo pontuações, transformando o conteúdo para 
 * minúsculo e separando as palavras
 */
public class ReadTXT {

    private final List<String> treatedTextArrayList;    

    /**
     * Cria um objeto do tipo File e separa as palavras do seu conteúdo
     * @param fileNameString
     */
    public ReadTXT(String fileNameString) {
        File file = new File(fileNameString);
        treatedTextArrayList = splitWords(file);
    }

    public List<String> getTreatedTextArrayList() {
        return treatedTextArrayList;
    }

    /**
     * Recebe o arquivo, faz o tratamento e adiciona as linhas ao ArrayList
     * @param file O arquivo .txt carregado anteriormente
     * @return arrayList com as palavras separadas e sem pontuação
     */
    private List<String> splitWords(File file) {
        List<String> arrayList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file, "utf-8");
            while (scanner.hasNext()) {
                String splitedLine = removePunctuation(lowerWords(scanner.next()));
                arrayList.add(splitedLine);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadTXT.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }
    
    /**
     * Recebe a string e a transforma para minúsculo
     * @param toTreat string carregada
     * @return string com os caracteres minúsculos
     */
    private String lowerWords(String toTreat) {
        return toTreat.toLowerCase();
    }

    /**
     * Recebe a string e aplica um filtro substuindo qualquer caractere que não
     * seja uma letra
     * @param toTreat string carregada
     * @return string filtrada
     */
    private String removePunctuation(String toTreat) {
        String regexToReplace = "[^\\p{L}\\d\\s_]";
        return toTreat.replaceAll(regexToReplace, "");
    }

}
