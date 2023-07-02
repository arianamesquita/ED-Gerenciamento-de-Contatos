package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import View.PessoaGUI;
import database.DoublyLinkedLists;
import database.NO;
import database.DAO.CategoriaDAO;
import database.DAO.ContatoDAO;
import database.DAO.PessoaDAO;
import model.Contato;
import model.Pessoa;

public class PessoaController implements FocusListener, ActionListener {

    private PessoaGUI pessoaGUI;
    private ContatoController contatoEdicao;
    private InicialScreenController inicialScreenController;

    public PessoaController() {
        this.pessoaGUI = new PessoaGUI();

        pessoaGUI.getNomeField().addFocusListener(this);
        pessoaGUI.getEmailField().addFocusListener(this);
        pessoaGUI.getSalvar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                getInicialScreenController().getTelaInicialGUI().getPessoaController().pessoaGUI.setVisible(false);
                salvar();
                getInicialScreenController().updateInterface();
                getInicialScreenController().getTelaInicialGUI().getCriar().setVisible(true);
            }

        });
        pessoaGUI.getAtualizar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getInicialScreenController().getTelaInicialGUI().getPessoaController().pessoaGUI.setVisible(false);
                atualiza();
                getInicialScreenController().getTelaInicialGUI().getCriar().setVisible(true);
            }

        });

    }

    private void salvar() {
        String nome = getPessoaGUI().getNomeField().getText();
        String email = getPessoaGUI().getEmailField().getText();
        String numero = getPessoaGUI().getTelefoneField().getText();
        numero = numero.replaceAll("[^0-9]", "");
        String data = getPessoaGUI().getDataField().getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date parsedDate;
        try {
            parsedDate = dateFormat.parse(data);
        } catch (ParseException e) {
            // Trate qualquer erro de análise aqui
            e.printStackTrace();
            return;
        }
        Pessoa pessoa = new Pessoa(nome, geraId(), numero, email, new java.sql.Date(parsedDate.getTime()));
        PessoaDAO pessoaDAO = new PessoaDAO();

        pessoaDAO.insert(pessoa); 

        System.out.println("1");
        Contato contato = new Contato(ContatoController.geraId(), new CategoriaDAO().findById(1), pessoa);
        ContatoDAO contatoDao = new ContatoDAO();
        contatoDao.insert(contato);
        System.out.println("2");

        getInicialScreenController().getListaContatoController().InsereNoFim(new ContatoController(contato));

    }

    public void apaga() {
        NO<ContatoController> current = getInicialScreenController().getListaContatoController().getInicio();
        while (current != null) {
            if (current.getData().isSelect()) {
                new PessoaDAO().delete(current.getData().getContato().getPessoa().getId());
                new ContatoDAO().delete(current.getData().getContato().getId());
                getInicialScreenController().getListaContatoController().ApagaData(current.getData());
                getInicialScreenController()
                        .setCountMouseClicked(getInicialScreenController().getCountMouseClicked() - 1);

            }
            current = current.getProximo();
        }

    }

    public void atualiza() {
        int id = getContatoEdicao().getContato().getPessoa().getId();
        String nome = getPessoaGUI().getNomeField().getText();
        String email = getPessoaGUI().getEmailField().getText();
        String numero = getPessoaGUI().getTelefoneField().getText();
        numero = numero.replaceAll("[^0-9]", "");
        String data = getPessoaGUI().getDataField().getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date parsedDate;
        try {
            parsedDate = dateFormat.parse(data);
        } catch (ParseException e) {
            // Trate qualquer erro de análise aqui
            e.printStackTrace();
            return;
        }
        Pessoa pessoa = new Pessoa(nome, id, numero, email, new java.sql.Date(parsedDate.getTime()));
        PessoaDAO pessoaDAO = new PessoaDAO();

        pessoaDAO.update(pessoa);
        NO<ContatoController> current = getInicialScreenController().getListaContatoController().getInicio();
        while (current != null) {
            if (current.getData() == getContatoEdicao()) {
                current.getData().getContato().setPessoa(pessoa);
                current.getData().updateGUI();
                getInicialScreenController()
                        .setCountMouseClicked(getInicialScreenController().getCountMouseClicked() - 1);
            }
            current = current.getProximo();

        }
        getInicialScreenController().updateInterface();

    }

    public void setNovoContato() {
        getPessoaGUI().getSalvar().setVisible(true);
        getPessoaGUI().getAtualizar().setVisible(false);
        getPessoaGUI().getNomeField().setText("digite seu nome");
        getPessoaGUI().getNomeField().setBackground(Color.white);
        getPessoaGUI().getNomeField().setForeground(Color.darkGray);
        ;

        getPessoaGUI().getEmailField().setText("digite seu email");
        getPessoaGUI().getEmailField().setBackground(Color.white);
        getPessoaGUI().getEmailField().setForeground(Color.darkGray);
        ;

        getPessoaGUI().getTelefoneField().setText("");
        getPessoaGUI().getTelefoneField().setBackground(Color.white);
        getPessoaGUI().getTelefoneField().setForeground(Color.darkGray);

        getPessoaGUI().getDataField().setText("");
        getPessoaGUI().getDataField().setBackground(Color.white);
        getPessoaGUI().getDataField().setForeground(Color.darkGray);
    }

    public void setEditarContato(ContatoController contato) {
        setContatoEdicao(contato);
        getPessoaGUI().getSalvar().setVisible(false);
        getPessoaGUI().getAtualizar().setVisible(true);
        getPessoaGUI().getNomeField().setText(contato.getContato().getPessoa().getNome());
        getPessoaGUI().getNomeField().setBackground(Color.white);
        getPessoaGUI().getNomeField().setForeground(Color.darkGray);
        ;

        getPessoaGUI().getEmailField().setText(contato.getContato().getPessoa().getEmail());
        getPessoaGUI().getEmailField().setBackground(Color.white);
        getPessoaGUI().getEmailField().setForeground(Color.darkGray);
        ;

        getPessoaGUI().getTelefoneField().setText(contato.getContato().getPessoa().getTelefone());
        getPessoaGUI().getTelefoneField().setBackground(Color.white);
        getPessoaGUI().getTelefoneField().setForeground(Color.darkGray);

        getPessoaGUI().getDataField().setText(
                new SimpleDateFormat("dd/MM/yyyy").format(contato.getContato().getPessoa().getDataAniversario()));
        getPessoaGUI().getDataField().setBackground(Color.white);
        getPessoaGUI().getDataField().setForeground(Color.darkGray);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == getPessoaGUI().getNomeField()) {
            if (getPessoaGUI().getNomeField().getText().equals("digite seu nome")) {
                getPessoaGUI().getNomeField().setBackground(Color.white);
                getPessoaGUI().getNomeField().setForeground(Color.darkGray);

                getPessoaGUI().getNomeField().setText("");
            }
        } else if (e.getSource() == getPessoaGUI().getEmailField()) {
            if (getPessoaGUI().getEmailField().getText().equals("digite seu email")) {
                getPessoaGUI().getEmailField().setBackground(Color.white);
                getPessoaGUI().getNomeField().setForeground(Color.darkGray);
                getPessoaGUI().getEmailField().setText("");
            }
        }

    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == getPessoaGUI().getNomeField()) {
            if (getPessoaGUI().getNomeField().getText().equals("")
                    || getPessoaGUI().getNomeField().getText().isEmpty()) {
                getPessoaGUI().getNomeField().setBackground(Color.red);
                getPessoaGUI().getNomeField().setForeground(Color.white);
                getPessoaGUI().getNomeField().setText("digite seu nome");
            }
        } else if (e.getSource() == getPessoaGUI().getEmailField()) {
            if (getPessoaGUI().getEmailField().getText().equals(" ")
                    || getPessoaGUI().getEmailField().getText().isEmpty()) {
                getPessoaGUI().getEmailField().setBackground(Color.red);
                getPessoaGUI().getEmailField().setForeground(Color.darkGray);

                getPessoaGUI().getEmailField().setText("digite seu email");
            }
            String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

            if (!getPessoaGUI().getEmailField().getText().matches(EMAIL_PATTERN)) {
                JOptionPane.showMessageDialog(getPessoaGUI(), "email digitado de forma incorreta!!", "erro!!", 0);
                getPessoaGUI().getEmailField().setText("digite seu email");
                getPessoaGUI().getEmailField().setForeground(Color.white);
                getPessoaGUI().getEmailField().setBackground(Color.red);

            }
        }
    }

    public static int geraId() {
        int count = 0;
        DoublyLinkedLists<Pessoa> pessoaList = new PessoaDAO().findAll();
        NO<Pessoa> atual = pessoaList.getInicio();
        while (atual != null) {

            if (count < atual.getData().getId()) {
                count = atual.getData().getId();
            }
            atual = atual.getProximo();

        }
        return count + 1;
    }

    public ContatoController getContatoEdicao() {
        return contatoEdicao;
    }

    public void setContatoEdicao(ContatoController contatoEdicao) {
        this.contatoEdicao = contatoEdicao;
    }

    public InicialScreenController getInicialScreenController() {
        return inicialScreenController;
    }

    public void setInicialScreenController(InicialScreenController inicialScreenController) {
        this.inicialScreenController = inicialScreenController;
    }

    public PessoaGUI getPessoaGUI() {
        return pessoaGUI;
    }

    public void setPessoaGUI(PessoaGUI pessoaGUI) {
        this.pessoaGUI = pessoaGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
