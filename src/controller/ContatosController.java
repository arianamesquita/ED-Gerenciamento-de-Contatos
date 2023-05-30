package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import View.ContatoGUI;
import model.Categoria;
import model.Pessoa;

public class ContatosController {

    Pessoa pessoa;
    Categoria categoria;
    ContatoGUI contatoGUI;

    public ContatosController(Pessoa pessoa, Categoria categoria) {
        this.pessoa = pessoa;
        this.categoria = categoria;
        this.contatoGUI = new ContatoGUI(pessoa, categoria);

        addMouseListener();
    }

    private void addMouseListener() {
        contatoGUI.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (contatoGUI.isSelect()) {
                    contatoGUI.getPaintmenu().setBackground(Color.darkGray);
                    contatoGUI.setSelect(false);
                } else {
                    contatoGUI.getPaintmenu().setBackground(new Color(8, 77, 110));
                    contatoGUI.setSelect(true);
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
                contatoGUI.getPaintmenu().setBackground(Color.black);
                contatoGUI.getNumerotelefone().setVisible(true);
                contatoGUI.getPaintcategoria().setVisible(true);
                contatoGUI.getEmail().setVisible(true);

                selecionacor(true);
                contatoGUI.getPaintmenu().repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                contatoGUI.getEmail().setVisible(false);
                contatoGUI.getNumerotelefone().setVisible(false);
                contatoGUI.getPaintcategoria().setVisible(false);
                contatoGUI.getPaintmenu().setBackground(Color.darkGray);
                selecionacor(false);
                contatoGUI.getPaintmenu().repaint();
            }

        });
    }

    public void selecionacor(boolean mouseEntered) {
        if (!contatoGUI.isSelect()) {
            if (mouseEntered) {
                contatoGUI.getPaintmenu().setBackground(new Color(79,79,79));
            } else
            contatoGUI.getPaintmenu().setBackground(Color.darkGray);
            contatoGUI.setSelect(false);
        } else {
            contatoGUI.getPaintmenu().setBackground(new Color(8, 77, 110));
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

    public ContatoGUI getContatoGUI() {
        return contatoGUI;
    }

    public void setContatoGUI(ContatoGUI contatoGUI) {
        this.contatoGUI = contatoGUI;
    }

}
