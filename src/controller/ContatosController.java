package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import View.ContatosScreenGUI;
import model.Categoria;
import model.Pessoa;

public class ContatosController {

    private Pessoa pessoa;
    private Categoria categoria;
    private ContatosScreenGUI contatoGUI;

    public ContatosController(Pessoa pessoa, Categoria categoria) {
        this.pessoa = pessoa;
        this.categoria = categoria;
        this.contatoGUI = new ContatosScreenGUI(pessoa, categoria);
        addMouseListener();
    }
    public  void updateGUI(){
        setContatoGUI(new ContatosScreenGUI(getPessoa(),getCategoria()));
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
                    contatoGUI.getPaintMenu().setBackground(Color.darkGray);
                    contatoGUI.setSelect(false);
                } else {
                    contatoGUI.getPaintMenu().setBackground(new Color(8, 77, 110));
                    contatoGUI.setSelect(true);
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ContatosScreenGUI getContatoGUI() {
        return contatoGUI;
    }

    public void setContatoGUI(ContatosScreenGUI contatoGUI) {
        this.contatoGUI = contatoGUI;
    }


}
