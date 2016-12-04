/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globalbill.backend.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura"),
    @NamedQuery(name = "Factura.findByFechaVenta", query = "SELECT f FROM Factura f WHERE f.fechaVenta = :fechaVenta"),
    @NamedQuery(name = "Factura.findByPrimerFechaPago", query = "SELECT f FROM Factura f WHERE f.primerFechaPago = :primerFechaPago"),
    @NamedQuery(name = "Factura.findByFechaVencimiento", query = "SELECT f FROM Factura f WHERE f.fechaVencimiento = :fechaVencimiento")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idFactura")
    private Integer idFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaVenta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "primerFechaPago")
    @Temporal(TemporalType.DATE)
    private Date primerFechaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaVencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFactura")
    private List<Asignacion> asignacionList;
    @JoinColumn(name = "cedulaCliente", referencedColumnName = "Cedula")
    @ManyToOne(optional = false)
    private Usuario cedulaCliente;
    @JoinColumn(name = " cedulaEmpleado", referencedColumnName = "Cedula")
    @ManyToOne(optional = false)
    private Usuario cedulaEmpleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFactura")
    private List<Estadoactual> estadoactualList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFactura")
    private List<Detallefactura> detallefacturaList;

    public Factura() {
    }

    public Factura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Factura(Integer idFactura, Date fechaVenta, Date primerFechaPago, Date fechaVencimiento) {
        this.idFactura = idFactura;
        this.fechaVenta = fechaVenta;
        this.primerFechaPago = primerFechaPago;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getPrimerFechaPago() {
        return primerFechaPago;
    }

    public void setPrimerFechaPago(Date primerFechaPago) {
        this.primerFechaPago = primerFechaPago;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @XmlTransient
    public List<Asignacion> getAsignacionList() {
        return asignacionList;
    }

    public void setAsignacionList(List<Asignacion> asignacionList) {
        this.asignacionList = asignacionList;
    }

    public Usuario getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(Usuario cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public Usuario getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(Usuario cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }

    @XmlTransient
    public List<Estadoactual> getEstadoactualList() {
        return estadoactualList;
    }

    public void setEstadoactualList(List<Estadoactual> estadoactualList) {
        this.estadoactualList = estadoactualList;
    }

    @XmlTransient
    public List<Detallefactura> getDetallefacturaList() {
        return detallefacturaList;
    }

    public void setDetallefacturaList(List<Detallefactura> detallefacturaList) {
        this.detallefacturaList = detallefacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.globalbill.backend.Entities.Factura[ idFactura=" + idFactura + " ]";
    }
    
}
