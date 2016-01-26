/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.web;

import com.unboundid.ldap.sdk.LDAPException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Vendedor;
import py.com.palermo.app.portalgeneral.modelo.Usuario;
import py.com.palermo.app.portalgeneral.servicio.UsuarioDAO;
import py.com.palermo.app.portalgeneral.servicio.VendedorDAO;
import py.com.palermo.app.portalgeneral.servicio.util.AbstractDAO;
import py.com.palermo.app.portalgeneral.web.util.BeanGenerico;
import py.com.palermo.app.portalgeneral.web.util.JsfUtil;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class UsuarioBean extends BeanGenerico<Usuario> implements Serializable {

    @EJB
    private UsuarioDAO ejb;
    private String vendedorNombre;

    @Override
    public AbstractDAO<Usuario> getEjb() {
        return ejb;
    }

    @Override
    public Usuario getNuevo() {
        return new Usuario();
    }

    public void migrar() {
        try {
            ejb.migrar();
            JsfUtil.addSuccessMessage("Se migró exitosamente");
        } catch (LDAPException ex) {
            JsfUtil.addErrorMessage("Hubo un problema al migrar!");
        }
    }

    @EJB
    private VendedorDAO ejbVendedor;

    public Vendedor findVendedor(Integer sucursalId, Long id) {
        return ejbVendedor.find(sucursalId, id.intValue());
    }

    public String getVendedorNombre() {
        if (getActual() != null && getActual().getReferenciaExterna() != null) {
            String[] pk = getActual().getReferenciaExterna().split(",");
            Integer empresaId = Integer.parseInt(pk[0]);
            Integer sucursalId = Integer.parseInt(pk[1]);
            Long vendedorId = Long.parseLong(pk[2]);
            Vendedor v = findVendedor(sucursalId, vendedorId);
            if (v != null) {
                vendedorNombre = v.getVendedornombre();
            }
        }
        return vendedorNombre;
    }

    public void setVendedorNombre(String vendedorNombre) {
        this.vendedorNombre = vendedorNombre;
    }

}
