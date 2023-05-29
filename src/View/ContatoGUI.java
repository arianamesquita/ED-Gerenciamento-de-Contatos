package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import View.ComponentsCustomGUI.paintmenu;
import model.Categoria;
import model.Pessoa;

public class ContatoGUI extends JPanel {

    private JLabel fotodeperfil, nome, numerotelefone, email, data;
    private paintmenu paintcategoria, paintmenu;
    private boolean select;

    public ContatoGUI(Pessoa pessoa, Categoria categoria) {
        this.select = false;
        setLayout(new BorderLayout());

        paintmenu = new paintmenu();
        paintmenu.setBackground(getBackground());
        paintmenu.setLayout(new GridBagLayout());
        paintmenu.setOpaque(false);
        paintmenu.setRounded(20);
        Icon icon = new ImageIcon("C:\\Users\\pedro\\Downloads\\imagemuser.png");

        fotodeperfil = new JLabel();
        fotodeperfil.setOpaque(false);
        fotodeperfil.setIcon(icon);
        email = new JLabel(pessoa.getEmail());
        numerotelefone = new JLabel(pessoa.getTelefone());
        nome = new JLabel(pessoa.getNome());

        paintcategoria = new paintmenu();
        paintcategoria.setBackground(Color.lightGray);
        paintcategoria.setLayout(new FlowLayout());
        paintcategoria.setOpaque(false);
        JLabel texto = new JLabel("categoria: " + categoria.getCategorias());
        paintcategoria.add(texto);

        fotodeperfil.setForeground(Color.white);
        email.setForeground(Color.white);
        numerotelefone.setForeground(Color.white);
        nome.setForeground(Color.white);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.weightx = 0.9;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        c.anchor = GridBagConstraints.WEST;
        paintmenu.add(fotodeperfil, c);
        c.insets = new Insets(0, 10, 0, 10);

        c.gridx = 1;
        c.gridy = 0;

        paintmenu.add(nome, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        paintmenu.add(email, c);
        c.gridx = 0;
        c.gridy = 2;
        paintmenu.add(numerotelefone, c);
        c.insets = new Insets(10, 10, 10, 10);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 3;
        paintmenu.add(paintcategoria, c);

        paintcategoria.setVisible(false);
        email.setVisible(false);
        numerotelefone.setVisible(false);
        paintmenu.setBackground(Color.darkGray);
        setOpaque(false);
        add(paintmenu, BorderLayout.CENTER);
        setVisible(true);

    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public JLabel getFotodeperfil() {
        return fotodeperfil;
    }

    public void setFotodeperfil(JLabel fotodeperfil) {
        this.fotodeperfil = fotodeperfil;
    }

    public JLabel getNome() {
        return nome;
    }

    public void setNome(JLabel nome) {
        this.nome = nome;
    }

    public JLabel getNumerotelefone() {
        return numerotelefone;
    }

    public void setNumerotelefone(JLabel numerotelefone) {
        this.numerotelefone = numerotelefone;
    }

    public JLabel getEmail() {
        return email;
    }

    public void setEmail(JLabel email) {
        this.email = email;
    }

    public JLabel getData() {
        return data;
    }

    public void setData(JLabel data) {
        this.data = data;
    }

    public paintmenu getPaintcategoria() {
        return paintcategoria;
    }

    public void setPaintcategoria(paintmenu paintcategoria) {
        this.paintcategoria = paintcategoria;
    }

    public paintmenu getPaintmenu() {
        return paintmenu;
    }

    public void setPaintmenu(paintmenu paintmenu) {
        this.paintmenu = paintmenu;
    }

}
