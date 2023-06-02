package View;

import controller.FiltroController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class InicialScreen extends JPanel{
    private BoxLayout layout;
    private JPanel panelcontatos,painelCategoria,paineleditar;
    private JButton criar, editar, apagar, apagarTodos, adicionarCategoria, removerCategoria;
    private JScrollPane scrollPane;
    private CaixaTextoGUI caixadetextoGui;
    private FiltroController filtro;

    public InicialScreen() {  
        setLayout(new BorderLayout());

        this.caixadetextoGui = new CaixaTextoGUI();
        this.panelcontatos = new JPanel();
        this.layout = new BoxLayout(panelcontatos, BoxLayout.Y_AXIS);
        this.scrollPane = new JScrollPane(panelcontatos);
        this.criar = new JButton("adicionar novo contato");
        this.editar = new JButton("editar");
        this.apagar = new JButton("apagar");
        this.apagarTodos = new JButton("apagar todos");
        this.adicionarCategoria = new JButton("adicionar categoria");
        this.removerCategoria = new JButton("remover categoria");
        this.painelCategoria = new JPanel();
        this.paineleditar = new JPanel();
        this.filtro = new FiltroController();
        panelcontatos.setLayout(layout);
        panelcontatos.setBackground(Color.gray);
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

        paineleditar.setLayout(new BoxLayout(paineleditar, BoxLayout.Y_AXIS));
        JPanel paintmenu = new JPanel(layout, isDoubleBuffered());
        paintmenu.setBackground(Color.gray);
        paintmenu.setLayout(new FlowLayout());
        paintmenu.add(criar);
        paintmenu.add(editar);
        paintmenu.add(apagar);
        paintmenu.add(apagarTodos);

        paineleditar.add(paintmenu);
        paineleditar.add(painelCategoria);
        caixadetextoGui.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        paineleditar.add(caixadetextoGui,BorderLayout.CENTER);

        editar.setVisible(false);
        apagar.setVisible(false);
        apagarTodos.setVisible(false);
        caixadetextoGui.setVisible(false);
        adicionarCategoria.setVisible(false);
        removerCategoria.setVisible(false);

        add(filtro.getFiltro(),BorderLayout.NORTH);
        add(paineleditar,BorderLayout.SOUTH);
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

    public JPanel getPanelcontatos() {
        return panelcontatos;
    }

    public void setPanelcontatos(JPanel panelcontatos) {
        this.panelcontatos = panelcontatos;
    }

    public JPanel getPainelCategoria() {
        return painelCategoria;
    }

    public void setPainelCategoria(JPanel painelCategoria) {
        this.painelCategoria = painelCategoria;
    }

    public JPanel getPaineleditar() {
        return paineleditar;
    }

    public void setPaineleditar(JPanel paineleditar) {
        this.paineleditar = paineleditar;
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

    public CaixaTextoGUI getCaixadetextoGui() {
        return caixadetextoGui;
    }

    public void setCaixadetextoGui(CaixaTextoGUI caixadetextoGui) {
        this.caixadetextoGui = caixadetextoGui;
    }


    public FiltroController getFiltro() {
        return filtro;
    }

    public void setFiltro(FiltroController filtro) {
        this.filtro = filtro;
    }
}
