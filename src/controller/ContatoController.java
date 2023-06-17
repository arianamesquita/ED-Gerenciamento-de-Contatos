package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import View.ContatosGUI;
import model.Contato;

public class ContatoController {
    private Contato contato;

    private InicialScreenController inicialScreenController;

    private ContatosGUI contatoGUI;

    public ContatoController(Contato contato) {

        this.contato = contato;
        this.contatoGUI = new ContatosGUI(getContato());
        addMouseListener();
    }
    public  void updateGUI(){
        setContatoGUI(new ContatosGUI(getContato()));
        addMouseListener();
    }
    public void setVisibleGUI(boolean aFlag){
        getContatoGUI().setVisible(aFlag);

    }
    public void repaint(){
        getContatoGUI().repaint();
    }

    private void addMouseListener() {
        contatoGUI.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(contatoGUI.isMouseClicked()){
                if (contatoGUI.isSelect()) {
                   getInicialScreenController().setCountMouseCliked(getInicialScreenController().getCountMouseCliked()-1);
                    contatoGUI.getPaintMenu().setBackground(Color.darkGray);
                    contatoGUI.setSelect(false);
                } else {
                    contatoGUI.getPaintMenu().setBackground(new Color(8, 77, 110));
                    contatoGUI.setSelect(true);
                    getInicialScreenController().setCountMouseCliked(getInicialScreenController().getCountMouseCliked()+1);

                }

            }}

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                contatoGUI.getPaintMenu().setBackground(Color.black);
                contatoGUI.getNumeroTelefone().setVisible(true);
                contatoGUI.getPaintCategoria().setVisible(true);
                contatoGUI.getEmail().setVisible(true);
                contatoGUI.getData().setVisible(true);

                SelecionaCor(true);
                contatoGUI.getPaintMenu().repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                contatoGUI.getEmail().setVisible(false);
                contatoGUI.getNumeroTelefone().setVisible(false);
                contatoGUI.getPaintCategoria().setVisible(false);
                contatoGUI.getData().setVisible(false);
                contatoGUI.getPaintMenu().setBackground(Color.darkGray);
                SelecionaCor(false);
                contatoGUI.getPaintMenu().repaint();
            }

        });
    }

    public void SelecionaCor(boolean mouseEntered) {
        if (!contatoGUI.isSelect()) {

            contatoGUI.setSelect(false);

            if (mouseEntered) {
                contatoGUI.getPaintMenu().setBackground(new Color(79,79,79));
            } else contatoGUI.getPaintMenu().setBackground(Color.darkGray);

        } else {
            contatoGUI.getPaintMenu().setBackground(new Color(8, 77, 110));
            contatoGUI.setSelect(true);
        }

    }

    public InicialScreenController getInicialScreenController() {
        return inicialScreenController;
    }

    public void setInicialScreenController(InicialScreenController inicialScreenController) {
        this.inicialScreenController = inicialScreenController;
    }

    public ContatosGUI getContatoGUI() {
        return contatoGUI;
    }

    public void setContatoGUI(ContatosGUI contatoGUI) {
        this.contatoGUI = contatoGUI;
    }
    public Contato getContato() {
        return contato;
    }
    public void setContato(Contato contato) {
        this.contato = contato;
    }


}
