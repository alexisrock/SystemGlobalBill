/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.frontend.controller.Managed;


import com.globalbill.backend.Entities.Cliente;
import com.globalbill.backend.Entities.Empleado;
import com.globalbill.backend.model.ClienteFacadeLocal;
import com.globalbill.backend.model.EmpleadoFacadeLocal;
import com.globalbill.backend.model.FacturaFacadeLocal;
import com.globalbill.backend.Entities.Factura;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

/**
 *
 * @author Global Bill System
 */
@Named(value = "facturaController")
@SessionScoped
public class FacturaController implements Serializable {

            private static final long serialVersionUID = 1L;

    @EJB
    private EmpleadoFacadeLocal empleadoFacade;
    @EJB
    private ClienteFacadeLocal clienteFacade;
    @EJB
    private FacturaFacadeLocal facturaFacade;
    private Factura factura;
    private List<Factura> facturaList;
    private List<Empleado> empleadoList;
    private List<Cliente> clienteList;

    public FacturaController() {
    }

    public FacturaController(Factura factura) {
        this.factura = factura;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public List<Factura> getFacturaList() {
        facturaList = facturaFacade.findAll();
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public List<Empleado> getEmpleadoList() {
        empleadoList = empleadoFacade.findAll();
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public List<Cliente> getClienteList() {
        clienteList = clienteFacade.findAll();
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public void registrarFactura() {
        try {
            facturaFacade.create(factura);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO, "Se ha realizado la operación con éxito", "Se ha registrado la factura"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Se ha producido un error", "No se ha podido registrar la factura"));
        }
    }

    public String editarFactura(Factura fac) {
        factura = fac;

        return "/sales/editarFactura";
    }

    public void editarFactura() {
        try {
            facturaFacade.create(factura);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO, "Se ha realizado la operación con éxito", "Se ha registrado la factura"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Se ha producido un error", "No se ha podido registrar la factura"));
        }
    }

 public String verdetallesfactura(Factura idfactua){
 DetalleFacturaController detalles = new DetalleFacturaController();
 detalles.listarDetalleFactura(idfactua);
 return"/faces/resources/factura/listardetallesfactura.xhtml";
 }
}
