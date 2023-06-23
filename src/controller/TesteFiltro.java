package controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import database.CategoriaDAO;
import database.ContatoDao;
import database.PessoaDAO;
import database.createList.DoublyLinkedLists.ContatoList;
import database.createList.NOs.ContatoNO;
import model.Categoria;
import model.Contato;
import model.Pessoa;

public class TesteFiltro {


    public static void main(String[] args) {
        
        
        
        //CategoriaDAO categoriaDAO = new CategoriaDAO();
        //Categoria nova = new Categoria();
        //nova = categoriaDAO.searchById(2);
        //categoriaDAO.save("teste");
        //categoriaDAO.removeByName("teste"); // temos o remove por ID e por nome
        //nova = categoriaDAO.searchByName("amigos");
        //System.out.println(nova);
        //categoriaDAO.update(nova, "teste2");


        /*Pessoa pessoa = new Pessoa();
        pessoa.setNome("Julia");
        pessoa.setEmail("juliaTurn@yahoo.com");
        pessoa.setTelefone("44999926597");

        nova = categoriaDAO.searchById(4);
        Contato contatoteste = new Contato();
        contatoteste.setPessoa(pessoa);
        contatoteste.setCategoria(nova);*/

        //ContatoDao contatoDao = new ContatoDao();
        //contatoDao.save(contatoteste);
        //contatoDao.removeById(15);
        //contatoDao.searchByName("Ariana");
        //ContatoList novalista = new ContatoList();

        /*System.out.println("--------------------------------");
        
        long startTime = System.currentTimeMillis(); // Registra o tempo final
        novalista = contatoDao.Listar();
        novalista.imprimir();
        long endTime = System.currentTimeMillis(); // Registra o tempo final
        long totalTime = endTime - startTime; // Calcula o tempo total em milissegundos
        System.out.println(totalTime);*/
        

        //PessoaDAO pessoaDAO = new PessoaDAO();
        //Pessoa pessoateste = new Pessoa();
        //pessoaDAO.save(pessoa);
        //pessoateste = pessoaDAO.searchByName("Fabiane");
        //System.out.println(pessoateste);





        
        
        ContatoDao contatoDao = new ContatoDao();
        ContatoList contatoList = contatoDao.Listar();
        TesteFiltro teste = new TesteFiltro();
        teste.quickSort(contatoList, "ddd");
        contatoList.imprimir();
        
        
    }


    public void quickSort(ContatoList contatos, String filtro) {
        quickSortRec(contatos, contatos.getInicio(), contatos.getFim(), filtro);
    }

    private void quickSortRec(ContatoList contatos, ContatoNO inicio, ContatoNO fim, String filtro) {
        if (inicio != null && fim != null && inicio != fim && inicio != fim.getProximo()) {
            ContatoNO pivot = partition(inicio, fim, filtro);
            quickSortRec(contatos, inicio, pivot.getAnterior(), filtro);
            quickSortRec(contatos, pivot.getProximo(), fim, filtro);
        }
    }

    private ContatoNO partition(ContatoNO inicio, ContatoNO fim, String filtro) {
        Contato pivot = fim.getContato();
        ContatoNO i = inicio.getAnterior();
        
        for (ContatoNO j = inicio; j != fim; j = j.getProximo()) {
            if (filtro.equals("ddd")){
                if (Integer.parseInt(j.getContato().getPessoa().getTelefone().substring(0,2)) 
                    <= Integer.parseInt(pivot.getPessoa().getTelefone().substring(0, 2))) {
                    i = (i == null) ? inicio : i.getProximo();
                    swap(i, j);
                }
            }
            else if (filtro.equals("categoria")){
                if (j.getContato().getCategoria().getId() <= pivot.getCategoria().getId()) {
                    i = (i == null) ? inicio : i.getProximo();
                    swap(i, j);
                }
            }
            else if (filtro.equals("nome")){ //esse acho q não precisa né, amigo?
                if (j.getContato().getPessoa().getNome().charAt(0) <= 
                        pivot.getPessoa().getNome().charAt(0)){
                    i = (i == null) ? inicio : i.getProximo();
                    swap(i, j); 
                }
            }
            else if (filtro.equals("email")){ 
                if (j.getContato().getPessoa().getEmail().charAt(0) <= 
                        pivot.getPessoa().getEmail().charAt(0)){
                    i = (i == null) ? inicio : i.getProximo();
                    swap(i, j); 
                }
            }

        }
        
        i = (i == null) ? inicio : i.getProximo();
        swap(i, fim);
        
        return i;
    }

    private void swap(ContatoNO no1, ContatoNO no2) {
        Contato temp = no1.getContato();
        no1.setContato(no2.getContato());
        no2.setContato(temp);
    }



    
}
