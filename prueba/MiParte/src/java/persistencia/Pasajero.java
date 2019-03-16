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
@Table(name = "pasajero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pasajero.findAll", query = "SELECT p FROM Pasajero p")
    , @NamedQuery(name = "Pasajero.findByIdPasajero", query = "SELECT p FROM Pasajero p WHERE p.idPasajero = :idPasajero")
    , @NamedQuery(name = "Pasajero.findByNombreUno", query = "SELECT p FROM Pasajero p WHERE p.nombreUno = :nombreUno")
    , @NamedQuery(name = "Pasajero.findByNombreDos", query = "SELECT p FROM Pasajero p WHERE p.nombreDos = :nombreDos")
    , @NamedQuery(name = "Pasajero.findByApellidoUno", query = "SELECT p FROM Pasajero p WHERE p.apellidoUno = :apellidoUno")
    , @NamedQuery(name = "Pasajero.findByApellidoDos", query = "SELECT p FROM Pasajero p WHERE p.apellidoDos = :apellidoDos")
    , @NamedQuery(name = "Pasajero.findByTelefono", query = "SELECT p FROM Pasajero p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Pasajero.findByDireccion", query = "SELECT p FROM Pasajero p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Pasajero.findByNumeroDocumento", query = "SELECT p FROM Pasajero p WHERE p.numeroDocumento = :numeroDocumento")})
public class Pasajero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pasajero")
    private Integer idPasajero;
    @Basic(optional = false)
    @Column(name = "nombre_uno")
    private String nombreUno;
    @Column(name = "nombre_dos")
    private String nombreDos;
    @Basic(optional = false)
    @Column(name = "apellido_uno")
    private String apellidoUno;
    @Column(name = "apellido_dos")
    private String apellidoDos;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_login")
    @ManyToOne(optional = false)
    private Login idUsuario;
    @JoinColumn(name = "tipo_documento", referencedColumnName = "id_documento")
    @ManyToOne(optional = false)
    private TipoDocumento tipoDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPasajero")
    private List<Tiquete> tiqueteList;

    public Pasajero() {
    }

    public Pasajero(Integer idPasajero) {
        this.idPasajero = idPasajero;
    }

    public Pasajero(Integer idPasajero, String nombreUno, String apellidoUno, String telefono, String direccion, String numeroDocumento) {
        this.idPasajero = idPasajero;
        this.nombreUno = nombreUno;
        this.apellidoUno = apellidoUno;
        this.telefono = telefono;
        this.direccion = direccion;
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(Integer idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getNombreUno() {
        return nombreUno;
    }

    public void setNombreUno(String nombreUno) {
        this.nombreUno = nombreUno;
    }

    public String getNombreDos() {
        return nombreDos;
    }

    public void setNombreDos(String nombreDos) {
        this.nombreDos = nombreDos;
    }

    public String getApellidoUno() {
        return apellidoUno;
    }

    public void setApellidoUno(String apellidoUno) {
        this.apellidoUno = apellidoUno;
    }

    public String getApellidoDos() {
        return apellidoDos;
    }

    public void setApellidoDos(String apellidoDos) {
        this.apellidoDos = apellidoDos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Login getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Login idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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
        hash += (idPasajero != null ? idPasajero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pasajero)) {
            return false;
        }
        Pasajero other = (Pasajero) object;
        if ((this.idPasajero == null && other.idPasajero != null) || (this.idPasajero != null && !this.idPasajero.equals(other.idPasajero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Pasajero[ idPasajero=" + idPasajero + " ]";
    }
    
}
