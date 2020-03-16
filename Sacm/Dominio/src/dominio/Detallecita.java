/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "detallecita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallecita.findAll", query = "SELECT d FROM Detallecita d"),
    @NamedQuery(name = "Detallecita.findByIdDetalleCita", query = "SELECT d FROM Detallecita d WHERE d.idDetalleCita = :idDetalleCita")})
public class Detallecita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idDetalleCita")
    private String idDetalleCita;
    @JoinColumn(name = "idCita", referencedColumnName = "idCita")
    @ManyToOne(optional = false)
    private Cita idCita;
    @JoinColumn(name = "idServicioDeRelajacion", referencedColumnName = "idServicioDeRelajacion")
    @ManyToOne(optional = false)
    private Servicioderelajacion idServicioDeRelajacion;

    public Detallecita() {
    }

    public Detallecita(String idDetalleCita) {
        this.idDetalleCita = idDetalleCita;
    }

    public String getIdDetalleCita() {
        return idDetalleCita;
    }

    public void setIdDetalleCita(String idDetalleCita) {
        this.idDetalleCita = idDetalleCita;
    }

    public Cita getIdCita() {
        return idCita;
    }

    public void setIdCita(Cita idCita) {
        this.idCita = idCita;
    }

    public Servicioderelajacion getIdServicioDeRelajacion() {
        return idServicioDeRelajacion;
    }

    public void setIdServicioDeRelajacion(Servicioderelajacion idServicioDeRelajacion) {
        this.idServicioDeRelajacion = idServicioDeRelajacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleCita != null ? idDetalleCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallecita)) {
            return false;
        }
        Detallecita other = (Detallecita) object;
        if ((this.idDetalleCita == null && other.idDetalleCita != null) || (this.idDetalleCita != null && !this.idDetalleCita.equals(other.idDetalleCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Detallecita[ idDetalleCita=" + idDetalleCita + " ]";
    }
    
}
