package controller;


import View.InicialScreenGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InicialScreenController {
    private ContatosController[] contatosController;
    private InicialScreenGUI inicialScreenGUI;

    public InicialScreenController(ContatosController[] contatosController) {
        this.contatosController = contatosController;
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

                getInicialScreenGUI().getCaixaTextoGui().setEditarContato(getContatoSelect());
                clickPanel(getContatoSelect());
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
        for (ContatosController contatosController2 : contatosController) {
            inicialScreenGUI.getPanelContatos().add(contatosController2.getContatoGUI());
            contatosController2.getContatoGUI().setMouseClicked(mouseClicked);
            contatosController2.getContatoGUI().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int count = 0;
                    for (ContatosController contatosController2 : contatosController) {
                        if (contatosController2.getContatoGUI().isSelect()
                                && !inicialScreenGUI.getCaixaTextoGui().getCaixaTexto().isVisible()) {
                            inicialScreenGUI.getEditar().setVisible(true);
                            inicialScreenGUI.getApagar().setVisible(true);
                            count++;
                        }
                    }

                    if (!inicialScreenGUI.getCaixaTextoGui().getCaixaTexto().isVisible() &&count == 1 ) {
                        inicialScreenGUI.getAdicionarCategoria().setVisible(true);
                        inicialScreenGUI.getRemoverCategoria().setVisible(true);
                        inicialScreenGUI.getCriar().setVisible(false);
                        inicialScreenGUI.getEditar().setVisible(true);
                        inicialScreenGUI.getApagar().setVisible(true);
                        inicialScreenGUI.getApagarTodos().setVisible(false);
                    } else
                    if(count == 1 && inicialScreenGUI.getCaixaTextoGui().getCaixaTexto().isVisible()){
                        inicialScreenGUI.getAdicionarCategoria().setVisible(false);
                        inicialScreenGUI.getRemoverCategoria().setVisible(false);
                        inicialScreenGUI.getCriar().setVisible(false);
                        inicialScreenGUI.getEditar().setVisible(false);
                        inicialScreenGUI.getApagar().setVisible(false);
                        inicialScreenGUI.getApagarTodos().setVisible(false);

                    }else if (count == 0 && !inicialScreenGUI.getCaixaTextoGui().getCaixaTexto().isVisible()) {
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
            });
        }
    }
    public ContatosController getContatoSelect(){
        for (ContatosController contatosController2 : contatosController) {
            if(contatosController2.getContatoGUI().isSelect()){
                return contatosController2;
            }
        }
        return null;
    

    }

    public ContatosController[] getContatosController() {
        return contatosController;
    }

    public void setContatosController(ContatosController[] contatosController) {
        this.contatosController = contatosController;
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
            int x = locationOnScreen.x + controller.getContatoGUI().getWidth()/2;

            int y = locationOnScreen.y +controller.getContatoGUI().getHeight()/2;
            System.out.println(x+"   "+y);
            robot.mouseMove(x, y);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseMove(x, y);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseMove(x, y);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            System.out.println(controller.getPessoa().getNome());
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }}