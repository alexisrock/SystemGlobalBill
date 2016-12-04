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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "usuarioasignado")
@XmlRootElement

@NamedNativeQueries({
    @NamedNativeQuery(name = "usuariolog", query = "SELECT nombreUsuario, contrasenia FROM Usuarioasignado WHERE nombreUsuario = ? and contrasenia = MD5(?)")})
@NamedQueries({    
    @NamedQuery(name = "Usuarioasignado.findAll", query = "SELECT u FROM Usuarioasignado u"),
    @NamedQuery(name = "Usuarioasignado.findByIdUsuario", query = "SELECT u FROM Usuarioasignado u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuarioasignado.findByNombreUsuario", query = "SELECT u FROM Usuarioasignado u WHERE u.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Usuarioasignado.findByContrasenia", query = "SELECT u FROM Usuarioasignado u WHERE u.contrasenia = :contrasenia")})
public class Usuarioasignado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Size(max = 56)
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @Size(max = 40)
    @Column(name = "Contrasenia")
    private String contrasenia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recaudador")
    private List<Entregatalonario> entregatalonarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedula1")
    private List<Novedad> novedadList;
    @JoinColumn(name = "idRol", referencedColumnName = "idRol")
    @ManyToOne(optional = false)
    private Rol idRol;
    @JoinColumn(name = "idUsuario", referencedColumnName = "Cedula", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Usuarioasignado() {
    }

    public Usuarioasignado(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @XmlTransient
    public List<Entregatalonario> getEntregatalonarioList() {
        return entregatalonarioList;
    }

    public void setEntregatalonarioList(List<Entregatalonario> entregatalonarioList) {
        this.entregatalonarioList = entregatalonarioList;
    }

    @XmlTransient
    public List<Novedad> getNovedadList() {
        return novedadList;
    }

    public void setNovedadList(List<Novedad> novedadList) {
        this.novedadList = novedadList;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarioasignado)) {
            return false;
        }
        Usuarioasignado other = (Usuarioasignado) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.globalbill.backend.Entities.Usuarioasignado[ idUsuario=" + idUsuario + " ]";
    }
    
    
    
    
    
    
    
    
    
}
