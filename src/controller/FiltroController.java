package controller;

import View.FiltroGUI;
import database.createList.DoublyLinkedLists.ContControlList;
import database.createList.NOs.ContControlNO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FiltroController implements ActionListener {
    private FiltroGUI filtroGUI;
    private InicialScreenController inicialScreenController;

    public FiltroController(){
        this.filtroGUI = new FiltroGUI();

        getFiltroGUI().getFiltrarButton().addActionListener(this);
        getFiltroGUI().getAdicionarButton().addActionListener(this);
        getFiltroGUI().getRemoverButton().addActionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getFiltroGUI().getAdicionarButton()) {
            setVisibleAll(true);
            adicionarComboBox();
            if (!getFiltroGUI().getFiltrarButton().isVisible()){
                getFiltroGUI().getRemoverButton().setVisible(true);
                getFiltroGUI().getFiltrarButton().setVisible(true);
            }
        } else if (e.getSource() == getFiltroGUI().getFiltrarButton()) {
            filtrar();
            getFiltroGUI().getRemoverButton().setVisible(false);
            getFiltroGUI().getFiltrarButton().setVisible(false);
            setVisibleAll(false);
        } else if (e.getSource() == getFiltroGUI().getRemoverButton()) {
            setVisibleAll(true);
            removerComboBox();
        }
    }

    private void adicionarComboBox() {
        if (getFiltroGUI().getComboBoxes().size() < getFiltroGUI().getFiltroText().length) {
            JComboBox<String> comboBox = new JComboBox<>(getFiltroGUI().getFiltroText());
            comboBox.setBackground(Color.lightGray);
            comboBox.setForeground(Color.darkGray);

            for (JComboBox<String> cb : getFiltroGUI().getComboBoxes()) {
                String itemSelecionado = (String) cb.getSelectedItem();
                comboBox.removeItem(itemSelecionado);
            }

            getFiltroGUI().getRemoverButton().setVisible(true);
            getFiltroGUI().getFiltrarButton().setVisible(true);
            getFiltroGUI().getComboBoxes().add(comboBox);
            getFiltroGUI().add(comboBox);
            for (JComboBox<String> combo: filtroGUI.getComboBoxes()) {
                combo.setEnabled(false);
            }
            comboBox.setEnabled(true);
            getFiltroGUI().revalidate(); // Atualiza o layout do painel
        }
    }

    private void removerComboBox() {
        if (!getFiltroGUI().getComboBoxes().isEmpty()) {
            JComboBox<String> comboBox = getFiltroGUI().getComboBoxes().remove(getFiltroGUI().getComboBoxes().size() - 1);
            getFiltroGUI().remove(comboBox);
            getFiltroGUI().revalidate(); // Atualiza o layout do painel
            getFiltroGUI().repaint(); // Redesenha o painel
            for (int i = 0; i < getFiltroGUI().getComboBoxes().size(); i++) {
                if( i == getFiltroGUI().getComboBoxes().size() - 1){
                    JComboBox<String> comboBox1 = getFiltroGUI().getComboBoxes().get(i);
                    comboBox1.setEnabled(true);
                }

            }
        }
        if (getFiltroGUI().getComboBoxes().isEmpty()){
            getFiltroGUI().getRemoverButton().setVisible(false);
            getFiltroGUI().getFiltrarButton().setVisible(false);
        }
    }

    private void filtrar() {
        StringBuilder filtroSelecionado = new StringBuilder();
        for (JComboBox<String> comboBox : getFiltroGUI().getComboBoxes()) {
            String itemSelecionado = (String) comboBox.getSelectedItem();
            filtroSelecionado.append(itemSelecionado).append(" , ");
            quickSort(getInicialScreenController().getListaContatoController());
            getInicialScreenController().updateInterface();
        }
        JOptionPane.showMessageDialog(getFiltroGUI(), "Filtro selecionado: " + filtroSelecionado);
    }
    private void setVisibleAll(boolean aFlag){
        for (JComboBox<String> comboBox : getFiltroGUI().getComboBoxes()) {
            comboBox.setVisible(aFlag);
            getFiltroGUI().repaint();
        }
    }




    public void quickSort(ContControlList contatos) {
        quickSortRec(contatos, contatos.getInicio(), contatos.getFim());
    }

    private void quickSortRec(ContControlList contatos, ContControlNO inicio, ContControlNO fim) {
        if (inicio != null && fim != null && inicio != fim && inicio != fim.getProximo()) {
            ContControlNO pivot = partition(inicio, fim);
            quickSortRec(contatos, inicio, pivot.getAnterior());
            quickSortRec(contatos, pivot.getProximo(), fim);
        }
    }

    private ContControlNO partition(ContControlNO inicio, ContControlNO fim) {
        ContatoController pivot = fim.getContato();
        ContControlNO i = inicio.getAnterior();
        
        for (ContControlNO j = inicio; j != fim; j = j.getProximo()) {
            if (Integer.parseInt(j.getContato().getContato().getPessoa().getTelefone().substring(0,2)) <= Integer.parseInt(pivot.getContato().getPessoa().getTelefone().substring(0, 2))) {
                i = (i == null) ? inicio : i.getProximo();
                swap(i, j);
            }
        }
        
        i = (i == null) ? inicio : i.getProximo();
        swap(i, fim);
        
        return i;
    }

    private void swap(ContControlNO no1, ContControlNO no2) {
        ContatoController temp = no1.getContato();
        no1.setContato(no2.getContato());
        no2.setContato(temp);
    }


    public FiltroGUI getFiltroGUI() {
        return filtroGUI;
    }

    public void setFiltroGUI(FiltroGUI filtroGUI) {
        this.filtroGUI = filtroGUI;
    }


    public InicialScreenController getInicialScreenController() {
        return inicialScreenController;
    }

    public void setInicialScreenController(InicialScreenController inicialScreenController) {
        this.inicialScreenController = inicialScreenController;
    }
}

