package View;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CaixadetextoGui extends JPanel{
    JLabel[] jl;
    JTextField[] jt;
    JButton[] jb;

    public CaixadetextoGui(){
        this.jt = new JTextField[4];
        this.jl = new JLabel[4];
        this.jb = new JButton[2];
        
        setPreferredSize(new Dimension(300, 200));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        jt[0] = new JTextField(30);
        jt[1] = new JTextField(30);
        jt[2] = new JTextField(30);
        jt[3] = new JTextField(30);

        jl[0] = new JLabel("nome");
        jl[1] = new JLabel("telefone");
        jl[2] = new JLabel("email");
        jl[3] = new JLabel("data");

        jb[0] = new JButton("cancelar");
        jb[1] = new JButton("salvar");

        c.weightx = 0.9;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 0, 0);
        add(jl[0],c);
        c.gridx = 1;
        c.gridy = 0;
        add(jt[0],c);
        c.gridx = 0;
        c.gridy = 1;
        add(jl[1],c);
        c.gridx = 1;
        c.gridy = 1;
        add(jt[1],c);
        c.gridx = 0;
        c.gridy = 2;
        add(jl[2],c);
        c.gridx = 1;
        c.gridy = 2;
        add(jt[2],c);
        c.gridx = 0;
        c.gridy = 3;
        add(jl[3],c);
        c.gridx = 1;
        c.gridy = 3;
        add(jt[3],c);
        c.gridx = 0;
        c.gridy = 4;
        add(jb[0], c);
        c.gridx = 1;
        c.gridy = 4;
        add(jb[1], c);
        
    }
    
}
