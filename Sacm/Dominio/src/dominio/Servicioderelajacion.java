/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "servicioderelajacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicioderelajacion.findAll", query = "SELECT s FROM Servicioderelajacion s"),
    @NamedQuery(name = "Servicioderelajacion.findByIdServicioDeRelajacion", query = "SELECT s FROM Servicioderelajacion s WHERE s.idServicioDeRelajacion = :idServicioDeRelajacion"),
    @NamedQuery(name = "Servicioderelajacion.findByNombre", query = "SELECT s FROM Servicioderelajacion s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Servicioderelajacion.findByDuracion", query = "SELECT s FROM Servicioderelajacion s WHERE s.duracion = :duracion"),
    @NamedQuery(name = "Servicioderelajacion.findByCosto", query = "SELECT s FROM Servicioderelajacion s WHERE s.costo = :costo")})
public class Servicioderelajacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idServicioDeRelajacion")
    private String idServicioDeRelajacion;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "duracion")
    @Temporal(TemporalType.TIME)
    private Date duracion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo")
    private Float costo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicioDeRelajacion")
    private List<Detallecita> detallecitaList;

    public Servicioderelajacion() {
    }

    public Servicioderelajacion(String idServicioDeRelajacion) {
        this.idServicioDeRelajacion = idServicioDeRelajacion;
    }

    public String getIdServicioDeRelajacion() {
        return idServicioDeRelajacion;
    }

    public void setIdServicioDeRelajacion(String idServicioDeRelajacion) {
        this.idServicioDeRelajacion = idServicioDeRelajacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getDuracion() {
        return duracion;
    }

    public void setDuracion(Date duracion) {
        this.duracion = duracion;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    @XmlTransient
    public List<Detallecita> getDetallecitaList() {
        return detallecitaList;
    }

    public void setDetallecitaList(List<Detallecita> detallecitaList) {
        this.detallecitaList = detallecitaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicioDeRelajacion != null ? idServicioDeRelajacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicioderelajacion)) {
            return false;
        }
        Servicioderelajacion other = (Servicioderelajacion) object;
        if ((this.idServicioDeRelajacion == null && other.idServicioDeRelajacion != null) || (this.idServicioDeRelajacion != null && !this.idServicioDeRelajacion.equals(other.idServicioDeRelajacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Servicioderelajacion[ idServicioDeRelajacion=" + idServicioDeRelajacion + " ]";
    }
    
}
