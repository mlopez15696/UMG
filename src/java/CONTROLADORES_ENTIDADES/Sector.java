/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADORES_ENTIDADES;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Manuel
 */
@Entity
@Table(name = "sector")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sector.findAll", query = "SELECT s FROM Sector s")
    , @NamedQuery(name = "Sector.findByCodigoSector", query = "SELECT s FROM Sector s WHERE s.codigoSector = :codigoSector")
    , @NamedQuery(name = "Sector.findByDescripcion", query = "SELECT s FROM Sector s WHERE s.descripcion = :descripcion")})
public class Sector implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_sector")
    private Integer codigoSector;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sectorCodigoSector")
    private Collection<Universidad> universidadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sectorCodigoSector")
    private Collection<Carrera> carreraCollection;

    public Sector() {
    }

    public Sector(Integer codigoSector) {
        this.codigoSector = codigoSector;
    }

    public Sector(Integer codigoSector, String descripcion) {
        this.codigoSector = codigoSector;
        this.descripcion = descripcion;
    }

    public Integer getCodigoSector() {
        return codigoSector;
    }

    public void setCodigoSector(Integer codigoSector) {
        this.codigoSector = codigoSector;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Universidad> getUniversidadCollection() {
        return universidadCollection;
    }

    public void setUniversidadCollection(Collection<Universidad> universidadCollection) {
        this.universidadCollection = universidadCollection;
    }

    @XmlTransient
    public Collection<Carrera> getCarreraCollection() {
        return carreraCollection;
    }

    public void setCarreraCollection(Collection<Carrera> carreraCollection) {
        this.carreraCollection = carreraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoSector != null ? codigoSector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sector)) {
            return false;
        }
        Sector other = (Sector) object;
        if ((this.codigoSector == null && other.codigoSector != null) || (this.codigoSector != null && !this.codigoSector.equals(other.codigoSector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CONTROLADORES_ENTIDADES.Sector[ codigoSector=" + codigoSector + " ]";
    }
    
}
