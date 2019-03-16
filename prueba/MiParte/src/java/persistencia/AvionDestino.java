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
@Table(name = "avion_destino")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AvionDestino.findAll", query = "SELECT a FROM AvionDestino a")
    , @NamedQuery(name = "AvionDestino.findByIdAvionDestino", query = "SELECT a FROM AvionDestino a WHERE a.idAvionDestino = :idAvionDestino")})
public class AvionDestino implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_avion_destino")
    private Integer idAvionDestino;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destino")
    private List<Tiquete> tiqueteList;
    @JoinColumn(name = "id_avion", referencedColumnName = "id_avion")
    @ManyToOne(optional = false)
    private Avion idAvion;
    @JoinColumn(name = "id_destino", referencedColumnName = "id_destino")
    @ManyToOne(optional = false)
    private Destino idDestino;

    public AvionDestino() {
    }

    public AvionDestino(Integer idAvionDestino) {
        this.idAvionDestino = idAvionDestino;
    }

    public Integer getIdAvionDestino() {
        return idAvionDestino;
    }

    public void setIdAvionDestino(Integer idAvionDestino) {
        this.idAvionDestino = idAvionDestino;
    }

    @XmlTransient
    public List<Tiquete> getTiqueteList() {
        return tiqueteList;
    }

    public void setTiqueteList(List<Tiquete> tiqueteList) {
        this.tiqueteList = tiqueteList;
    }

    public Avion getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(Avion idAvion) {
        this.idAvion = idAvion;
    }

    public Destino getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(Destino idDestino) {
        this.idDestino = idDestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAvionDestino != null ? idAvionDestino.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvionDestino)) {
            return false;
        }
        AvionDestino other = (AvionDestino) object;
        if ((this.idAvionDestino == null && other.idAvionDestino != null) || (this.idAvionDestino != null && !this.idAvionDestino.equals(other.idAvionDestino))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.AvionDestino[ idAvionDestino=" + idAvionDestino + " ]";
    }
    
}
