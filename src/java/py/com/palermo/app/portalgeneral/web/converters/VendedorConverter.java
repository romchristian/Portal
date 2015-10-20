/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.web.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Vendedor;
import py.com.palermo.app.portalgeneral.modelo.Auditable;
import py.com.palermo.app.portalgeneral.web.VendedorBean;

/**
 *
 * @author cromero
 */
@FacesConverter(forClass = Vendedor.class)
public class VendedorConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }

        return getController(facesContext).find(getKey(value));
    }

    public VendedorBean getController(FacesContext facesContext) {
        return (VendedorBean) facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), null, "vendedorBean");
    }

    java.lang.Long getKey(String value) {
        java.lang.Long key;
        try {
            key = Long.valueOf(value);
        } catch (Exception e) {
            key = 0L;
        }
        return key;
    }

    String getStringKey(java.lang.Long value) {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }

        try {

            Auditable o = (Auditable) object;
            return getStringKey(o.getId());
        } catch (Exception e) {
            return null;
        }

    }
}
