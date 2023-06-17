package controller;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import View.InicialScreenGUI;
import database.ContatoDao;
import database.createList.ContatoList;
import database.createList.ContatosControllerList;
import database.createList.NoContato;
import database.createList.NoContatosControl;

public class InicialScreenController {

    private ContatosControllerList cList;

    private ContatoList contatoList;

    private InicialScreenGUI inicialScreenGUI;
    private int countMouseCliked = 0;

    public InicialScreenController() {
        this.contatoList = new ContatoDao().Listar();
        this.cList = new ContatosControllerList();
        this.inicialScreenGUI = new InicialScreenGUI();
        PreencheContatos();
        addContatoPanel();
        ConfgPanelContatos();
        getInicialScreenGUI().add(inicialScreenGUI.getScrollPane(), BorderLayout.CENTER);
        getInicialScreenGUI().getFiltro().setContatos(cList);
        getInicialScreenGUI().setVisible(true);
    }


    public void addActionListener(){

    }

    public void PreencheContatos() {
        NoContato atual = contatoList.getInicio();
        while (atual != null) {
            getcList().InsereNoFim(new ContatosController(atual.getContato()));
            atual = atual.getProximo();
        }
    }

    public void addContatoPanel() {
        NoContatosControl atual = cList.getInicio();
        while (atual != null) {
            getInicialScreenGUI().getPanelContatos().add(atual.getContato().getContatoGUI());
            atual = atual.getProximo();
        }
    }



    public void ConfgPanelContatos(){
        NoContatosControl atual = cList.getInicio();
        setMouseCliked(true);
        while (atual != null) {
            atual.getContato().getContatoGUI().addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                   PercorreContato(atual.getContato());
                }
                
            });
            atual = atual.getProximo();
        }

    }

    public void PercorreContato(ContatosController controller) {
        if(controller.getContatoGUI().isSelect()){
            countMouseCliked++;
        }else countMouseCliked--;


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
    public void setMouseCliked(boolean aFlag){
        NoContatosControl atual = cList.getInicio();
        while (atual != null) {
            atual.getContato().getContatoGUI().setMouseClicked(aFlag);
            atual = atual.getProximo();
        }
    }
    

    public ContatosControllerList getcList() {
        return cList;
    }

    public void setcList(ContatosControllerList cList) {
        this.cList = cList;
    }

    public ContatoList getContatoList() {
        return contatoList;
    }

    public void setContatoList(ContatoList contatoList) {
        this.contatoList = contatoList;
    }

    public InicialScreenGUI getInicialScreenGUI() {
        return inicialScreenGUI;
    }

    public void setInicialScreenGUI(InicialScreenGUI inicialScreenGUI) {
        this.inicialScreenGUI = inicialScreenGUI;
    }

    public static void clickPanel(ContatosController controller) {

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
}