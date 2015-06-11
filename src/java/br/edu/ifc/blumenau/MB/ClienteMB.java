/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.blumenau.MB;

import br.edu.ifc.blumenau.DAO.ClienteDAO;
import br.edu.ifc.blumenau.DTO.ClienteDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author ederaugusto
 */

@RequestScoped
@ManagedBean(name = "clienteMB")
public class ClienteMB {
    
    ClienteDTO cliente = null;

    public ClienteDTO getCliente() {
        if (cliente == null)
            cliente = new ClienteDTO();
        return cliente;
    }
    
    public DataModel<ClienteDTO> getClientes() {
        DataModel<ClienteDTO> clientes = null;
        ClienteDAO clienteDAO = new ClienteDAO();
        try {
            clientes = new ListDataModel(clienteDAO.listar());
        } catch (SQLException ex) {
            Logger.getLogger(ClienteMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
    

    public String inserir() {     
        ClienteDAO clienteDAO = new ClienteDAO();
        try {
            clienteDAO.inserir(cliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "sucesso";
    }
    
    public String excluir(int id) {
        ClienteDAO clienteDAO = new ClienteDAO();
        try {
            clienteDAO.excluir(id);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteMB.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return "sucesso";
    }
    
}
