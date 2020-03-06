/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADORES_ENTIDADES;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Manuel
 */
@Entity
@Table(name = "estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")
    , @NamedQuery(name = "Estudiante.findByCodigoEstudiante", query = "SELECT e FROM Estudiante e WHERE e.codigoEstudiante = :codigoEstudiante")
    , @NamedQuery(name = "Estudiante.findByNombreEstudiante", query = "SELECT e FROM Estudiante e WHERE e.nombreEstudiante = :nombreEstudiante")
    , @NamedQuery(name = "Estudiante.findByEdad", query = "SELECT e FROM Estudiante e WHERE e.edad = :edad")
    , @NamedQuery(name = "Estudiante.findByCorreoElectronico", query = "SELECT e FROM Estudiante e WHERE e.correoElectronico = :correoElectronico")
    , @NamedQuery(name = "Estudiante.findByTelefono", query = "SELECT e FROM Estudiante e WHERE e.telefono = :telefono")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_estudiante")
    private Integer codigoEstudiante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "nombre_estudiante")
    private String nombreEstudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @JoinColumn(name = "carrera_codigo_carrera", referencedColumnName = "codigo_carrera")
    @ManyToOne(optional = false)
    private Carrera carreraCodigoCarrera;
    @JoinColumn(name = "genero_codigo_genero", referencedColumnName = "codigo_genero")
    @ManyToOne(optional = false)
    private Genero generoCodigoGenero;
    @JoinColumn(name = "universidad_codigo_universidad", referencedColumnName = "codigo_universidad")
    @ManyToOne(optional = false)
    private Universidad universidadCodigoUniversidad;

    public Estudiante() {
    }

    public Estudiante(Integer codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public Estudiante(Integer codigoEstudiante, String nombreEstudiante, int edad, String correoElectronico, int telefono) {
        this.codigoEstudiante = codigoEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
    }

    public Integer getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(Integer codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Carrera getCarreraCodigoCarrera() {
        return carreraCodigoCarrera;
    }

    public void setCarreraCodigoCarrera(Carrera carreraCodigoCarrera) {
        this.carreraCodigoCarrera = carreraCodigoCarrera;
    }

    public Genero getGeneroCodigoGenero() {
        return generoCodigoGenero;
    }

    public void setGeneroCodigoGenero(Genero generoCodigoGenero) {
        this.generoCodigoGenero = generoCodigoGenero;
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
        hash += (codigoEstudiante != null ? codigoEstudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.codigoEstudiante == null && other.codigoEstudiante != null) || (this.codigoEstudiante != null && !this.codigoEstudiante.equals(other.codigoEstudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CONTROLADORES_ENTIDADES.Estudiante[ codigoEstudiante=" + codigoEstudiante + " ]";
    }
    
}
