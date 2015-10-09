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
@XmlType(name = "ProductosMedidas")
public class ProductosMedidas {

    private Integer ProductoId;
    private Integer ProductosUM;
    private String ProductosUMNombre;
    private Integer ProductosUMCantidad;
    private BigDecimal ProductosUMLitros;
    private BigDecimal ProductosUMKilos;

    public ProductosMedidas() {
    }


    public ProductosMedidas(Integer ProductoId, Integer ProductosUM, String ProductosUMNombre, Integer ProductosUMCantidad, BigDecimal ProductosUMLitros, BigDecimal ProductosUMKilos) {
        this.ProductoId = ProductoId;
        this.ProductosUM = ProductosUM;
        this.ProductosUMNombre = ProductosUMNombre;
        this.ProductosUMCantidad = ProductosUMCantidad;
        this.ProductosUMLitros = ProductosUMLitros;
        this.ProductosUMKilos = ProductosUMKilos;
    }

    public ProductosMedidas(Object[] o) {
        this((Integer) o[0],
                (Integer) o[1],
                (String) o[2],
                (Integer) o[3],
                (BigDecimal) o[4],
                (BigDecimal) o[5]);
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

    public String getProductosUMNombre() {
        return ProductosUMNombre;
    }

    @XmlElement(name = "ProductosUMNombre")
    public void setProductosUMNombre(String ProductosUMNombre) {
        this.ProductosUMNombre = ProductosUMNombre;
    }

    public Integer getProductosUMCantidad() {
        return ProductosUMCantidad;
    }

    @XmlElement(name = "ProductosUMCantidad")
    public void setProductosUMCantidad(Integer ProductosUMCantidad) {
        this.ProductosUMCantidad = ProductosUMCantidad;
    }

    public BigDecimal getProductosUMLitros() {
        return ProductosUMLitros;
    }

    @XmlElement(name = "ProductosUMLitros")
    public void setProductosUMLitros(BigDecimal ProductosUMLitros) {
        this.ProductosUMLitros = ProductosUMLitros;
    }

    public BigDecimal getProductosUMKilos() {
        return ProductosUMKilos;
    }

    @XmlElement(name = "ProductosUMKilos")
    public void setProductosUMKilos(BigDecimal ProductosUMKilos) {
        this.ProductosUMKilos = ProductosUMKilos;
    }
}
