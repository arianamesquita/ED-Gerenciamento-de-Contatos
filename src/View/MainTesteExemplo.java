package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

import controller.ContatosController;
import database.CategoriaDAO;
import database.PessoaDAO;

public class MainTesteExemplo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(950, 550);
        frame.setResizable(false);
        PessoaDAO pessoa = new PessoaDAO("pedro", 0, "61985439393", "pedrohenriquedejesus13@gmail.com",new java.util.Date());
        CategoriaDAO categoria = new CategoriaDAO("amigo");
        ContatosController[] contato = new ContatosController[10];

        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(layout);
        for (int i = 0; i < contato.length; i++) {
            contato[i] =  new ContatosController(pessoa, categoria);
            contato[i].getPessoa().setNome("pedro henrique de jesus ferreira" + i);
            panel.add(contato[i].getContatoGUI());
            panel.add(Box.createRigidArea(new Dimension(0, 2)));

        }
        panel.setBackground(Color.gray);


        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setPaint(new Color( 163, 183, 203));
                g2.fill(thumbBounds);
            }
        
            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setPaint(new Color( 120, 136, 151));
                g2.fill(trackBounds);
            }
        });


        scrollPane.setPreferredSize(new Dimension(300, 500));

        frame.add(scrollPane, BorderLayout.WEST);

        frame.setVisible(true);

    }
}
