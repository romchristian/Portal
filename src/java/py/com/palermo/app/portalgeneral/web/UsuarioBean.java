/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.web;

import com.unboundid.ldap.sdk.LDAPException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Vendedor;
import py.com.palermo.app.portalgeneral.modelo.Pdvmovil;
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
    @EJB
    private VendedorDAO ejbVendedor;
    private Vendedor vendedorSelecciando;
    private Pdvmovil pdvmovilSelecionado;

    @Override
    public String edit() {

        if (vendedorSelecciando != null && pdvmovilSelecionado != null) {
            getActual().setReferenciaExterna(vendedorSelecciando.getVendedorid() + "");
            ejbVendedor.setDeviceId(vendedorSelecciando, pdvmovilSelecionado.getDeviceid());
        }
        return super.edit();
    }

    @Override
    public String create() {
        if (vendedorSelecciando != null && pdvmovilSelecionado != null) {
            getActual().setReferenciaExterna(vendedorSelecciando.getVendedorid() + "");
            ejbVendedor.setDeviceId(vendedorSelecciando, pdvmovilSelecionado.getDeviceid());
        }
        return super.create(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario getActual() {
        Usuario u = super.getActual(); //To change body of generated methods, choose Tools | Templates.
        if (u.getReferenciaExterna() != null && vendedorSelecciando == null) {
            try {
                Vendedor v = ejbVendedor.find(1, Integer.parseInt(u.getReferenciaExterna()));
                vendedorSelecciando = v;
            } catch (Exception e) {
            }
        }
        return u;
    }

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

    public Vendedor getVendedorSelecciando() {
        return vendedorSelecciando;
    }

    public void setVendedorSelecciando(Vendedor vendedorSelecciando) {
        this.vendedorSelecciando = vendedorSelecciando;
    }

    public Pdvmovil getPdvmovilSelecionado() {
        return pdvmovilSelecionado;
    }

    public void setPdvmovilSelecionado(Pdvmovil pdvmovilSelecionado) {
        this.pdvmovilSelecionado = pdvmovilSelecionado;
    }

}
