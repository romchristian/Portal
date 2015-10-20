/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cromero
 */
@Entity
@Table(name = "pdvmovil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pdvmovil.findAll", query = "SELECT p FROM Pdvmovil p")})
public class Pdvmovil implements Serializable, Auditable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "cuentaemail")
    private String cuentaemail;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 255)
    @Column(name = "deviceid")
    private String deviceid;
    @Size(max = 255)
    @Column(name = "estado")
    private String estado;
    @OneToOne(mappedBy = "pdvMovil")
    private Usuario usuario;
    private String empresa;
    private String nombre;
    private String apellido;
    @Column(name = "lat")
    private Double lat;
    @Column(name = "long")
    private Double longitud;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha = new Date();

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

   

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    
    public Pdvmovil() {
    }

    public Pdvmovil(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCuentaemail() {
        return cuentaemail;
    }

    public void setCuentaemail(String cuentaemail) {
        this.cuentaemail = cuentaemail;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pdvmovil)) {
            return false;
        }
        Pdvmovil other = (Pdvmovil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion;
    }

}
