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
@XmlType(name = "UnidadesMedida")
public class UnidadesMedida {

    private Integer UnidadesMedidaID;
    private String UnidadesMedidaNombre;
    private String UnidadesMedidaAbreviado;
    private Integer UnidadesMedidaEstado;

    public UnidadesMedida() {
    }


    public UnidadesMedida(Integer UnidadesMedidaID, String UnidadesMedidaNombre, String UnidadesMedidaAbreviado, Integer UnidadesMedidaEstado) {
        this.UnidadesMedidaID = UnidadesMedidaID;
        this.UnidadesMedidaNombre = UnidadesMedidaNombre;
        this.UnidadesMedidaAbreviado = UnidadesMedidaAbreviado;
        this.UnidadesMedidaEstado = UnidadesMedidaEstado;
    }

    public UnidadesMedida(Object[] o) {
        this((Integer) o[0],
                (String) o[1],
                (String) o[2],
                (Integer) o[3]);
    }

    public Integer getUnidadesMedidaID() {
        return UnidadesMedidaID;
    }

    @XmlElement(name = "UnidadesMedidaID")
    public void setUnidadesMedidaID(Integer UnidadesMedidaID) {
        this.UnidadesMedidaID = UnidadesMedidaID;
    }

    public String getUnidadesMedidaNombre() {
        return UnidadesMedidaNombre;
    }

    @XmlElement(name = "UnidadesMedidaNombre")
    public void setUnidadesMedidaNombre(String UnidadesMedidaNombre) {
        this.UnidadesMedidaNombre = UnidadesMedidaNombre;
    }

    public String getUnidadesMedidaAbreviado() {
        return UnidadesMedidaAbreviado;
    }

    @XmlElement(name = "UnidadesMedidaAbreviado")
    public void setUnidadesMedidaAbreviado(String UnidadesMedidaAbreviado) {
        this.UnidadesMedidaAbreviado = UnidadesMedidaAbreviado;
    }

    public Integer getUnidadesMedidaEstado() {
        return UnidadesMedidaEstado;
    }

    @XmlElement(name = "UnidadesMedidaEstado")
    public void setUnidadesMedidaEstado(Integer UnidadesMedidaEstado) {
        this.UnidadesMedidaEstado = UnidadesMedidaEstado;
    }
}
