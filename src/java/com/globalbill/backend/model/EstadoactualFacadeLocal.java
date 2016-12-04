/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.backend.model;

import com.globalbill.backend.Entities.Estadoactual;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface EstadoactualFacadeLocal {

    void create(Estadoactual estadoactual);

    void edit(Estadoactual estadoactual);

    void remove(Estadoactual estadoactual);

    Estadoactual find(Object id);

    List<Estadoactual> findAll();

    List<Estadoactual> findRange(int[] range);

    int count();
    
}
