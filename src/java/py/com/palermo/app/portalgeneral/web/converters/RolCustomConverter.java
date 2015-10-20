/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.web.converters;

import javax.faces.convert.FacesConverter;
import py.com.palermo.app.portalgeneral.modelo.RolCustom;

/**
 *
 * @author cromero
 */
@FacesConverter(forClass = RolCustom.class)
public class RolCustomConverter extends ConverterGenerico<RolCustom> {

    @Override
    public String getBeanName() {
        return "rolCustomBean";
    }
}
