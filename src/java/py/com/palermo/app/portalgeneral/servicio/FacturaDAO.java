/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.servicio;

import py.com.palermo.app.portalgeneral.servicio.util.QueryParameter;
import py.com.palermo.app.portalgeneral.servicio.util.ABMService;
import py.com.palermo.app.portalgeneral.servicio.util.AbstractDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import py.com.palermo.app.portalgeneral.modelo.Factura;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class FacturaDAO extends AbstractDAO<Factura> {

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
        return abmService.getEM().createQuery("select obj from Factura obj").getResultList();
    }

    @Override
    public List<Factura> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
