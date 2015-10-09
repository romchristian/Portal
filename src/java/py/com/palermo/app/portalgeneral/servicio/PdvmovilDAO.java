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
import py.com.palermo.app.portalgeneral.modelo.Pdvmovil;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PdvmovilDAO extends AbstractDAO<Pdvmovil> {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Pdvmovil create(Pdvmovil entity) {
        return abmService.create(entity);
    }

    @Override
    public Pdvmovil edit(Pdvmovil entity) {
        return abmService.update(entity);
    }

    @Override
    public void remove(Pdvmovil entity) {
        abmService.delete(entity);
    }

    @Override
    public Pdvmovil find(Object id) {
        return abmService.find(id, Pdvmovil.class);
    }

    @Override
    public List<Pdvmovil> findAll() {
        return abmService.getEM().createQuery("select obj from Pdvmovil obj").getResultList();
    }

    @Override
    public List<Pdvmovil> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
