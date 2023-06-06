package View;

import controller.ContatoScreenController;
import controller.CategoriaController;
import controller.FiltroController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class InicialScreenGUI extends JPanel{
    private BoxLayout layout;
    private CategoriaController categoriaController;
    private JPanel panelContatos, painelEditar;
    private JButton criar, editar, apagar, apagarTodos, adicionarCategoria, removerCategoria;
    private JLabel contador;
    private JScrollPane scrollPane;
    private ContatoScreenController caixaTextoGui;
    private FiltroController filtro;

    public InicialScreenGUI() {
        setLayout(new BorderLayout());

        this.caixaTextoGui = new ContatoScreenController();
        this.panelContatos = new JPanel();
        this.layout = new BoxLayout(panelContatos, BoxLayout.Y_AXIS);
        this.scrollPane = new JScrollPane(panelContatos);
        this.criar = new JButton("adicionar novo contato");
        this.editar = new JButton("editar");
        this.apagar = new JButton("apagar");
        this.apagarTodos = new JButton("apagar todos");
        this.contador = new JLabel();
        this.adicionarCategoria = new JButton("adicionar categoria");
        this.removerCategoria = new JButton("remover categoria");

        this.painelEditar = new JPanel();
        this.filtro = new FiltroController();
        this.categoriaController = new CategoriaController();
        contador.setForeground(Color.white);
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

        painelEditar.setLayout(new BoxLayout(painelEditar, BoxLayout.Y_AXIS));
        JPanel paintmenu = new JPanel(layout, isDoubleBuffered());
        paintmenu.setBackground(Color.gray);
        paintmenu.setLayout(new FlowLayout());
        paintmenu.add(criar);
        paintmenu.add(editar);
        paintmenu.add(apagar);
        paintmenu.add(contador);
        paintmenu.add(apagarTodos);

        painelEditar.add(paintmenu);
        painelEditar.add(categoriaController.getCategoriaGUI());
        caixaTextoGui.getCaixaTexto().setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        painelEditar.add(caixaTextoGui.getCaixaTexto(),BorderLayout.CENTER);

        editar.setVisible(false);
        apagar.setVisible(false);
        apagarTodos.setVisible(false);
        caixaTextoGui.getCaixaTexto().setVisible(false);
        adicionarCategoria.setVisible(false);
        removerCategoria.setVisible(false);
        contador.setVisible(false);
        categoriaController.getCategoriaGUI().setVisible(false);

        add(filtro.getFiltro(),BorderLayout.NORTH);
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


    public JPanel getPainelEditar() {
        return painelEditar;
    }

    public void setPainelEditar(JPanel painelEditar) {
        this.painelEditar = painelEditar;
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


    public FiltroController getFiltro() {
        return filtro;
    }

    public void setFiltro(FiltroController filtro) {
        this.filtro = filtro;
    }

    public ContatoScreenController getCaixaTextoGui() {
        return caixaTextoGui;
    }

    public JLabel getContador() {
        return contador;
    }

    public void setContador(JLabel contador) {
        this.contador = contador;
    }

    public CategoriaController getCategoriaController() {
        return categoriaController;
    }

    public void setCategoriaController(CategoriaController categoriaController) {
        this.categoriaController = categoriaController;
    }

    public void setCaixaTextoGui(ContatoScreenController caixaTextoGui) {
        this.caixaTextoGui = caixaTextoGui;
    }
}
