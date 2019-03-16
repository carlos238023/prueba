/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author roberto.hernandezUSA
 */
@Entity
@Table(name = "avion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avion.findAll", query = "SELECT a FROM Avion a")
    , @NamedQuery(name = "Avion.findByIdAvion", query = "SELECT a FROM Avion a WHERE a.idAvion = :idAvion")
    , @NamedQuery(name = "Avion.findByCapacidad", query = "SELECT a FROM Avion a WHERE a.capacidad = :capacidad")
    , @NamedQuery(name = "Avion.findByPlaca", query = "SELECT a FROM Avion a WHERE a.placa = :placa")})
public class Avion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_avion")
    private Integer idAvion;
    @Basic(optional = false)
    @Column(name = "capacidad")
    private int capacidad;
    @Basic(optional = false)
    @Column(name = "placa")
    private String placa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAvion")
    private List<AvionDestino> avionDestinoList;
    @JoinColumn(name = "aerolinea", referencedColumnName = "id_aerolinea")
    @ManyToOne(optional = false)
    private Aerolinea aerolinea;

    public Avion() {
    }

    public Avion(Integer idAvion) {
        this.idAvion = idAvion;
    }

    public Avion(Integer idAvion, int capacidad, String placa) {
        this.idAvion = idAvion;
        this.capacidad = capacidad;
        this.placa = placa;
    }

    public Integer getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(Integer idAvion) {
        this.idAvion = idAvion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @XmlTransient
    public List<AvionDestino> getAvionDestinoList() {
        return avionDestinoList;
    }

    public void setAvionDestinoList(List<AvionDestino> avionDestinoList) {
        this.avionDestinoList = avionDestinoList;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAvion != null ? idAvion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avion)) {
            return false;
        }
        Avion other = (Avion) object;
        if ((this.idAvion == null && other.idAvion != null) || (this.idAvion != null && !this.idAvion.equals(other.idAvion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Avion[ idAvion=" + idAvion + " ]";
    }
    
}
