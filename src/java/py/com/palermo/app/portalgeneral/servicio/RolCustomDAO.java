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
import py.com.palermo.app.portalgeneral.modelo.RolCustom;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class RolCustomDAO extends AbstractDAO<RolCustom> {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public RolCustom create(RolCustom entity) {
        return abmService.create(entity);
    }

    @Override
    public RolCustom edit(RolCustom entity) {
        System.out.println("HOLA1");
        for(Rol r: entity.getRoles()){
            System.out.println("Rol: " + r);
        }
        System.out.println("HOLA2");
        return abmService.update(entity);
    }

    @Override
    public void remove(RolCustom entity) {
        abmService.delete(entity);
    }

    @Override
    public RolCustom find(Object id) {
        return abmService.find(id, RolCustom.class);
    }

    @Override
    public List<RolCustom> findAll() {
        return abmService.getEM().createQuery("select obj from RolCustom obj").getResultList();
    }

    @Override
    public List<RolCustom> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
