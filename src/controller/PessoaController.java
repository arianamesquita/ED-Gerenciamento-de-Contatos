package controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import View.PessoaGUI;

public class PessoaController implements FocusListener {

    private PessoaGUI caixaTexto;
    private ContatoController contatoEdicao;

    public PessoaController() {
        this.caixaTexto = new PessoaGUI();

        caixaTexto.getNomeField().addFocusListener(this);
        caixaTexto.getEmailField().addFocusListener(this);

    }
    
    public void setNovoContato(){
        getCaixaTexto().getNomeField().setText("digite seu nome");
        getCaixaTexto().getNomeField().setBackground(Color.white);
        getCaixaTexto().getNomeField().setForeground(Color.darkGray);;

        getCaixaTexto().getEmailField().setText("digite seu email");
        getCaixaTexto().getEmailField().setBackground(Color.white);
        getCaixaTexto().getEmailField().setForeground(Color.darkGray);;

        getCaixaTexto().getTelefoneField().setText("");
        getCaixaTexto().getTelefoneField().setBackground(Color.white);
        getCaixaTexto().getTelefoneField().setForeground(Color.darkGray);

        getCaixaTexto().getDataField().setText("");
        getCaixaTexto().getDataField().setBackground(Color.white);
        getCaixaTexto().getDataField().setForeground(Color.darkGray);
    }
    public void setEditarContato(ContatoController contato){
        setContatoEdicao(contato);
        getCaixaTexto().getNomeField().setText(contato.getContato().getPessoa().getNome());
        getCaixaTexto().getNomeField().setBackground(Color.white);
        getCaixaTexto().getNomeField().setForeground(Color.darkGray);;

        getCaixaTexto().getEmailField().setText(contato.getContato().getPessoa().getEmail());
        getCaixaTexto().getEmailField().setBackground(Color.white);
        getCaixaTexto().getEmailField().setForeground(Color.darkGray);;

        getCaixaTexto().getTelefoneField().setText(contato.getContato().getPessoa().getTelefone());
        getCaixaTexto().getTelefoneField().setBackground(Color.white);
        getCaixaTexto().getTelefoneField().setForeground(Color.darkGray);
     

        getCaixaTexto().getDataField().setText(new SimpleDateFormat("dd/MM/yyyy").format(contato.getContato().getPessoa().getDataAniversario()));
        getCaixaTexto().getDataField().setBackground(Color.white);
        getCaixaTexto().getDataField().setForeground(Color.darkGray);
    }

    public PessoaGUI getCaixaTexto() {
        return caixaTexto;
    }

    public void setCaixaTexto(PessoaGUI caixaTexto) {
        this.caixaTexto = caixaTexto;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == getCaixaTexto().getNomeField()) {
            if (getCaixaTexto().getNomeField().getText().equals("digite seu nome")) {
                getCaixaTexto().getNomeField().setBackground(Color.white);
                getCaixaTexto().getNomeField().setForeground(Color.darkGray);

                getCaixaTexto().getNomeField().setText("");
            }
        } else if (e.getSource() == getCaixaTexto().getEmailField()) {
            if (getCaixaTexto().getEmailField().getText().equals("digite seu email")) {
                getCaixaTexto().getEmailField().setBackground(Color.white);
                getCaixaTexto().getNomeField().setForeground(Color.darkGray);
                getCaixaTexto().getEmailField().setText("");
            }
        }

    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == getCaixaTexto().getNomeField()) {
            if (getCaixaTexto().getNomeField().getText().equals("")
                    || getCaixaTexto().getNomeField().getText().isEmpty()) {
                getCaixaTexto().getNomeField().setBackground(Color.red);
                getCaixaTexto().getNomeField().setForeground(Color.white);
                getCaixaTexto().getNomeField().setText("digite seu nome");
            }
        } else if (e.getSource() == getCaixaTexto().getEmailField()) {
            if (getCaixaTexto().getEmailField().getText().equals(" ")
                    || getCaixaTexto().getEmailField().getText().isEmpty()) {
                getCaixaTexto().getEmailField().setBackground(Color.red);
                getCaixaTexto().getEmailField().setForeground(Color.darkGray);

                getCaixaTexto().getEmailField().setText("digite seu email");
            }
            String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

            if (!getCaixaTexto().getEmailField().getText().matches(EMAIL_PATTERN)) {
                JOptionPane.showMessageDialog(caixaTexto,"email digitado de forma incorreta!!", "erro!!", 0);
                getCaixaTexto().getEmailField().setText("digite seu email");       
                 getCaixaTexto().getEmailField().setForeground(Color.white);
                getCaixaTexto().getEmailField().setBackground(Color.red);

            }
        }
    }

    public ContatoController getContatoEdicao() {
        return contatoEdicao;
    }

    public void setContatoEdicao(ContatoController contatoEdicao) {
        this.contatoEdicao = contatoEdicao;
    }
}
