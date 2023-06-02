package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import View.ComponentsCustomGUI.PaintMenu;

public class CaixaTextoGUI extends JPanel {
    JLabel[] jl;
    JTextField[] jt;
    JButton[] jb;
    PaintMenu paintmenu;

    public CaixaTextoGUI() {
        this.jt = new JTextField[4];
        this.jl = new JLabel[4];
        this.jb = new JButton[2];
        this.paintmenu = new PaintMenu();
        paintmenu.setLayout(new GridBagLayout());
        paintmenu.setOpaque(false);
        paintmenu.setRounded(20);

        setLayout(new BorderLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        jt[0] = new JTextField(30);
        jt[1] = new JTextField(30);
        jt[2] = new JTextField(30);
        jt[3] = new JTextField(30);

        jl[0] = new JLabel("nome");
        jl[1] = new JLabel("telefone");
        jl[2] = new JLabel("email");
        jl[3] = new JLabel("data de aniversário");
        for (JLabel jLabel : jl) {
            jLabel.setForeground(Color.white);

        }

        jb[0] = new JButton("cancelar");
        jb[1] = new JButton("salvar");

        c.weightx = 0.9;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 10, 0, 0);
        paintmenu.add(jl[0], c);
        c.insets = new Insets(10, 10, 0, 10);
        c.gridx = 1;
        c.gridy = 0;
        paintmenu.add(jt[0], c);
        c.gridx = 0;
        c.gridy = 1;
        paintmenu.add(jl[1], c);
        c.gridx = 1;
        c.gridy = 1;
        paintmenu.add(jt[1], c);
        c.gridx = 0;
        c.gridy = 2;
        paintmenu.add(jl[2], c);
        c.gridx = 1;
        c.gridy = 2;
        paintmenu.add(jt[2], c);
        c.gridx = 0;
        c.gridy = 3;
        paintmenu.add(jl[3], c);
        c.gridx = 1;
        c.gridy = 3;
        paintmenu.add(jt[3], c);
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(20, 10, 10, 10);

        paintmenu.add(jb[0], c);
        c.gridx = 1;
        c.gridy = 4;
        paintmenu.add(jb[1], c);
        paintmenu.setBackground(Color.darkGray);
        setBackground(Color.gray);
        setOpaque(true);
        add(paintmenu, BorderLayout.CENTER);
        setVisible(true);

    }

    public JLabel[] getJl() {
        return jl;
    }

    public void setJl(JLabel[] jl) {
        this.jl = jl;
    }

    public JTextField[] getJt() {
        return jt;
    }

    public void setJt(JTextField[] jt) {
        this.jt = jt;
    }

    public JButton[] getJb() {
        return jb;
    }

    public void setJb(JButton[] jb) {
        this.jb = jb;
    }

}