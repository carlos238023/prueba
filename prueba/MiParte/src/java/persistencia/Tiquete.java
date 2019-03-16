/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "tiquete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiquete.findAll", query = "SELECT t FROM Tiquete t")
    , @NamedQuery(name = "Tiquete.findByIdTiquete", query = "SELECT t FROM Tiquete t WHERE t.tiquetePK.idTiquete = :idTiquete")
    , @NamedQuery(name = "Tiquete.findByValor", query = "SELECT t FROM Tiquete t WHERE t.valor = :valor")
    , @NamedQuery(name = "Tiquete.findByFechaVuelo", query = "SELECT t FROM Tiquete t WHERE t.fechaVuelo = :fechaVuelo")
    , @NamedQuery(name = "Tiquete.findByNumeroPuesto", query = "SELECT t FROM Tiquete t WHERE t.tiquetePK.numeroPuesto = :numeroPuesto")
    , @NamedQuery(name = "Tiquete.findByIva", query = "SELECT t FROM Tiquete t WHERE t.iva = :iva")
    , @NamedQuery(name = "Tiquete.findByTotal", query = "SELECT t FROM Tiquete t WHERE t.total = :total")
    , @NamedQuery(name = "Tiquete.findByHoraSalida", query = "SELECT t FROM Tiquete t WHERE t.horaSalida = :horaSalida")
    , @NamedQuery(name = "Tiquete.findByCodigo", query = "SELECT t FROM Tiquete t WHERE t.codigo = :codigo")})
public class Tiquete implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TiquetePK tiquetePK;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "fecha_vuelo")
    private String fechaVuelo;
    @Basic(optional = false)
    @Column(name = "iva")
    private double iva;
    @Basic(optional = false)
    @Column(name = "total")
    private double total;
    @Basic(optional = false)
    @Column(name = "hora_salida")
    private String horaSalida;
    @Basic(optional = false)
    @Column(name = "codigo")
    private int codigo;
    @JoinColumn(name = "clase", referencedColumnName = "id_clase")
    @ManyToOne(optional = false)
    private Clase clase;
    @JoinColumn(name = "destino", referencedColumnName = "id_avion_destino")
    @ManyToOne(optional = false)
    private AvionDestino destino;
    @JoinColumn(name = "id_pasajero", referencedColumnName = "id_pasajero")
    @ManyToOne(optional = false)
    private Pasajero idPasajero;
    @JoinColumn(name = "id_tipo_pago", referencedColumnName = "id_tipo_pago")
    @ManyToOne(optional = false)
    private TipoPago idTipoPago;
    @JoinColumn(name = "tipo_vuelo", referencedColumnName = "id_tipo_vuelo")
    @ManyToOne(optional = false)
    private TipoVuelo tipoVuelo;

    public Tiquete() {
    }

    public Tiquete(TiquetePK tiquetePK) {
        this.tiquetePK = tiquetePK;
    }

    public Tiquete(TiquetePK tiquetePK, double valor, String fechaVuelo, double iva, double total, String horaSalida, int codigo) {
        this.tiquetePK = tiquetePK;
        this.valor = valor;
        this.fechaVuelo = fechaVuelo;
        this.iva = iva;
        this.total = total;
        this.horaSalida = horaSalida;
        this.codigo = codigo;
    }

    public Tiquete(int idTiquete, int numeroPuesto) {
        this.tiquetePK = new TiquetePK(idTiquete, numeroPuesto);
    }

    public TiquetePK getTiquetePK() {
        return tiquetePK;
    }

    public void setTiquetePK(TiquetePK tiquetePK) {
        this.tiquetePK = tiquetePK;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(String fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public AvionDestino getDestino() {
        return destino;
    }

    public void setDestino(AvionDestino destino) {
        this.destino = destino;
    }

    public Pasajero getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(Pasajero idPasajero) {
        this.idPasajero = idPasajero;
    }

    public TipoPago getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(TipoPago idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public TipoVuelo getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(TipoVuelo tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiquetePK != null ? tiquetePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiquete)) {
            return false;
        }
        Tiquete other = (Tiquete) object;
        if ((this.tiquetePK == null && other.tiquetePK != null) || (this.tiquetePK != null && !this.tiquetePK.equals(other.tiquetePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Tiquete[ tiquetePK=" + tiquetePK + " ]";
    }
    
}
