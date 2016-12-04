/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.backend.model;

import com.globalbill.backend.Entities.Usuarioasignado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface UsuarioasignadoFacadeLocal {

    void create(Usuarioasignado usuarioasignado);

    void edit(Usuarioasignado usuarioasignado);

    void remove(Usuarioasignado usuarioasignado);

    Usuarioasignado find(Object id);

    List<Usuarioasignado> findAll();

    List<Usuarioasignado> findRange(int[] range);

    int count();    
    
    public Usuarioasignado iniciosession(String nombreUsuario, String contrasenia);
}
