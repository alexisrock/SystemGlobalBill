/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.frontend.controller.Managed;

import com.globalbill.backend.Entities.Detallefactura;
import com.globalbill.backend.Entities.Factura;
import com.globalbill.backend.Entities.Producto;
import com.globalbill.backend.model.DetallefacturaFacadeLocal;
import com.globalbill.backend.model.FacturaFacadeLocal;
import com.globalbill.backend.model.ProductoFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marihuanita
 */
@Named(value = "detalleFacturaController")
@SessionScoped
public class DetalleFacturaController implements Serializable {

                private static final long serialVersionUID = 1L;

    @EJB
    private FacturaFacadeLocal facturaFacade;
    private ProductoFacadeLocal productoFacade;

    @EJB
    private DetallefacturaFacadeLocal detalleFacturaFacade;
    private Detallefactura detalleFactura;
    private List<Factura> facturaList;
    private List<Producto> productoList;
    private List<Detallefactura> detalleFacturaList;

    public DetalleFacturaController() {
    }

    public DetalleFacturaController(Detallefactura detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public Detallefactura getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(Detallefactura detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public List<Detallefactura> getDetalleFacturaList() {
        detalleFacturaList = detalleFacturaFacade.findAll();
        return detalleFacturaList;
    }

    public void setDetalleFacturaList(List<Detallefactura> detalleFacturaList) {
        this.detalleFacturaList = detalleFacturaList;
    }

    public List<Factura> getFacturaList() {
        facturaList = facturaFacade.findAll();
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public List<Producto> getProductoList() {
        productoList = productoFacade.findAll();
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public void registrarDetalleFactura() {
        try {
            detalleFacturaFacade.create(detalleFactura);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO, "Se ha realizado la operación con éxito", "Se ha registrado los detalles de la factura"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Se produjo un error", "No se han podido registrar los detalles de la factura "));
        }
    }
    
    public void listarDetalleFactura(Factura idfac){
        try{
            detalleFacturaFacade.find(idfac);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
            FacesMessage.SEVERITY_ERROR, "Se produjo un error", "No se han podido listar los detalles de la factura "));
        }
    }
    
}
