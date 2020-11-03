package projeto1.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Responsible for the user interface, receiving all the desired files.
 * Performs the verification by the extension .txt. <br>
 * The output is made with the same file name, just changing the extension to
 * .csv.
 *
 * @author Ariel Tadeu
 * @author Enzo Fujimoto
 * @author Guilherme Lopes
 * @author Leonardo Teixeira
 */
public class Main {

    /**
     * Responsible for starting the entire program and passing the user data to
     * the {@link Control}.
     */
    private void startProgram() {
        List<String> fileRequest = userTextInterface();
        Control control = new Control(fileRequest);
    }
    
    /**
     * Displays to the user the text interface and requests all the full paths
     * to the files to be transformed.
     * 
     * @return List with all the complete paths to be processed.
     */
    private List<String> userTextInterface() {
        Scanner reader = new Scanner(System.in);
        List<String> fileRequest = new ArrayList();
        String lineString;
        System.out.println("Write each file path you want (FULL PATH). Then 0 to stop");
        do {
            lineString = reader.nextLine();
            if (!"0".equals(lineString)) {
                fileRequest.add(lineString);
            } else {
                break;
            }
        } while (true);

        return fileRequest;
    }

    /**
     * <b>Main entry</b>
     * 
     * @param args Not implemented, therefore not used.
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.startProgram();
    }
}
