package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import View.ComponentsCustomGUI.PaintMenu;

public class PessoaGUI extends JPanel {
    private JLabel[] jl;
    private JTextField nomeField;
    private JFormattedTextField telefoneField;
    private JTextField emailField;
    private JFormattedTextField dataField;

    private MaskFormatter telefoneFormatter;
    private MaskFormatter dataFormatter;

    private JButton salvar, cancelar, atualizar;

    private PaintMenu paintmenu;

    public PessoaGUI() {
        setLayout(new BorderLayout());

        this.paintmenu = new PaintMenu();
        this.jl = new JLabel[4];
        try {
            this.telefoneFormatter = new MaskFormatter("(##) ####-####");
            this.dataFormatter = new MaskFormatter("##/##/####");
            telefoneFormatter.setPlaceholderCharacter('0');
            dataFormatter.setPlaceholderCharacter('0');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.nomeField = new JTextField("digite seu nome");
        this.telefoneField = new JFormattedTextField(telefoneFormatter);
        this.emailField = new JFormattedTextField("digite seu email");
        this.dataField = new JFormattedTextField(dataFormatter);
        this.salvar = new JButton("salvar");
        this.cancelar = new JButton("cancelar");
        this.atualizar = new JButton("atualizar");

        paintmenu.setLayout(new GridBagLayout());
        paintmenu.setOpaque(false);
        paintmenu.setRounded(20);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        jl[0] = new JLabel("nome");
        jl[1] = new JLabel("telefone");
        jl[2] = new JLabel("email");
        jl[3] = new JLabel("data de nascimento");

        for (JLabel jLabel : jl) {
            jLabel.setForeground(Color.white);

        }

        c.weightx = 0.9;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 10, 0, 0);
        paintmenu.add(jl[0], c);
        c.insets = new Insets(10, 10, 0, 10);
        c.gridx = 1;
        c.gridy = 0;
        paintmenu.add(nomeField, c);
        c.gridx = 0;
        c.gridy = 1;
        paintmenu.add(jl[1], c);
        c.gridx = 1;
        c.gridy = 1;
        paintmenu.add(telefoneField, c);
        c.gridx = 0;
        c.gridy = 2;
        paintmenu.add(jl[2], c);
        c.gridx = 1;
        c.gridy = 2;
        paintmenu.add(emailField, c);
        c.gridx = 0;
        c.gridy = 3;
        paintmenu.add(jl[3], c);
        c.gridx = 1;
        c.gridy = 3;
        paintmenu.add(dataField, c);
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(20, 10, 10, 10);

        paintmenu.add(cancelar, c);
        c.gridx = 1;
        c.gridy = 4;
        paintmenu.add(salvar, c);
        c.gridx = 1;
        c.gridy = 4;
        paintmenu.add(atualizar, c);
        salvar.setVisible(false);
        atualizar.setVisible(false);
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

    public JTextField getNomeField() {
        return nomeField;
    }

    public void setNomeField(JTextField nomeField) {
        this.nomeField = nomeField;
    }

    public JFormattedTextField getTelefoneField() {
        return telefoneField;
    }

    public void setTelefoneField(JFormattedTextField telefoneField) {
        this.telefoneField = telefoneField;
    }

    public void setEmailField(JFormattedTextField emailField) {
        this.emailField = emailField;
    }

    public JFormattedTextField getDataField() {
        return dataField;
    }

    public void setDataField(JFormattedTextField dataField) {
        this.dataField = dataField;
    }

    public MaskFormatter getTelefoneFormatter() {
        return telefoneFormatter;
    }

    public void setTelefoneFormatter(MaskFormatter telefoneFormatter) {
        this.telefoneFormatter = telefoneFormatter;
    }

    public MaskFormatter getDataFormatter() {
        return dataFormatter;
    }

    public void setDataFormatter(MaskFormatter dataFormatter) {
        this.dataFormatter = dataFormatter;
    }

    public JButton getSalvar() {
        return salvar;
    }

    public void setSalvar(JButton salvar) {
        this.salvar = salvar;
    }

    public JButton getCancelar() {
        return cancelar;
    }

    public void setCancelar(JButton cancelar) {
        this.cancelar = cancelar;
    }

    public PaintMenu getPaintmenu() {
        return paintmenu;
    }

    public void setPaintmenu(PaintMenu paintmenu) {
        this.paintmenu = paintmenu;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public void setEmailField(JTextField emailField) {
        this.emailField = emailField;
    }

    public JButton getAtualizar() {
        return atualizar;
    }

    public void setAtualizar(JButton atualizar) {
        this.atualizar = atualizar;
    }

}