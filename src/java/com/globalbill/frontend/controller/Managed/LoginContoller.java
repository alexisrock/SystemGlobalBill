/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.frontend.controller.Managed;

import com.globalbill.backend.Entities.Usuarioasignado;
import com.globalbill.backend.model.UsuarioFacade;
import com.globalbill.backend.model.UsuarioasignadoFacade;
import com.globalbill.backend.model.UsuarioasignadoFacadeLocal;
import javax.inject.Named;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Administrador
 */
//@Named(value = "loginContoller")
@ManagedBean
@SessionScoped
public class LoginContoller implements Serializable {
    private static final long serialVersionUID = 1L;
 
        
    @EJB
    private  UsuarioasignadoFacadeLocal usuarioF;
    
    private Usuarioasignado usuarioa;
    
    private  HttpServletRequest hsr;
    private  FacesContext fcontext;
    private FacesMessage fmessage;
    
    public LoginContoller() {
  
    }
    
    
   public String validarUsuario(){
  Usuarioasignado u = usuarioF.iniciosession(usuarioa.getNombreUsuario(), usuarioa.getContrasenia());
     if (u!= null){
     hsr.getSession().getAttribute("Usuariologueado");
     return "/faces/home.xhtml";
     }else{
      
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "Se produjo un error", "usuario y/o la contraseña no son validos");
            FacesContext.getCurrentInstance().addMessage(null, fm);
       
     }


  return "";
   }
           
  
   
   

    public Usuarioasignado getUsuarioa() {
        return usuarioa;
    }

    public void setUsuarioa(Usuarioasignado usuarioa) {
        this.usuarioa = usuarioa;
    }
    
    
    @PostConstruct
    
public void init(){

     usuarioa= new Usuarioasignado();
     fcontext =  FacesContext.getCurrentInstance();
    hsr = (HttpServletRequest) fcontext.getExternalContext().getRequest();
}
    
}
