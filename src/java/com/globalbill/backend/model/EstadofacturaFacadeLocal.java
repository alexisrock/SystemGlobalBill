/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.backend.model;

import com.globalbill.backend.Entities.Estadofactura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface EstadofacturaFacadeLocal {

    void create(Estadofactura estadofactura);

    void edit(Estadofactura estadofactura);

    void remove(Estadofactura estadofactura);

    Estadofactura find(Object id);

    List<Estadofactura> findAll();

    List<Estadofactura> findRange(int[] range);

    int count();
    
}
