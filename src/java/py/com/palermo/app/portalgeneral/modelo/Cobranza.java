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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author christian.romero
 */
@Entity
@Table(name = "cobranza")
@NamedQueries({
    @NamedQuery(name = "Cobranza.findAll", query = "SELECT c FROM Cobranza c")})
public class Cobranza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id")
    private String id;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "clienteid")
    private Integer clienteid;
    @Column(name = "estadoanulacion")
    private Character estadoanulacion;
    @Column(name = "estadodescarga")
    private Character estadodescarga;
    @Column(name = "vendedorid")
    private Integer vendedorid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private BigDecimal total;
    @Size(max = 255)
    @Column(name = "gpslat")
    private String gpslat;
    @Size(max = 255)
    @Column(name = "gpslong")
    private String gpslong;
    @OneToMany(mappedBy = "cobranza")
    private Collection<Cobranzadetalle> conbranzadetalleCollection;
    @OneToMany(mappedBy = "cobranza")
    private Collection<Cobranzaaplicacionpago> cobranzaaplicacionpagoCollection;

    public Cobranza() {
    }

  

    public Cobranza(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public Character getEstadoanulacion() {
        return estadoanulacion;
    }

    public void setEstadoanulacion(Character estadoanulacion) {
        this.estadoanulacion = estadoanulacion;
    }

    public Character getEstadodescarga() {
        return estadodescarga;
    }

    public void setEstadodescarga(Character estadodescarga) {
        this.estadodescarga = estadodescarga;
    }

    public Integer getVendedorid() {
        return vendedorid;
    }

    public void setVendedorid(Integer vendedorid) {
        this.vendedorid = vendedorid;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
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

    public Collection<Cobranzadetalle> getConbranzadetalleCollection() {
        return conbranzadetalleCollection;
    }

    public void setConbranzadetalleCollection(Collection<Cobranzadetalle> conbranzadetalleCollection) {
        this.conbranzadetalleCollection = conbranzadetalleCollection;
    }

    public Collection<Cobranzaaplicacionpago> getCobranzaaplicacionpagoCollection() {
        return cobranzaaplicacionpagoCollection;
    }

    public void setCobranzaaplicacionpagoCollection(Collection<Cobranzaaplicacionpago> cobranzaaplicacionpagoCollection) {
        this.cobranzaaplicacionpagoCollection = cobranzaaplicacionpagoCollection;
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
        if (!(object instanceof Cobranza)) {
            return false;
        }
        Cobranza other = (Cobranza) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.servicioarthy.modelo.Cobranza[ id=" + id + " ]";
    }

}
