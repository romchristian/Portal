/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.interfaz;

/**
 *
 * @author cromero
 */
public class NoHayCmpCobranzaException extends Exception{

    @Override
    public String getMessage() {
        return "No hay comprobante cobranza";
    }
    
}
