/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.frontend.controller.Managed;

import com.globalbill.backend.Entities.Usuario;
import com.globalbill.backend.model.UsuarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Administrador
 */
@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioController implements Serializable {

       
    private static final long serialVersionUID = 1L;

    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    private Usuario usuario;
    
    
    
//    @PersistenceContext(unitName = "JSFProdPU")
//    private EntityManager em;
//    @Resource
//    private javax.transaction.UserTransaction utx;
//    
//    
    
    
    public UsuarioController() {
    }
  


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
       @PostConstruct()
    public void init(){

   usuario= new Usuario();
    
}
    
    public void crearUsuario(){
    
    try{
    usuarioFacade.create(usuario);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "","El usuario ha sido registrado correctamente"));
      

}catch(Exception e){
  FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(
            FacesMessage.SEVERITY_ERROR,"Se produjo un error: ", e.getMessage()));
            
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "Se produjo un error al insertar. "+ 
            "el codigo de la excepción es: ", e.getMessage());
            
            RequestContext.getCurrentInstance().showMessageInDialog(fm);
    
}
    
    }
    
    
    public List<Usuario> listarUsuario(){
        return usuarioFacade.findAll();
    }

    public void removerUsuario(Usuario usua){
    
        try {
    usuarioFacade.remove(usua);

    }catch(Exception e){
    FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(
            FacesMessage.SEVERITY_ERROR,"Se produjo un error: ", e.getMessage()));
            
    }
    
    }
    
    public String EditarUsuario(){    
    usuarioFacade.edit(usuario);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "","producto Editado correctamente"));
    return"/Faces/resources/Usuario/elimarUsuario.xhtml";
    }
    
    public String EditarUsuario(Usuario usua){
    usuario = usua;    
    return"/Faces/resources/Usuario/editarUsuario.xhtml";
    }

//    public void persist(Object object) {
//        try {
//            utx.begin();
//            em.persist(object);
//            utx.commit();
//        } catch (Exception e) {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
//            throw new RuntimeException(e);
//        }
//    }
    
  
    
    
    
    
}
