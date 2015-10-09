/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.servicio.response;

import javax.xml.bind.annotation.XmlRootElement;
import py.com.palermo.app.portalgeneral.modelo.Rol;
import py.com.palermo.app.portalgeneral.modelo.Usuario;

/**
 *
 * @author cromero
 */

@XmlRootElement
public class UsuarioResponse {

    private String mensaje;
    private Usuario usuario;
    private Rol[] roles;

    public String getMensaje() {
        return mensaje;
    }


    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    
    public Usuario getUsuario() {
        return usuario;
    }

    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol[] getRoles() {
        return roles;
    }

    public void setRoles(Rol[] roles) {
        this.roles = roles;
    }
        

}
