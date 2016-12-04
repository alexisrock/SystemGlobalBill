/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.backend.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "actualizacionproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actualizacionproducto.findAll", query = "SELECT a FROM Actualizacionproducto a"),
    @NamedQuery(name = "Actualizacionproducto.findByNumeroActualizacion", query = "SELECT a FROM Actualizacionproducto a WHERE a.numeroActualizacion = :numeroActualizacion"),
    @NamedQuery(name = "Actualizacionproducto.findByFechaActualizacion", query = "SELECT a FROM Actualizacionproducto a WHERE a.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Actualizacionproducto.findByNuevoValorUnitario", query = "SELECT a FROM Actualizacionproducto a WHERE a.nuevoValorUnitario = :nuevoValorUnitario")})
public class Actualizacionproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroActualizacion")
    private Integer numeroActualizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaActualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcionActualizacion")
    private String descripcionActualizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nuevoValorUnitario")
    private double nuevoValorUnitario;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public Actualizacionproducto() {
    }

    public Actualizacionproducto(Integer numeroActualizacion) {
        this.numeroActualizacion = numeroActualizacion;
    }

    public Actualizacionproducto(Integer numeroActualizacion, Date fechaActualizacion, double nuevoValorUnitario) {
        this.numeroActualizacion = numeroActualizacion;
        this.fechaActualizacion = fechaActualizacion;
        this.nuevoValorUnitario = nuevoValorUnitario;
    }

    public Integer getNumeroActualizacion() {
        return numeroActualizacion;
    }

    public void setNumeroActualizacion(Integer numeroActualizacion) {
        this.numeroActualizacion = numeroActualizacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getDescripcionActualizacion() {
        return descripcionActualizacion;
    }

    public void setDescripcionActualizacion(String descripcionActualizacion) {
        this.descripcionActualizacion = descripcionActualizacion;
    }

    public double getNuevoValorUnitario() {
        return nuevoValorUnitario;
    }

    public void setNuevoValorUnitario(double nuevoValorUnitario) {
        this.nuevoValorUnitario = nuevoValorUnitario;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroActualizacion != null ? numeroActualizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actualizacionproducto)) {
            return false;
        }
        Actualizacionproducto other = (Actualizacionproducto) object;
        if ((this.numeroActualizacion == null && other.numeroActualizacion != null) || (this.numeroActualizacion != null && !this.numeroActualizacion.equals(other.numeroActualizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.globalbill.backend.Entities.Actualizacionproducto[ numeroActualizacion=" + numeroActualizacion + " ]";
    }
    
}
