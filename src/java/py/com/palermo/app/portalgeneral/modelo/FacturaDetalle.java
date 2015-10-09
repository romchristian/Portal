/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cromero
 */
@XmlRootElement(name = "FacturaDetalle")
@Entity
public class FacturaDetalle implements Serializable {

    @Id
    private String id;
    @Column(name = "facturaid")
    private String facturaId;
    private Integer linea;

    private Long descuentoPorcentaje;
    private Integer impuestoPorcentaje;

    private Integer descuentoId;
    private Integer cantidadMinima;
    private Integer precioId;
    private Integer impuestoId;
    private Integer productoId;
    private int promoId;

    private BigDecimal cantidad;
    private BigDecimal precio;
    private BigDecimal preciosOriginal;
    private BigDecimal descuento;
    private BigDecimal impuesto;
    private BigDecimal subtotal;
    private BigDecimal total;

    private Integer productoUmId;
    
    private String descripcion;
    private String unidadMedidaDesc;

    
    @ManyToOne
    @JoinColumn(name = "facturaid", referencedColumnName = "id", updatable = false, insertable = false)
    private Factura factura;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(String facturaId) {
        this.facturaId = facturaId;
    }

    public Integer getLinea() {
        return linea;
    }

    public void setLinea(Integer linea) {
        this.linea = linea;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Long getDescuentoPorcentaje() {
        return descuentoPorcentaje;
    }

    public void setDescuentoPorcentaje(Long descuentoPorcentaje) {
        this.descuentoPorcentaje = descuentoPorcentaje;
    }

    public Integer getImpuestoPorcentaje() {
        return impuestoPorcentaje;
    }

    public void setImpuestoPorcentaje(Integer impuestoPorcentaje) {
        this.impuestoPorcentaje = impuestoPorcentaje;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(BigDecimal impuesto) {
        this.impuesto = impuesto;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getDescuentoId() {
        return descuentoId;
    }

    public void setDescuentoId(Integer descuentoId) {
        this.descuentoId = descuentoId;
    }

    public Integer getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(Integer cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public Integer getPrecioId() {
        return precioId;
    }

    public void setPrecioId(Integer precioId) {
        this.precioId = precioId;
    }

    public Integer getImpuestoId() {
        return impuestoId;
    }

    public void setImpuestoId(Integer impuestoId) {
        this.impuestoId = impuestoId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public BigDecimal getPreciosOriginal() {
        return preciosOriginal;
    }

    public void setPreciosOriginal(BigDecimal preciosOriginal) {
        this.preciosOriginal = preciosOriginal;
    }

    public Integer getProductoUmId() {
        return productoUmId;
    }

    public void setProductoUmId(Integer productoUmId) {
        this.productoUmId = productoUmId;
    }

    public int getPromoId() {
        return promoId;
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidadMedidaDesc() {
        return unidadMedidaDesc;
    }

    public void setUnidadMedidaDesc(String unidadMedidaDesc) {
        this.unidadMedidaDesc = unidadMedidaDesc;
    }

    
    
    public Factura getFactura() {
        return factura;
    }

    @XmlTransient
    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final FacturaDetalle other = (FacturaDetalle) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
