/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author cromero
 */
@XmlType(name = "Precios")
public class Precios {

    private Integer ProductoId;
    private Integer ProductosUM;
    private Integer PreciosPreciosID;
    private Integer PreciosDesde;
    private Integer PreciosHasta;
    private BigDecimal PreciosImporte;

    public Precios() {
    }


    public Precios(Integer ProductoId, Integer ProductosUM, Integer PreciosPreciosID, Integer PreciosDesde, Integer PreciosHasta, BigDecimal PreciosImporte) {
        this.ProductoId = ProductoId;
        this.ProductosUM = ProductosUM;
        this.PreciosPreciosID = PreciosPreciosID;
        this.PreciosDesde = PreciosDesde;
        this.PreciosHasta = PreciosHasta;
        this.PreciosImporte = PreciosImporte;
    }

    public Precios(Object[]o) {
        this((Integer)o[0],
                (Integer)o[1],
                (Integer)o[2],
                (Integer)o[3],
                (Integer)o[4],
                (BigDecimal)o[5]);
    }

    
    
    public Integer getProductoId() {
        return ProductoId;
    }

    @XmlElement(name = "ProductoId")
    public void setProductoId(Integer ProductoId) {
        this.ProductoId = ProductoId;
    }

    public Integer getProductosUM() {
        return ProductosUM;
    }

    @XmlElement(name = "ProductosUM")
    public void setProductosUM(Integer ProductosUM) {
        this.ProductosUM = ProductosUM;
    }

    public Integer getPreciosPreciosID() {
        return PreciosPreciosID;
    }

    @XmlElement(name = "PreciosPreciosID")
    public void setPreciosPreciosID(Integer PreciosPreciosID) {
        this.PreciosPreciosID = PreciosPreciosID;
    }

    public Integer getPreciosDesde() {
        return PreciosDesde;
    }

    @XmlElement(name = "PreciosDesde")
    public void setPreciosDesde(Integer PreciosDesde) {
        this.PreciosDesde = PreciosDesde;
    }

    public Integer getPreciosHasta() {
        return PreciosHasta;
    }

    @XmlElement(name = "PreciosHasta")
    public void setPreciosHasta(Integer PreciosHasta) {
        this.PreciosHasta = PreciosHasta;
    }

    public BigDecimal getPreciosImporte() {
        return PreciosImporte;
    }

    @XmlElement(name = "PreciosImporte")
    public void setPreciosImporte(BigDecimal PreciosImporte) {
        this.PreciosImporte = PreciosImporte;
    }
}
