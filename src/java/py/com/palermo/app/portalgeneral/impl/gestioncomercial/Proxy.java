/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import py.com.palermo.app.portalgeneral.interfaz.AccesoDenegadoException;

/**
 *
 * @author cromero
 */
@Stateless
public class Proxy {

    @EJB
    private DAOGcVentasPalermoASU daoASU;
    @EJB
    private DAOGcVentasPalermoCDE daoCDE;
    @EJB
    private DAOGcVentasPalermoENC daoENC;
    @EJB
    private DAOGcVentasPalermoPJC daoPJC;

    public DAOGcVentasPalermo getContenedorGCVentas(int sucursalid) throws AccesoDenegadoException {
        DAOGcVentasPalermo R = null;

        switch (sucursalid) {
            case 1:
                R = daoASU;
                break;
            case 2:
                R = daoCDE;
                break;
            case 4:
                R = daoPJC;
                break;
            case 111:
                R = daoENC;
                break;
            default:
                throw new AccesoDenegadoException();

        }

        return R;
    }
}
