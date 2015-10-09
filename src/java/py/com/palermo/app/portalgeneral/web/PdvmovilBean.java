/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.web;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.palermo.app.portalgeneral.modelo.Pdvmovil;
import py.com.palermo.app.portalgeneral.servicio.PdvmovilDAO;
import py.com.palermo.app.portalgeneral.servicio.util.AbstractDAO;
import py.com.palermo.app.portalgeneral.web.util.BeanGenerico;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class PdvmovilBean extends BeanGenerico<Pdvmovil> implements Serializable {

    @EJB
    private PdvmovilDAO ejb;

    @Override
    public AbstractDAO<Pdvmovil> getEjb() {
        return ejb;
    }

    @Override
    public Pdvmovil getNuevo() {
        return new Pdvmovil();
    }
}
