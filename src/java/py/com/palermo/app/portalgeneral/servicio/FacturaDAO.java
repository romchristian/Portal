/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.servicio;

import java.util.ArrayList;
import py.com.palermo.app.portalgeneral.servicio.util.QueryParameter;
import py.com.palermo.app.portalgeneral.servicio.util.ABMService;
import py.com.palermo.app.portalgeneral.servicio.util.AbstractDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Vendedor;
import py.com.palermo.app.portalgeneral.modelo.Factura;
import py.com.palermo.app.portalgeneral.web.util.Credencial;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class FacturaDAO extends AbstractDAO<Factura> {

    @Inject
    private Credencial credencial;

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Factura create(Factura entity) {
        return abmService.create(entity);
    }

    @Override
    public Factura edit(Factura entity) {
        return abmService.update(entity);
    }

    @Override
    public void remove(Factura entity) {
        abmService.delete(entity);
    }

    @Override
    public Factura find(Object id) {
        return abmService.find(id, Factura.class);
    }

    @Override
    public List<Factura> findAll() {
        List<Factura> R = new ArrayList<>();
            System.out.println("usuario : " + credencial.getUsuario());
        
        if (credencial.getUsuario() != null && credencial.getUsuario().getRolcustom() != null) {
            System.out.println("Rol : " + credencial.getUsuario().getRolcustom().getNombre());
            
            if (credencial.getUsuario().getRolcustom().getNombre().compareToIgnoreCase("Gerente") == 0) {
                R = abmService.getEM().createQuery("select obj from Factura obj ").getResultList();
            } else if (credencial.getUsuario().getRolcustom().getNombre().compareToIgnoreCase("Supervisor Territorio") == 0) {
                R = abmService.getEM().createQuery("select obj from Factura obj WHERE OBJ.territorio = :territorio")
                        .setParameter("territorio", credencial.getUsuario().getTerritorio())
                        .getResultList();
            } else if (credencial.getUsuario().getRolcustom().getNombre().compareToIgnoreCase("Vendedor") == 0) {
                R = abmService.getEM().createQuery("select obj from Factura obj WHERE UPPER(OBJ.usuario) = :usuario")
                        .setParameter("usuario", credencial.getUsuario().getUsername().trim().toUpperCase())
                        .getResultList();
            }
        }

        return R;
    }
    
    
    

    @Override
    public List<Factura> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
