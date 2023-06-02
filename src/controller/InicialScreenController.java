package controller;

import View.InicialScreen;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InicialScreenController {
    private ContatosController[] contatosController;
    private InicialScreen inicialScreenGUI;

    public InicialScreenController(ContatosController[] contatosController) {
        this.contatosController = contatosController;
        this.inicialScreenGUI = new InicialScreen();
        
        PercorreContato(true);

        getInicialScreenGUI().getCriar().addActionListener(e -> {
            if (getInicialScreenGUI().getCaixadetextoGui().isVisible()) {

                getInicialScreenGUI().getCriar().setVisible(true);
                getInicialScreenGUI().getCaixadetextoGui().setVisible(true);

            } else {

                getInicialScreenGUI().getCaixadetextoGui().setVisible(true);
                getInicialScreenGUI().getCriar().setVisible(false);
                PercorreContato(false);

            }

        });

        getInicialScreenGUI().getCaixadetextoGui().getJb()[0].addActionListener(e -> {

            inicialScreenGUI.getCaixadetextoGui().setVisible(false);
            getInicialScreenGUI().getCriar().setVisible(true);
            PercorreContato(true);

        });
        inicialScreenGUI.add(inicialScreenGUI.getScrollPane(), BorderLayout.CENTER);
    }

    public void PercorreContato(Boolean mouseClicked) {
        for (ContatosController contatosController2 : contatosController) {
            inicialScreenGUI.getPanelcontatos().add(contatosController2.getContatoGUI());
            contatosController2.getContatoGUI().setMouseClicked(mouseClicked);
            contatosController2.getContatoGUI().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int count = 0;
                    for (ContatosController contatosController2 : contatosController) {
                        if (contatosController2.getContatoGUI().isSelect()
                                && !inicialScreenGUI.getCaixadetextoGui().isVisible()) {
                            inicialScreenGUI.getEditar().setVisible(true);
                            inicialScreenGUI.getApagar().setVisible(true);
                            count++;
                        }
                    }
                    if (count == 1 && !inicialScreenGUI.getCaixadetextoGui().isVisible()) {
                        inicialScreenGUI.getAdicionarCategoria().setVisible(true);
                        inicialScreenGUI.getRemoverCategoria().setVisible(true);
                        inicialScreenGUI.getCriar().setVisible(false);
                        inicialScreenGUI.getEditar().setVisible(true);
                        inicialScreenGUI.getApagar().setVisible(true);
                        inicialScreenGUI.getApagarTodos().setVisible(false);
                    } else if (count == 0 && !inicialScreenGUI.getCaixadetextoGui().isVisible()) {
                        inicialScreenGUI.getEditar().setVisible(false);
                        inicialScreenGUI.getApagar().setVisible(false);
                        inicialScreenGUI.getApagarTodos().setVisible(false);
                        inicialScreenGUI.getAdicionarCategoria().setVisible(false);
                        inicialScreenGUI.getRemoverCategoria().setVisible(false);
                        inicialScreenGUI.getCriar().setVisible(true);

                    } else if (count > 1 && !inicialScreenGUI.getCaixadetextoGui().isVisible()) {
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

    public ContatosController[] getContatosController() {
        return contatosController;
    }

    public void setContatosController(ContatosController[] contatosController) {
        this.contatosController = contatosController;
    }

    public InicialScreen getInicialScreenGUI() {
        return inicialScreenGUI;
    }

    public void setInicialScreenGUI(InicialScreen inicialScreen) {
        this.inicialScreenGUI = inicialScreen;
    }

}