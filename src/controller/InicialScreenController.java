package controller;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

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

    public InicialScreenController(){
        this.contatoList = new ContatoDao().Listar();
        this.cList = new ContatosControllerList();
        this.inicialScreenGUI = new InicialScreenGUI();
        contatoList.imprimir();
        PreencherContatos();
        addContatoPanel();
        
        getInicialScreenGUI().setVisible(true);
    }

    public void PreencherContatos() {
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
        }
    }

    public InicialScreenController(ContatosController[] contatosController) {
        this.inicialScreenGUI = new InicialScreenGUI();

        PercorreContato(true);

        getInicialScreenGUI().getCriar().addActionListener(e -> {
            if (getInicialScreenGUI().getCaixaTextoGui().getCaixaTexto().isVisible()) {

                getInicialScreenGUI().getCriar().setVisible(true);
                getInicialScreenGUI().getCaixaTextoGui().getCaixaTexto().setVisible(true);

            } else {
                getInicialScreenGUI().getCaixaTextoGui().setNovoContato();
                getInicialScreenGUI().getCaixaTextoGui().getCaixaTexto().setVisible(true);
                getInicialScreenGUI().getCriar().setVisible(false);
                PercorreContato(false);

            }

        });
        getInicialScreenGUI().getEditar().addActionListener(e -> {
            if (getInicialScreenGUI().getCaixaTextoGui().getCaixaTexto().isVisible()) {

                getInicialScreenGUI().getCriar().setVisible(true);
                getInicialScreenGUI().getCaixaTextoGui().getCaixaTexto().setVisible(true);

            } else {

       //         getInicialScreenGUI().getCaixaTextoGui().setEditarContato(getContatoSelect());
       //         clickPanel(getContatoSelect());
                getInicialScreenGUI().getCaixaTextoGui().getCaixaTexto().setVisible(true);
                getInicialScreenGUI().getCriar().setVisible(false);
                PercorreContato(false);

            }

        });
        getInicialScreenGUI().getCategoriaController().getCategoriaGUI().setVisible(true);

        getInicialScreenGUI().getCaixaTextoGui().getCaixaTexto().getCancelar().addActionListener(e -> {

            inicialScreenGUI.getCaixaTextoGui().getCaixaTexto().setVisible(false);
            getInicialScreenGUI().getCriar().setVisible(true);
            PercorreContato(true);

        });

        inicialScreenGUI.add(inicialScreenGUI.getScrollPane(), BorderLayout.CENTER);
    }

    public void PercorreContato(Boolean mouseClicked) {
       // for (ContatosController contatosController2 : contatosController) {
        //    inicialScreenGUI.getPanelContatos().add(contatosController2.getContatoGUI());
        //    contatosController2.getContatoGUI().setMouseClicked(mouseClicked);
         //   contatosController2.getContatoGUI().addMouseListener(new MouseAdapter() {
          //      @Override
           //     public void mouseClicked(MouseEvent e) {
                    int count = 0;
            //        for (ContatosController contatosController2 : contatosController) {
           //             if (contatosController2.getContatoGUI().isSelect()
            //                    && !inicialScreenGUI.getCaixaTextoGui().getCaixaTexto().isVisible()) {
            //                inicialScreenGUI.getEditar().setVisible(true);
            //                inicialScreenGUI.getApagar().setVisible(true);
            //                count++;
            //            }
           //         }

                    if (!inicialScreenGUI.getCaixaTextoGui().getCaixaTexto().isVisible() && count == 1) {
                        inicialScreenGUI.getAdicionarCategoria().setVisible(true);
                        inicialScreenGUI.getRemoverCategoria().setVisible(true);
                        inicialScreenGUI.getCriar().setVisible(false);
                        inicialScreenGUI.getEditar().setVisible(true);
                        inicialScreenGUI.getApagar().setVisible(true);
                        inicialScreenGUI.getApagarTodos().setVisible(false);
                    } else if (count == 1 && inicialScreenGUI.getCaixaTextoGui().getCaixaTexto().isVisible()) {
                        inicialScreenGUI.getAdicionarCategoria().setVisible(false);
                        inicialScreenGUI.getRemoverCategoria().setVisible(false);
                        inicialScreenGUI.getCriar().setVisible(false);
                        inicialScreenGUI.getEditar().setVisible(false);
                        inicialScreenGUI.getApagar().setVisible(false);
                        inicialScreenGUI.getApagarTodos().setVisible(false);

                    } else if (count == 0 && !inicialScreenGUI.getCaixaTextoGui().getCaixaTexto().isVisible()) {
                        inicialScreenGUI.getEditar().setVisible(false);
                        inicialScreenGUI.getApagar().setVisible(false);
                        inicialScreenGUI.getApagarTodos().setVisible(false);
                        inicialScreenGUI.getAdicionarCategoria().setVisible(false);
                        inicialScreenGUI.getRemoverCategoria().setVisible(false);
                        inicialScreenGUI.getCriar().setVisible(true);

                    } else if (count > 1 && !inicialScreenGUI.getCaixaTextoGui().getCaixaTexto().isVisible()) {
                        inicialScreenGUI.getAdicionarCategoria().setVisible(true);
                        inicialScreenGUI.getRemoverCategoria().setVisible(true);
                        inicialScreenGUI.getEditar().setVisible(false);
                        inicialScreenGUI.getApagar().setVisible(false);
                        inicialScreenGUI.getApagarTodos().setVisible(true);
                        inicialScreenGUI.getCriar().setVisible(false);

                    }
                }
 //           });
     //   }
 //   }

  //  public ContatosController getContatoSelect() {
  //      for (ContatosController contatosController2 : contatosController) {
    //        if (contatosController2.getContatoGUI().isSelect()) {
   //             return contatosController2;
  //          }
  //      }
   //     return null;

    //}

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