/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.servicio.response;

import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlType;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Clientes;

/**
 *
 * @author cromero
 */
/**
 * Código de retorno de la busqueda realizada Valores : -1: Error inesperado 0:
 * Busqueda realizada 1: id de la pocket debe ser mayor a cero
 */
@XmlType(name = "ClientesResponse")
public class ClientesResponse {

    private int codRetorno;
    private Clientes[] Clientes;
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

    public Clientes[] getClientes() {
        return Clientes;
    }

    @XmlElement(name = "Clientes")
    public void setClientes(Clientes[] Clientes) {
        this.Clientes = Clientes;
    }
}
