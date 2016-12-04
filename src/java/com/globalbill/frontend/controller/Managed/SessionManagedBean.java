/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.frontend.controller.Managed;


import com.globalbill.backend.Entities.Usuarioasignado;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrador
 */
@Named(value = "sessionManagedBean")
@SessionScoped
public class SessionManagedBean implements Serializable {

    private final HttpServletRequest hsr;
    private final FacesContext fcontext;
    private  Usuarioasignado  usuariovalido;

   
    public  Usuarioasignado getUsuariovalido() {
        return usuariovalido;
    }

    public void setUsuariovalido( Usuarioasignado usuariovalido) {
        this.usuariovalido = usuariovalido;
    }
    
     public SessionManagedBean() {
        fcontext = FacesContext.getCurrentInstance();
        hsr = (HttpServletRequest) fcontext.getExternalContext().getRequest();
        if (hsr.getSession().getAttribute("Usuariologueado") != null) {
            usuariovalido = ( Usuarioasignado) hsr.getSession().getAttribute("Usuariologueado");

        }

    }

    public String cerrarSesion() {

        hsr.getSession().removeAttribute("Usuariologueado");
        hsr.getSession().invalidate();
        return "index.html";
    }
     @PostConstruct()
public void init(){

    usuariovalido= new Usuarioasignado();
    
}

}
