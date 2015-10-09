/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author cromero
 */
@XmlType(name = "CantMaximaClientesPromo")
public class CantMaximaClientesPromo {

    private Integer ProductoId;
    private Integer ClientesId;
    private Integer Cantidad;

    public CantMaximaClientesPromo() {
    }


    public CantMaximaClientesPromo(Integer ProductoId, Integer ClientesId, Integer Cantidad) {
        this.ProductoId = ProductoId;
        this.ClientesId = ClientesId;
        this.Cantidad = Cantidad;
    }

    public CantMaximaClientesPromo(Object[] o) {
        this((Integer) o[0], (Integer) o[1], (Integer) o[2]);
    }

    public Integer getProductoId() {
        return ProductoId;
    }

    @XmlElement(name = "ProductoId")
    public void setProductoId(Integer ProductoId) {
        this.ProductoId = ProductoId;
    }

    public Integer getClientesId() {
        return ClientesId;
    }

    @XmlElement(name = "ClientesId")
    public void setClientesId(Integer ClientesId) {
        this.ClientesId = ClientesId;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    @XmlElement(name = "Cantidad")
    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }
}
