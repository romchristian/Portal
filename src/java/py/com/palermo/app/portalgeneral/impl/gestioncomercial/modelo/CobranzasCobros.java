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
@Table(name = "cobranzascobros")
@IdClass(CobranzasCobrosPK.class)
@XmlType(name = "CobranzasCobros")
public class CobranzasCobros implements Serializable {

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
    private int cobranzaslinea;
    @Column(name = "mediospagosid")
    private Short mediospagosid;
    @Column(name = "cobranzasvalornumero")
    private Integer cobranzasvalornumero;
    @Column(name = "cobranzasfechavalor")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cobranzasfechavalor;
    @Column(name = "bancoid")
    private Short bancoid;
    @Column(name = "cobranzascuentabanco")
    private String cobranzascuentabanco;
    @Column(name = "cobranzasvalorvencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cobranzasvalorvencimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cobranzasvalorimporte")
    private BigDecimal cobranzasvalorimporte;
    @Column(name = "cobranzasvalorobservacion")
    private String cobranzasvalorobservacion;
    @JoinColumns({
        @JoinColumn(name = "empresasid", referencedColumnName = "empresasid", insertable = false, updatable = false),
        @JoinColumn(name = "sucursalesid", referencedColumnName = "sucursalesid", insertable = false, updatable = false),
        @JoinColumn(name = "cobranzascmpid", referencedColumnName = "cobranzascmpid", insertable = false, updatable = false),
        @JoinColumn(name = "cobranzasnumero", referencedColumnName = "cobranzasnumero", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Cobranzas cobranzas;
    @Column(name = "clientesid")
    private int clientesid;
    @Column(name = "retclientetimbrado")
    private int retclientetimbrado;
    @Column(name = "retnumero")
    private long retnumero;

    public CobranzasCobros() {
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

    public int getCobranzaslinea() {
        return cobranzaslinea;
    }

    @XmlElement(name = "CobranzasLinea")
    public void setCobranzaslinea(int cobranzaslinea) {
        this.cobranzaslinea = cobranzaslinea;
    }

    public Short getMediospagosid() {
        return mediospagosid;
    }

    @XmlElement(name = "MediosPagosId")
    public void setMediospagosid(Short mediospagosid) {
        this.mediospagosid = mediospagosid;
    }

    public Integer getCobranzasvalornumero() {
        return cobranzasvalornumero;
    }

    @XmlElement(name = "CobranzasValorNumero")
    public void setCobranzasvalornumero(Integer cobranzasvalornumero) {
        this.cobranzasvalornumero = cobranzasvalornumero;
    }

    public Date getCobranzasfechavalor() {
        return cobranzasfechavalor;
    }

    @XmlElement(name = "CobranzasFechaValor")
    public void setCobranzasfechavalor(Date cobranzasfechavalor) {
        this.cobranzasfechavalor = cobranzasfechavalor;
    }

    public Short getBancoid() {
        return bancoid;
    }

    @XmlElement(name = "BancoId")
    public void setBancoid(Short bancoid) {
        this.bancoid = bancoid;
    }

    public String getCobranzascuentabanco() {
        return cobranzascuentabanco;
    }

    @XmlElement(name = "CobranzasCuentaBanco")
    public void setCobranzascuentabanco(String cobranzascuentabanco) {
        this.cobranzascuentabanco = cobranzascuentabanco;
    }

    public Date getCobranzasvalorvencimiento() {
        return cobranzasvalorvencimiento;
    }

    @XmlElement(name = "CobranzasValorVencimiento")
    public void setCobranzasvalorvencimiento(Date cobranzasvalorvencimiento) {
        this.cobranzasvalorvencimiento = cobranzasvalorvencimiento;
    }

    public BigDecimal getCobranzasvalorimporte() {
        return cobranzasvalorimporte;
    }

    @XmlElement(name = "CobranzasValorImporte")
    public void setCobranzasvalorimporte(BigDecimal cobranzasvalorimporte) {
        this.cobranzasvalorimporte = cobranzasvalorimporte;
    }

    public String getCobranzasvalorobservacion() {
        return cobranzasvalorobservacion;
    }

    @XmlElement(name = "CobranzasValorObservacion")
    public void setCobranzasvalorobservacion(String cobranzasvalorobservacion) {
        this.cobranzasvalorobservacion = cobranzasvalorobservacion;
    }

    public Cobranzas getCobranzas() {
        return cobranzas;
    }

    public void setCobranzas(Cobranzas cobranzas) {
        this.cobranzas = cobranzas;
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

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.empresasid;
        hash = 13 * hash + this.sucursalesid;
        hash = 13 * hash + this.cobranzascmpid;
        hash = 13 * hash + this.cobranzasnumero;
        hash = 13 * hash + this.cobranzaslinea;
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
        final CobranzasCobros other = (CobranzasCobros) obj;
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
        if (this.cobranzaslinea != other.cobranzaslinea) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.serviciopocket.gcmovil.entity.Cobranzascobros[ cobranzascobrosPK=" + cobranzaslinea + " ]";
    }
}
