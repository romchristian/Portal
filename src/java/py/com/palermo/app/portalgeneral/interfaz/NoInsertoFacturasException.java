/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.interfaz;



/**
 *
 * @author cromero
 */

public class NoInsertoFacturasException extends Exception {

    String message;

    public NoInsertoFacturasException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "[FACTURAS] Error al insertar en gcventas: " + message;
    }
}
