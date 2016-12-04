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
@Table(name = "asignacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignacion.findAll", query = "SELECT a FROM Asignacion a"),
    @NamedQuery(name = "Asignacion.findByIdAsignacion", query = "SELECT a FROM Asignacion a WHERE a.idAsignacion = :idAsignacion"),
    @NamedQuery(name = "Asignacion.findByFecha", query = "SELECT a FROM Asignacion a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Asignacion.findByValorAbonado", query = "SELECT a FROM Asignacion a WHERE a.valorAbonado = :valorAbonado"),
    @NamedQuery(name = "Asignacion.findByProximaFechaRecaudo", query = "SELECT a FROM Asignacion a WHERE a.proximaFechaRecaudo = :proximaFechaRecaudo"),
    @NamedQuery(name = "Asignacion.findByObservaciones", query = "SELECT a FROM Asignacion a WHERE a.observaciones = :observaciones")})
public class Asignacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAsignacion")
    private Integer idAsignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorAbonado")
    private double valorAbonado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proximaFechaRecaudo")
    @Temporal(TemporalType.DATE)
    private Date proximaFechaRecaudo;
    @Size(max = 255)
    @Column(name = "Observaciones")
    private String observaciones;
    @JoinColumn(name = "idTalonario", referencedColumnName = "idTalonario")
    @ManyToOne(optional = false)
    private Talonario idTalonario;
    @JoinColumn(name = "idFactura", referencedColumnName = "idFactura")
    @ManyToOne(optional = false)
    private Factura idFactura;

    public Asignacion() {
    }

    public Asignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Asignacion(Integer idAsignacion, Date fecha, double valorAbonado, Date proximaFechaRecaudo) {
        this.idAsignacion = idAsignacion;
        this.fecha = fecha;
        this.valorAbonado = valorAbonado;
        this.proximaFechaRecaudo = proximaFechaRecaudo;
    }

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValorAbonado() {
        return valorAbonado;
    }

    public void setValorAbonado(double valorAbonado) {
        this.valorAbonado = valorAbonado;
    }

    public Date getProximaFechaRecaudo() {
        return proximaFechaRecaudo;
    }

    public void setProximaFechaRecaudo(Date proximaFechaRecaudo) {
        this.proximaFechaRecaudo = proximaFechaRecaudo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Talonario getIdTalonario() {
        return idTalonario;
    }

    public void setIdTalonario(Talonario idTalonario) {
        this.idTalonario = idTalonario;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignacion != null ? idAsignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignacion)) {
            return false;
        }
        Asignacion other = (Asignacion) object;
        if ((this.idAsignacion == null && other.idAsignacion != null) || (this.idAsignacion != null && !this.idAsignacion.equals(other.idAsignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.globalbill.backend.Entities.Asignacion[ idAsignacion=" + idAsignacion + " ]";
    }
    
}
