/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c"),
    @NamedQuery(name = "Cita.findByIdCita", query = "SELECT c FROM Cita c WHERE c.idCita = :idCita"),
    @NamedQuery(name = "Cita.findByFecha", query = "SELECT c FROM Cita c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Cita.findByHora", query = "SELECT c FROM Cita c WHERE c.hora = :hora"),
    @NamedQuery(name = "Cita.findByDuracion", query = "SELECT c FROM Cita c WHERE c.duracion = :duracion"),
    @NamedQuery(name = "Cita.findByCostoTotal", query = "SELECT c FROM Cita c WHERE c.costoTotal = :costoTotal")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCita")
    private String idCita;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "duracion")
    @Temporal(TemporalType.TIME)
    private Date duracion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costoTotal")
    private Float costoTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCita")
    private List<Detallecita> detallecitaList;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;

    public Cita() {
        
    }

    public Cita(String idCita) {
        this.idCita = idCita;
    }

    public Cita(String idCita, Date fecha, Date hora, Date duracion, Float costoTotal, List<Detallecita> detallecitaList, Cliente idCliente) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
        this.costoTotal = costoTotal;
        this.detallecitaList = detallecitaList;
        this.idCliente = idCliente;
    }
    
    

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getDuracion() {
        return duracion;
    }

    public void setDuracion(Date duracion) {
        this.duracion = duracion;
    }

    public Float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Float costoTotal) {
        this.costoTotal = costoTotal;
    }

    @XmlTransient
    public List<Detallecita> getDetallecitaList() {
        return detallecitaList;
    }

    public void setDetallecitaList(List<Detallecita> detallecitaList) {
        this.detallecitaList = detallecitaList;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idCita);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cita other = (Cita) obj;
        if (!Objects.equals(this.idCita, other.idCita)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return this.idCita+" "+this.getIdCliente().getIdCliente();
    }
    
}
