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
        ContatosController[] contato = new ContatosController[200];

        for (int i = 0; i < contato.length; i++) {
            //PessoaDAO pessoa = new PessoaDAO("pedro"+i, i, "61985439393", "pedrohenriquedejesus13@gmail.com",new java.util.Date());
            //CategoriaDAO categoria = new CategoriaDAO("amigo");
            //contato[i] =  new ContatosController(pessoa, categoria);

        }
        int count = 0;
        for (ContatosController con:contato) {
        con.getPessoa().setNome("pedro"+count+"uma nova gostosa");
        con.updateGUI();
        count++;
        }
        for (ContatosController con:contato) {
            System.out.println(con.getPessoa().getNome());

        }


        InicialScreenController iController = new InicialScreenController(contato);


        frame.add(iController.getInicialScreenGUI(),BorderLayout.CENTER);

        frame.setVisible(true);

    }
    
}
