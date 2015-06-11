/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author mateus
 */
@ManagedBean
@RequestScoped
public class LoginMB implements Serializable {

    /**
     * Creates a new instance of LoginMB
     */
    
    private static final String user = "bla";
    private static final String pass = "bla";
    
    private String username;
    private String password;
    
    private boolean loggedIn;
    
    @ManagedProperty(value="#{navigationMB}")
    private NavigationMB navigationMB;
    
    public String doLogin() {
        if(user.equals(username) && pass.equals(password)){
            loggedIn = true;
            System.out.println("Cheguei");
            return "sucesso";
        }
        
        FacesMessage message = new FacesMessage("Erro no login!", "ERROR MSG");
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, message);
        return navigationMB.toLogin();
    }
    
    public String doLogout() {
        loggedIn = false;
        FacesMessage message = new FacesMessage("Logout com sucesso!", "INFO MSG");
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, message);
        return navigationMB.toLogin();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    
    public void setNavigationMB(NavigationMB navigationMB) {
        this.navigationMB = navigationMB;
    }
    
    public LoginMB() {
    }
    
}
