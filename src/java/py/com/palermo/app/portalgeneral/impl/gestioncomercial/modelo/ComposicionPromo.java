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
@XmlType(name = "ComposicionPromo")
public class ComposicionPromo {

    private Integer ProductoIdKit;
    private Integer ProductoId;
    private Integer CantidadProducto;
    private Short Imprimible;

    public ComposicionPromo() {
    }



    public ComposicionPromo(Integer ProductoIdKit, Integer ProductoId, Integer CantidadProducto, Short Imprimible) {
        this.ProductoIdKit = ProductoIdKit;
        this.ProductoId = ProductoId;
        this.CantidadProducto = CantidadProducto;
        this.Imprimible = Imprimible != null?((Integer)(Imprimible * -1)).shortValue():0;
    }

    public ComposicionPromo(Object[] o) {
        this((Integer) o[0], (Integer) o[1],(Integer) o[2],((BigDecimal) o[3]).shortValue());
    }

    public Integer getProductoIdKit() {
        return ProductoIdKit;
    }

    @XmlElement(name = "ProductoIdKit")
    public void setProductoIdKit(Integer ProductoIdKit) {
        this.ProductoIdKit = ProductoIdKit;
    }
    
    public Integer getProductoId() {
        return ProductoId;
    }

    @XmlElement(name = "ProductoId")
    public void setProductoId(Integer ProductoId) {
        this.ProductoId = ProductoId;
    }

    

    public Integer getCantidadProducto() {
        return CantidadProducto;
    }

    @XmlElement(name = "CantidadProducto")
    public void setCantidadProducto(Integer CantidadProducto) {
        this.CantidadProducto = CantidadProducto;
    }

    public Short getImprimible() {
        return Imprimible;
    }

    @XmlElement(name = "Imprimible")
    public void setImprimible(Short Imprimible) {
        this.Imprimible = Imprimible;
    }

    
}
