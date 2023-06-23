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

    public FiltroController() {
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
            if (!getFiltroGUI().getFiltrarButton().isVisible()) {
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
        if (getFiltroGUI().getComboBoxes().size() < 2) {
            JComboBox<String> comboBox = new JComboBox<>(getFiltroGUI().getFiltroText());
            comboBox.setBackground(Color.lightGray);
            comboBox.setForeground(Color.darkGray);

            if (getFiltroGUI().getComboBoxes().size() == 1) {
                getFiltroGUI().getComboBoxes().get(0).removeAllItems();
            }

            String[] text = { "A -> z", "Z -> A" };
            JComboBox<String> secondComboBox = new JComboBox<>(text);
            secondComboBox.setBackground(Color.lightGray);
            secondComboBox.setForeground(Color.darkGray);

            getFiltroGUI().getRemoverButton().setVisible(true);
            getFiltroGUI().getFiltrarButton().setVisible(true);
            getFiltroGUI().getComboBoxes().add(comboBox);
            getFiltroGUI().getComboBoxes().add(secondComboBox);
            getFiltroGUI().add(comboBox);
            getFiltroGUI().add(secondComboBox);
            for (JComboBox<String> combo : getFiltroGUI().getComboBoxes()) {
                combo.setEnabled(true);
            }
            comboBox.setEnabled(true);
            getFiltroGUI().revalidate(); // Atualiza o layout do painel
        }
    }

    private void removerComboBox() {
        if (!getFiltroGUI().getComboBoxes().isEmpty()) {
            JComboBox<String> comboBox = getFiltroGUI().getComboBoxes()
                    .remove(getFiltroGUI().getComboBoxes().size() - 1);
            getFiltroGUI().remove(comboBox);
            getFiltroGUI().revalidate(); // Atualiza o layout do painel
            getFiltroGUI().repaint(); // Redesenha o painel
            for (int i = 0; i < getFiltroGUI().getComboBoxes().size(); i++) {
                if (i == getFiltroGUI().getComboBoxes().size() - 1) {
                    JComboBox<String> comboBox1 = getFiltroGUI().getComboBoxes().get(i);
                    comboBox1.setEnabled(true);
                }

            }
        }
        if (getFiltroGUI().getComboBoxes().isEmpty()) {
            getFiltroGUI().getRemoverButton().setVisible(false);
            getFiltroGUI().getFiltrarButton().setVisible(false);
        }
    }

    private void filtrar() {
        StringBuilder filtroSelecionado = new StringBuilder();
   
            String itemSelecionado = (String) getFiltroGUI().getComboBoxes().get(0).getSelectedItem();
         
           if (getFiltroGUI().getComboBoxes().get(1).getSelectedIndex() == 0) {
                          quickSortFiltro1(getInicialScreenController().getListaContatoController(), itemSelecionado);
            }else if(getFiltroGUI().getComboBoxes().get(1).getSelectedIndex() == 1){
                quickSortFiltro2(getInicialScreenController().getListaContatoController(), itemSelecionado);
            }
    
            getInicialScreenController().updateInterface();
       
        JOptionPane.showMessageDialog(getFiltroGUI(), "Filtro selecionado: " + filtroSelecionado);
    }

    private void setVisibleAll(boolean aFlag) {
        for (JComboBox<String> comboBox : getFiltroGUI().getComboBoxes()) {
            comboBox.setVisible(aFlag);
            getFiltroGUI().repaint();
        }
    }

    public void quickSortFiltro1(ContControlList contatos, String filtro) {
        quickSortRecFiltro1(contatos, contatos.getInicio(), contatos.getFim(), filtro);
    }

    private void quickSortRecFiltro1(ContControlList contatos, ContControlNO inicio, ContControlNO fim, String filtro) {
        if (inicio != null && fim != null && inicio != fim && inicio != fim.getProximo()) {
            ContControlNO pivot = partitionFiltro1(inicio, fim, filtro);
            quickSortRecFiltro1(contatos, inicio, pivot.getAnterior(), filtro);
            quickSortRecFiltro1(contatos, pivot.getProximo(), fim, filtro);
        }
    }

    private ContControlNO partitionFiltro1(ContControlNO inicio, ContControlNO fim, String filtro) {
        ContatoController pivot = fim.getContato();
        ContControlNO i = inicio.getAnterior();

        for (ContControlNO j = inicio; j != fim; j = j.getProximo()) {
            if (filtro.equals("ddd")) {
                if (Integer.parseInt(j.getContato().getContato().getPessoa().getTelefone().substring(0, 2)) <= Integer
                        .parseInt(pivot.getContato().getPessoa().getTelefone().substring(0, 2))) {
                    i = (i == null) ? inicio : i.getProximo();
                    swapFiltro1(i, j);
                }
            } else if (filtro.equals("categoria")) {
                if (j.getContato().getContato().getCategoria().getId() <= pivot.getContato().getCategoria().getId()) {
                    i = (i == null) ? inicio : i.getProximo();
                    swapFiltro1(i, j);
                }
            } else if (filtro.equals("nome")) { // esse acho q não precisa né, amigo?
                if (j.getContato().getContato().getPessoa().getNome().charAt(0) <= pivot.getContato().getPessoa()
                        .getNome().charAt(0)) {
                    i = (i == null) ? inicio : i.getProximo();
                    swapFiltro1(i, j);
                }
            } else if (filtro.equals("email")) {
                if (j.getContato().getContato().getPessoa().getEmail().charAt(0) <= pivot.getContato().getPessoa()
                        .getEmail().charAt(0)) {
                    i = (i == null) ? inicio : i.getProximo();
                    swapFiltro1(i, j);
                }
            }

        }

        i = (i == null) ? inicio : i.getProximo();
        swapFiltro1(i, fim);

        return i;
    }

    private void swapFiltro1(ContControlNO no1, ContControlNO no2) {
        ContatoController temp = no1.getContato();
        no1.setContato(no2.getContato());
        no2.setContato(temp);
    }

    public void quickSortFiltro2(ContControlList contatos, String filtro) {
        quickSortRecFiltro2(contatos, contatos.getInicio(), contatos.getFim(), filtro);
    }

    private void quickSortRecFiltro2(ContControlList contatos, ContControlNO inicio, ContControlNO fim, String filtro) {
        if (inicio != null && fim != null && inicio != fim && inicio != fim.getProximo()) {
            ContControlNO pivot = partitionFiltro2(inicio, fim, filtro);
            quickSortRecFiltro2(contatos, inicio, pivot.getAnterior(), filtro);
            quickSortRecFiltro2(contatos, pivot.getProximo(), fim, filtro);
        }
    }

    private ContControlNO partitionFiltro2(ContControlNO inicio, ContControlNO fim, String filtro) {
        ContatoController pivot = fim.getContato();
        ContControlNO i = inicio.getAnterior();

        for (ContControlNO j = inicio; j != fim; j = j.getProximo()) {
            if (filtro.equals("ddd")) {
                if (Integer.parseInt(j.getContato().getContato().getPessoa().getTelefone().substring(0, 2)) >= Integer
                        .parseInt(pivot.getContato().getPessoa().getTelefone().substring(0, 2))) {
                    i = (i == null) ? inicio : i.getProximo();
                    swapFiltro2(i, j);
                }
            } else if (filtro.equals("categoria")) {
                if (j.getContato().getContato().getCategoria().getId() >= pivot.getContato().getCategoria().getId()) {
                    i = (i == null) ? inicio : i.getProximo();
                    swapFiltro2(i, j);
                }
            } else if (filtro.equals("nome")) { // esse acho q não precisa né, amigo?
                if (j.getContato().getContato().getPessoa().getNome().charAt(0) >= pivot.getContato().getPessoa()
                        .getNome().charAt(0)) {
                    i = (i == null) ? inicio : i.getProximo();
                    swapFiltro2(i, j);
                }
            } else if (filtro.equals("email")) {
                if (j.getContato().getContato().getPessoa().getEmail().charAt(0) >= pivot.getContato().getPessoa()
                        .getEmail().charAt(0)) {
                    i = (i == null) ? inicio : i.getProximo();
                    swapFiltro2(i, j);
                }
            }

        }

        i = (i == null) ? inicio : i.getProximo();
        swapFiltro2(i, fim);

        return i;
    }

    private void swapFiltro2(ContControlNO no1, ContControlNO no2) {
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