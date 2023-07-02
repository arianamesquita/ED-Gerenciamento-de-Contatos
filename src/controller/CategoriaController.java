package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;

import View.CategoriaGUI;
import database.DoublyLinkedLists;
import database.NO;
import database.DAO.CategoriaDAO;
import database.DAO.ContatoDAO;
import model.Categoria;

public class CategoriaController implements ActionListener, FocusListener {
    private CategoriaGUI categoriaGUI;

    private InicialScreenController inicialScreenController;

    public CategoriaController() {

        this.categoriaGUI = new CategoriaGUI();
        addConfg();
    }

    public void addConfg() {
        getCategoriaGUI().getPanel().setVisible(true);
        getCategoriaGUI().getCategoriaText().setVisible(false);
        getCategoriaGUI().getCategoriasButton().setVisible(false);
        getCategoriaGUI().getAdicionarCategoria().setVisible(true);
        getCategoriaGUI().getControleButtons().setVisible(false);
        getCategoriaGUI().getRemoverCategoria().setVisible(true);
        getCategoriaGUI().getCategoriaExistente().setVisible(false);
        getCategoriaGUI().getNovaCategoria().setVisible(false);
        getCategoriaGUI().getCategoriaField().setVisible(false);
        getCategoriaGUI().getSalvar().setVisible(false);
        getCategoriaGUI().getCancelar().setVisible(false);
        getCategoriaGUI().getCategoriaField().setText("digite uma categoria");
        getCategoriaGUI().setVisible(true);

        addActionListener();
    }

    private void addActionListener() {
        getCategoriaGUI().getAdicionarCategoria().addActionListener(this);
        getCategoriaGUI().getRemoverCategoria().addActionListener(this);
        getCategoriaGUI().getCategoriaExistente().addActionListener(this);
        getCategoriaGUI().getNovaCategoria().addActionListener(this);
        getCategoriaGUI().getCategoriaField().addActionListener(this);
        getCategoriaGUI().getSalvar().addActionListener(this);
        getCategoriaGUI().getCancelar().addActionListener(this);
        getCategoriaGUI().getCategoriaField().addFocusListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getCategoriaGUI().getAdicionarCategoria()) {
            getInicialScreenController().setMouseClicked(false);
            getCategoriaGUI().getCategoriasButton().setVisible(true);
            getCategoriaGUI().getControleButtons().setVisible(true);
            getCategoriaGUI().getPanel().setVisible(false);
            getCategoriaGUI().getAdicionarCategoria().setVisible(false);
            getCategoriaGUI().getRemoverCategoria().setVisible(false);
            getCategoriaGUI().getCategoriaExistente().setVisible(true);
            getCategoriaGUI().getNovaCategoria().setVisible(false);
            getCategoriaGUI().getCategoriaField().setVisible(false);
            getCategoriaGUI().getSalvar().setVisible(true);
            getCategoriaGUI().getCancelar().setVisible(true);
            getCategoriaGUI().getCategoriaText().setVisible(false);
            getInicialScreenController().getTelaInicialGUI().getEditar().setVisible(false);
            getInicialScreenController().getTelaInicialGUI().getApagar().setVisible(false);
            getInicialScreenController().getTelaInicialGUI().getApagarTodos().setVisible(false);

        } else if (e.getSource() == getCategoriaGUI().getRemoverCategoria()) {
            getCategoriaGUI().getAdicionarCategoria().setVisible(false);
            getCategoriaGUI().getRemoverCategoria().setVisible(false);
            int resposta = JOptionPane.showConfirmDialog(getCategoriaGUI(), "Deseja continuar?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                remove();
                getCategoriaGUI().getCancelar().doClick();
                getInicialScreenController().getTelaInicialGUI().getEditar().setVisible(false);
                getInicialScreenController().getTelaInicialGUI().getApagar().setVisible(false);
                getInicialScreenController().getTelaInicialGUI().getApagarTodos().setVisible(false);
                getCategoriaGUI().getAdicionarCategoria().setVisible(false);
                getCategoriaGUI().getRemoverCategoria().setVisible(false);
                getInicialScreenController().getTelaInicialGUI().getCriar().setVisible(true);

            } else if (resposta == JOptionPane.NO_OPTION) {
                getCategoriaGUI().getCancelar().doClick();
            } else if (resposta == JOptionPane.CLOSED_OPTION) {
                getCategoriaGUI().getCancelar().doClick();
            }

        } else if (e.getSource() == getCategoriaGUI().getNovaCategoria()) {
            getCategoriaGUI().getCategoriasButton().setVisible(true);
            getCategoriaGUI().getControleButtons().setVisible(true);
            getCategoriaGUI().getRemoverCategoria().setVisible(false);
            getCategoriaGUI().getCategoriaExistente().setVisible(false);
            getCategoriaGUI().getNovaCategoria().setVisible(false);
            getCategoriaGUI().getCategoriaField().setVisible(true);
            getCategoriaGUI().getSalvar().setVisible(true);
            getCategoriaGUI().getCancelar().setVisible(true);
            getCategoriaGUI().getCategoriaText().setVisible(true);

        } else // Adicionar método DAO para salvar a categoria
        if (e.getSource() == getCategoriaGUI().getCancelar()) {
            getCategoriaGUI().getCategoriasButton().setVisible(false);
            getCategoriaGUI().getControleButtons().setVisible(false);
            getCategoriaGUI().getPanel().setVisible(true);
            getCategoriaGUI().getAdicionarCategoria().setVisible(true);
            getCategoriaGUI().getRemoverCategoria().setVisible(true);
            getCategoriaGUI().getCategoriaExistente().setVisible(false);
            getCategoriaGUI().getNovaCategoria().setVisible(false);
            getCategoriaGUI().getCategoriaField().setVisible(false);
            getCategoriaGUI().getSalvar().setVisible(false);
            getCategoriaGUI().getCancelar().setVisible(false);
            getCategoriaGUI().getCategoriaText().setVisible(false);
            getInicialScreenController().getTelaInicialGUI().getEditar().setVisible(true);

            if(getInicialScreenController().getCountMouseClicked()>1){
            getInicialScreenController().getTelaInicialGUI().getApagarTodos().setVisible(true);
            getInicialScreenController().getTelaInicialGUI().getEditar().setVisible(false);

            }else {getInicialScreenController().getTelaInicialGUI().getApagar().setVisible(true);}
            

            getInicialScreenController().setMouseClicked(true);
        } else if (e.getSource() == getCategoriaGUI().getSalvar()) {
            addNovaCategoria();
            getCategoriaGUI().getCancelar().doClick();
            getInicialScreenController().getTelaInicialGUI().getEditar().setVisible(false);
            getInicialScreenController().getTelaInicialGUI().getApagar().setVisible(false);
            getInicialScreenController().getTelaInicialGUI().getApagarTodos().setVisible(false);
            getInicialScreenController().getTelaInicialGUI().getCriar().setVisible(true);
            getCategoriaGUI().getAdicionarCategoria().setVisible(false);
            getCategoriaGUI().getRemoverCategoria().setVisible(false);

        }
        getInicialScreenController().updateInterface();

    }

    @Override
    public void focusGained(FocusEvent e) {
        if (getCategoriaGUI().getCategoriaField().getText().equals("digite uma categoria")) {
            getCategoriaGUI().getCategoriaField().setBackground(Color.white);
            getCategoriaGUI().getCategoriaField().setForeground(Color.darkGray);

            getCategoriaGUI().getCategoriaField().setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (getCategoriaGUI().getCategoriaField().getText().equals("")
                || getCategoriaGUI().getCategoriaField().getText().isEmpty()) {
            getCategoriaGUI().getCategoriaField().setBackground(Color.red);
            getCategoriaGUI().getCategoriaField().setForeground(Color.white);
            getCategoriaGUI().getCategoriaField().setText("digite uma categoria");
        }
    }

    private void addNovaCategoria() {
        NO<ContatoController> current = getInicialScreenController().getListaContatoController().getInicio();
        while (current != null) {
            if (current.getData().isSelect()) {
                Categoria categoria = new CategoriaDAO().findById(getCategoriaGUI().getCategoriaExistente().getSelectedIndex());
                current.getData().getContato().setCategoria(categoria);
                current.getData().updateGUI();
                new ContatoDAO().update(current.getData().getContato());

                getInicialScreenController()
                        .setCountMouseClicked(getInicialScreenController().getCountMouseClicked() - 1);

            }
            current = current.getProximo();
        }

    }

    public void remove() {
        NO<ContatoController> current = getInicialScreenController().getListaContatoController().getInicio();
        while (current != null) {
            if (current.getData().isSelect()) {
                Categoria categoria = new CategoriaDAO().findById(0);
                        
                current.getData().getContato().setCategoria(categoria);
                current.getData().updateGUI();
                new ContatoDAO().update(current.getData().getContato());

                getInicialScreenController()
                        .setCountMouseClicked(getInicialScreenController().getCountMouseClicked() - 1);

            }
            current = current.getProximo();

        }

    }

    public void updateCategoria() {
        setCategoriaGUI(new CategoriaGUI());
        addConfg();
    }

    public static String[] buscarCategorias() {
        DoublyLinkedLists<Categoria> categoriaList = new CategoriaDAO().findAll();
        NO<Categoria> current = categoriaList.getInicio();
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.getData().getNome()).append(" - ");
            current = current.getProximo();
        }
        return String.valueOf(sb).split(" - ");
    }

    public CategoriaGUI getCategoriaGUI() {
        return categoriaGUI;
    }

    public void setCategoriaGUI(CategoriaGUI categoriaGUI) {
        this.categoriaGUI = categoriaGUI;
    }

    public InicialScreenController getInicialScreenController() {
        return inicialScreenController;
    }

    public void setInicialScreenController(InicialScreenController inicialScreenController) {
        this.inicialScreenController = inicialScreenController;
    }
}
