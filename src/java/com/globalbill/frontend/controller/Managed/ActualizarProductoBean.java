/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.frontend.controller.Managed;

import com.globalbill.backend.Entities.Actualizacionproducto;
import com.globalbill.backend.Entities.Producto;
import com.globalbill.backend.model.ActualizacionproductoFacadeLocal;
import com.globalbill.backend.model.ProductoFacadeLocal;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Administrador
 */
@Named(value = "actualizarProductoBean")
@SessionScoped
public class ActualizarProductoBean implements Serializable {

    /**
     * Creates a new instance of ActualizarProductoBean
     */
    
    @EJB
    private ProductoFacadeLocal productoFacade;
    
    @EJB
    private ActualizacionproductoFacadeLocal actualizacionFacade;
    private Actualizacionproducto actualizacionproducto;
    private List<Actualizacionproducto> actualist;
    private List<Producto> productolist;
    
  
    
    
    public ActualizarProductoBean() {
        actualizacionproducto = new Actualizacionproducto();
    }

    public Actualizacionproducto getActualizacionproducto() {
        return actualizacionproducto;
    }

    public void setActualizacionproducto(Actualizacionproducto actualizacionproducto) {
        this.actualizacionproducto = actualizacionproducto;
    }

    public List<Actualizacionproducto> getActualist() {
        actualist = actualizacionFacade.findAll();
        return actualist;
    }

    public void setActualist(List<Actualizacionproducto> actualist) {
        this.actualist = actualist;
    }

    public List<Producto> getProductolist() {
        productolist = productoFacade.findAll();
        return productolist;
    }

    public void setProductolist(List<Producto> productolist) {
        this.productolist = productolist;
    }
    
    public String registrarActulizacion(){
        try{
        actualizacionFacade.create(actualizacionproducto);
            System.out.println("numero de registros"+productolist.size());
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "producto registrado correctamente"));
         

        return " ";
      }catch(Exception e){
  FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(
            FacesMessage.SEVERITY_ERROR,"Se produjo un error: ", e.getMessage()));
            
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "Se produjo un error al insertar. "+ 
            "el codigo de la excepción es: ", e.getMessage());
            
            RequestContext.getCurrentInstance().showMessageInDialog(fm);
    
        }
        return " ";
    }
      
    
    
    public String editaractualizacion(Actualizacionproducto actu){
        actualizacionproducto = actu; 
        
        return "/faces/resources/ActualizarProducto/editarActulizacion2.xhtml";
    }
    public String editaactualizacion(){
    actualizacionFacade.edit(actualizacionproducto);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "","producto Editado correctamente"));
     return "/faces/resources/ActualizarProducto/editarActualizacion.xhtml";
    }
    
}
