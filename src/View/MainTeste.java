package View;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import controller.ContatosController;
import controller.InicialScreenController;
import database.CategoriaDAO;
import database.PessoaDAO;

public class MainTeste {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 700);
        
        PessoaDAO pessoa = new PessoaDAO("pedro", 0, "61985439393", "pedrohenriquedejesus13@gmail.com",new java.util.Date());
        CategoriaDAO categoria = new CategoriaDAO("amigo");
        ContatosController[] contato = new ContatosController[1000];
        

        for (int i = 0; i < contato.length; i++) {
            contato[i] =  new ContatosController(pessoa, categoria);
            contato[i].getPessoa().setNome("pedro henrique de jesus ferreira" + i);
        }
        InicialScreenController iController = new InicialScreenController(contato);
      

        frame.add(iController.getInicialScreenGUI(),BorderLayout.CENTER);

        frame.setVisible(true);

    }
    
}
