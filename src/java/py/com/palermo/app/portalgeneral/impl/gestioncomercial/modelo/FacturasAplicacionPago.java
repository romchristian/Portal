/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "facturasaplicacionpago")
@IdClass(FacturasAplicacionPagoPK.class)
@XmlType(name = "FacturasAplicacionPago")
public class FacturasAplicacionPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private short empresasid;
    @Id
    private short sucursalesid;
    @Id
    private short facturascobroscmpid;
    @Id
    private short facturascobrospuntoexpedicionnro;
    @Id
    private int facturascobrosnumero;
    @Id
    private short facturascobrosvalorlinea;
    @Id
    private short facturascmpid;
    @Id
    private short facturaspuntoexpedicionnro;
    @Id
    private int facturasnumero;
    @Column(name = "monto")
    private BigDecimal monto;
    @JoinColumns({
        @JoinColumn(name = "empresasid", referencedColumnName = "empresasid", insertable = false, updatable = false),
        @JoinColumn(name = "sucursalesid", referencedColumnName = "sucursalesid", insertable = false, updatable = false),
        @JoinColumn(name = "facturascmpid", referencedColumnName = "facturascmpid", insertable = false, updatable = false),
        @JoinColumn(name = "facturaspuntoexpedicionnro", referencedColumnName = "facturaspuntoexpedicionnro", insertable = false, updatable = false),
        @JoinColumn(name = "facturasnumero", referencedColumnName = "facturasnumero", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Facturas facturas;
    @JoinColumns({
        @JoinColumn(name = "empresasid", referencedColumnName = "empresasid", insertable = false, updatable = false),
        @JoinColumn(name = "sucursalesid", referencedColumnName = "sucursalesid", insertable = false, updatable = false),
        @JoinColumn(name = "facturascobroscmpid", referencedColumnName = "facturascmpid", insertable = false, updatable = false),
        @JoinColumn(name = "facturascobrospuntoexpedicionnro", referencedColumnName = "facturaspuntoexpedicionnro", insertable = false, updatable = false),
        @JoinColumn(name = "facturascobrosnumero", referencedColumnName = "facturasnumero", insertable = false, updatable = false),
        @JoinColumn(name = "facturascobrosvalorlinea", referencedColumnName = "facturasvalorlinea", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private FacturasCobros facturasCobros;

    public FacturasAplicacionPago() {
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

    public short getFacturascobroscmpid() {
        return facturascobroscmpid;
    }

    @XmlElement(name = "FacturasCobrosCmpId")
    public void setFacturascobroscmpid(short facturascobroscmpid) {
        this.facturascobroscmpid = facturascobroscmpid;
    }

    public short getFacturascobrospuntoexpedicionnro() {
        return facturascobrospuntoexpedicionnro;
    }

    @XmlElement(name = "FacturasCobrosPuntoExpedicionNro")
    public void setFacturascobrospuntoexpedicionnro(short facturascobrospuntoexpedicionnro) {
        this.facturascobrospuntoexpedicionnro = facturascobrospuntoexpedicionnro;
    }

    public int getFacturascobrosnumero() {
        return facturascobrosnumero;
    }

    @XmlElement(name = "FacturasCobrosNumero")
    public void setFacturascobrosnumero(int facturascobrosnumero) {
        this.facturascobrosnumero = facturascobrosnumero;
    }

    public short getFacturascobrosvalorlinea() {
        return facturascobrosvalorlinea;
    }

    @XmlElement(name = "FacturasCobrosValorLinea")
    public void setFacturascobrosvalorlinea(short facturascobrosvalorlinea) {
        this.facturascobrosvalorlinea = facturascobrosvalorlinea;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    @XmlElement(name = "Monto")
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Facturas getFacturas() {
        return facturas;
    }

    public void setFacturas(Facturas facturas) {
        this.facturas = facturas;
    }

    public FacturasCobros getFacturasCobros() {
        return facturasCobros;
    }

    public void setFacturasCobros(FacturasCobros facturasCobros) {
        this.facturasCobros = facturasCobros;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FacturasAplicacionPago other = (FacturasAplicacionPago) obj;
        if (this.empresasid != other.empresasid) {
            return false;
        }
        if (this.sucursalesid != other.sucursalesid) {
            return false;
        }
        if (this.facturascobroscmpid != other.facturascobroscmpid) {
            return false;
        }
        if (this.facturascobrospuntoexpedicionnro != other.facturascobrospuntoexpedicionnro) {
            return false;
        }
        if (this.facturascobrosnumero != other.facturascobrosnumero) {
            return false;
        }
        if (this.facturascobrosvalorlinea != other.facturascobrosvalorlinea) {
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
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.empresasid;
        hash = 79 * hash + this.sucursalesid;
        hash = 79 * hash + this.facturascobroscmpid;
        hash = 79 * hash + this.facturascobrospuntoexpedicionnro;
        hash = 79 * hash + this.facturascobrosnumero;
        hash = 79 * hash + this.facturascobrosvalorlinea;
        hash = 79 * hash + this.facturascmpid;
        hash = 79 * hash + this.facturaspuntoexpedicionnro;
        hash = 79 * hash + this.facturasnumero;
        return hash;
    }
}
