/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.frontend.controller.Managed;

import com.globalbill.backend.Entities.Ciudad;
import com.globalbill.backend.Entities.Localidad;
import com.globalbill.backend.model.CiudadFacadeLocal;
import com.globalbill.backend.model.LocalidadFacadeLocal;
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
@Named(value = "localidadBean")
@SessionScoped
public class LocalidadBean implements Serializable {
      private static final long serialVersionUID = 1L;
    @EJB
      private CiudadFacadeLocal ciudadFacade;
      
      @EJB
      private LocalidadFacadeLocal localidadfacade;
      private Localidad localidad;      
      private List<Ciudad> ciudadlist;
      private List<Localidad> localidadList;
      
   

    /**
     * Creates a new instance of LocalidadBean
     */
    public LocalidadBean() {
    }
     @PostConstruct()
public void init(){

    localidad= new Localidad();
    
}

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public List<Ciudad> getCiudadlist() {
        ciudadlist = ciudadFacade.findAll();
        return ciudadlist;
    }

    public void setCiudadlist(List<Ciudad> ciudadlist) {
        this.ciudadlist = ciudadlist;
    }

    public List<Localidad> getLocalidadList() {
        localidadList = localidadfacade.findAll();
        return localidadList;
    }

    public void setLocalidadList(List<Localidad> localidadList) {
        this.localidadList = localidadList;
    }


    
    
}
