/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author christian.romero
 */
@Entity
@Table(name = "devolucion")
@NamedQueries({
    @NamedQuery(name = "Devolucion.findAll", query = "SELECT d FROM Devolucion d")})
public class Devolucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "empresaid")
    private Short empresaid;
    @Column(name = "sucursalid")
    private Short sucursalid;
    @Column(name = "clienteid")
    private Integer clienteid;
    @Column(name = "vendedorid")
    private Integer vendedorid;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidadgruesas")
    private BigDecimal cantidadgruesas;
    @Size(max = 255)
    @Column(name = "estadodescarga")
    private String estadodescarga;
    @Size(max = 255)
    @Column(name = "gpslat")
    private String gpslat;
    @Size(max = 255)
    @Column(name = "gpslong")
    private String gpslong;
    @Size(max = 255)
    @Column(name = "hashkey")
    private String hashkey;
    @Size(max = 255)
    @Column(name = "estadoeliminacion")
    private String estadoeliminacion;
    @OneToMany(mappedBy = "devolucionid")
    private Collection<Devoluciondetalle> devoluciondetalleCollection;

    public Devolucion() {
    }

    public Devolucion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(Short empresaid) {
        this.empresaid = empresaid;
    }

    public Short getSucursalid() {
        return sucursalid;
    }

    public void setSucursalid(Short sucursalid) {
        this.sucursalid = sucursalid;
    }

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public Integer getVendedorid() {
        return vendedorid;
    }

    public void setVendedorid(Integer vendedorid) {
        this.vendedorid = vendedorid;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getCantidadgruesas() {
        return cantidadgruesas;
    }

    public void setCantidadgruesas(BigDecimal cantidadgruesas) {
        this.cantidadgruesas = cantidadgruesas;
    }

    public String getEstadodescarga() {
        return estadodescarga;
    }

    public void setEstadodescarga(String estadodescarga) {
        this.estadodescarga = estadodescarga;
    }

    public String getGpslat() {
        return gpslat;
    }

    public void setGpslat(String gpslat) {
        this.gpslat = gpslat;
    }

    public String getGpslong() {
        return gpslong;
    }

    public void setGpslong(String gpslong) {
        this.gpslong = gpslong;
    }

    public String getHashkey() {
        return hashkey;
    }

    public void setHashkey(String hashkey) {
        this.hashkey = hashkey;
    }

    public String getEstadoeliminacion() {
        return estadoeliminacion;
    }

    public void setEstadoeliminacion(String estadoeliminacion) {
        this.estadoeliminacion = estadoeliminacion;
    }

    public Collection<Devoluciondetalle> getDevoluciondetalleCollection() {
        return devoluciondetalleCollection;
    }

    public void setDevoluciondetalleCollection(Collection<Devoluciondetalle> devoluciondetalleCollection) {
        this.devoluciondetalleCollection = devoluciondetalleCollection;
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
        if (!(object instanceof Devolucion)) {
            return false;
        }
        Devolucion other = (Devolucion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.app.portalgeneral.modelo.Devolucion[ id=" + id + " ]";
    }
    
}
