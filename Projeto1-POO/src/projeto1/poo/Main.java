package projeto1.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private void startProgram() {
        List<String> fileRequest = userTextInterface();
        Control control = new Control(fileRequest);
    }
    
    private List<String> userTextInterface() {
        Scanner reader = new Scanner(System.in);
        List<String> fileRequest = new ArrayList();
        String lineString;
        System.out.println("Write each file path you want. Then 0 to stop");
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
    
    public static void main(String[] args) {
        Main main = new Main();
        main.startProgram();
    }
}
