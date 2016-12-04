/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.frontend.controller.Managed;

import com.globalbill.backend.Entities.Producto;
import com.globalbill.backend.model.ProductoFacadeLocal;
import javax.faces.bean.SessionScoped;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


/**
 *
 * @author Administrador
 */
@FacesConverter(value = "productoConverter")
@SessionScoped
public class ProductoConverter implements Converter {

   @EJB
   private ProductoFacadeLocal productoFacade;
    
    
    
    public ProductoConverter() {
    }
@Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
        List<Producto> produc= productoFacade.findAll();
        for (Producto objeto : produc) {
            if (objeto.getIdProducto()== Integer.parseInt(valor)) {
                return objeto; 
            }
        }
        return null;
    }
@Override
    public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
        if (objeto != null) {
            return ((Producto) objeto).getIdProducto().toString();
        } else {
            return "";
        }
    }

    
   
   
}