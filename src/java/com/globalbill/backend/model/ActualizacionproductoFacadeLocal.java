/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.backend.model;

import com.globalbill.backend.Entities.Actualizacionproducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface ActualizacionproductoFacadeLocal {

    void create(Actualizacionproducto actualizacionproducto);

    void edit(Actualizacionproducto actualizacionproducto);

    void remove(Actualizacionproducto actualizacionproducto);

    Actualizacionproducto find(Object id);

    List<Actualizacionproducto> findAll();

    List<Actualizacionproducto> findRange(int[] range);

    int count();
    
}
