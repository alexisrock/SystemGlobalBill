/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.backend.model;

import com.globalbill.backend.Entities.Usuarioasignado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Administrador
 */
@Stateless
public class UsuarioasignadoFacade extends AbstractFacade<Usuarioasignado> implements UsuarioasignadoFacadeLocal {

    @PersistenceContext(unitName = "JSFProdPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioasignadoFacade() {
        super(Usuarioasignado.class);
    }
    
    @Override
     public Usuarioasignado iniciosession(String nombreUsuario, String contrasenia){
    
    Usuarioasignado usuario = null;
    TypedQuery<Usuarioasignado> query = em.createNamedQuery("usuariolog", Usuarioasignado.class);
    query.setParameter(1, nombreUsuario);
    query.setParameter(2, contrasenia);
    List<Usuarioasignado> usuriosas = query.getResultList();
    if (usuriosas.size()==1){
    
   usuario =   usuriosas.get(0);
    }
    return null;
    
    
    }
    
     
}
