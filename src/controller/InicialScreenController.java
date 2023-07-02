package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import View.TelaInicialGUI;
import database.DoublyLinkedLists;
import database.NO;
import database.DAO.ContatoDAO;
import model.Contato;

public class InicialScreenController implements ActionListener, MouseListener {
    private DoublyLinkedLists<ContatoController> listaContatoController;
    private DoublyLinkedLists<Contato> listaContatos;

    private TelaInicialGUI telaInicialGUI;
    private int countMouseClicked;
    private boolean mouseClicked;

    public InicialScreenController() {
        this.listaContatos = new ContatoDAO().findAll();
        this.listaContatoController = new DoublyLinkedLists<>();
        this.telaInicialGUI = new TelaInicialGUI();
        this.countMouseClicked = 0;

        PreencheContatos();

        updateInterface();

        getTelaInicialGUI().add(telaInicialGUI.getScrollPane(), BorderLayout.CENTER);
        getTelaInicialGUI().setVisible(true);
    }

    public void updateInterface() {
        getTelaInicialGUI().getPanelContatos().removeAll();
        addContatoPanel();
        addListener();
        getTelaInicialGUI().getPessoaController().setInicialScreenController(this);
        getTelaInicialGUI().getFiltro().setInicialScreenController(this);
        getTelaInicialGUI().getCategoriaController().setInicialScreenController(this);
    }

    public void addListener() {
        addMouseListenerContatos();
        ListenerButtons();

    }

    public void PreencheContatos() {
        NO<Contato> current = getListaContatos().getInicio();
        while (current != null) {
            getListaContatoController().InsereNoFim(new ContatoController(current.getData()));
            current = current.getProximo();
        }
    }

    public void addContatoPanel() {
        NO<ContatoController>current = getListaContatoController().getInicio();
        while (current != null) {
            getTelaInicialGUI().getPanelContatos().add(current.getData().getContatoGUI());
            current = current.getProximo();
        }
    }

    private void addMouseListenerContatos() {
        NO<ContatoController> current = getListaContatoController().getInicio();
        setMouseClicked(true);
        while (current != null) {
            current.getData().setInicialScreenController(this);
            current.getData().getContatoGUI().addMouseListener(this);
            current = current.getProximo();
        }

    }

    private void mouseListenerContatos() {

        if (!getTelaInicialGUI().getPessoaController().getPessoaGUI().isVisible() && getCountMouseClicked() == 1) {
            getTelaInicialGUI().getCategoriaController().getCategoriaGUI().setVisible(true);
            getTelaInicialGUI().getCategoriaController().getCategoriaGUI().getAdicionarCategoria().setVisible(true);
            getTelaInicialGUI().getCategoriaController().getCategoriaGUI().getRemoverCategoria().setVisible(true);
            getTelaInicialGUI().getCriar().setVisible(false);
            getTelaInicialGUI().getEditar().setVisible(true);
            getTelaInicialGUI().getApagar().setVisible(true);
            getTelaInicialGUI().getApagarTodos().setVisible(false);

        } else if (getCountMouseClicked() == 1
                && getTelaInicialGUI().getPessoaController().getPessoaGUI().isVisible()) {
            getTelaInicialGUI().getCategoriaController().getCategoriaGUI().getAdicionarCategoria().setVisible(true);
            getTelaInicialGUI().getCategoriaController().getCategoriaGUI().getRemoverCategoria().setVisible(true);
            getTelaInicialGUI().getCriar().setVisible(false);
            getTelaInicialGUI().getEditar().setVisible(false);
            getTelaInicialGUI().getApagar().setVisible(false);
            getTelaInicialGUI().getApagarTodos().setVisible(false);

        } else if (getCountMouseClicked() == 0) {
            getTelaInicialGUI().getEditar().setVisible(false);
            getTelaInicialGUI().getApagar().setVisible(false);
            getTelaInicialGUI().getCategoriaController().getCategoriaGUI().setVisible(false);
            getTelaInicialGUI().getApagarTodos().setVisible(false);
            getTelaInicialGUI().getAdicionarCategoria().setVisible(false);
            getTelaInicialGUI().getRemoverCategoria().setVisible(false);
            getTelaInicialGUI().getCriar().setVisible(true);

        } else if (getCountMouseClicked() > 1
                && !getTelaInicialGUI().getPessoaController().getPessoaGUI().isVisible()) {
            getTelaInicialGUI().getAdicionarCategoria().setVisible(true);
            getTelaInicialGUI().getRemoverCategoria().setVisible(true);
            getTelaInicialGUI().getEditar().setVisible(false);
            getTelaInicialGUI().getApagar().setVisible(false);
            getTelaInicialGUI().getApagarTodos().setVisible(true);
            getTelaInicialGUI().getCriar().setVisible(false);

        }
    }

    private void ListenerButtons() {
        getTelaInicialGUI().getCriar().addActionListener(e -> {
            getTelaInicialGUI().getCriar().setVisible(false);
            getTelaInicialGUI().getEditar().setVisible(false);
            getTelaInicialGUI().getApagar().setVisible(false);
            getTelaInicialGUI().getApagarTodos().setVisible(false);
            getTelaInicialGUI().getCategoriaController().getCategoriaGUI().setVisible(false);
            getTelaInicialGUI().getPessoaController().setNovoContato();
            getTelaInicialGUI().getPessoaController().getPessoaGUI().setVisible(true);
            setMouseClicked(false);
        });
        getTelaInicialGUI().getEditar().addActionListener(e -> {
            getTelaInicialGUI().getCriar().setVisible(false);
            getTelaInicialGUI().getEditar().setVisible(false);
            getTelaInicialGUI().getApagar().setVisible(false);
            getTelaInicialGUI().getApagarTodos().setVisible(false);
            getTelaInicialGUI().getCategoriaController().getCategoriaGUI().setVisible(false);
            getTelaInicialGUI().getPessoaController().setEditarContato(getContatoSelect());
            getTelaInicialGUI().getPessoaController().getPessoaGUI().setVisible(true);
            setMouseClicked(false);
        });
        getTelaInicialGUI().getApagar().addActionListener(e -> {
            getTelaInicialGUI().getPessoaController().apaga();
            getTelaInicialGUI().getEditar().setVisible(false);
            getTelaInicialGUI().getApagar().setVisible(false);
            getTelaInicialGUI().getCategoriaController().getCategoriaGUI().setVisible(false);
            getTelaInicialGUI().getApagarTodos().setVisible(false);
            getTelaInicialGUI().getAdicionarCategoria().setVisible(false);
            getTelaInicialGUI().getRemoverCategoria().setVisible(false);
            getTelaInicialGUI().getCriar().setVisible(true);

            updateInterface();
        });
        getTelaInicialGUI().getApagarTodos().addActionListener(e -> {
            getTelaInicialGUI().getPessoaController().apaga();
            getTelaInicialGUI().getEditar().setVisible(false);
            getTelaInicialGUI().getApagar().setVisible(false);
            getTelaInicialGUI().getCategoriaController().getCategoriaGUI().setVisible(false);
            getTelaInicialGUI().getApagarTodos().setVisible(false);
            getTelaInicialGUI().getAdicionarCategoria().setVisible(false);
            getTelaInicialGUI().getRemoverCategoria().setVisible(false);
            getTelaInicialGUI().getCriar().setVisible(true);

            updateInterface();
        });

        getTelaInicialGUI().getPessoaController().getPessoaGUI().getCancelar().addActionListener(e -> {
            if (getCountMouseClicked() >= 1) {
                getTelaInicialGUI().getCriar().setVisible(false);
                getTelaInicialGUI().getEditar().setVisible(true);
                getTelaInicialGUI().getApagar().setVisible(true);
                getTelaInicialGUI().getCategoriaController().getCategoriaGUI().setVisible(true);
                System.out.println("a");
            } else {
                getTelaInicialGUI().getCriar().setVisible(true);
                getTelaInicialGUI().getEditar().setVisible(false);
                getTelaInicialGUI().getApagar().setVisible(false);
                getTelaInicialGUI().getCategoriaController().getCategoriaGUI().setVisible(false);
            }
            getTelaInicialGUI().getApagarTodos().setVisible(false);
            getTelaInicialGUI().getPessoaController().getPessoaGUI().setVisible(false);
            setMouseClicked(true);

        });
    }

    public void setMouseClicked(boolean aFlag) {
        this.mouseClicked = aFlag;
        NO<ContatoController> current = getListaContatoController().getInicio();
        while (current != null) {
            current.getData().setMouseClicked(aFlag);
            current = current.getProximo();
        }
    }

    public ContatoController getContatoSelect() {
        NO<ContatoController> current = getListaContatoController().getInicio();
        while (current != null) {
            if (current.getData().isSelect()) {
                return current.getData();
            }
            current = current.getProximo();
        }
        return null;
    }

    public String[] getContatosSelects() {
        NO<ContatoController> current = getListaContatoController().getInicio();
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.getData().getContato().getId()).append(" - ");
            current = current.getProximo();
        }
        return String.valueOf(sb).split(" - ");
    }



    public DoublyLinkedLists<ContatoController> getListaContatoController() {
        return listaContatoController;
    }

    public void setListaContatoController(DoublyLinkedLists<ContatoController> listaContatoController) {
        this.listaContatoController = listaContatoController;
    }

    public DoublyLinkedLists<Contato> getListaContatos() {
        return listaContatos;
    }

    public void setListaContatos(DoublyLinkedLists<Contato> listaContatos) {
        this.listaContatos = listaContatos;
    }

    public TelaInicialGUI getTelaInicialGUI() {
        return telaInicialGUI;
    }

    public void setTelaInicialGUI(TelaInicialGUI telaInicialGUI) {
        this.telaInicialGUI = telaInicialGUI;
    }

    public int getCountMouseClicked() {
        return countMouseClicked;
    }

    public void setCountMouseClicked(int countMouseClicked) {
        System.out.println(countMouseClicked);
        this.countMouseClicked = countMouseClicked;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (isMouseClicked()) {
            mouseListenerContatos();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public boolean isMouseClicked() {
        return mouseClicked;
    }

}