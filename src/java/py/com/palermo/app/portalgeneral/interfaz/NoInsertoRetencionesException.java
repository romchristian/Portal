/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.interfaz;

/**
 *
 * @author cromero
 */

public class NoInsertoRetencionesException extends Exception{

    String message;
    public NoInsertoRetencionesException(String message) {
        this.message= message;
    }

    
    @Override
    public String getMessage() {
        return "[Retenciones] Error al insertar en gcventas: " + message;
    }
    
}
