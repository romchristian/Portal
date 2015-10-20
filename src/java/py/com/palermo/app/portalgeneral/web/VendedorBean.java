/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.web;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Vendedor;
import py.com.palermo.app.portalgeneral.servicio.VendedorDAO;
import py.com.palermo.app.portalgeneral.web.util.JsfUtil;

/**
 *
 * @author cromero
 */
@Named
@ViewScoped
public class VendedorBean implements Serializable {

    @EJB
    private VendedorDAO ejbVendedor;

    public SelectItem[] getItemsAvailableVendedor() {
        return JsfUtil.getSelectItems(ejbVendedor.findAll(1), true);
    }

    public Vendedor find(Long id) {
        return ejbVendedor.find(1, id.intValue());
    }
}
