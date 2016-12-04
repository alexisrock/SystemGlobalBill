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
@Table(name = "estadoactual")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadoactual.findAll", query = "SELECT e FROM Estadoactual e"),
    @NamedQuery(name = "Estadoactual.findByIdEstadoActual", query = "SELECT e FROM Estadoactual e WHERE e.idEstadoActual = :idEstadoActual"),
    @NamedQuery(name = "Estadoactual.findByFecha", query = "SELECT e FROM Estadoactual e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Estadoactual.findByObservaciones", query = "SELECT e FROM Estadoactual e WHERE e.observaciones = :observaciones")})
public class Estadoactual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEstadoActual")
    private Integer idEstadoActual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 255)
    @Column(name = "Observaciones")
    private String observaciones;
    @JoinColumn(name = "idFactura", referencedColumnName = "idFactura")
    @ManyToOne(optional = false)
    private Factura idFactura;
    @JoinColumn(name = "idEstadoFactura", referencedColumnName = "idEstadosFactura")
    @ManyToOne(optional = false)
    private Estadofactura idEstadoFactura;

    public Estadoactual() {
    }

    public Estadoactual(Integer idEstadoActual) {
        this.idEstadoActual = idEstadoActual;
    }

    public Estadoactual(Integer idEstadoActual, Date fecha) {
        this.idEstadoActual = idEstadoActual;
        this.fecha = fecha;
    }

    public Integer getIdEstadoActual() {
        return idEstadoActual;
    }

    public void setIdEstadoActual(Integer idEstadoActual) {
        this.idEstadoActual = idEstadoActual;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }

    public Estadofactura getIdEstadoFactura() {
        return idEstadoFactura;
    }

    public void setIdEstadoFactura(Estadofactura idEstadoFactura) {
        this.idEstadoFactura = idEstadoFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoActual != null ? idEstadoActual.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadoactual)) {
            return false;
        }
        Estadoactual other = (Estadoactual) object;
        if ((this.idEstadoActual == null && other.idEstadoActual != null) || (this.idEstadoActual != null && !this.idEstadoActual.equals(other.idEstadoActual))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.globalbill.backend.Entities.Estadoactual[ idEstadoActual=" + idEstadoActual + " ]";
    }
    
}
