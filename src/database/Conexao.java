package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexao {
    private String jDBString;
    private String user,senha;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private final String driver = "com.mysql.cj.jdbc.Driver";
    
    public Conexao(String local,String porta, String bd,  String user, String senha) {
        this.jDBString = "jdbc:mysql://"+ local +":" + porta +"/"+ bd;
        this.user = user;
        this.senha = senha;
    }

    public void Conecta(){
        try {
            Class.forName(getDriver());
            setConnection(DriverManager.getConnection(getjDBString(), getUser(), getSenha()));
            setStatement(getConnection().createStatement());
            JOptionPane.showMessageDialog(null, "banco de dados conectado com sucesso");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "não foi possivel conectar ao banco de dados erro:\n"+e);
        }
    }
    public void Desconecta(){
        try {
            getResultSet().close();
            getStatement().close();
            getConnection().close();
            JOptionPane.showMessageDialog(null, "banco de dados desconectado com sucesso");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "não foi possivel desconectar o banco de dados erro:\n"+e);
        }
    }
    
    public void ExecuteQuery(String sqlsString){
        try {
            setResultSet(getStatement().executeQuery(sqlsString));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "não foi possivel execultar a Query erro:\n"+e);

        }
    }
    
    public void ConfigUser(String user, String senha) {
		setUser(user);
		setSenha(senha);
	}

    public String getjDBString() {
        return jDBString;
    }
    public void setjDBString(String jDBString) {
        this.jDBString = jDBString;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public Statement getStatement() {
        return statement;
    }
    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    public ResultSet getResultSet() {
        return resultSet;
    }
    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
    public String getDriver() {
        return driver;
    }    
}
