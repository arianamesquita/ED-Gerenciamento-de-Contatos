package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class InicialScreen extends JPanel {
    private BoxLayout layout;
    private JPanel panelContatos,painelCategoria, painelEditar;
    private JButton criar, editar, apagar, apagarTodos, adicionarCategoria, removerCategoria;
    private JScrollPane scrollPane;
    private CaixaTextoGUI caixaTextoGui;

    public InicialScreen() {
        setLayout(new BorderLayout());

        this.caixaTextoGui = new CaixaTextoGUI();
        this.panelContatos = new JPanel();
        this.layout = new BoxLayout(panelContatos, BoxLayout.Y_AXIS);
        this.scrollPane = new JScrollPane(panelContatos);
        this.criar = new JButton("adicionar novo contato");
        this.editar = new JButton("editar");
        this.apagar = new JButton("apagar");
        this.apagarTodos = new JButton("apagar todos");
        this.adicionarCategoria = new JButton("adicionar categoria");
        this.removerCategoria = new JButton("remover categoria");
        this.painelCategoria = new JPanel();
        this.painelEditar = new JPanel();
        panelContatos.setLayout(layout);
        panelContatos.setBackground(Color.gray);
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setPaint(new Color(163, 183, 203));
                g2.fill(thumbBounds);
            }

            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setPaint(new Color(120, 136, 151));
                g2.fill(trackBounds);
            }
        });
        scrollPane.setBackground(Color.lightGray);
        painelCategoria.setLayout(new FlowLayout());
        painelCategoria.setBackground(Color.gray);
        painelCategoria.add(adicionarCategoria);
        painelCategoria.add(removerCategoria);

        painelEditar.setLayout(new BoxLayout(painelEditar, BoxLayout.Y_AXIS));
        JPanel panel = new JPanel(layout, isDoubleBuffered());
        panel.setBackground(Color.gray);
        panel.setLayout(new FlowLayout());
        panel.add(criar);
        panel.add(editar);
        panel.add(apagar);
        panel.add(apagarTodos);
        painelEditar.add(panel);
        painelEditar.add(caixaTextoGui);

        editar.setVisible(false);
        apagar.setVisible(false);
        apagarTodos.setVisible(false);
        caixaTextoGui.setVisible(false);
        adicionarCategoria.setVisible(false);
        removerCategoria.setVisible(false);
        
        add(painelCategoria,BorderLayout.NORTH);
        add(painelEditar,BorderLayout.SOUTH);
        setBackground(Color.gray);
        setOpaque(true);
        setVisible(true);
    }

    public BoxLayout getLayout() {
        return layout;
    }

    public void setLayout(BoxLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanelContatos() {
        return panelContatos;
    }

    public void setPanelContatos(JPanel panelContatos) {
        this.panelContatos = panelContatos;
    }

    public JButton getCriar() {
        return criar;
    }

    public void setCriar(JButton criar) {
        this.criar = criar;
    }

    public JButton getEditar() {
        return editar;
    }

    public void setEditar(JButton editar) {
        this.editar = editar;
    }

    public JButton getApagar() {
        return apagar;
    }

    public void setApagar(JButton apagar) {
        this.apagar = apagar;
    }

    public JButton getApagarTodos() {
        return apagarTodos;
    }

    public void setApagarTodos(JButton apagarTodos) {
        this.apagarTodos = apagarTodos;
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

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JPanel getPainelCategoria() {
        return painelCategoria;
    }

    public void setPainelCategoria(JPanel painelCategoria) {
        this.painelCategoria = painelCategoria;
    }

    public JPanel getPainelEditar() {
        return painelEditar;
    }

    public void setPainelEditar(JPanel painelEditar) {
        this.painelEditar = painelEditar;
    }

    public CaixaTextoGUI getCaixaTextoGui() {
        return caixaTextoGui;
    }

    public void setCaixaTextoGui(CaixaTextoGUI caixaTextoGui) {
        this.caixaTextoGui = caixaTextoGui;
    }

}
