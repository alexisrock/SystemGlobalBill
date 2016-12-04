/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.backend.model;

import com.globalbill.backend.Entities.Entregatalonario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface EntregatalonarioFacadeLocal {

    void create(Entregatalonario entregatalonario);

    void edit(Entregatalonario entregatalonario);

    void remove(Entregatalonario entregatalonario);

    Entregatalonario find(Object id);

    List<Entregatalonario> findAll();

    List<Entregatalonario> findRange(int[] range);

    int count();
    
}
