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
@Table(name = "carrera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrera.findAll", query = "SELECT c FROM Carrera c")
    , @NamedQuery(name = "Carrera.findByCodigoCarrera", query = "SELECT c FROM Carrera c WHERE c.codigoCarrera = :codigoCarrera")
    , @NamedQuery(name = "Carrera.findByNombreCarrera", query = "SELECT c FROM Carrera c WHERE c.nombreCarrera = :nombreCarrera")
    , @NamedQuery(name = "Carrera.findByUbicacion", query = "SELECT c FROM Carrera c WHERE c.ubicacion = :ubicacion")
    , @NamedQuery(name = "Carrera.findByDuracion", query = "SELECT c FROM Carrera c WHERE c.duracion = :duracion")
    , @NamedQuery(name = "Carrera.findByPlan", query = "SELECT c FROM Carrera c WHERE c.plan = :plan")})
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_carrera")
    private Integer codigoCarrera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_carrera")
    private String nombreCarrera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion")
    private int duracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "plan")
    private String plan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carreraCodigoCarrera")
    private Collection<Estudiante> estudianteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carreraCodigoCarrera")
    private Collection<Genero> generoCollection;
    @JoinColumn(name = "sector_codigo_sector", referencedColumnName = "codigo_sector")
    @ManyToOne(optional = false)
    private Sector sectorCodigoSector;
    @JoinColumn(name = "universidad_codigo_universidad", referencedColumnName = "codigo_universidad")
    @ManyToOne(optional = false)
    private Universidad universidadCodigoUniversidad;

    public Carrera() {
    }

    public Carrera(Integer codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public Carrera(Integer codigoCarrera, String nombreCarrera, String ubicacion, int duracion, String plan) {
        this.codigoCarrera = codigoCarrera;
        this.nombreCarrera = nombreCarrera;
        this.ubicacion = ubicacion;
        this.duracion = duracion;
        this.plan = plan;
    }

    public Integer getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(Integer codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    @XmlTransient
    public Collection<Estudiante> getEstudianteCollection() {
        return estudianteCollection;
    }

    public void setEstudianteCollection(Collection<Estudiante> estudianteCollection) {
        this.estudianteCollection = estudianteCollection;
    }

    @XmlTransient
    public Collection<Genero> getGeneroCollection() {
        return generoCollection;
    }

    public void setGeneroCollection(Collection<Genero> generoCollection) {
        this.generoCollection = generoCollection;
    }

    public Sector getSectorCodigoSector() {
        return sectorCodigoSector;
    }

    public void setSectorCodigoSector(Sector sectorCodigoSector) {
        this.sectorCodigoSector = sectorCodigoSector;
    }

    public Universidad getUniversidadCodigoUniversidad() {
        return universidadCodigoUniversidad;
    }

    public void setUniversidadCodigoUniversidad(Universidad universidadCodigoUniversidad) {
        this.universidadCodigoUniversidad = universidadCodigoUniversidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCarrera != null ? codigoCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.codigoCarrera == null && other.codigoCarrera != null) || (this.codigoCarrera != null && !this.codigoCarrera.equals(other.codigoCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CONTROLADORES_ENTIDADES.Carrera[ codigoCarrera=" + codigoCarrera + " ]";
    }
    
}
