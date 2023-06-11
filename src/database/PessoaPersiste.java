package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import model.Pessoa;

public class PessoaPersiste extends Pessoa {

    public String pathFile = "C:\\Users\\arian\\eclipse-workspace\\gerenciamentocontatos\\file\\categoria\\";

    public void gravar (Pessoa pessoa){
        try {
			FileOutputStream file = new FileOutputStream(pathFile + pessoa.getId());
			ObjectOutputStream stream = new ObjectOutputStream(file);
			stream.writeObject(pessoa);
			stream.flush();
		}
		catch (Exception erro) {
			System.out.print("Falha na gravacao.\n" + erro.toString());
		}
		System.out.print("Emprestimo armazenado com sucesso!\n\n");
    }

    public Pessoa ler (int id){
		try {
			FileInputStream file = new FileInputStream(pathFile + id);
			ObjectInputStream stream = new ObjectInputStream(file);
			return ((Pessoa) stream.readObject());
		} catch (Exception erro) {
			System.out.println("Falha na leitura.\n" + erro.toString());
			return null;
		}
    }

    public Pessoa apagar (int id) throws IOException{
		File file = new File(pathFile + id);
		OutputStream out = new FileOutputStream(file, false);
		try {
			out.write("Test".getBytes());
		} finally {
			out.flush();
			out.close();		
			out = null;
			System.gc();
		}
		file.deleteOnExit();
		if (!file.delete()) {
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
