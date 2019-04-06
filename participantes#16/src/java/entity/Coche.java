/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "coche")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coche.findAll", query = "SELECT c FROM Coche c")
    , @NamedQuery(name = "Coche.findByCodCoche", query = "SELECT c FROM Coche c WHERE c.codCoche = :codCoche")
    , @NamedQuery(name = "Coche.findByMatricula", query = "SELECT c FROM Coche c WHERE c.matricula = :matricula")
    , @NamedQuery(name = "Coche.findByModelo", query = "SELECT c FROM Coche c WHERE c.modelo = :modelo")
    , @NamedQuery(name = "Coche.findByColor", query = "SELECT c FROM Coche c WHERE c.color = :color")
    , @NamedQuery(name = "Coche.findByMarcar", query = "SELECT c FROM Coche c WHERE c.marcar = :marcar")})
public class Coche implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codCoche")
    private String codCoche;
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "color")
    private String color;
    @Column(name = "marcar")
    private String marcar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCoche", fetch = FetchType.EAGER)
    private List<DetalleReserva> detalleReservaList;

    public Coche() {
    }

    public Coche(String codCoche) {
        this.codCoche = codCoche;
    }

    public String getCodCoche() {
        return codCoche;
    }

    public void setCodCoche(String codCoche) {
        this.codCoche = codCoche;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarcar() {
        return marcar;
    }

    public void setMarcar(String marcar) {
        this.marcar = marcar;
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
        hash += (codCoche != null ? codCoche.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coche)) {
            return false;
        }
        Coche other = (Coche) object;
        if ((this.codCoche == null && other.codCoche != null) || (this.codCoche != null && !this.codCoche.equals(other.codCoche))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Coche[ codCoche=" + codCoche + " ]";
    }
    
}
