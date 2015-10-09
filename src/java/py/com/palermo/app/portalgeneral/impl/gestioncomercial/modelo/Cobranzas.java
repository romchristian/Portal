/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author cromero
 */
@Entity
@Table(name = "cobranzas")
@IdClass(CobranzasPK.class)
@XmlType(name = "Cobranzas")
public class Cobranzas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private short empresasid;
    @Id
    private short sucursalesid;
    @Id
    private short cobranzascmpid;
    @Id
    private int cobranzasnumero;
    @Column(name = "clientesid", updatable = true)
    private Integer clientesid;
    @Column(name = "vendedorid", updatable = true)
    private Integer vendedorid;
    @Column(name = "cobranzasfecha", updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date cobranzasfecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cobranzastotal", updatable = true)
    private BigDecimal cobranzastotal;
    @Column(name = "cobranzasestadoanulacion", updatable = true)
    private Character cobranzasestadoanulacion;
    @Column(name = "cobranzasestadodescarga", updatable = true)
    private Character cobranzasestadodescarga;

    @Column(name = "cobranzasgpslat",updatable = true)
    private String cobranzasgpslat;
    @Column(name = "cobranzasgpslong",updatable = true)
    private String cobranzasgpslong;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cobranzas")
    private List<CobranzasDetalle> cobranzasdetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cobranzas")
    private List<CobranzasCobros> cobranzascobrosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cobranzas")
    private List<CobranzasAplicacionPago> cobranzasAplicacionPagosList;
    
    
    

    public Cobranzas() {
    }

    public Integer getClientesid() {
        return clientesid;
    }

    public List<CobranzasAplicacionPago> getCobranzasAplicacionPagosList() {
        return cobranzasAplicacionPagosList;
    }

    public void setCobranzasAplicacionPagosList(List<CobranzasAplicacionPago> cobranzasAplicacionPagosList) {
        this.cobranzasAplicacionPagosList = cobranzasAplicacionPagosList;
    }

    

    @XmlElement(name = "ClientesId")
    public void setClientesid(Integer clientesid) {
        this.clientesid = clientesid;
    }

    public Date getCobranzasfecha() {
        return cobranzasfecha;
    }

    @XmlElement(name = "CobranzasFecha")
    public void setCobranzasfecha(Date cobranzasfecha) {
        this.cobranzasfecha = cobranzasfecha;
    }

    public BigDecimal getCobranzastotal() {
        return cobranzastotal;
    }

    @XmlElement(name = "CobranzasTotal")
    public void setCobranzastotal(BigDecimal cobranzastotal) {
        this.cobranzastotal = cobranzastotal;
    }

    public Character getCobranzasestadoanulacion() {
        return cobranzasestadoanulacion;
    }

    @XmlElement(name = "CobranzasEstadoAnulacion")
    public void setCobranzasestadoanulacion(Character cobranzasestadoanulacion) {
        this.cobranzasestadoanulacion = cobranzasestadoanulacion;
    }

    public Character getCobranzasestadodescarga() {
        return cobranzasestadodescarga;
    }

    @XmlElement(name = "CobranzasEstadoDescarga")
    public void setCobranzasestadodescarga(Character cobranzasestadodescarga) {
        this.cobranzasestadodescarga = cobranzasestadodescarga;
    }

    public List<CobranzasDetalle> getCobranzasdetalleList() {
        return cobranzasdetalleList;
    }

    public void setCobranzasdetalleList(List<CobranzasDetalle> cobranzasdetalleList) {
        this.cobranzasdetalleList = cobranzasdetalleList;
    }

    public List<CobranzasCobros> getCobranzascobrosList() {
        return cobranzascobrosList;
    }

    
    public void setCobranzascobrosList(List<CobranzasCobros> cobranzascobrosList) {
        this.cobranzascobrosList = cobranzascobrosList;
    }

    public short getEmpresasid() {
        return empresasid;
    }

    @XmlElement(name = "EmpresasId")
    public void setEmpresasid(short empresasid) {
        this.empresasid = empresasid;
    }

    public short getSucursalesid() {
        return sucursalesid;
    }

    @XmlElement(name = "SucursalesId")
    public void setSucursalesid(short sucursalesid) {
        this.sucursalesid = sucursalesid;
    }

    public short getCobranzascmpid() {
        return cobranzascmpid;
    }

    @XmlElement(name = "CobranzasCmpId")
    public void setCobranzascmpid(short cobranzascmpid) {
        this.cobranzascmpid = cobranzascmpid;
    }

    public int getCobranzasnumero() {
        return cobranzasnumero;
    }

    @XmlElement(name = "CobranzasNumero")
    public void setCobranzasnumero(int cobranzasnumero) {
        this.cobranzasnumero = cobranzasnumero;
    }

    public Integer getVendedorid() {
        return vendedorid;
    }

    @XmlElement(name = "VendedorId")
    public void setVendedorid(Integer vendedorid) {
        this.vendedorid = vendedorid;
    }

    public String getCobranzasgpslat() {
        return cobranzasgpslat;
    }

    @XmlElement(name = "CobranzasGpsLat")
    public void setCobranzasgpslat(String cobranzasgpslat) {
        this.cobranzasgpslat = cobranzasgpslat;
    }

    public String getCobranzasgpslong() {
        return cobranzasgpslong;
    }

    @XmlElement(name = "CobranzasGpsLong")
    public void setCobranzasgpslong(String cobranzasgpslong) {
        this.cobranzasgpslong = cobranzasgpslong;
    }

    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.empresasid;
        hash = 79 * hash + this.sucursalesid;
        hash = 79 * hash + this.cobranzascmpid;
        hash = 79 * hash + this.cobranzasnumero;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cobranzas other = (Cobranzas) obj;
        if (this.empresasid != other.empresasid) {
            return false;
        }
        if (this.sucursalesid != other.sucursalesid) {
            return false;
        }
        if (this.cobranzascmpid != other.cobranzascmpid) {
            return false;
        }
        if (this.cobranzasnumero != other.cobranzasnumero) {
            return false;
        }
        return true;
    }

    
}
