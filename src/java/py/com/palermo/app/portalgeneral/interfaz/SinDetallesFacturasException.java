/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.interfaz;

/**
 *
 * @author cromero
 */

public class SinDetallesFacturasException extends Exception {

    String message;

    public SinDetallesFacturasException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "[FACTURAS] Error de conexion: Intente de Nuevo";
    }
}
