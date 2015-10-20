/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.web;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import py.com.palermo.app.portalgeneral.modelo.Pdvmovil;
import py.com.palermo.app.portalgeneral.servicio.PdvmovilDAO;
import py.com.palermo.app.portalgeneral.servicio.util.AbstractDAO;
import py.com.palermo.app.portalgeneral.web.util.BeanGenerico;
import py.com.palermo.app.portalgeneral.web.util.JsfUtil;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class PdvmovilBean extends BeanGenerico<Pdvmovil> implements Serializable {

    @EJB
    private PdvmovilDAO ejb;
    private MapModel emptyModel;

    public MapModel getEmptyModel() {
        return emptyModel;
    }

    public void setEmptyModel(MapModel emptyModel) {
        this.emptyModel = emptyModel;
    }

    @Override
    public AbstractDAO<Pdvmovil> getEjb() {
        return ejb;
    }

    @Override
    public Pdvmovil getNuevo() {
        return new Pdvmovil();
    }

    public void addMarker() {

        String title = "";

        Double lat = getActual().getLat();
        Double longitud = getActual().getLongitud();

        if (lat != null && longitud != null) {
            emptyModel = new DefaultMapModel();
            org.primefaces.model.map.Marker marker = new org.primefaces.model.map.Marker(new LatLng(lat, longitud), title);
            emptyModel.addOverlay(marker);
        }else{
            JsfUtil.addSuccessMessage("No se registro la ubicación de este dispositivo!");
        }

    }
    
    public void toggleActivacion(){
        if(getActual() != null && getActual().getEstado() != null){
            if(getActual().getEstado().compareToIgnoreCase("ACTIVO")==0){
                getActual().setEstado("INACTIVO");
                edit();
            }else if(getActual().getEstado().compareToIgnoreCase("INACTIVO")==0){
                getActual().setEstado("ACTIVO");
                edit();
            }
        }
        
    }
}
