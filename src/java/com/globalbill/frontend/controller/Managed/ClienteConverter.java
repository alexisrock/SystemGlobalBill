/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.frontend.controller.Managed;

import com.globalbill.backend.Entities.Cliente;
import com.globalbill.backend.model.ClienteFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


/**
 *
 * @author Global bill System
 */
@FacesConverter(value = "clienteConverter")
@SessionScoped
public class ClienteConverter implements Converter {

@EJB
private ClienteFacadeLocal clienteFacade;

    public ClienteConverter() {
    }
    
            @Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
        List<Cliente> cliente = this.clienteFacade.findAll();
        for (Cliente objeto : cliente) {
            if (objeto.getCedula()== Integer.parseInt(valor)) {
                return objeto;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
        if (objeto != null) {
            return ((Cliente) objeto).getCedula().toString();
        } else {
            return "";
        }
    }
    
}
