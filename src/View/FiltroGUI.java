package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FiltroGUI extends JPanel {

    private JButton filtrarButton;
    private JButton adicionarButton;
    private JButton removerButton;
    private JPanel panelButtons;
    private ArrayList<JComboBox<String>> comboBoxes;
    private String[] filtroText = { "A->Z", "Z->A", "ddd", "categoria" };

    public FiltroGUI() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.gray);

        this.comboBoxes = new ArrayList<>();
        this.filtrarButton = new JButton("Filtrar");
        this.adicionarButton = new JButton("Adicionar Filtro");
        this.removerButton = new JButton("Remover Filtro");
        this.panelButtons = new JPanel();
        panelButtons.setOpaque(false);
        panelButtons.setLayout(new FlowLayout());
        panelButtons.add(adicionarButton);
        panelButtons.add(removerButton);
        panelButtons.add(filtrarButton);
        add(panelButtons);
        removerButton.setVisible(false);
        filtrarButton.setVisible(false);
        setVisible(true);
    }

    public JButton getFiltrarButton() {
        return filtrarButton;
    }

    public void setFiltrarButton(JButton filtrarButton) {
        this.filtrarButton = filtrarButton;
    }

    public JButton getAdicionarButton() {
        return adicionarButton;
    }

    public void setAdicionarButton(JButton adicionarButton) {
        this.adicionarButton = adicionarButton;
    }

    public JButton getRemoverButton() {
        return removerButton;
    }

    public void setRemoverButton(JButton removerButton) {
        this.removerButton = removerButton;
    }

    public ArrayList<JComboBox<String>> getComboBoxes() {
        return comboBoxes;
    }

    public void setComboBoxes(ArrayList<JComboBox<String>> comboBoxes) {
        this.comboBoxes = comboBoxes;
    }

    public String[] getFiltroText() {
        return filtroText;
    }

    public void setFiltroText(String[] filtroText) {
        this.filtroText = filtroText;
    }

    public JPanel getPanelButtons() {
        return panelButtons;
    }

    public void setPanelButtons(JPanel panelButtons) {
        this.panelButtons = panelButtons;
    }


}

