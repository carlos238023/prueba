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
@Table(name = "tipo_vuelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoVuelo.findAll", query = "SELECT t FROM TipoVuelo t")
    , @NamedQuery(name = "TipoVuelo.findByIdTipoVuelo", query = "SELECT t FROM TipoVuelo t WHERE t.idTipoVuelo = :idTipoVuelo")
    , @NamedQuery(name = "TipoVuelo.findByVuelo", query = "SELECT t FROM TipoVuelo t WHERE t.vuelo = :vuelo")})
public class TipoVuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_vuelo")
    private Integer idTipoVuelo;
    @Basic(optional = false)
    @Column(name = "vuelo")
    private String vuelo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoVuelo")
    private List<Tiquete> tiqueteList;

    public TipoVuelo() {
    }

    public TipoVuelo(Integer idTipoVuelo) {
        this.idTipoVuelo = idTipoVuelo;
    }

    public TipoVuelo(Integer idTipoVuelo, String vuelo) {
        this.idTipoVuelo = idTipoVuelo;
        this.vuelo = vuelo;
    }

    public Integer getIdTipoVuelo() {
        return idTipoVuelo;
    }

    public void setIdTipoVuelo(Integer idTipoVuelo) {
        this.idTipoVuelo = idTipoVuelo;
    }

    public String getVuelo() {
        return vuelo;
    }

    public void setVuelo(String vuelo) {
        this.vuelo = vuelo;
    }

    @XmlTransient
    public List<Tiquete> getTiqueteList() {
        return tiqueteList;
    }

    public void setTiqueteList(List<Tiquete> tiqueteList) {
        this.tiqueteList = tiqueteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoVuelo != null ? idTipoVuelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoVuelo)) {
            return false;
        }
        TipoVuelo other = (TipoVuelo) object;
        if ((this.idTipoVuelo == null && other.idTipoVuelo != null) || (this.idTipoVuelo != null && !this.idTipoVuelo.equals(other.idTipoVuelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.TipoVuelo[ idTipoVuelo=" + idTipoVuelo + " ]";
    }
    
}
