package View;

import controller.CategoriaController;

import javax.swing.*;
import java.awt.*;

public class CategoriaGUI extends JPanel {
    private JButton adicionarCategoria, removerCategoria, novaCategoria, salvar, cancelar;
    private JLabel categoriaText;
    private JComboBox<String> categoriaExistente;
    private String[] textCategorias;
    private JTextField categoriaField;
    private JPanel categoriasButton, controleButtons, panel;

    public CategoriaGUI() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.adicionarCategoria = new JButton("adicionar categoria");
        this.removerCategoria = new JButton("remover categoria");
        this.novaCategoria = new JButton("nova categoria");
        this.salvar = new JButton("salvar");
        this.cancelar = new JButton("cancelar");
        this.categoriaExistente = new JComboBox<>(CategoriaController.buscarCategorias());
        this.categoriaText = new JLabel("nova categoria:");
        this.categoriaField = new JTextField();
        this.categoriasButton = new JPanel(new FlowLayout());
        this.controleButtons = new JPanel(new FlowLayout());
        this.panel = new JPanel(new FlowLayout());
        categoriaField.setForeground(Color.darkGray);
        categoriaText.setForeground(Color.white);
        categoriasButton.setOpaque(false);
        controleButtons.setOpaque(false);
        panel.setOpaque(false);

        categoriasButton.add(categoriaExistente);
        categoriasButton.add(novaCategoria);
        categoriasButton.add(categoriaText);
        categoriasButton.add(categoriaField);

        controleButtons.add(salvar);
        controleButtons.add(cancelar);
        panel.add(adicionarCategoria);
        panel.add(removerCategoria);

        add(panel);
        add(categoriasButton);
        add(controleButtons);
        setBackground(Color.gray);
        setVisible(true);
    }

    public JButton getAdicionarCategoria() {
        return adicionarCategoria;
    }

    public void setAdicionarCategoria(JButton adicionarCategoria) {
        this.adicionarCategoria = adicionarCategoria;
    }

    public JButton getRemoverCategoria() {
        return removerCategoria;
    }

    public void setRemoverCategoria(JButton removerCategoria) {
        this.removerCategoria = removerCategoria;
    }

    public JButton getNovaCategoria() {
        return novaCategoria;
    }

    public void setNovaCategoria(JButton novaCategoria) {
        this.novaCategoria = novaCategoria;
    }

    public JButton getSalvar() {
        return salvar;
    }

    public void setSalvar(JButton salvar) {
        this.salvar = salvar;
    }

    public JButton getCancelar() {
        return cancelar;
    }

    public void setCancelar(JButton cancelar) {
        this.cancelar = cancelar;
    }

    public JComboBox<String> getCategoriaExistente() {
        return categoriaExistente;
    }

    public void setCategoriaExistente(JComboBox<String> categoriaExistente) {
        this.categoriaExistente = categoriaExistente;
    }

    public String[] getTextCategorias() {
        return textCategorias;
    }

    public void setTextCategorias(String[] textCategorias) {
        this.textCategorias = textCategorias;
    }

    public JTextField getCategoriaField() {
        return categoriaField;
    }

    public void setCategoriaField(JTextField categoriaField) {
        this.categoriaField = categoriaField;
    }

    public JPanel getCategoriasButton() {
        return categoriasButton;
    }

    public void setCategoriasButton(JPanel categoriasButton) {
        this.categoriasButton = categoriasButton;
    }

    public JPanel getControleButtons() {
        return controleButtons;
    }

    public void setControleButtons(JPanel controleButtons) {
        this.controleButtons = controleButtons;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JLabel getCategoriaText() {
        return categoriaText;
    }

    public void setCategoriaText(JLabel categoriaText) {
        this.categoriaText = categoriaText;
    }
}
