package controller;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.*;

import View.TelaInicialGUI;
import database.ContatoDao;
import database.createList.DoublyLinkedLists.ContatoList;
import database.createList.DoublyLinkedLists.ContControlList;
import database.createList.NOs.ContatoNO;
import database.createList.NOs.ContControlNO;

public class InicialScreenController implements ActionListener,MouseListener {

    private ContControlList cList;

    private ContatoList contatoList;

    private TelaInicialGUI inicialScreenGUI;

    private ContatoController controller;
    private int countMouseCliked = 0;

    public InicialScreenController() {
        this.contatoList = new ContatoDao().Listar();
        this.cList = new ContControlList();
        this.inicialScreenGUI = new TelaInicialGUI();
        updateInterface();

        getInicialScreenGUI().add(inicialScreenGUI.getScrollPane(), BorderLayout.CENTER);
        getInicialScreenGUI().setVisible(true);
    }

    public void updateInterface(){
        PreencheContatos();
        addContatoPanel();
        addActionListener();
        getInicialScreenGUI().getFiltro().setInicialScreenController(this);
    }


    public void addActionListener(){
        ConfgPanelContatos();
        ListenerButtons();

    }

    public void PreencheContatos() {
        ContatoNO atual = contatoList.getInicio();
        while (atual != null) {
            getcList().InsereNoFim(new ContatoController(atual.getContato()));
            atual = atual.getProximo();
        }
    }

    public void addContatoPanel() {
        ContControlNO atual = cList.getInicio();
        while (atual != null) {
            getInicialScreenGUI().getPanelContatos().add(atual.getContato().getContatoGUI());
            atual = atual.getProximo();
        }
    }



    public void ConfgPanelContatos(){
        ContControlNO atual = cList.getInicio();
        setMouseCliked(true);
        while (atual != null) {
            setController(atual.getContato());
            atual.getContato().setInicialScreenController(this);
            atual.getContato().getContatoGUI().addMouseListener(this);
            atual = atual.getProximo();
        }

    }

    public void PercorreContato() {
        System.out.println("a");
        System.out.println(countMouseCliked);

        if (!inicialScreenGUI.getCaixaTextoGui().getCaixaTexto().isVisible() && countMouseCliked == 1) {
            inicialScreenGUI.getAdicionarCategoria().setVisible(true);
            inicialScreenGUI.getRemoverCategoria().setVisible(true);
            inicialScreenGUI.getCriar().setVisible(false);
            inicialScreenGUI.getEditar().setVisible(true);
            inicialScreenGUI.getApagar().setVisible(true);
            inicialScreenGUI.getApagarTodos().setVisible(false);
        } else if (countMouseCliked == 1 && inicialScreenGUI.getCaixaTextoGui().getCaixaTexto().isVisible()) {
            inicialScreenGUI.getAdicionarCategoria().setVisible(false);
            inicialScreenGUI.getRemoverCategoria().setVisible(false);
            inicialScreenGUI.getCriar().setVisible(false);
            inicialScreenGUI.getEditar().setVisible(false);
            inicialScreenGUI.getApagar().setVisible(false);
            inicialScreenGUI.getApagarTodos().setVisible(false);

        } else if (countMouseCliked == 0 && !inicialScreenGUI.getCaixaTextoGui().getCaixaTexto().isVisible()) {
            inicialScreenGUI.getEditar().setVisible(false);
            inicialScreenGUI.getApagar().setVisible(false);
            inicialScreenGUI.getApagarTodos().setVisible(false);
            inicialScreenGUI.getAdicionarCategoria().setVisible(false);
            inicialScreenGUI.getRemoverCategoria().setVisible(false);
            inicialScreenGUI.getCriar().setVisible(true);

        } else if (countMouseCliked > 1 && !inicialScreenGUI.getCaixaTextoGui().getCaixaTexto().isVisible()) {
            inicialScreenGUI.getAdicionarCategoria().setVisible(true);
            inicialScreenGUI.getRemoverCategoria().setVisible(true);
            inicialScreenGUI.getEditar().setVisible(false);
            inicialScreenGUI.getApagar().setVisible(false);
            inicialScreenGUI.getApagarTodos().setVisible(true);
            inicialScreenGUI.getCriar().setVisible(false);

        }
    }
    public void ListenerButtons(){
        getInicialScreenGUI().getCriar().addActionListener(e -> {
            getInicialScreenGUI().getCriar().setVisible(false);
            getInicialScreenGUI().getEditar().setVisible(false);
            getInicialScreenGUI().getApagar().setVisible(false);
            getInicialScreenGUI().getApagarTodos().setVisible(false);
            getInicialScreenGUI().getCategoriaController().getCategoriaGUI().setVisible(false);
            getInicialScreenGUI().getCaixaTextoGui().setNovoContato();
            getInicialScreenGUI().getCaixaTextoGui().getCaixaTexto().setVisible(true);
            setMouseCliked(false);
        });
        getInicialScreenGUI().getEditar().addActionListener(e -> {
            getInicialScreenGUI().getCriar().setVisible(false);
            getInicialScreenGUI().getEditar().setVisible(false);
            getInicialScreenGUI().getApagar().setVisible(false);
            getInicialScreenGUI().getApagarTodos().setVisible(false);
            getInicialScreenGUI().getCategoriaController().getCategoriaGUI().setVisible(false);
            getInicialScreenGUI().getCaixaTextoGui().setEditarContato(getContatoSelect());
            getInicialScreenGUI().getCaixaTextoGui().getCaixaTexto().setVisible(true);
            setMouseCliked(false);
        });
        getInicialScreenGUI().getApagar().addActionListener(e -> {});
        getInicialScreenGUI().getApagarTodos().addActionListener(e -> {});
        getInicialScreenGUI().getCaixaTextoGui().getCaixaTexto().getCancelar().addActionListener(e -> {
            if (countMouseCliked >=1){
            getInicialScreenGUI().getCriar().setVisible(false);
            getInicialScreenGUI().getEditar().setVisible(true);
            getInicialScreenGUI().getApagar().setVisible(true);

            }
            else {
                getInicialScreenGUI().getCriar().setVisible(true);
                getInicialScreenGUI().getEditar().setVisible(false);
                getInicialScreenGUI().getApagar().setVisible(false);
            }
            getInicialScreenGUI().getApagarTodos().setVisible(false);
            getInicialScreenGUI().getCategoriaController().getCategoriaGUI().setVisible(false);
            getInicialScreenGUI().getCaixaTextoGui().getCaixaTexto().setVisible(false);
            setMouseCliked(true);

        });
    }
    public void setMouseCliked(boolean aFlag){
        ContControlNO atual = cList.getInicio();
        while (atual != null) {
            atual.getContato().getContatoGUI().setMouseClicked(aFlag);
            atual = atual.getProximo();
        }
    }
    public ContatoController getContatoSelect(){
        ContControlNO atual = cList.getInicio();
        while (atual != null) {
            if(atual.getContato().getContatoGUI().isSelect()){
                return atual.getContato();
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public ContatoController getController() {
        return controller;
    }

    public void setController(ContatoController controller) {
        this.controller = controller;
    }

    public ContControlList getcList() {
        return cList;
    }

    public void setcList(ContControlList cList) {
        this.cList = cList;
    }

    public ContatoList getContatoList() {
        return contatoList;
    }

    public void setContatoList(ContatoList contatoList) {
        this.contatoList = contatoList;
    }

    public TelaInicialGUI getInicialScreenGUI() {
        return inicialScreenGUI;
    }

    public void setInicialScreenGUI(TelaInicialGUI inicialScreenGUI) {
        this.inicialScreenGUI = inicialScreenGUI;
    }

    public static void clickPanel(ContatoController controller) {

        try {
            Robot robot = new Robot();
            Point locationOnScreen = controller.getContatoGUI().getLocationOnScreen();
            int x = locationOnScreen.x + controller.getContatoGUI().getWidth() / 2;

            int y = locationOnScreen.y + controller.getContatoGUI().getHeight() / 2;
            System.out.println(x + "   " + y);
            robot.mouseMove(x, y);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseMove(x, y);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseMove(x, y);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            System.out.println(controller.getContato().getPessoa().getNome());
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        PercorreContato();

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

    public int getCountMouseCliked() {
        return countMouseCliked;
    }

    public void setCountMouseCliked(int countMouseCliked) {
        this.countMouseCliked = countMouseCliked;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}