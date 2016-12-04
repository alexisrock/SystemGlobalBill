/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.frontend.controller.Managed;

import com.globalbill.backend.Entities.Ciudad;
import com.globalbill.backend.model.CiudadFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Administrador
 */
@Named(value = "ciudadBean")
@SessionScoped
public class CiudadController implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of CiudadBean
     */
      @EJB
      private CiudadFacadeLocal ciudadFacade;
      private Ciudad ciudad;
      
    public CiudadController() {
    }
    
    
     @PostConstruct()
public void init(){

    ciudad= new Ciudad();
    
}

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

public List <Ciudad> listarCiudad(){

return ciudadFacade.findAll();
}


}
