/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.blumenau.MB;

import br.edu.ifc.blumenau.DAO.ClienteDAO;
import br.edu.ifc.blumenau.DTO.ClienteDTO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
    
}
