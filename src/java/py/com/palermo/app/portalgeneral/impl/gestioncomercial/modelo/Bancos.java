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
@XmlType(name = "Bancos")
public class Bancos {

    private Integer BancosId;
    private String BancosNombre;

    public Bancos() {
    }


    public Bancos(Integer BancosId, String BancosNombre) {
        this.BancosId = BancosId;
        this.BancosNombre = BancosNombre;
    }

    public Bancos(Object[] o) {
        this(((Short) o[0]).intValue(), (String) o[1]);
    }

    public Integer getBancosId() {
        return BancosId;
    }

    @XmlElement(name = "BancosId")
    public void setBancosId(Integer BancosId) {
        this.BancosId = BancosId;
    }

    public String getBancosNombre() {
        return BancosNombre;
    }

    @XmlElement(name = "BancosNombre")
    public void setBancosNombre(String BancosNombre) {
        this.BancosNombre = BancosNombre;
    }
}
