/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.interfaz;



/**
 *
 * @author cromero
 */

public class NoInsertoCobranzasException extends Exception {

    String message;

    public NoInsertoCobranzasException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "[COBRANZA] Error al insertar en gcventas: " + message;
    }
}
