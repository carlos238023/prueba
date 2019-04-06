/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roberto.hernandezUSA
 */
@Entity
@Table(name = "detalle_reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleReserva.findAll", query = "SELECT d FROM DetalleReserva d")
    , @NamedQuery(name = "DetalleReserva.findByIdGaraje", query = "SELECT d FROM DetalleReserva d WHERE d.idGaraje = :idGaraje")
    , @NamedQuery(name = "DetalleReserva.findByAgencia", query = "SELECT d FROM DetalleReserva d WHERE d.agencia = :agencia")
    , @NamedQuery(name = "DetalleReserva.findByTotalAquiler", query = "SELECT d FROM DetalleReserva d WHERE d.totalAquiler = :totalAquiler")})
public class DetalleReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_garaje")
    private Integer idGaraje;
    @Column(name = "agencia")
    private String agencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_aquiler")
    private Double totalAquiler;
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Reserva idReserva;
    @JoinColumn(name = "codCoche", referencedColumnName = "codCoche")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Coche codCoche;

    public DetalleReserva() {
    }

    public DetalleReserva(Integer idGaraje) {
        this.idGaraje = idGaraje;
    }

    public Integer getIdGaraje() {
        return idGaraje;
    }

    public void setIdGaraje(Integer idGaraje) {
        this.idGaraje = idGaraje;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Double getTotalAquiler() {
        return totalAquiler;
    }

    public void setTotalAquiler(Double totalAquiler) {
        this.totalAquiler = totalAquiler;
    }

    public Reserva getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Reserva idReserva) {
        this.idReserva = idReserva;
    }

    public Coche getCodCoche() {
        return codCoche;
    }

    public void setCodCoche(Coche codCoche) {
        this.codCoche = codCoche;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGaraje != null ? idGaraje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleReserva)) {
            return false;
        }
        DetalleReserva other = (DetalleReserva) object;
        if ((this.idGaraje == null && other.idGaraje != null) || (this.idGaraje != null && !this.idGaraje.equals(other.idGaraje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DetalleReserva[ idGaraje=" + idGaraje + " ]";
    }
    
}
