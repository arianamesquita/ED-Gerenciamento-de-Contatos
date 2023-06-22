package View;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import controller.InicialScreenController;

public class MainTeste {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // Registra o tempo inicial

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 700);

        InicialScreenController iController = new InicialScreenController();

        frame.add(iController.getTelaInicialGUI(), BorderLayout.CENTER);
        frame.setVisible(true);
        System.out.println("tudo certo!!");

        long endTime = System.currentTimeMillis(); // Registra o tempo final
        long totalTime = endTime - startTime; // Calcula o tempo total em milissegundos

        // Converte o tempo total para minutos e segundos
        long totalSeconds = totalTime / 1000;
        long minutes = totalSeconds / 60;
        long seconds = totalSeconds % 60;

        System.out.println("Tempo total: " + minutes + " minuto(s) e " + seconds + " segundo(s).");
    }

}
