
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;


public class ClienteDao {
    
    private Conexao conexao;
    private Statement stmt;
    private boolean sucesso = false;

    public ClienteDao() {
        conexao = new Conexao();
        try {
            stmt = (Statement) conexao.getConn().createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean inserir(Cliente cliente) {
        try {
            stmt.execute("INSERT INTO cliente (nome, descricao) VALUES ('" + cliente.getNome() + "','" + cliente.getDescricao() + "')");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return sucesso;
    }

    public boolean alterar(Cliente cliente) {
        try {
            stmt.execute("UPDATE cliente SET nome = '" + cliente.getNome() + "', descricao = '" + cliente.getDescricao() + "' WHERE id = '" + cliente.getId() + "'");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return sucesso;
    }

    public boolean remover(Cliente cliente) {
        try {
            stmt.execute("DELETE FROM cliente WHERE id = '" + cliente.getId() + "'");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return sucesso;
    }

    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente ORDER BY nome");
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setDescricao(rs.getString("descricao"));

                clientes.add(cliente);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return clientes;
    }
}


