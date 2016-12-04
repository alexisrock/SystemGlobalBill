/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.backend.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByCedula", query = "SELECT e FROM Empleado e WHERE e.cedula = :cedula"),
    @NamedQuery(name = "Empleado.findByCelularAsignado", query = "SELECT e FROM Empleado e WHERE e.celularAsignado = :celularAsignado"),
    @NamedQuery(name = "Empleado.findByCargo", query = "SELECT e FROM Empleado e WHERE e.cargo = :cargo")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cedula")
    private Integer cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CelularAsignado")
    private String celularAsignado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 48)
    @Column(name = "Cargo")
    private String cargo;
    @JoinColumn(name = "idLocalidadAsignada", referencedColumnName = "idLocalidad")
    @ManyToOne(optional = false)
    private Localidad idLocalidadAsignada;
    @JoinColumn(name = "Cedula", referencedColumnName = "Cedula", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Empleado() {
    }

    public Empleado(Integer cedula) {
        this.cedula = cedula;
    }

    public Empleado(Integer cedula, String celularAsignado, String cargo) {
        this.cedula = cedula;
        this.celularAsignado = celularAsignado;
        this.cargo = cargo;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getCelularAsignado() {
        return celularAsignado;
    }

    public void setCelularAsignado(String celularAsignado) {
        this.celularAsignado = celularAsignado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Localidad getIdLocalidadAsignada() {
        return idLocalidadAsignada;
    }

    public void setIdLocalidadAsignada(Localidad idLocalidadAsignada) {
        this.idLocalidadAsignada = idLocalidadAsignada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.globalbill.backend.Entities.Empleado[ cedula=" + cedula + " ]";
    }
    
}
