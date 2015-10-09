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
@Table(name = "cobranzasaplicacionpago")
@IdClass(CobranzasAplicacionPagoPK.class)
@XmlType(name = "CobranzasAplicacionPago")
public class CobranzasAplicacionPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private short empresasid;
    @Id
    private short sucursalesid;
    @Id
    private short cobranzascobroscmpid;
    @Id
    private int cobranzascobrosnumero;
    @Id
    private short cobranzascobroslinea;
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
        @JoinColumn(name = "cobranzascobroscmpid", referencedColumnName = "cobranzascmpid", insertable = false, updatable = false),
        @JoinColumn(name = "cobranzascobrosnumero", referencedColumnName = "cobranzasnumero", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Cobranzas cobranzas;

    public CobranzasAplicacionPago() {
    }

    public Cobranzas getCobranzas() {
        return cobranzas;
    }

    public void setCobranzas(Cobranzas cobranzas) {
        this.cobranzas = cobranzas;
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

    public BigDecimal getMonto() {
        return monto;
    }

    @XmlElement(name = "Monto")
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public short getCobranzascobroscmpid() {
        return cobranzascobroscmpid;
    }

    @XmlElement(name = "CobranzasCobrosCmpId")
    public void setCobranzascobroscmpid(short cobranzascobroscmpid) {
        this.cobranzascobroscmpid = cobranzascobroscmpid;
    }

    public int getCobranzascobrosnumero() {
        return cobranzascobrosnumero;
    }

    @XmlElement(name = "CobranzasCobrosNumero")
    public void setCobranzascobrosnumero(int cobranzascobrosnumero) {
        this.cobranzascobrosnumero = cobranzascobrosnumero;
    }

    public short getCobranzascobroslinea() {
        return cobranzascobroslinea;
    }

    @XmlElement(name = "CobranzasCobrosLinea")
    public void setCobranzascobroslinea(short cobranzascobroslinea) {
        this.cobranzascobroslinea = cobranzascobroslinea;
    }


  

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CobranzasAplicacionPago other = (CobranzasAplicacionPago) obj;
        if (this.empresasid != other.empresasid) {
            return false;
        }
        if (this.sucursalesid != other.sucursalesid) {
            return false;
        }
        if (this.cobranzascobroscmpid != other.cobranzascobroscmpid) {
            return false;
        }
        if (this.cobranzascobrosnumero != other.cobranzascobrosnumero) {
            return false;
        }
        if (this.cobranzascobroslinea != other.cobranzascobroslinea) {
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
        int hash = 7;
        hash = 79 * hash + this.empresasid;
        hash = 79 * hash + this.sucursalesid;
        hash = 79 * hash + this.cobranzascobroscmpid;
        hash = 79 * hash + this.cobranzascobrosnumero;
        hash = 79 * hash + this.cobranzascobroslinea;
        hash = 79 * hash + this.facturascmpid;
        hash = 79 * hash + this.facturaspuntoexpedicionnro;
        hash = 79 * hash + this.facturasnumero;
        return hash;
    }
}
