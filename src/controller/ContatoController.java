package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import View.ContatosGUI;
import database.ContatoDao;
import database.PessoaDAO;
import database.createList.DoublyLinkedLists.ContatoList;
import database.createList.DoublyLinkedLists.PessoaList;
import database.createList.NOs.ContatoNO;
import database.createList.NOs.PessoaNO;
import model.Contato;

public class ContatoController {
    private Contato contato;
    private ContatosGUI contatoGUI;
    private boolean select, mouseClicked;
    private InicialScreenController inicialScreenController;

    public ContatoController(Contato contato) {

        this.contato = contato;
        this.contatoGUI = new ContatosGUI(getContato());
        this.mouseClicked = false;
        this.select = false;
        addMouseListener();
    }
   
    public  void updateGUI(){
        setContatoGUI(new ContatosGUI(getContato()));
        setSelect(false);
        addMouseListener();
    }
    public void setVisibleGUI(boolean aFlag){
        getContatoGUI().setVisible(aFlag);

    }
    public void repaint(){
        getContatoGUI().repaint();
    }

    private void addMouseListener() {
        contatoGUI.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if(isMouseClicked()){
                if (isSelect()) {
                   getInicialScreenController().setCountMouseClicked(getInicialScreenController().getCountMouseClicked()-1);
                   contatoGUI.getPaintMenu().setBackground(Color.darkGray);
                   setSelect(false);
                } else {
                    contatoGUI.getPaintMenu().setBackground(new Color(8, 77, 110));
                    setSelect(true);
                    getInicialScreenController().setCountMouseClicked(getInicialScreenController().getCountMouseClicked()+1);

                }

            }}

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                contatoGUI.getPaintMenu().setBackground(Color.black);
                contatoGUI.getNumeroTelefone().setVisible(true);
                contatoGUI.getPaintCategoria().setVisible(true);
                contatoGUI.getEmail().setVisible(true);
                contatoGUI.getData().setVisible(true);
                SelecionaCor(true);
                contatoGUI.getPaintMenu().repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                contatoGUI.getEmail().setVisible(false);
                contatoGUI.getNumeroTelefone().setVisible(false);
                contatoGUI.getPaintCategoria().setVisible(false);
                contatoGUI.getData().setVisible(false);
                contatoGUI.getPaintMenu().setBackground(Color.darkGray);
                SelecionaCor(false);
                contatoGUI.getPaintMenu().repaint();
            }

        });
    }

    public void SelecionaCor(boolean mouseEntered) {

        if (!isSelect()) {
            if (mouseEntered) {
                contatoGUI.getPaintMenu().setBackground(new Color(79,79,79));
            } else contatoGUI.getPaintMenu().setBackground(Color.darkGray);
        } else {
            contatoGUI.getPaintMenu().setBackground(new Color(8, 77, 110));

        }

    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public InicialScreenController getInicialScreenController() {
        return inicialScreenController;
    }

    public void setInicialScreenController(InicialScreenController inicialScreenController) {
        this.inicialScreenController = inicialScreenController;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public boolean isMouseClicked() {
        return mouseClicked;
    }

    public void setMouseClicked(boolean mouseClicked) {
        this.mouseClicked = mouseClicked;
    }

    public ContatosGUI getContatoGUI() {
        return contatoGUI;
    }

    public void setContatoGUI(ContatosGUI contatoGUI) {
        this.contatoGUI = contatoGUI;
    }

       
    public static int geraId() {
        int count = 0;
        ContatoList contatoList =  new ContatoDao().Listar();
        ContatoNO atual = contatoList.getInicio();
        while(atual!= null ){
                    
            if (count < atual.getContato().getId()) {
                count = atual.getContato().getId();
            }
            atual = atual.getProximo();
        
     
        }
    return count + 1;
    }
}
