package controller;

import View.FiltroGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FiltroController implements ActionListener {
    private FiltroGUI filtro;

    public FiltroController(){
        this.filtro = new FiltroGUI();
        filtro.getFiltrarButton().addActionListener(this);
        filtro.getAdicionarButton().addActionListener(this);
        filtro.getRemoverButton().addActionListener(this);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == filtro.getAdicionarButton()) {
            setVisibleAll(true);
            adicionarComboBox();
        } else if (e.getSource() == filtro.getFiltrarButton()) {
            filtrar();
            filtro.getRemoverButton().setVisible(false);
            filtro.getFiltrarButton().setVisible(false);
            setVisibleAll(false);
        } else if (e.getSource() == filtro.getRemoverButton()) {
            setVisibleAll(true);
            removerComboBox();
        }
    }

    private void adicionarComboBox() {
        if (filtro.getComboBoxes().size() < filtro.getFiltroText().length) {
            JComboBox<String> comboBox = new JComboBox<>(filtro.getFiltroText());
            comboBox.setBackground(Color.lightGray);
            comboBox.setForeground(Color.darkGray);

            for (JComboBox<String> cb : filtro.getComboBoxes()) {
                String itemSelecionado = (String) cb.getSelectedItem();
                comboBox.removeItem(itemSelecionado);
            }

            filtro.getRemoverButton().setVisible(true);
            filtro.getFiltrarButton().setVisible(true);
            filtro.getComboBoxes().add(comboBox);
            filtro.add(comboBox);
            filtro.revalidate(); // Atualiza o layout do painel
        }
    }

    private void removerComboBox() {
        if (!filtro.getComboBoxes().isEmpty()) {
            JComboBox<String> comboBox = filtro.getComboBoxes().remove(filtro.getComboBoxes().size() - 1);
            filtro.remove(comboBox);
            filtro.revalidate(); // Atualiza o layout do painel
            filtro.repaint(); // Redesenha o painel
        }
        if (filtro.getComboBoxes().isEmpty()){
            filtro.getRemoverButton().setVisible(false);
            filtro.getFiltrarButton().setVisible(false);
        }
    }

    private void filtrar() {
        StringBuilder filtroSelecionado = new StringBuilder();
        for (JComboBox<String> comboBox : filtro.getComboBoxes()) {
            String itemSelecionado = (String) comboBox.getSelectedItem();
            filtroSelecionado.append(itemSelecionado).append(" , ");
        }
        JOptionPane.showMessageDialog(filtro, "Filtro selecionado: " + filtroSelecionado);
    }
    private void setVisibleAll(boolean aFlag){
        for (JComboBox<String> comboBox : filtro.getComboBoxes()) {
            comboBox.setVisible(aFlag);
            filtro.repaint();
        }
    }

    public FiltroGUI getFiltro() {
        return filtro;
    }

    public void setFiltro(FiltroGUI filtro) {
        this.filtro = filtro;
    }
}
