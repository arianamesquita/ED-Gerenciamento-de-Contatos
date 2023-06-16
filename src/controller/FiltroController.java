package controller;

import View.FiltroGUI;
import database.createList.ContatosControllerList;
import database.createList.NoContato;
import database.createList.NoContatosControl;
import model.Contato;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FiltroController implements ActionListener {
    private FiltroGUI filtro;
    private ContatosControllerList contatos;

    public FiltroController(){
        this.filtro = new FiltroGUI();

        getFiltro().getFiltrarButton().addActionListener(this);
        getFiltro().getAdicionarButton().addActionListener(this);
        getFiltro().getRemoverButton().addActionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getFiltro().getAdicionarButton()) {
            setVisibleAll(true);
            adicionarComboBox();
            if (!getFiltro().getFiltrarButton().isVisible()){
                getFiltro().getRemoverButton().setVisible(true);
                getFiltro().getFiltrarButton().setVisible(true);
            }
        } else if (e.getSource() == getFiltro().getFiltrarButton()) {
            filtrar();
            getFiltro().getRemoverButton().setVisible(false);
            getFiltro().getFiltrarButton().setVisible(false);
            setVisibleAll(false);
        } else if (e.getSource() == getFiltro().getRemoverButton()) {
            setVisibleAll(true);
            removerComboBox();
        }
    }

    private void adicionarComboBox() {
        if (getFiltro().getComboBoxes().size() < getFiltro().getFiltroText().length) {
            JComboBox<String> comboBox = new JComboBox<>(getFiltro().getFiltroText());
            comboBox.setBackground(Color.lightGray);
            comboBox.setForeground(Color.darkGray);

            for (JComboBox<String> cb : getFiltro().getComboBoxes()) {
                String itemSelecionado = (String) cb.getSelectedItem();
                comboBox.removeItem(itemSelecionado);
            }

            getFiltro().getRemoverButton().setVisible(true);
            getFiltro().getFiltrarButton().setVisible(true);
            getFiltro().getComboBoxes().add(comboBox);
            getFiltro().add(comboBox);
            for (JComboBox<String> combo: filtro.getComboBoxes()) {
                combo.setEnabled(false);
            }
            comboBox.setEnabled(true);
            getFiltro().revalidate(); // Atualiza o layout do painel
        }
    }

    private void removerComboBox() {
        if (!getFiltro().getComboBoxes().isEmpty()) {
            JComboBox<String> comboBox = getFiltro().getComboBoxes().remove(getFiltro().getComboBoxes().size() - 1);
            getFiltro().remove(comboBox);
            getFiltro().revalidate(); // Atualiza o layout do painel
            getFiltro().repaint(); // Redesenha o painel
            for (int i = 0; i < getFiltro().getComboBoxes().size(); i++) {
                if( i ==getFiltro().getComboBoxes().size() - 1){
                    JComboBox<String> comboBox1 = getFiltro().getComboBoxes().get(i);
                    comboBox1.setEnabled(true);
                }

            }
        }
        if (getFiltro().getComboBoxes().isEmpty()){
            getFiltro().getRemoverButton().setVisible(false);
            getFiltro().getFiltrarButton().setVisible(false);
        }
    }

    private void filtrar() {
        StringBuilder filtroSelecionado = new StringBuilder();
        for (JComboBox<String> comboBox : getFiltro().getComboBoxes()) {
            String itemSelecionado = (String) comboBox.getSelectedItem();
            filtroSelecionado.append(itemSelecionado).append(" , ");
        }
        JOptionPane.showMessageDialog(getFiltro(), "Filtro selecionado: " + filtroSelecionado);
    }
    private void setVisibleAll(boolean aFlag){
        for (JComboBox<String> comboBox : getFiltro().getComboBoxes()) {
            comboBox.setVisible(aFlag);
            getFiltro().repaint();
        }
    }

    public FiltroGUI getFiltro() {
        return filtro;
    }

    public void setFiltro(FiltroGUI filtro) {
        this.filtro = filtro;
    }


    public void setContatos(ContatosControllerList contatos) {
        this.contatos = contatos;
    }



    public void quickSort(ContatosControllerList contatos) {
        System.out.println(contatos.getController().getContato().getPessoa().getNome());
        quickSortRec(contatos, getInicio(), getFim());
    }

    private NoContatosControl getFim() {
        return null;
    }
    private NoContatosControl getInicio() {
        return null;
    }

    private void quickSortRec(ContatosControllerList contatos, NoContatosControl inicio, NoContatosControl fim) {
        if (inicio != null && fim != null && inicio != fim && inicio != fim.getProximo()) {
            NoContatosControl pivot = partition(inicio, fim);
            quickSortRec(contatos, inicio, pivot.getAnterior());
            quickSortRec(contatos, pivot.getProximo(), fim);
        }
    }

    private NoContatosControl partition(NoContatosControl inicio, NoContatosControl fim) {
        ContatosController pivot = fim.getContato();
        NoContatosControl i = inicio.getAnterior();
        
        for (NoContatosControl j = inicio; j != fim; j = j.getProximo()) {

            if (Integer.parseInt(j.getContato().getContato().getPessoa().getTelefone().substring(0, 1)) <= Integer.parseInt(pivot.getContato().getPessoa().getTelefone().substring(0, 1))) {
                i = (i == null) ? inicio : i.getProximo();
                swap(i, j);
            }
        }
        
        i = (i == null) ? inicio : i.getProximo();
        swap(i, fim);

        System.out.println(pivot);
        
        return i;
    }

    private void swap(NoContatosControl no1, NoContatosControl no2) {
        ContatosController temp = no1.getContato();
        no1.setContato(no2.getContato());
        no2.setContato(temp);
    }
}

