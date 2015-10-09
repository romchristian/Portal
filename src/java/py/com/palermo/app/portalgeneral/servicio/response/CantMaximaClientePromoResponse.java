/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.servicio.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.CantMaximaClientesPromo;


/**
 *
 * @author cromero
 */
/**
 * Código de retorno de la busqueda realizada Valores : -1: Error inesperado 0:
 * Busqueda realizada 1: id de la pocket debe ser mayor a cero
 */
@XmlType(name = "CantMaximaClientePromoResponse")
public class CantMaximaClientePromoResponse {

    private int codRetorno;
    private CantMaximaClientesPromo[] cantMaximaClientesPromos;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    @XmlElement(name = "Mensaje")
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getCodRetorno() {
        return codRetorno;
    }

    @XmlElement(name = "codRetorno")
    public void setCodRetorno(int codRetorno) {
        this.codRetorno = codRetorno;
    }

    public CantMaximaClientesPromo[] getCantMaximaClientesPromos() {
        return cantMaximaClientesPromos;
    }

    @XmlElement(name = "CantMaximaClientesPromos")
    public void setCantMaximaClientesPromos(CantMaximaClientesPromo[] cantMaximaClientesPromos) {
        this.cantMaximaClientesPromos = cantMaximaClientesPromos;
    }
}
