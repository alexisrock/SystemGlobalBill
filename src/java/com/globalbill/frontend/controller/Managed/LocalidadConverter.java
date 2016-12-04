/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.frontend.controller.Managed;

import com.globalbill.backend.Entities.Localidad;
import com.globalbill.backend.model.LocalidadFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Administrador
 */
@FacesConverter(value = "localidadConverter")
@SessionScoped
public class LocalidadConverter implements Converter{
     @EJB
      private LocalidadFacadeLocal localidadfacade;
    
     
     public LocalidadConverter() {
    }
@Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
        List<Localidad> localid= this.localidadfacade.findAll();
        for (Localidad objeto :localid) {
            if (objeto.getIdLocalidad()== Integer.parseInt(valor)) {
                return objeto; 
            }
        }
        return null;
    }
@Override
    public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
        if (objeto != null) {
            return ((Localidad) objeto).getIdLocalidad().toString();
        } else {
            return "";
        }
    }
    
   
    
}
