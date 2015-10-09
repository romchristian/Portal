/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.interfaz;

/**
 *
 * @author cromero
 */

public class NoSeDercargoException extends Exception {

    String message;

    public NoSeDercargoException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "Hay algunos documentos pendientes de descarga: " + message;
    }
}
