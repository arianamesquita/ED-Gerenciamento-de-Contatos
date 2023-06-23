package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;

import View.CategoriaGUI;
import database.CategoriaDAO;
import database.ContatoDao;
import database.createList.DoublyLinkedLists.CategoriaList;
import database.createList.NOs.CategoriaNO;
import database.createList.NOs.ContControlNO;
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
            getInicialScreenController().getTelaInicialGUI().getApagar().setVisible(true);
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
        ContControlNO current = getInicialScreenController().getListaContatoController().getInicio();
        while (current != null) {
            if (current.getContato().isSelect()) {
                Categoria categoria = new CategoriaDAO()
                        .searchByName((String) getCategoriaGUI().getCategoriaExistente().getSelectedItem());
                current.getContato().getContato().setCategoria(categoria);
                current.getContato().updateGUI();
                new ContatoDao().update(current.getContato().getContato(), categoria);

                getInicialScreenController()
                        .setCountMouseClicked(getInicialScreenController().getCountMouseClicked() - 1);

            }
            current = current.getProximo();
        }

    }

    public void remove() {
        ContControlNO current = getInicialScreenController().getListaContatoController().getInicio();
        while (current != null) {
            if (current.getContato().isSelect()) {
                Categoria categoria = new CategoriaDAO()
                        .searchById(1);
                current.getContato().getContato().setCategoria(categoria);
                current.getContato().updateGUI();
                new ContatoDao().update(current.getContato().getContato(), categoria);

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
        CategoriaList categoriaList = new CategoriaDAO().Listar();
        CategoriaNO current = categoriaList.getInicio();
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.getCategoria().getNome()).append(" - ");
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
