package controller;

import View.CategoriaGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CategoriaController implements ActionListener, FocusListener{
    private CategoriaGUI categoriaGUI;

    public CategoriaController(){

        this.categoriaGUI = new CategoriaGUI();
        getCategoriaGUI().getPanel().setVisible(true);
        getCategoriaGUI().getCategoriaText().setVisible(false);
        getCategoriaGUI().getCategoriasButton().setVisible(false);
        getCategoriaGUI().getControleButtons().setVisible(false);
        getCategoriaGUI().getAdicionarCategoria().setVisible(true);
        getCategoriaGUI().getRemoverCategoria().setVisible(true);
        getCategoriaGUI().getCategoriaExistente().setVisible(false);
        getCategoriaGUI().getNovaCategoria().setVisible(false);
        getCategoriaGUI().getCategoriaField().setVisible(false);
        getCategoriaGUI().getSalvar().setVisible(false);
        getCategoriaGUI().getCancelar().setVisible(false);
        getCategoriaGUI().getCategoriaField().setText("digite uma categoria");

        addActionListener();
    }
    private void addActionListener(){
        getCategoriaGUI().getAdicionarCategoria().addActionListener(this);
        getCategoriaGUI().getRemoverCategoria().addActionListener(this);
        getCategoriaGUI().getCategoriaExistente().addActionListener(this);
        getCategoriaGUI().getNovaCategoria().addActionListener(this);
        getCategoriaGUI().getCategoriaField().addActionListener(this);
        getCategoriaGUI().getSalvar().addActionListener(this);
        getCategoriaGUI().getCancelar().addActionListener(this);
        getCategoriaGUI().getCategoriaField().addFocusListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getCategoriaGUI().getAdicionarCategoria()) {
            getCategoriaGUI().getCategoriasButton().setVisible(true);
            getCategoriaGUI().getControleButtons().setVisible(true);
            getCategoriaGUI().getPanel().setVisible(false);
            getCategoriaGUI().getAdicionarCategoria().setVisible(false);
            getCategoriaGUI().getRemoverCategoria().setVisible(false);
            getCategoriaGUI().getCategoriaExistente().setVisible(true);
            getCategoriaGUI().getNovaCategoria().setVisible(true);
            getCategoriaGUI().getCategoriaField().setVisible(false);
            getCategoriaGUI().getSalvar().setVisible(true);
            getCategoriaGUI().getCancelar().setVisible(true);
            getCategoriaGUI().getCategoriaText().setVisible(false);

        } else
        if (e.getSource() == getCategoriaGUI().getRemoverCategoria()) {
            getCategoriaGUI().getAdicionarCategoria().setVisible(false);
            getCategoriaGUI().getRemoverCategoria().setVisible(false);
            int resposta = JOptionPane.showConfirmDialog(getCategoriaGUI(), "Deseja continuar?", "Confirmação", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(getCategoriaGUI(), "AGUARDANDO FUNÇÃO");
                getCategoriaGUI().getCancelar().doClick();
            } else if (resposta == JOptionPane.NO_OPTION) {
                getCategoriaGUI().getCancelar().doClick();
            } else if (resposta == JOptionPane.CLOSED_OPTION) {
                getCategoriaGUI().getCancelar().doClick();
            }

        } else
        if (e.getSource() == getCategoriaGUI().getNovaCategoria()) {
            getCategoriaGUI().getCategoriasButton().setVisible(true);
            getCategoriaGUI().getControleButtons().setVisible(true);
            getCategoriaGUI().getRemoverCategoria().setVisible(false);
            getCategoriaGUI().getCategoriaExistente().setVisible(false);
            getCategoriaGUI().getNovaCategoria().setVisible(false);
            getCategoriaGUI().getCategoriaField().setVisible(true);
            getCategoriaGUI().getSalvar().setVisible(true);
            getCategoriaGUI().getCancelar().setVisible(true);
            getCategoriaGUI().getCategoriaText().setVisible(true);

        }  else //Adicionar método DAO para salvar a categoria
        if (e.getSource() == getCategoriaGUI().getCancelar()) {
            getCategoriaGUI().getCategoriasButton().setVisible(false);
            getCategoriaGUI().getControleButtons().setVisible(false);
            getCategoriaGUI().getPanel().setVisible(true);
            getCategoriaGUI().getAdicionarCategoria().setVisible(true);
            getCategoriaGUI().getRemoverCategoria().setVisible(true);
            getCategoriaGUI().getCategoriaExistente().setVisible(false);
            getCategoriaGUI().getNovaCategoria().setVisible(false);
            getCategoriaGUI().getCategoriaField().setVisible(false);
            getCategoriaGUI().getSalvar().setVisible(false);
            getCategoriaGUI().getCancelar().setVisible(false);
            getCategoriaGUI().getCategoriaText().setVisible(false);

        }

    }

    @Override
    public void focusGained(FocusEvent e) {
        if (getCategoriaGUI().getCategoriaField().getText().equals("digite uma categoria")) {
            getCategoriaGUI().getCategoriaField().setBackground(Color.white);
            getCategoriaGUI().getCategoriaField().setForeground(Color.darkGray);

            getCategoriaGUI().getCategoriaField().setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (getCategoriaGUI().getCategoriaField().getText().equals("")
                || getCategoriaGUI().getCategoriaField().getText().isEmpty()) {
            getCategoriaGUI().getCategoriaField().setBackground(Color.red);
            getCategoriaGUI().getCategoriaField().setForeground(Color.white);
            getCategoriaGUI().getCategoriaField().setText("digite uma categoria");
        }
    }

    public CategoriaGUI getCategoriaGUI() {
        return categoriaGUI;
    }

    public void setCategoriaGUI(CategoriaGUI categoriaGUI) {
        this.categoriaGUI = categoriaGUI;
    }


}
