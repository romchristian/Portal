/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.servicio;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import py.com.palermo.app.portalgeneral.interfaz.IServicio;
import py.com.palermo.app.portalgeneral.servicio.response.UsuarioResponse;

/**
 * REST Web Service
 *
 * @author cromero
 */
@Path("/servicio")
public class Servicio {

    @EJB
    private IServicio iServ;

    @GET
    @Produces("application/json")
    @Path("/usuario/{deviceId}")
    public UsuarioResponse getUsuario(@PathParam("deviceId") String deviceId) {
        UsuarioResponse R = iServ.getUsuario(deviceId);
        System.out.println("UsuarioResponse: " + R.getUsuario());
        return R;
    }

}
