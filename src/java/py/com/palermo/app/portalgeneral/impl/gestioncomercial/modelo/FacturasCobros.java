/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "facturascobros")
@IdClass(FacturasCobrosPK.class)
@XmlType(name = "FacturasCobros")
public class FacturasCobros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private short empresasid;
    @Id
    private short sucursalesid;
    @Id
    private short facturascmpid;
    @Id
    private short facturaspuntoexpedicionnro;
    @Id
    private int facturasnumero;
    @Id
    private short facturasvalorlinea;
    @Column(name = "mediospagosid")
    private Short mediospagosid;
    @Column(name = "facturasvalornumero")
    private Integer facturasvalornumero;
    @Column(name = "facturasvalorfecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date facturasvalorfecha;
    @Column(name = "bancoid")
    private Integer bancoid;
    @Column(name = "facturascuentabanco")
    private String facturascuentabanco;
    @Column(name = "facturasvalorvencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date facturasvalorvencimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "facturasvalorimporte")
    private BigDecimal facturasvalorimporte;
    @Column(name = "facturasvalorobservacion")
    private String facturasvalorobservacion;
    @JoinColumns({
        @JoinColumn(name = "empresasid", referencedColumnName = "empresasid", insertable = false, updatable = false),
        @JoinColumn(name = "sucursalesid", referencedColumnName = "sucursalesid", insertable = false, updatable = false),
        @JoinColumn(name = "facturascmpid", referencedColumnName = "facturascmpid", insertable = false, updatable = false),
        @JoinColumn(name = "facturaspuntoexpedicionnro", referencedColumnName = "facturaspuntoexpedicionnro", insertable = false, updatable = false),
        @JoinColumn(name = "facturasnumero", referencedColumnName = "facturasnumero", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Facturas facturas;
    @Column(name = "clientesid")
    private int clientesid;
    @Column(name = "retclientetimbrado")
    private int retclientetimbrado;
    @Column(name = "retnumero")
    private long retnumero;

    public FacturasCobros() {
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

    public short getFacturasvalorlinea() {
        return facturasvalorlinea;
    }

    @XmlElement(name = "FacturasValorLinea")
    public void setFacturasvalorlinea(short facturasvalorlinea) {
        this.facturasvalorlinea = facturasvalorlinea;
    }

    public Short getMediospagosid() {
        return mediospagosid;
    }

    @XmlElement(name = "MediosPagosId")
    public void setMediospagosid(Short mediospagosid) {
        this.mediospagosid = mediospagosid;
    }

    public Integer getFacturasvalornumero() {
        return facturasvalornumero;
    }

    @XmlElement(name = "FacturasValorNumero")
    public void setFacturasvalornumero(Integer facturasvalornumero) {
        this.facturasvalornumero = facturasvalornumero;
    }

    public Date getFacturasvalorfecha() {
        return facturasvalorfecha;
    }

    @XmlElement(name = "FacturasValorFecha")
    public void setFacturasvalorfecha(Date facturasvalorfecha) {
        this.facturasvalorfecha = facturasvalorfecha;
    }

    public Integer getBancoid() {
        return bancoid;
    }

    @XmlElement(name = "BancoId")
    public void setBancoid(Integer bancoid) {
        this.bancoid = bancoid;
    }

    public String getFacturascuentabanco() {
        return facturascuentabanco;
    }

    @XmlElement(name = "FacturasCuentaBanco")
    public void setFacturascuentabanco(String facturascuentabanco) {
        this.facturascuentabanco = facturascuentabanco;
    }

    public Date getFacturasvalorvencimiento() {
        return facturasvalorvencimiento;
    }

    @XmlElement(name = "FacturasValorVencimiento")
    public void setFacturasvalorvencimiento(Date facturasvalorvencimiento) {
        this.facturasvalorvencimiento = facturasvalorvencimiento;
    }

    public BigDecimal getFacturasvalorimporte() {
        return facturasvalorimporte;
    }

    @XmlElement(name = "FacturasValorImporte")
    public void setFacturasvalorimporte(BigDecimal facturasvalorimporte) {
        this.facturasvalorimporte = facturasvalorimporte;
    }

    public String getFacturasvalorobservacion() {
        return facturasvalorobservacion;
    }

    @XmlElement(name = "FacturasValorObservacion")
    public void setFacturasvalorobservacion(String facturasvalorobservacion) {
        this.facturasvalorobservacion = facturasvalorobservacion;
    }

    public int getClientesid() {
        return clientesid;
    }

    @XmlElement(name = "ClientesId")
    public void setClientesid(int clientesid) {
        this.clientesid = clientesid;
    }

    public int getRetclientetimbrado() {
        return retclientetimbrado;
    }

    @XmlElement(name = "RetClienteTimbrado")
    public void setRetclientetimbrado(int retclientetimbrado) {
        this.retclientetimbrado = retclientetimbrado;
    }

    public long getRetnumero() {
        return retnumero;
    }

    @XmlElement(name = "RetNumero")
    public void setRetnumero(long retnumero) {
        this.retnumero = retnumero;
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
        hash = 89 * hash + this.empresasid;
        hash = 89 * hash + this.sucursalesid;
        hash = 89 * hash + this.facturascmpid;
        hash = 89 * hash + this.facturaspuntoexpedicionnro;
        hash = 89 * hash + this.facturasnumero;
        hash = 89 * hash + this.facturasvalorlinea;
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
        final FacturasCobros other = (FacturasCobros) obj;
        if (this.empresasid != other.empresasid) {
            return false;
        }
        if (this.sucursalesid != other.sucursalesid) {
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
        if (this.facturasvalorlinea != other.facturasvalorlinea) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.serviciopocket.gcmovil.entity.Facturascobros[ facturascobrosPK=" + facturasvalorlinea + " ]";
    }
}
