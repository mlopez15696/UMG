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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "universidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Universidad.findAll", query = "SELECT u FROM Universidad u")
    , @NamedQuery(name = "Universidad.findByCodigoUniversidad", query = "SELECT u FROM Universidad u WHERE u.codigoUniversidad = :codigoUniversidad")
    , @NamedQuery(name = "Universidad.findByNombre", query = "SELECT u FROM Universidad u WHERE u.nombre = :nombre")})
public class Universidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_universidad")
    private Integer codigoUniversidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universidadCodigoUniversidad")
    private Collection<Estudiante> estudianteCollection;
    @JoinColumn(name = "sector_codigo_sector", referencedColumnName = "codigo_sector")
    @ManyToOne(optional = false)
    private Sector sectorCodigoSector;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universidadCodigoUniversidad")
    private Collection<Carrera> carreraCollection;

    public Universidad() {
    }

    public Universidad(Integer codigoUniversidad) {
        this.codigoUniversidad = codigoUniversidad;
    }

    public Universidad(Integer codigoUniversidad, String nombre) {
        this.codigoUniversidad = codigoUniversidad;
        this.nombre = nombre;
    }

    public Integer getCodigoUniversidad() {
        return codigoUniversidad;
    }

    public void setCodigoUniversidad(Integer codigoUniversidad) {
        this.codigoUniversidad = codigoUniversidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Estudiante> getEstudianteCollection() {
        return estudianteCollection;
    }

    public void setEstudianteCollection(Collection<Estudiante> estudianteCollection) {
        this.estudianteCollection = estudianteCollection;
    }

    public Sector getSectorCodigoSector() {
        return sectorCodigoSector;
    }

    public void setSectorCodigoSector(Sector sectorCodigoSector) {
        this.sectorCodigoSector = sectorCodigoSector;
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
        hash += (codigoUniversidad != null ? codigoUniversidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Universidad)) {
            return false;
        }
        Universidad other = (Universidad) object;
        if ((this.codigoUniversidad == null && other.codigoUniversidad != null) || (this.codigoUniversidad != null && !this.codigoUniversidad.equals(other.codigoUniversidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CONTROLADORES_ENTIDADES.Universidad[ codigoUniversidad=" + codigoUniversidad + " ]";
    }
    
}
