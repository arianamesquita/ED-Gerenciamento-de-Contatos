package View;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import controller.InicialScreenController;

public class MainTeste {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 700);

        InicialScreenController iController = new InicialScreenController();
     
        frame.add(iController.getTelaInicialGUI(),BorderLayout.CENTER);
        frame.setVisible(true);
        System.out.println("tudo certo!!");

    }
    
}
