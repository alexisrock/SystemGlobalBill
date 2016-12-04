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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "talonario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Talonario.findAll", query = "SELECT t FROM Talonario t"),
    @NamedQuery(name = "Talonario.findByIdTalonario", query = "SELECT t FROM Talonario t WHERE t.idTalonario = :idTalonario"),
    @NamedQuery(name = "Talonario.findByFecha", query = "SELECT t FROM Talonario t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "Talonario.findByNumeroInicial", query = "SELECT t FROM Talonario t WHERE t.numeroInicial = :numeroInicial"),
    @NamedQuery(name = "Talonario.findByNumeroFinal", query = "SELECT t FROM Talonario t WHERE t.numeroFinal = :numeroFinal")})
public class Talonario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTalonario")
    private Integer idTalonario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroInicial")
    private int numeroInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroFinal")
    private int numeroFinal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTalonario")
    private List<Asignacion> asignacionList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "talonario")
    private Entregatalonario entregatalonario;

    public Talonario() {
    }

    public Talonario(Integer idTalonario) {
        this.idTalonario = idTalonario;
    }

    public Talonario(Integer idTalonario, Date fecha, int numeroInicial, int numeroFinal) {
        this.idTalonario = idTalonario;
        this.fecha = fecha;
        this.numeroInicial = numeroInicial;
        this.numeroFinal = numeroFinal;
    }

    public Integer getIdTalonario() {
        return idTalonario;
    }

    public void setIdTalonario(Integer idTalonario) {
        this.idTalonario = idTalonario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumeroInicial() {
        return numeroInicial;
    }

    public void setNumeroInicial(int numeroInicial) {
        this.numeroInicial = numeroInicial;
    }

    public int getNumeroFinal() {
        return numeroFinal;
    }

    public void setNumeroFinal(int numeroFinal) {
        this.numeroFinal = numeroFinal;
    }

    @XmlTransient
    public List<Asignacion> getAsignacionList() {
        return asignacionList;
    }

    public void setAsignacionList(List<Asignacion> asignacionList) {
        this.asignacionList = asignacionList;
    }

    public Entregatalonario getEntregatalonario() {
        return entregatalonario;
    }

    public void setEntregatalonario(Entregatalonario entregatalonario) {
        this.entregatalonario = entregatalonario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTalonario != null ? idTalonario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Talonario)) {
            return false;
        }
        Talonario other = (Talonario) object;
        if ((this.idTalonario == null && other.idTalonario != null) || (this.idTalonario != null && !this.idTalonario.equals(other.idTalonario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.globalbill.backend.Entities.Talonario[ idTalonario=" + idTalonario + " ]";
    }
    
}
