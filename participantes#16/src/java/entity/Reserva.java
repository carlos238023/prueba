/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author roberto.hernandezUSA
 */
@Entity
@Table(name = "reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
    , @NamedQuery(name = "Reserva.findByIdReserva", query = "SELECT r FROM Reserva r WHERE r.idReserva = :idReserva")
    , @NamedQuery(name = "Reserva.findByFechaInicio", query = "SELECT r FROM Reserva r WHERE r.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Reserva.findByFechaFinal", query = "SELECT r FROM Reserva r WHERE r.fechaFinal = :fechaFinal")
    , @NamedQuery(name = "Reserva.findByPrecioAlquiler", query = "SELECT r FROM Reserva r WHERE r.precioAlquiler = :precioAlquiler")
    , @NamedQuery(name = "Reserva.findByListrosGasolina", query = "SELECT r FROM Reserva r WHERE r.listrosGasolina = :listrosGasolina")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_reserva")
    private Integer idReserva;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_final")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_alquiler")
    private Double precioAlquiler;
    @Column(name = "listros_gasolina")
    private Integer listrosGasolina;
    @JoinColumn(name = "codCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cliente codCliente=new Cliente();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReserva", fetch = FetchType.EAGER)
    private List<DetalleReserva> detalleReservaList;

    public Reserva() {
    }

    public Reserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(Double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public Integer getListrosGasolina() {
        return listrosGasolina;
    }

    public void setListrosGasolina(Integer listrosGasolina) {
        this.listrosGasolina = listrosGasolina;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    @XmlTransient
    public List<DetalleReserva> getDetalleReservaList() {
        return detalleReservaList;
    }

    public void setDetalleReservaList(List<DetalleReserva> detalleReservaList) {
        this.detalleReservaList = detalleReservaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Reserva[ idReserva=" + idReserva + " ]";
    }
    
}
