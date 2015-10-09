/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author cromero
 */
@Stateless
//@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class DAOGcVentasPalermoCDE extends DAOGcVentasPalermo {

    @Override
    public EntityManager getEM() {
        return null;
    }
}
