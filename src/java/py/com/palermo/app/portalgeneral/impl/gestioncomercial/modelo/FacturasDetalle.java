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
@Table(name = "facturasdetalle")
@IdClass(FacturasDetallePK.class)
@XmlType(name = "FacturasDetalle")
public class FacturasDetalle implements Serializable {

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
    private short facturaslinea;
    @Column(name = "productosid")
    private Integer productosid;
    @Column(name = "productosum")
    private Short productosum;
    @Column(name = "facturascantidad")
    private Integer facturascantidad;
    @Column(name = "facturaspromocion")
    private Character facturaspromocion;
    @Column(name = "facturascantidaduminima")
    private Integer facturascantidaduminima;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "facturasprecios")
    private BigDecimal facturasprecios;
    @Column(name = "facturaspreciosoriginal")
    private BigDecimal facturaspreciosoriginal;
    @Column(name = "facturasdescuentoporcentaje")
    private BigDecimal facturasdescuentoporcentaje;
    @Column(name = "impuestoid")
    private Short impuestoid;
    @Column(name = "facturasimpuestoporcentaje")
    private Short facturasimpuestoporcentaje;
    @Column(name = "facturaslineasubtotal")
    private BigDecimal facturaslineasubtotal;
    @Column(name = "facturaslineadescuento")
    private BigDecimal facturaslineadescuento;
    @Column(name = "facturaslineaimpuesto")
    private BigDecimal facturaslineaimpuesto;
    @Column(name = "facturaslineatotal")
    private BigDecimal facturaslineatotal;
    @Column(name = "preciosid")
    private Short preciosid;
    @Basic(optional = false)
    @Column(name = "descuentosid")
    private int descuentosid;
    @Column(name = "promoplm3")
    private Integer promoplm3;
    @Column(name = "promoid")
    private Integer promoid;
    @JoinColumns({
        @JoinColumn(name = "empresasid", referencedColumnName = "empresasid", insertable = false, updatable = false),
        @JoinColumn(name = "sucursalesid", referencedColumnName = "sucursalesid", insertable = false, updatable = false),
        @JoinColumn(name = "facturascmpid", referencedColumnName = "facturascmpid", insertable = false, updatable = false),
        @JoinColumn(name = "facturaspuntoexpedicionnro", referencedColumnName = "facturaspuntoexpedicionnro", insertable = false, updatable = false),
        @JoinColumn(name = "facturasnumero", referencedColumnName = "facturasnumero", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Facturas facturas;

    public FacturasDetalle() {
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

    public short getFacturaslinea() {
        return facturaslinea;
    }

    @XmlElement(name = "FacturasLinea")
    public void setFacturaslinea(short facturaslinea) {
        this.facturaslinea = facturaslinea;
    }

    public Integer getProductosid() {
        return productosid;
    }

    @XmlElement(name = "ProductosId")
    public void setProductosid(Integer productosid) {
        this.productosid = productosid;
    }

    public Short getProductosum() {
        return productosum;
    }

    @XmlElement(name = "ProductosUM")
    public void setProductosum(Short productosum) {
        this.productosum = productosum;
    }

    public Integer getFacturascantidad() {
        return facturascantidad;
    }

    @XmlElement(name = "FacturasCantidad")
    public void setFacturascantidad(Integer facturascantidad) {
        this.facturascantidad = facturascantidad;
    }

    public Character getFacturaspromocion() {
        return facturaspromocion;
    }

    @XmlElement(name = "FacturasPromocion")
    public void setFacturaspromocion(Character facturaspromocion) {
        this.facturaspromocion = facturaspromocion;
    }

    public Integer getFacturascantidaduminima() {
        return facturascantidaduminima;
    }

    @XmlElement(name = "FacturasCantidadUMinima")
    public void setFacturascantidaduminima(Integer facturascantidaduminima) {
        this.facturascantidaduminima = facturascantidaduminima;
    }

    public BigDecimal getFacturasprecios() {
        return facturasprecios;
    }

    @XmlElement(name = "FacturasPrecios")
    public void setFacturasprecios(BigDecimal facturasprecios) {
        this.facturasprecios = facturasprecios;
    }

    public BigDecimal getFacturaspreciosoriginal() {
        return facturaspreciosoriginal;
    }

    @XmlElement(name = "FacturasPreciosOriginal")
    public void setFacturaspreciosoriginal(BigDecimal facturaspreciosoriginal) {
        this.facturaspreciosoriginal = facturaspreciosoriginal;
    }

    public BigDecimal getFacturasdescuentoporcentaje() {
        return facturasdescuentoporcentaje;
    }

    @XmlElement(name = "FacturasDescuentoPorcentaje")
    public void setFacturasdescuentoporcentaje(BigDecimal facturasdescuentoporcentaje) {
        this.facturasdescuentoporcentaje = facturasdescuentoporcentaje;
    }

    public Short getImpuestoid() {
        return impuestoid;
    }

    @XmlElement(name = "ImpuestoId")
    public void setImpuestoid(Short impuestoid) {
        this.impuestoid = impuestoid;
    }

    public Short getFacturasimpuestoporcentaje() {
        return facturasimpuestoporcentaje;
    }

    @XmlElement(name = "FacturasImpuestoPorcentaje")
    public void setFacturasimpuestoporcentaje(Short facturasimpuestoporcentaje) {
        this.facturasimpuestoporcentaje = facturasimpuestoporcentaje;
    }

    public BigDecimal getFacturaslineasubtotal() {
        return facturaslineasubtotal;
    }

    @XmlElement(name = "FacturasLineaSubTotal")
    public void setFacturaslineasubtotal(BigDecimal facturaslineasubtotal) {
        this.facturaslineasubtotal = facturaslineasubtotal;
    }

    public BigDecimal getFacturaslineadescuento() {
        return facturaslineadescuento;
    }

    @XmlElement(name = "FacturasLineaDescuento")
    public void setFacturaslineadescuento(BigDecimal facturaslineadescuento) {
        this.facturaslineadescuento = facturaslineadescuento;
    }

    public BigDecimal getFacturaslineaimpuesto() {
        return facturaslineaimpuesto;
    }

    @XmlElement(name = "FacturasLineaImpuesto")
    public void setFacturaslineaimpuesto(BigDecimal facturaslineaimpuesto) {
        this.facturaslineaimpuesto = facturaslineaimpuesto;
    }

    public BigDecimal getFacturaslineatotal() {
        return facturaslineatotal;
    }

    @XmlElement(name = "FacturasLineaTotal")
    public void setFacturaslineatotal(BigDecimal facturaslineatotal) {
        this.facturaslineatotal = facturaslineatotal;
    }

    public Short getPreciosid() {
        return preciosid;
    }

    @XmlElement(name = "PreciosId")
    public void setPreciosid(Short preciosid) {
        this.preciosid = preciosid;
    }

    public int getDescuentosid() {
        return descuentosid;
    }

    @XmlElement(name = "DescuentosId")
    public void setDescuentosid(int descuentosid) {
        this.descuentosid = descuentosid;
    }

    public Integer getPromoplm3() {
        return promoplm3;
    }

    @XmlElement(name = "PromoPlm3")
    public void setPromoplm3(Integer promoplm3) {
        this.promoplm3 = promoplm3;
    }

    public Integer getPromoid() {
        return promoid;
    }

    @XmlElement(name = "PromoId")
    public void setPromoid(Integer promoid) {
        this.promoid = promoid;
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
        hash = 53 * hash + this.facturascmpid;
        hash = 53 * hash + this.facturaspuntoexpedicionnro;
        hash = 53 * hash + this.facturasnumero;
        hash = 53 * hash + this.facturaslinea;
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
        final FacturasDetalle other = (FacturasDetalle) obj;
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
        if (this.facturaslinea != other.facturaslinea) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.serviciopocket.gcmovil.entity.Facturasdetalle[ facturasdetallePK=" + facturaslinea + " ]";
    }
}
