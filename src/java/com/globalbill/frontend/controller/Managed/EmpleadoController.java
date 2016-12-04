/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.frontend.controller.Managed;


import com.globalbill.backend.Entities.Empleado;
import com.globalbill.backend.Entities.Localidad;
import com.globalbill.backend.Entities.Usuario;
import com.globalbill.backend.model.EmpleadoFacadeLocal;
import com.globalbill.backend.model.LocalidadFacadeLocal;
import com.globalbill.backend.model.UsuarioFacadeLocal;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Global bill System
 */
@Named(value = "empleadoController")
@SessionScoped
public class EmpleadoController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EJB
    private EmpleadoFacadeLocal empleadoFacade;
    private Empleado empleado;
    private List<Empleado> empleadolist;
    
     @EJB
      private LocalidadFacadeLocal localidadfacade;
    private List<Localidad> localidadlist;
    
    @EJB
     private UsuarioFacadeLocal usuariofacade;
     private List<Usuario> usuariolist;
     private Usuario usuario;
    
    public EmpleadoController() {
    }

    public EmpleadoController(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Localidad> getLocalidadlist() {
         localidadlist = localidadfacade.findAll();
        return localidadlist;
    }

    public void setLocalidadlist(List<Localidad> localidadlist) {
        this.localidadlist = localidadlist;
    }

    
    public void registrarEmpleado() {
        try {
            empleadoFacade.create(empleado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO, "Se ha realizado la acción con éxito", "Se ha registrado el empleado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Se ha producido un error", "No se ha podido registrar el empleado"));
        }
    }

    public String editarEmpleado(Empleado emp) {
        empleado = emp;
        return "/Faces/Resources/empleados/editarempleado.xhtml";
    }

    public String editarEmpleado() {
        try {
            empleadoFacade.edit(empleado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO, "Se ha realizado la edición", "Se han guardado los cambios realizados"));
         return "/Faces/Resources/empleados/eliminarempleado.xhtml";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Se ha producido un error", "No se ha podido editar los cambios"));
        }
         return "/Faces/Resources/empleados/eliminarempleado.xhtml";
    }

    public void eliminarEmpleado(Empleado emple) {
          empleadoFacade.remove(emple);
       
    }

    public List<Empleado> getEmpleadolist() {
       empleadolist= empleadoFacade.findAll();
        return empleadolist;
    }

    public void setEmpleadolist(List<Empleado> empleadolist) {
        this.empleadolist = empleadolist;
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
    
       
   
        
      
   
    
}


