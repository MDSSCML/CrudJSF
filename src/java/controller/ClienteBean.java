
package controller;

import dao.ClienteDao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;
import model.Cliente;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable{
    
    private ClienteDao clienteDAO;
    private Cliente cliente = new Cliente();
    private DataModel<Cliente> clientes;

    public void novo(){
        cliente = new Cliente();
    }

    public String inserir(){
        String resultado = "falha";
        clienteDAO = new ClienteDao();
        boolean retorno = clienteDAO.inserir(cliente);

        if(retorno){
            resultado = "clientes";
        }

        return resultado;
    }

    public void selecionar(){
        cliente = clientes.getRowData();
    }

    public String alterar(){
        String resultado = "falha";
        clienteDAO = new ClienteDao();
        boolean retorno = clienteDAO.alterar(cliente);

        if(retorno){
            resultado = "clientes";
        }

        return resultado;
    }

    public String remover(){
        String resultado = "falha";
        clienteDAO = new ClienteDao();
        boolean retorno = clienteDAO.remover(cliente);

        if(retorno){
            resultado = "clientes";
        }

        return resultado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DataModel<Cliente> getClientes() {
        clienteDAO = new ClienteDao();
        List<Cliente> clienteList = clienteDAO.listar();
        clientes = new ListDataModel<Cliente>(clienteList);
        return clientes;
    }

    public void setClientes(DataModel<Cliente> clientes) {
        this.clientes = clientes;
    }

}

    
