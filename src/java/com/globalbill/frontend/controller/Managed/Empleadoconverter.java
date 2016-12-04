/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.frontend.controller.Managed;


import com.globalbill.backend.Entities.Empleado;
import com.globalbill.backend.model.EmpleadoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;



/**
 *
 * @author Global Bill System
 */
@FacesConverter(value = "empleadoconverter")
@SessionScoped
public class Empleadoconverter implements Converter {

@EJB
private EmpleadoFacadeLocal empleadoFacade;
    
    public Empleadoconverter() {
    }
    
        @Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
        List<Empleado> empleado = this.empleadoFacade.findAll();
        for (Empleado objeto : empleado) {
            if (objeto.getCedula()== Integer.parseInt(valor)) {
                return objeto;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
        if (objeto != null) {
            return ((Empleado) objeto).getCedula().toString();
        } else {
            return "";
        }
    }

}
    
