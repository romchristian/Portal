/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.web;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import py.com.palermo.app.portalgeneral.modelo.Factura;
import py.com.palermo.app.portalgeneral.servicio.FacturaDAO;
import py.com.palermo.app.portalgeneral.servicio.util.AbstractDAO;
import py.com.palermo.app.portalgeneral.web.util.BeanGenerico;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class FacturaBean extends BeanGenerico<Factura> implements Serializable {

    @EJB
    private FacturaDAO ejb;
    private MapModel emptyModel;

    private String idFact;

    @PostConstruct
    public void init() {
        emptyModel = new DefaultMapModel();
    }

    public String getIdFact() {
        return idFact;
    }

    public void setIdFact(String idFact) {
        this.idFact = idFact;
    }

    public MapModel getEmptyModel() {
        return emptyModel;
    }

    public void setEmptyModel(MapModel emptyModel) {
        this.emptyModel = emptyModel;
    }

    @Override
    public String cargaDatos() {
        if (idFact != null) {
            setActual(getEjb().find(idFact));
        }
        return null;
    }

    @Override
    public AbstractDAO<Factura> getEjb() {
        return ejb;
    }

    @Override
    public Factura getNuevo() {
        return new Factura();
    }

     public void addMarker() {
        double lat =  Double.parseDouble(getActual().getGpsLat());
        double lng =  Double.parseDouble(getActual().getGpsLong());
        String title = "";
        
        emptyModel = new DefaultMapModel();
        org.primefaces.model.map.Marker marker = new org.primefaces.model.map.Marker(new LatLng(lat, lng), title);
        emptyModel.addOverlay(marker);
          
     
    }
}
