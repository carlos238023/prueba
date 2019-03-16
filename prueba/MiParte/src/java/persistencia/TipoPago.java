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
@Table(name = "tipo_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPago.findAll", query = "SELECT t FROM TipoPago t")
    , @NamedQuery(name = "TipoPago.findByIdTipoPago", query = "SELECT t FROM TipoPago t WHERE t.idTipoPago = :idTipoPago")
    , @NamedQuery(name = "TipoPago.findByPago", query = "SELECT t FROM TipoPago t WHERE t.pago = :pago")})
public class TipoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_pago")
    private Integer idTipoPago;
    @Basic(optional = false)
    @Column(name = "pago")
    private String pago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoPago")
    private List<Tiquete> tiqueteList;

    public TipoPago() {
    }

    public TipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public TipoPago(Integer idTipoPago, String pago) {
        this.idTipoPago = idTipoPago;
        this.pago = pago;
    }

    public Integer getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
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
        hash += (idTipoPago != null ? idTipoPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPago)) {
            return false;
        }
        TipoPago other = (TipoPago) object;
        if ((this.idTipoPago == null && other.idTipoPago != null) || (this.idTipoPago != null && !this.idTipoPago.equals(other.idTipoPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.TipoPago[ idTipoPago=" + idTipoPago + " ]";
    }
    
}
