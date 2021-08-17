
package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    
    private String driver = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://localhost/Tenax";
    private String USER = "root";
    private String SENHA = "";
    private Connection conn;

    public Conexao() {
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(URL, USER, SENHA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
