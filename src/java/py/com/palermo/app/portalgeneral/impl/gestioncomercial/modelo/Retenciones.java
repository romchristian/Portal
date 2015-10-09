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
@IdClass(RetencionesPK.class)
@Table(name = "retenciones")
@XmlType(name = "Retenciones")
public class Retenciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "empresasid")
    private short empresasid;
    @Id
    @Column(name = "sucursalesid")
    private short sucursalesid;
    @Id
    @Column(name = "clientesid")
    private int clientesid;
    @Id
    @Column(name = "retclientetimbrado")
    private int retclientetimbrado;
    @Id
    @Column(name = "retnumero")
    private long retnumero;
    @Column(name = "retrazonsocialretenido")
    private String retrazonsocialretenido;
    @Column(name = "retrucretenido")
    private String retrucretenido;
    @Column(name = "retfecharetencion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date retfecharetencion;
    @Column(name = "retvalorsiniva")
    private BigDecimal retvalorsiniva;
    @Column(name = "retporcentajeiva")
    private Integer retporcentajeiva;
    @Column(name = "retporcentajerenta")
    private Integer retporcentajerenta;
    @Column(name = "retimporteiva")
    private BigDecimal retimporteiva;
    @Column(name = "retimporterenta")
    private BigDecimal retimporterenta;
    @Column(name = "retimporteret")
    private BigDecimal retimporteret;
    @Column(name = "retimportesaldo")
    private BigDecimal retimportesaldo;
    @Column(name = "retestadodescarga")
    private Character retestadodescarga;
    @Column(name = "vendedoresid")
    private int vendedoresid;

    public Retenciones() {
    }

    public int getClientesid() {
        return clientesid;
    }

    @XmlElement(name = "ClientesId")
    public void setClientesid(int clientesid) {
        this.clientesid = clientesid;
    }

    public short getEmpresasid() {
        return empresasid;
    }

    @XmlElement(name = "EmpresasId")
    public void setEmpresasid(short empresasid) {
        this.empresasid = empresasid;
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

    public short getSucursalesid() {
        return sucursalesid;
    }

    @XmlElement(name = "SucursalesId")
    public void setSucursalesid(short sucursalesid) {
        this.sucursalesid = sucursalesid;
    }

    public String getRetrazonsocialretenido() {
        return retrazonsocialretenido;
    }

    @XmlElement(name = "RetRazonSocialRetenido")
    public void setRetrazonsocialretenido(String retrazonsocialretenido) {
        this.retrazonsocialretenido = retrazonsocialretenido;
    }

    public String getRetrucretenido() {
        return retrucretenido;
    }

    @XmlElement(name = "RetRucRetenido")
    public void setRetrucretenido(String retrucretenido) {
        this.retrucretenido = retrucretenido;
    }

    public Date getRetfecharetencion() {
        return retfecharetencion;
    }

    @XmlElement(name = "RetFechaRetencion")
    public void setRetfecharetencion(Date retfecharetencion) {
        this.retfecharetencion = retfecharetencion;
    }

    public BigDecimal getRetvalorsiniva() {
        return retvalorsiniva;
    }

    @XmlElement(name = "RetValorSinIva")
    public void setRetvalorsiniva(BigDecimal retvalorsiniva) {
        this.retvalorsiniva = retvalorsiniva;
    }

    public Integer getRetporcentajeiva() {
        return retporcentajeiva;
    }

    @XmlElement(name = "RetPorcentajeIva")
    public void setRetporcentajeiva(Integer retporcentajeiva) {
        this.retporcentajeiva = retporcentajeiva;
    }

    public Integer getRetporcentajerenta() {
        return retporcentajerenta;
    }

    @XmlElement(name = "RetPorcentajeRenta")
    public void setRetporcentajerenta(Integer retporcentajerenta) {
        this.retporcentajerenta = retporcentajerenta;
    }

    public BigDecimal getRetimporteiva() {
        return retimporteiva;
    }

    @XmlElement(name = "RetImporteIva")
    public void setRetimporteiva(BigDecimal retimporteiva) {
        this.retimporteiva = retimporteiva;
    }

    public BigDecimal getRetimporterenta() {
        return retimporterenta;
    }

    @XmlElement(name = "RetImporteRenta")
    public void setRetimporterenta(BigDecimal retimporterenta) {
        this.retimporterenta = retimporterenta;
    }

    public BigDecimal getRetimporteret() {
        return retimporteret;
    }

    @XmlElement(name = "RetImporteRet")
    public void setRetimporteret(BigDecimal retimporteret) {
        this.retimporteret = retimporteret;
    }

    public BigDecimal getRetimportesaldo() {
        return retimportesaldo;
    }

    @XmlElement(name = "RetImporteSaldo")
    public void setRetimportesaldo(BigDecimal retimportesaldo) {
        this.retimportesaldo = retimportesaldo;
    }

    public Character getRetestadodescarga() {
        return retestadodescarga;
    }

    @XmlElement(name = "RetEstadoDescarga")
    public void setRetestadodescarga(Character retestadodescarga) {
        this.retestadodescarga = retestadodescarga;
    }

    public int getVendedoresid() {
        return vendedoresid;
    }

    @XmlElement(name = "VendedoresId")
    public void setVendedoresid(int vendedoresid) {
        this.vendedoresid = vendedoresid;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Retenciones other = (Retenciones) obj;
        if (this.empresasid != other.empresasid) {
            return false;
        }
        if (this.sucursalesid != other.sucursalesid) {
            return false;
        }
        if (this.clientesid != other.clientesid) {
            return false;
        }
        if (this.retclientetimbrado != other.retclientetimbrado) {
            return false;
        }
        if (this.retnumero != other.retnumero) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.empresasid;
        hash = 83 * hash + this.sucursalesid;
        hash = 83 * hash + this.clientesid;
        hash = 83 * hash + this.retclientetimbrado;
        hash = 83 * hash + (int) (this.retnumero ^ (this.retnumero >>> 32));
        return hash;
    }
}
