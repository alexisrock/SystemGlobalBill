/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.backend.model;

import com.globalbill.backend.Entities.Talonario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface TalonarioFacadeLocal {

    void create(Talonario talonario);

    void edit(Talonario talonario);

    void remove(Talonario talonario);

    Talonario find(Object id);

    List<Talonario> findAll();

    List<Talonario> findRange(int[] range);

    int count();
    
}
