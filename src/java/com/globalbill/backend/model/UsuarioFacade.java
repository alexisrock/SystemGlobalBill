/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.backend.model;

import com.globalbill.backend.Entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "JSFProdPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
  /*  
    public void registrarPedido(){
        em.getTransaction().begin();
        try{
        //1. insertar pedido
        //2. actualizar stock en producto
        em.getTransaction().commit();
        
        }catch(Exception e){
            
            //gestiono la excepcion
            em.getTransaction().rollback();
            em.flush();
        }
    }
    
    */
}
