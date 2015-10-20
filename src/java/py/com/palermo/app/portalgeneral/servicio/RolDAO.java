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
import py.com.palermo.app.portalgeneral.modelo.Rol;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class RolDAO extends AbstractDAO<Rol> {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Rol create(Rol entity) {
        return abmService.create(entity);
    }

    @Override
    public Rol edit(Rol entity) {
        return abmService.update(entity);
    }

    @Override
    public void remove(Rol entity) {
        abmService.delete(entity);
    }

    @Override
    public Rol find(Object id) {
        return abmService.find(id, Rol.class);
    }

    @Override
    public List<Rol> findAll() {
        return abmService.getEM().createQuery("select obj from Rol obj").getResultList();
    }

    @Override
    public List<Rol> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
