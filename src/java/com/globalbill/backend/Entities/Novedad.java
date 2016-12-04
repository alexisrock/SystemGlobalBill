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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "novedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Novedad.findAll", query = "SELECT n FROM Novedad n"),
    @NamedQuery(name = "Novedad.findByNumeroNovedad", query = "SELECT n FROM Novedad n WHERE n.numeroNovedad = :numeroNovedad"),
    @NamedQuery(name = "Novedad.findByAsunto", query = "SELECT n FROM Novedad n WHERE n.asunto = :asunto"),
    @NamedQuery(name = "Novedad.findByDestinatario", query = "SELECT n FROM Novedad n WHERE n.destinatario = :destinatario")})
public class Novedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroNovedad")
    private Integer numeroNovedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "Asunto")
    private String asunto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Novedad")
    private String novedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Destinatario")
    private String destinatario;
    
    @JoinColumn(name = "cedula", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuarioasignado cedula1;

    public Novedad() {
    }

    public Novedad(Integer numeroNovedad) {
        this.numeroNovedad = numeroNovedad;
    }

    public Novedad(Integer numeroNovedad, String asunto, String novedad, String destinatario) {
        this.numeroNovedad = numeroNovedad;
        this.asunto = asunto;
        this.novedad = novedad;
        this.destinatario = destinatario;
    }

    public Integer getNumeroNovedad() {
        return numeroNovedad;
    }

    public void setNumeroNovedad(Integer numeroNovedad) {
        this.numeroNovedad = numeroNovedad;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

   

    public Usuarioasignado getCedula1() {
        return cedula1;
    }

    public void setCedula1(Usuarioasignado cedula1) {
        this.cedula1 = cedula1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroNovedad != null ? numeroNovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Novedad)) {
            return false;
        }
        Novedad other = (Novedad) object;
        if ((this.numeroNovedad == null && other.numeroNovedad != null) || (this.numeroNovedad != null && !this.numeroNovedad.equals(other.numeroNovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.globalbill.backend.Entities.Novedad[ numeroNovedad=" + numeroNovedad + " ]";
    }
    
}
