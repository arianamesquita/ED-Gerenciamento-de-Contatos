package database.DAO;

import database.DoublyLinkedLists;

public interface InterfaceDAO<T, K> {
    // Método para inserir um novo objeto no banco de dados
    void insert(T obj);
    
    // Método para atualizar um objeto existente no banco de dados
    void update(T obj);
    
    // Método para excluir um objeto do banco de dados usando a chave primária
    void delete(K id);
    
    // Método para buscar um objeto pelo seu ID (chave primária)
    T findById(K id);
    
    // Método para buscar todos os objetos da entidade no banco de dados
    DoublyLinkedLists<T> findAll();
}

