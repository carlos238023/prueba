/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author roberto.hernandezUSA
 */
@Embeddable
public class TiquetePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_tiquete")
    private int idTiquete;
    @Basic(optional = false)
    @Column(name = "numero_puesto")
    private int numeroPuesto;

    public TiquetePK() {
    }

    public TiquetePK(int idTiquete, int numeroPuesto) {
        this.idTiquete = idTiquete;
        this.numeroPuesto = numeroPuesto;
    }

    public int getIdTiquete() {
        return idTiquete;
    }

    public void setIdTiquete(int idTiquete) {
        this.idTiquete = idTiquete;
    }

    public int getNumeroPuesto() {
        return numeroPuesto;
    }

    public void setNumeroPuesto(int numeroPuesto) {
        this.numeroPuesto = numeroPuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTiquete;
        hash += (int) numeroPuesto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiquetePK)) {
            return false;
        }
        TiquetePK other = (TiquetePK) object;
        if (this.idTiquete != other.idTiquete) {
            return false;
        }
        if (this.numeroPuesto != other.numeroPuesto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.TiquetePK[ idTiquete=" + idTiquete + ", numeroPuesto=" + numeroPuesto + " ]";
    }
    
}
