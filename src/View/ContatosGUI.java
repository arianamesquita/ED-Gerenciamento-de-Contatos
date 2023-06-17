package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import View.ComponentsCustomGUI.PaintMenu;
import model.Contato;

public class ContatosGUI extends JPanel {

    private JLabel fotoPerfil, nome, numeroTelefone, email, data;
    private PaintMenu paintCategoria, paintMenu;
    private boolean select, mouseClicked;
    private Contato contato;

    public ContatosGUI(Contato contato) {
        this.contato = contato;
        this.select = false;
        setLayout(new BorderLayout());

        paintMenu = new PaintMenu();
        paintMenu.setBackground(getBackground());
        paintMenu.setLayout(new GridBagLayout());
        paintMenu.setOpaque(false);
        paintMenu.setRounded(20);
        Icon icon = new ImageIcon("C:\\Users\\pedro\\Downloads\\imagemuser.png");

        fotoPerfil = new JLabel();
        fotoPerfil.setOpaque(false);
        fotoPerfil.setIcon(icon);
        email = new JLabel(getContato().getPessoa().getEmail());
        numeroTelefone = new JLabel(getContato().getPessoa().getTelefone());
        nome = new JLabel(getContato().getPessoa().getNome());
        nome.setHorizontalAlignment(JLabel.LEFT);

        paintCategoria = new PaintMenu();
        paintCategoria.setBackground(Color.lightGray);
        paintCategoria.setLayout(new FlowLayout());
        paintCategoria.setOpaque(false);
        JLabel texto = new JLabel("categoria: " + getContato().getCategoria().getNome());
        paintCategoria.add(texto);

        fotoPerfil.setForeground(Color.white);
        email.setForeground(Color.white);
        numeroTelefone.setForeground(Color.white);
        nome.setForeground(Color.white);


        Date dataAniversario = getContato().getPessoa().getDataAniversario();
        dataAniversario.setYear(Calendar.getInstance().get(Calendar.YEAR) - 1900);
        data = new JLabel("Data de Aniversario: "+new SimpleDateFormat("dd/MM/yyyy").format(dataAniversario));
        data.setForeground(Color.white);


        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.1;
        paintMenu.add(fotoPerfil, c);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        paintMenu.add(nome, c);
        c.insets = new Insets(10, 10, 0, 10);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        paintMenu.add(numeroTelefone, c);
        c.gridx = 0;
        c.gridy = 2;
        paintMenu.add(email, c);
        c.gridx = 0;
        c.gridy = 3;
        paintMenu.add(data,c);
        c.insets = new Insets(10, 10, 10, 10);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 4;
        paintMenu.add(paintCategoria, c);

        paintCategoria.setVisible(false);
        email.setVisible(false);
        numeroTelefone.setVisible(false);
        data.setVisible(false);
        paintMenu.setBackground(Color.darkGray);
        setOpaque(false);
        add(paintMenu, BorderLayout.CENTER);
        setVisible(true);

    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public JLabel getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(JLabel fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public JLabel getNome() {
        return nome;
    }

    public void setNome(JLabel nome) {
        this.nome = nome;
    }

    public JLabel getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(JLabel numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
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

    public PaintMenu getPaintCategoria() {
        return paintCategoria;
    }

    public void setPaintCategoria(PaintMenu paintCategoria) {
        this.paintCategoria = paintCategoria;
    }

    public PaintMenu getPaintMenu() {
        return paintMenu;
    }

    public void setPaintMenu(PaintMenu paintMenu) {
        this.paintMenu = paintMenu;
    }

    public boolean isMouseClicked() {
        return mouseClicked;
    }

    public void setMouseClicked(boolean mouseClicked) {
        this.mouseClicked = mouseClicked;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }


}