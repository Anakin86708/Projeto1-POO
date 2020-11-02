package projeto1.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Responsável pela interface com o usuário, recebendo todos os arquivos
 * desejados. Realiza a verificação pela extensão .txt. <br>
 * A saída é feita com o mesmo nome de arquivo, apenas alterando a extensão para
 * .csv
 *
 * @author Ariel Tadeu
 * @author Enzo Fujimoto
 * @author Guilherme Lopes
 * @author Leonardo Teixeira
 */
public class Main {

    /**
     * Responável por iniciar todo o programa e passar o dados do usuário para
     * o {@link Control}
     */
    private void startProgram() {
        List<String> fileRequest = userTextInterface();
        Control control = new Control(fileRequest);
    }
    
    /**
     * Exibe ao usuário a interface de texto e requisita todos os caminhos
     * completos para os arquivos que serão transformados.
     * 
     * @return Lista com todos os caminhos completos para serem processados
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
     * <b>Entrada principal do programa</b>
     * 
     * @param args
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.startProgram();
    }
}
