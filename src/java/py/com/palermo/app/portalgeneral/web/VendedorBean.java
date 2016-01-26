/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.web;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Vendedor;
import py.com.palermo.app.portalgeneral.servicio.VendedorDAO;

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
        List<Vendedor> lista = ejbVendedor.findAll(1);
        SelectItem[] R = new SelectItem[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            Vendedor v = lista.get(i);
            R[i] = new SelectItem(v.getEmpresasid()+","+v.getSucursalesid()+","+v.getVendedorid(),v.getVendedornombre());
        }
        return R;
    }

    public Vendedor find(Long id) {
        return ejbVendedor.find(1, id.intValue());
    }
    
    public Vendedor find(Integer sucursalId,Long id) {
        return ejbVendedor.find(sucursalId, id.intValue());
    }
}
