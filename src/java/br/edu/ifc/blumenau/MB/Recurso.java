/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifc.blumenau.MB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mateus
 */
@ManagedBean
@RequestScoped
public class Recurso {
    
    private String nomePagina;
    private String grupoPermitido;

    public String getNomePagina() {
        return nomePagina;
    }

    public void setNomePagina() {
        this.nomePagina = "admin";
    }

    public String getGrupoPermitido() {
        return grupoPermitido;
    }

    public void setGrupoPermitido() {
        this.grupoPermitido = "admin";
    }
    
    public String checkAcesso(Login login) {
        if(login.getUsuario().equals("bla")) {
            HttpSession session = SessionBean.getSession();
            session.setAttribute("usuario", login.getUsuario());
            return "admin";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Login e senha incorretos",
                    "Entre com login e senha corretos"));
            return "login";
        }
    }
    
    public String logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        return "login";
    }
    
}
