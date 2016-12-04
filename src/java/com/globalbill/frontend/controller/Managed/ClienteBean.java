/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.frontend.controller.Managed;

import com.globalbill.backend.Entities.Cliente;
import com.globalbill.backend.Entities.Usuario;
import com.globalbill.backend.Entities.Localidad;
import com.globalbill.backend.model.ClienteFacadeLocal;
import com.globalbill.backend.model.LocalidadFacadeLocal;
import com.globalbill.backend.model.UsuarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import java.util.List;
/**
 *
 * @author Administrador
 */
@Named(value = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @EJB
    private  ClienteFacadeLocal clientefacade;
    private Cliente cliente;
    private List<Cliente> clientelist;
    
    
    
     @EJB
      private LocalidadFacadeLocal localidadfacade;
    private List<Localidad> localidadlist;
    
     @EJB
     private UsuarioFacadeLocal usuariofacade;
     private List<Usuario> usuariolist;
     private Usuario usuario;
    
    public ClienteBean() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
       @PostConstruct()
public void init(){

   cliente= new Cliente();
    
}

    public List<Usuario> getUsuariolist() {
          usuariolist = usuariofacade.findAll();
        return usuariolist;
    }

    public void setUsuariolist(List<Usuario> usuariolist) {
              this.usuariolist = usuariolist;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Localidad> getLocalidadlist() {
        localidadlist = localidadfacade.findAll();
        return localidadlist;
    }

    public void setLocalidadlist(List<Localidad> localidadlist) {
        this.localidadlist = localidadlist;
    }

    public List<Cliente> getClientelist() {
        clientelist = clientefacade.findAll();
        return clientelist;
    }

    public void setClientelist(List<Cliente> clientelist) {
        this.clientelist = clientelist;
    }


    
    

    public void crearCliente(){
    
    try{
    clientefacade.create(cliente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "el cliente se ha registrado correctamente"));
      
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
    
 
    
 public void eliminarCliente(Cliente clien){
 try {
    clientefacade.remove(clien);

    }catch(Exception e){
    FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(
            FacesMessage.SEVERITY_ERROR,"Se produjo un error: ", e.getMessage()));
            
    }
 
 }

 public String EditarCliente(Cliente cli){
 cliente = cli;
 return"/faces/resources/Usuario/editarCliente.xhtml";
 
 }
 
 public String EditarCliente(){
 
 try{
   clientefacade.edit(cliente);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "","El cliente ha sido Editado correctamente"));

    return "/faces/resources/Usuario/eliminarCliente.xhtml";
   }
   
   catch(Exception e){
   
    FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(
            FacesMessage.SEVERITY_ERROR,"Se produjo un error: ", e.getMessage()));
            
   }
     return "/faces/resources/Usuario/eliminarCliente.xhtml";
 }
 
 
 
}
 
 
 
 
