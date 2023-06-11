package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import model.Categoria;

public class CategoriaPersiste extends Categoria{

    public String pathFile = "C:\\Users\\arian\\eclipse-workspace\\gerenciamentocontatos\\file\\categoria\\";

    public void gravar (Categoria categoria){
        try {
            FileOutputStream file = new FileOutputStream(pathFile + categoria.getNome());
            ObjectOutputStream stream = new ObjectOutputStream(file);
            stream.writeObject(categoria);
            stream.flush();
        } catch (Exception erro){
            System.out.println("Falha na gravação.\n" + erro.toString());
        } System.out.println("Emprestimo armazenado com sucesso!\n\n");
    }

    public Categoria ler (String nome){
        try {
            FileInputStream file = new FileInputStream(pathFile + nome);
            ObjectInputStream stream = new ObjectInputStream(file);
            return ((Categoria) stream.readObject());
        } catch (Exception erro){
            System.out.println("Falha na leitura.\n" + erro.toString());
            return null;
        }
    }

    public Categoria apagar (String nome) throws IOException {
        File file = new File(pathFile + nome);
        OutputStream out = new FileOutputStream(file, false);
        try{
            out.write("Test".getBytes());
        } finally {
            out.flush();
            out.close();
            out = null;
            System.gc();
        }
        file.deleteOnExit();
        if (!file.delete()){
            throw new IOException("Não foi possível deletar o arquivo.");
        } 
        return null;
    }

    public String[] listarArquivos(){
        String[] lista = new String[100];
        int i = 0;
        try {
            File arquivos = new File(pathFile);
            for (File arqFile : arquivos.listFiles()) {
                String nomes = arqFile.getName();
                lista[i] = nomes;
                i++;
            }
        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return lista;
    }
}
