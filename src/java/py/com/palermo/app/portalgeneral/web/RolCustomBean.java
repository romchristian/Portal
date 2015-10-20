/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.web;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.palermo.app.portalgeneral.modelo.RolCustom;
import py.com.palermo.app.portalgeneral.servicio.RolCustomDAO;
import py.com.palermo.app.portalgeneral.servicio.util.AbstractDAO;
import py.com.palermo.app.portalgeneral.web.util.BeanGenerico;
import py.com.palermo.app.portalgeneral.web.util.JsfUtil;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class RolCustomBean extends BeanGenerico<RolCustom> implements Serializable {

    @EJB
    private RolCustomDAO ejb;

    @Override
    public AbstractDAO<RolCustom> getEjb() {
        return ejb;
    }

    @Override
    public RolCustom getNuevo() {
        return new RolCustom();
    }

    @Override
    public String edit() {
        if (getEjb().edit(getActual()) == null) {
            JsfUtil.addErrorMessage("Otro usuario realizó una modificación sobre el mismo dato,y pruebe de nuevo");
            return null;
        }

        JsfUtil.addSuccessMessage("Se guardó exitosamente!");
        setActual(null);
        return "listado.xhtml?faces-redirect=true";
    }

}
