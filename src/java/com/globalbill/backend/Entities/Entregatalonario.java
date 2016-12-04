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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "entregatalonario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entregatalonario.findAll", query = "SELECT e FROM Entregatalonario e"),
    @NamedQuery(name = "Entregatalonario.findByIdTalonario", query = "SELECT e FROM Entregatalonario e WHERE e.idTalonario = :idTalonario"),
    @NamedQuery(name = "Entregatalonario.findByFechaEntrega", query = "SELECT e FROM Entregatalonario e WHERE e.fechaEntrega = :fechaEntrega")})
public class Entregatalonario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTalonario")
    private Integer idTalonario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEntrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @JoinColumn(name = "idTalonario", referencedColumnName = "idTalonario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Talonario talonario;
    @JoinColumn(name = "Recaudador", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarioasignado recaudador;

    public Entregatalonario() {
    }

    public Entregatalonario(Integer idTalonario) {
        this.idTalonario = idTalonario;
    }

    public Entregatalonario(Integer idTalonario, Date fechaEntrega) {
        this.idTalonario = idTalonario;
        this.fechaEntrega = fechaEntrega;
    }

    public Integer getIdTalonario() {
        return idTalonario;
    }

    public void setIdTalonario(Integer idTalonario) {
        this.idTalonario = idTalonario;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Talonario getTalonario() {
        return talonario;
    }

    public void setTalonario(Talonario talonario) {
        this.talonario = talonario;
    }

    public Usuarioasignado getRecaudador() {
        return recaudador;
    }

    public void setRecaudador(Usuarioasignado recaudador) {
        this.recaudador = recaudador;
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
        if (!(object instanceof Entregatalonario)) {
            return false;
        }
        Entregatalonario other = (Entregatalonario) object;
        if ((this.idTalonario == null && other.idTalonario != null) || (this.idTalonario != null && !this.idTalonario.equals(other.idTalonario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.globalbill.backend.Entities.Entregatalonario[ idTalonario=" + idTalonario + " ]";
    }
    
}
