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
import py.com.palermo.app.portalgeneral.modelo.Cobranza;
import py.com.palermo.app.portalgeneral.servicio.CobranzaDAO;
import py.com.palermo.app.portalgeneral.servicio.util.AbstractDAO;
import py.com.palermo.app.portalgeneral.web.util.BeanGenerico;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class CobranzaBean extends BeanGenerico<Cobranza> implements Serializable {

    @EJB
    private CobranzaDAO ejb;
    private MapModel emptyModel;

    private String idCob;

    @PostConstruct
    public void init() {
        emptyModel = new DefaultMapModel();
    }

    public String getIdCob() {
        return idCob;
    }

    public void setIdCob(String idCob) {
        this.idCob = idCob;
    }

    public MapModel getEmptyModel() {
        return emptyModel;
    }

    public void setEmptyModel(MapModel emptyModel) {
        this.emptyModel = emptyModel;
    }

    @Override
    public String cargaDatos() {
        if (idCob != null) {
            setActual(getEjb().find(idCob));
        }
        return null;
    }

    @Override
    public AbstractDAO<Cobranza> getEjb() {
        return ejb;
    }

    @Override
    public Cobranza getNuevo() {
        return new Cobranza();
    }

    public void addMarker() {

        Double lat;
        Double lng;
        String title = "Cliente Cod: " + getActual().getClienteid();

        System.out.println("Add marker!!!!");

        
        System.out.println("Lat: " + getActual().getGpslat());
        System.out.println("Long: " + getActual().getGpslong());
        lat = Double.parseDouble(getActual().getGpslat());
        lng = Double.parseDouble(getActual().getGpslong());
        System.out.println("Parse ok");

        if (lat != null && lng != null) {
            System.out.println("Entre if");
            emptyModel = new DefaultMapModel();
            org.primefaces.model.map.Marker marker = new org.primefaces.model.map.Marker(new LatLng(lat, lng), title);
            emptyModel.addOverlay(marker);
            System.out.println("Agrego");
        } else {
            emptyModel = new DefaultMapModel();
        }

    }
}
