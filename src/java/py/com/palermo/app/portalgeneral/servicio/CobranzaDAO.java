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
import py.com.palermo.app.portalgeneral.modelo.Cobranza;
import py.com.palermo.app.portalgeneral.web.util.Credencial;

/**
 *
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CobranzaDAO extends AbstractDAO<Cobranza> {

    @Inject
    private Credencial credencial;

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Cobranza create(Cobranza entity) {
        return abmService.create(entity);
    }

    @Override
    public Cobranza edit(Cobranza entity) {
        return abmService.update(entity);
    }

    @Override
    public void remove(Cobranza entity) {
        abmService.delete(entity);
    }

    @Override
    public Cobranza find(Object id) {
        return abmService.find(id, Cobranza.class);
    }

    @Override
    public List<Cobranza> findAll() {
        return abmService.getEM().createQuery("SELECT c FROM Cobranza c").getResultList();
    }

    @Override
    public List<Cobranza> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

}
