/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.backend.Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "estadofactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadofactura.findAll", query = "SELECT e FROM Estadofactura e"),
    @NamedQuery(name = "Estadofactura.findByIdEstadosFactura", query = "SELECT e FROM Estadofactura e WHERE e.idEstadosFactura = :idEstadosFactura"),
    @NamedQuery(name = "Estadofactura.findByNombre", query = "SELECT e FROM Estadofactura e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estadofactura.findByDescripcion", query = "SELECT e FROM Estadofactura e WHERE e.descripcion = :descripcion")})
public class Estadofactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEstadosFactura")
    private Integer idEstadosFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoFactura")
    private List<Estadoactual> estadoactualList;

    public Estadofactura() {
    }

    public Estadofactura(Integer idEstadosFactura) {
        this.idEstadosFactura = idEstadosFactura;
    }

    public Estadofactura(Integer idEstadosFactura, String nombre, String descripcion) {
        this.idEstadosFactura = idEstadosFactura;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdEstadosFactura() {
        return idEstadosFactura;
    }

    public void setIdEstadosFactura(Integer idEstadosFactura) {
        this.idEstadosFactura = idEstadosFactura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Estadoactual> getEstadoactualList() {
        return estadoactualList;
    }

    public void setEstadoactualList(List<Estadoactual> estadoactualList) {
        this.estadoactualList = estadoactualList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadosFactura != null ? idEstadosFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadofactura)) {
            return false;
        }
        Estadofactura other = (Estadofactura) object;
        if ((this.idEstadosFactura == null && other.idEstadosFactura != null) || (this.idEstadosFactura != null && !this.idEstadosFactura.equals(other.idEstadosFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.globalbill.backend.Entities.Estadofactura[ idEstadosFactura=" + idEstadosFactura + " ]";
    }
    
}
