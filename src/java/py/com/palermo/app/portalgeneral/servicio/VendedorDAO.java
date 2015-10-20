/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Vendedor;

/**
 *
 * @author cromero
 */
@Stateless
public class VendedorDAO {

    @PersistenceContext(unitName = "GCMovilPU")
    private EntityManager em;

    public List<Vendedor> findAll(Integer sucursalId) {
        return em.createQuery("SELECT v FROM Vendedor v WHERE v.sucursalesid = ?1")
                .setParameter(1, sucursalId).getResultList();
    }

    public Vendedor find(Integer sucursalId, Integer vendedorId) {
        Vendedor R = null;
        try {
            R = (Vendedor) em.createQuery("SELECT v FROM Vendedor v WHERE v.sucursalesid = ?1 AND v.vendedorid = ?2")
                    .setParameter(1, sucursalId)
                    .setParameter(2, vendedorId)
                    .getSingleResult();

        } catch (Exception e) {
        }

        return R;
    }

    public void setDeviceId(Vendedor v,String deviceId) {
        
        em.createQuery("UPDATE Vendedor v set v.deviceid = null WHERE v.deviceid = ?1")
                .setParameter(1, deviceId)
                .executeUpdate();
        
        v.setDeviceid(deviceId);
        em.merge(v);
    }

}
