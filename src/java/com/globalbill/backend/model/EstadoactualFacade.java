/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.backend.model;

import com.globalbill.backend.Entities.Estadoactual;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class EstadoactualFacade extends AbstractFacade<Estadoactual> implements EstadoactualFacadeLocal {

    @PersistenceContext(unitName = "JSFProdPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoactualFacade() {
        super(Estadoactual.class);
    }
    
}
