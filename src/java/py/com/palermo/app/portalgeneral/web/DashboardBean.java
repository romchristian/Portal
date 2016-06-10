/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.web;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author christian.romero
 */
@Named
@ViewScoped
public class DashboardBean implements Serializable {

    private Double[] datosHombres = {2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3};
    private Double[] datosMujeres = {2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3};

    public Double[] getDatosHombres() {
        return datosHombres;
    }

    public void setDatosHombres(Double[] datosHombres) {
        this.datosHombres = datosHombres;
    }

    public Double[] getDatosMujeres() {
        return datosMujeres;
    }

    public void setDatosMujeres(Double[] datosMujeres) {
        this.datosMujeres = datosMujeres;
    }

   
}
