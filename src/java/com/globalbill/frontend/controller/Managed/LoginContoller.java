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
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;


import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Administrador
 */
//@Named(value = "loginContoller")
@Named(value="loginContoller")
@SessionScoped
public class LoginContoller implements Serializable {
 
        
    @EJB
    private  UsuarioasignadoFacadeLocal usuarioF;
    
    private Usuarioasignado usuarioa;
        
    public LoginContoller() {
  
    }
    
    
   public String validarUsuario(){
       String url = null;
        Usuarioasignado usuariovalido;
        usuariovalido = usuarioF.iniciosession(this.usuarioa);
     try{
       if (usuariovalido != null){
           HttpSession sesion = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
             sesion.setAttribute("usuarioLogin", usuariovalido);             
           url = "/protegido/index.xhtml?faces-redirect=true";
           System.out.println("despues del url");
     }else{
           System.out.println("hago esto");
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "usuario y/o la contraseña no son validos", "");
            FacesContext.getCurrentInstance().addMessage(null, fm);
       
     }
     }catch(Exception e){
          FacesContext.getCurrentInstance().addMessage(
                    null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error: ", "datos incorrectos"));
        
     
     }
       System.out.println("linea final");
return url;
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
     
 
}
    
}
