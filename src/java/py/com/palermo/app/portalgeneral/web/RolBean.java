/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.web;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.palermo.app.portalgeneral.modelo.Rol;
import py.com.palermo.app.portalgeneral.servicio.RolDAO;
import py.com.palermo.app.portalgeneral.servicio.util.AbstractDAO;
import py.com.palermo.app.portalgeneral.web.util.BeanGenerico;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class RolBean extends BeanGenerico<Rol> implements Serializable {

    @EJB
    private RolDAO ejb;
 
    @Override
    public AbstractDAO<Rol> getEjb() {
        return ejb;
    }

    @Override
    public Rol getNuevo() {
        return new Rol();
    }

}
