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
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Global Bill System
 */
@Named(value = "actualizarProductoController")
@SessionScoped
public class ActualizarProductoController {
    
        private static final long serialVersionUID = 1L;


    @EJB
    private ProductoFacadeLocal productoFacade;

    @EJB
    private ActualizacionproductoFacadeLocal actualizacionFacade;
    private Actualizacionproducto actualizacionproducto;
    private List<Actualizacionproducto> actualist;
    private List<Producto> productolist;

    
    @PostConstruct()
    public void init() {
        actualizacionproducto = new Actualizacionproducto();
    }
    
    public ActualizarProductoController(Actualizacionproducto actualizacionproducto) {
        this.actualizacionproducto = actualizacionproducto;
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

    public String registrarActulizacion() {
        try {
            actualizacionFacade.create(actualizacionproducto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "producto registrado correctamente"));

            return " ";
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Se produjo un error: ", e.getMessage()));

            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Se produjo un error al insertar. "
                    + "el codigo de la excepción es: ", e.getMessage());

            RequestContext.getCurrentInstance().showMessageInDialog(fm);

        }
        return " ";
    }

    public String editarActualizacion(Actualizacionproducto actu) {
        actualizacionproducto = actu;

        return "/faces/resources/ActualizarProducto/editarActulizacion2.xhtml";
    }

    public String editarActualizacion() {
        actualizacionFacade.edit(actualizacionproducto);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "producto Editado correctamente"));
        return "/faces/resources/ActualizarProducto/editarActualizacion.xhtml";
    }

    public ActualizarProductoController() {
    }

}
