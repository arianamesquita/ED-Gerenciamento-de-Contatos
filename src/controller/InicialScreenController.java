package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import View.telinha;

public class InicialScreenController {
    private ContatosController[] contatosController;
    private telinha inicialScreenGUI;
    public InicialScreenController(ContatosController[] contatosController) {
        this.contatosController = contatosController;
        this.inicialScreenGUI = new telinha();
        for (ContatosController contatosController2 : contatosController) {
            inicialScreenGUI.getPanelcontatos().add(contatosController2.getContatoGUI());
            contatosController2.getContatoGUI().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int count = 0;
                for (ContatosController contatosController2 : contatosController) {
                    if(contatosController2.getContatoGUI().isSelect()){
                        inicialScreenGUI.getEditar().setVisible(true);
                        inicialScreenGUI.getApagar().setVisible(true);
                        count++;
                    } 
                }
                if(count==1){
                    inicialScreenGUI.getAdicionarCategoria().setVisible(true);
                    inicialScreenGUI.getRemoverCategoria().setVisible(true);
                    inicialScreenGUI.getCriar().setVisible(false);
                    inicialScreenGUI.getEditar().setVisible(true);
                    inicialScreenGUI.getApagar().setVisible(true);
                    inicialScreenGUI.getApagarTodos().setVisible(false);
                }else if(count==0){
                    inicialScreenGUI.getEditar().setVisible(false);
                    inicialScreenGUI.getApagar().setVisible(false);
                    inicialScreenGUI.getApagarTodos().setVisible(false);
                    inicialScreenGUI.getAdicionarCategoria().setVisible(false);
                    inicialScreenGUI.getRemoverCategoria().setVisible(false);
                    inicialScreenGUI.getCriar().setVisible(true);

                }else  if(count>1){
                    inicialScreenGUI.getAdicionarCategoria().setVisible(true);
                    inicialScreenGUI.getRemoverCategoria().setVisible(true);
                    inicialScreenGUI.getEditar().setVisible(false);
                    inicialScreenGUI.getApagar().setVisible(false);
                    inicialScreenGUI.getApagarTodos().setVisible(true);
                    inicialScreenGUI.getCriar().setVisible(false);

                }
            }});
        }

        getInicialScreenGUI().getCriar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (getInicialScreenGUI().getCaixadetextoGui().isVisible()){                   
                     getInicialScreenGUI().getCriar().setVisible(true);
                    getInicialScreenGUI().getCaixadetextoGui().setVisible(true);

                }else {getInicialScreenGUI().getCaixadetextoGui().setVisible(true);
                    getInicialScreenGUI().getCriar().setVisible(false);

                }

            }
            
        });
            
        getInicialScreenGUI().getCaixadetextoGui().getJb()[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            inicialScreenGUI.getCaixadetextoGui().setVisible(false);
            getInicialScreenGUI().getCriar().setVisible(true);

            }
            
        });
        inicialScreenGUI.add(inicialScreenGUI.getScrollPane(),BorderLayout.CENTER);
    }
    public ContatosController[] getContatosController() {
        return contatosController;
    }
    public void setContatosController(ContatosController[] contatosController) {
        this.contatosController = contatosController;
    }
    public telinha getInicialScreenGUI() {
        return inicialScreenGUI;
    }
    public void setInicialScreenGUI(telinha inicialScreen) {
        this.inicialScreenGUI = inicialScreen;
    }

    
    
}