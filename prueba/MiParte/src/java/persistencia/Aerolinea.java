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
@Table(name = "aerolinea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aerolinea.findAll", query = "SELECT a FROM Aerolinea a")
    , @NamedQuery(name = "Aerolinea.findByIdAerolinea", query = "SELECT a FROM Aerolinea a WHERE a.idAerolinea = :idAerolinea")
    , @NamedQuery(name = "Aerolinea.findByNombreAerolinea", query = "SELECT a FROM Aerolinea a WHERE a.nombreAerolinea = :nombreAerolinea")})
public class Aerolinea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aerolinea")
    private Integer idAerolinea;
    @Basic(optional = false)
    @Column(name = "nombre_aerolinea")
    private String nombreAerolinea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aerolinea")
    private List<Avion> avionList;

    public Aerolinea() {
    }

    public Aerolinea(Integer idAerolinea) {
        this.idAerolinea = idAerolinea;
    }

    public Aerolinea(Integer idAerolinea, String nombreAerolinea) {
        this.idAerolinea = idAerolinea;
        this.nombreAerolinea = nombreAerolinea;
    }

    public Integer getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(Integer idAerolinea) {
        this.idAerolinea = idAerolinea;
    }

    public String getNombreAerolinea() {
        return nombreAerolinea;
    }

    public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
    }

    @XmlTransient
    public List<Avion> getAvionList() {
        return avionList;
    }

    public void setAvionList(List<Avion> avionList) {
        this.avionList = avionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAerolinea != null ? idAerolinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aerolinea)) {
            return false;
        }
        Aerolinea other = (Aerolinea) object;
        if ((this.idAerolinea == null && other.idAerolinea != null) || (this.idAerolinea != null && !this.idAerolinea.equals(other.idAerolinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Aerolinea[ idAerolinea=" + idAerolinea + " ]";
    }
    
}
