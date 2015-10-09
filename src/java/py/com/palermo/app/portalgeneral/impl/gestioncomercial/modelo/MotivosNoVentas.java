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
@XmlType(name = "MotivosNoVentas")
public class MotivosNoVentas {

    private Integer motivosnoventasid;
    private String motivosnoventasnombre;

    public MotivosNoVentas() {
    }



    public MotivosNoVentas(Integer motivosnoventasid, String motivosnoventasnombre) {
        this.motivosnoventasid = motivosnoventasid;
        this.motivosnoventasnombre = motivosnoventasnombre;
    }

    public MotivosNoVentas(Object[] o) {
        this((Integer) o[0], (String) o[1]);
    }

    public Integer getMotivosnoventasid() {
        return motivosnoventasid;
    }

    @XmlElement(name = "MotivosNoVentasId")
    public void setMotivosnoventasid(Integer motivosnoventasid) {
        this.motivosnoventasid = motivosnoventasid;
    }

    public String getMotivosnoventasnombre() {
        return motivosnoventasnombre;
    }

    @XmlElement(name = "MotivosNoVentasNombre")
    public void setMotivosnoventasnombre(String motivosnoventasnombre) {
        this.motivosnoventasnombre = motivosnoventasnombre;
    }
}
