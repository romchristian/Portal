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
@XmlType(name = "Canales")
public class Canales {

    private Integer CanalesId;
    private String CanalesDescripcion;

    public Canales() {
    }



    public Canales(Integer CanalesId, String CanalesDescripcion) {
        this.CanalesId = CanalesId;
        this.CanalesDescripcion = CanalesDescripcion;
    }

    public Canales(Object[] o) {
        this(((Short) o[0]).intValue(), (String) o[1]);
    }

    public Integer getCanalesId() {
        return CanalesId;
    }

    @XmlElement(name = "CanalesId")
    public void setCanalesId(Integer CanalesId) {
        this.CanalesId = CanalesId;
    }

    public String getCanalesDescripcion() {
        return CanalesDescripcion;
    }

    @XmlElement(name = "CanalesDescripcion")
    public void setCanalesDescripcion(String CanalesDescripcion) {
        this.CanalesDescripcion = CanalesDescripcion;
    }
}
