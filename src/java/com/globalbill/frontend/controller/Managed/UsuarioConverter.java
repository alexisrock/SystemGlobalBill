/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.frontend.controller.Managed;

import com.globalbill.backend.Entities.Usuario;
import com.globalbill.backend.model.UsuarioFacadeLocal;




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
@FacesConverter(value = "usuarioConverter")
@SessionScoped
public class UsuarioConverter implements Converter {

    
        @EJB
    private UsuarioFacadeLocal usuarioFacad;
    /**
     * Creates a new instance of UsuarioConverter
     */
    public UsuarioConverter() {
    }
    
    @Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
        List<Usuario> user= usuarioFacad.findAll();
        for (Usuario objeto : user) {
            if (objeto.getCedula()== Integer.parseInt(valor)) {
                return objeto; 
            }
        }
        return null;
    }
@Override
   public String getAsString(FacesContext contexto, UIComponent componente, Object objeto) {
        if (objeto != null) {
            
            return ((Usuario) objeto).getCedula().toString();
        } else {
            return "";
        }
    }
    
}
