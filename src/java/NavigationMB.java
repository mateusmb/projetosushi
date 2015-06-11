/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author mateus
 */
@ManagedBean
@RequestScoped
public class NavigationMB {

    /**
     * Creates a new instance of NavigationMB
     */
    public String redirectToLogin() {
        return "/Login/login.xhtml?faces-redirect=true";
    }
    
    public String toLogin() {
        return "/Login/login.xhtml";
    }
    
    public String redirectToInfo() {
        return "/info/info.xhtl?faces-redirect=true";
    }
    
    public String toInfo() {
        return "/info/info.xhtml";
    }
    
    public String redirectToWelcome() {
        return "/secured/welcome.xhtml?faces-redirect=true";
    }
    
    public String toWelcome() {
        return "/secured/welcome.xhtml";
    }
    
    public NavigationMB() {
    }
    
}
