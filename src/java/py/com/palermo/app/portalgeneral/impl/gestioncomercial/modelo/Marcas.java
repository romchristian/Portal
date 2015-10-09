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
@XmlType(name = "Marcas")
public class Marcas {

    private Integer Marcasid;
    private String MarcasDescripcion;
    private Integer MarcasOrden;

    public Marcas() {
    }



    public Marcas(Integer Marcasid, String MarcasDescripcion, Integer MarcasOrden) {
        this.Marcasid = Marcasid;
        this.MarcasDescripcion = MarcasDescripcion;
        this.MarcasOrden = MarcasOrden;
    }

    public Marcas(Object[] o) {
        this((Integer) o[0], (String) o[1], (Integer) o[2]);
    }

    public Integer getMarcasid() {
        return Marcasid;
    }

    @XmlElement(name = "MarcasId")
    public void setMarcasid(Integer Marcasid) {
        this.Marcasid = Marcasid;
    }

    public String getMarcasDescripcion() {
        return MarcasDescripcion;
    }

    @XmlElement(name = "MarcasDescripcion")
    public void setMarcasDescripcion(String MarcasDescripcion) {
        this.MarcasDescripcion = MarcasDescripcion;
    }

    public Integer getMarcasOrden() {
        return MarcasOrden;
    }

    @XmlElement(name = "MarcasOrden")
    public void setMarcasOrden(Integer MarcasOrden) {
        this.MarcasOrden = MarcasOrden;
    }
}
