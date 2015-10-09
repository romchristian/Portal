/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author cromero
 */
@Entity
@Table(name = "cobranzasdetalle")
@IdClass(CobranzasDetallePK.class)
@XmlType(name = "CobranzasDetalle")
public class CobranzasDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private short empresasid;
    @Id
    private short sucursalesid;
    @Id
    private short cobranzascmpid;
    @Id
    private int cobranzasnumero;
    @Id
    private short facturascmpid;
    @Id
    private short facturaspuntoexpedicionnro;
    @Id
    private int facturasnumero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cobranzaspago")
    private BigDecimal cobranzaspago;
    @Basic(optional = false)

    @Column(name = "vendedorid")
    private short vendedorid;
    @JoinColumns({
        @JoinColumn(name = "empresasid", referencedColumnName = "empresasid", insertable = false, updatable = false),
        @JoinColumn(name = "sucursalesid", referencedColumnName = "sucursalesid", insertable = false, updatable = false),
        @JoinColumn(name = "cobranzascmpid", referencedColumnName = "cobranzascmpid", insertable = false, updatable = false),
        @JoinColumn(name = "cobranzasnumero", referencedColumnName = "cobranzasnumero", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Cobranzas cobranzas;
    @JoinColumns({
        @JoinColumn(name = "empresasid", referencedColumnName = "empresasid", insertable = false, updatable = false),
        @JoinColumn(name = "sucursalesid", referencedColumnName = "sucursalesid", insertable = false, updatable = false),
        @JoinColumn(name = "facturascmpid", referencedColumnName = "facturascmpid", insertable = false, updatable = false),
        @JoinColumn(name = "facturaspuntoexpedicionnro", referencedColumnName = "facturaspuntoexpedicionnro", insertable = false, updatable = false),
        @JoinColumn(name = "facturasnumero", referencedColumnName = "facturasnumero", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Facturas facturas;

    public CobranzasDetalle() {
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

    public short getFacturascmpid() {
        return facturascmpid;
    }

    @XmlElement(name = "FacturasCmpId")
    public void setFacturascmpid(short facturascmpid) {
        this.facturascmpid = facturascmpid;
    }

    public short getFacturaspuntoexpedicionnro() {
        return facturaspuntoexpedicionnro;
    }

    @XmlElement(name = "FacturasPuntoExpedicionNro")
    public void setFacturaspuntoexpedicionnro(short facturaspuntoexpedicionnro) {
        this.facturaspuntoexpedicionnro = facturaspuntoexpedicionnro;
    }

    public int getFacturasnumero() {
        return facturasnumero;
    }

    @XmlElement(name = "FacturasNumero")
    public void setFacturasnumero(int facturasnumero) {
        this.facturasnumero = facturasnumero;
    }

    public BigDecimal getCobranzaspago() {
        return cobranzaspago;
    }

    @XmlElement(name = "CobranzasPago")
    public void setCobranzaspago(BigDecimal cobranzaspago) {
        this.cobranzaspago = cobranzaspago;
    }

    public short getVendedorid() {
        return vendedorid;
    }

    @XmlElement(name = "VendedorId")
    public void setVendedorid(short vendedorid) {
        this.vendedorid = vendedorid;
    }

    public Cobranzas getCobranzas() {
        return cobranzas;
    }

    public void setCobranzas(Cobranzas cobranzas) {
        this.cobranzas = cobranzas;
    }

    public Facturas getFacturas() {
        return facturas;
    }

    public void setFacturas(Facturas facturas) {
        this.facturas = facturas;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.empresasid;
        hash = 53 * hash + this.sucursalesid;
        hash = 53 * hash + this.cobranzascmpid;
        hash = 53 * hash + this.cobranzasnumero;
        hash = 53 * hash + this.facturascmpid;
        hash = 53 * hash + this.facturaspuntoexpedicionnro;
        hash = 53 * hash + this.facturasnumero;
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
        final CobranzasDetalle other = (CobranzasDetalle) obj;
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
        if (this.facturascmpid != other.facturascmpid) {
            return false;
        }
        if (this.facturaspuntoexpedicionnro != other.facturaspuntoexpedicionnro) {
            return false;
        }
        if (this.facturasnumero != other.facturasnumero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.serviciopocket.gcmovil.entity.Cobranzasdetalle[ cobranzasdetallePK=" + cobranzasnumero + " ]";
    }
}
