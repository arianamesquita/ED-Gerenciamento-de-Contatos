
import java.awt.BorderLayout;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.InicialScreenController;

public class App {
    public static void main(String[] args) throws MalformedURLException {

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 700);
        frame.setTitle("Contatos");

        ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/2xUsiBa.png?4"));
        frame.setIconImage(icon.getImage());

        InicialScreenController iController = new InicialScreenController();

        frame.add(iController.getTelaInicialGUI(), BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
