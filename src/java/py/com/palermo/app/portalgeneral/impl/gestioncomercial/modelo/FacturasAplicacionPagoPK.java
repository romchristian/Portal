/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;

import java.io.Serializable;

/**
 *
 * @author cromero
 */
public class FacturasAplicacionPagoPK implements Serializable {

    private short empresasid;
    private short sucursalesid;
    private short facturascobroscmpid;
    private short facturascobrospuntoexpedicionnro;
    private int facturascobrosnumero;
    private short facturascobrosvalorlinea;
    private short facturascmpid;
    private short facturaspuntoexpedicionnro;
    private int facturasnumero;

    public FacturasAplicacionPagoPK() {
    }

    public FacturasAplicacionPagoPK(short empresasid, short sucursalesid, short facturascobroscmpid, short facturascobrospuntoexpedicionnro, int facturascobrosnumero, short facturascobrosvalorlinea, short facturascmpid, short facturaspuntoexpedicionnro, int facturasnumero) {
        this.empresasid = empresasid;
        this.sucursalesid = sucursalesid;
        this.facturascobroscmpid = facturascobroscmpid;
        this.facturascobrospuntoexpedicionnro = facturascobrospuntoexpedicionnro;
        this.facturascobrosnumero = facturascobrosnumero;
        this.facturascobrosvalorlinea = facturascobrosvalorlinea;
        this.facturascmpid = facturascmpid;
        this.facturaspuntoexpedicionnro = facturaspuntoexpedicionnro;
        this.facturasnumero = facturasnumero;
    }

    public short getEmpresasid() {
        return empresasid;
    }

    public void setEmpresasid(short empresasid) {
        this.empresasid = empresasid;
    }

    public short getFacturascmpid() {
        return facturascmpid;
    }

    public void setFacturascmpid(short facturascmpid) {
        this.facturascmpid = facturascmpid;
    }

    public short getFacturascobroscmpid() {
        return facturascobroscmpid;
    }

    public void setFacturascobroscmpid(short facturascobroscmpid) {
        this.facturascobroscmpid = facturascobroscmpid;
    }

    public int getFacturascobrosnumero() {
        return facturascobrosnumero;
    }

    public void setFacturascobrosnumero(int facturascobrosnumero) {
        this.facturascobrosnumero = facturascobrosnumero;
    }

    public short getFacturascobrospuntoexpedicionnro() {
        return facturascobrospuntoexpedicionnro;
    }

    public void setFacturascobrospuntoexpedicionnro(short facturascobrospuntoexpedicionnro) {
        this.facturascobrospuntoexpedicionnro = facturascobrospuntoexpedicionnro;
    }

    public short getFacturascobrosvalorlinea() {
        return facturascobrosvalorlinea;
    }

    public void setFacturascobrosvalorlinea(short facturascobrosvalorlinea) {
        this.facturascobrosvalorlinea = facturascobrosvalorlinea;
    }

    public int getFacturasnumero() {
        return facturasnumero;
    }

    public void setFacturasnumero(int facturasnumero) {
        this.facturasnumero = facturasnumero;
    }

    public short getFacturaspuntoexpedicionnro() {
        return facturaspuntoexpedicionnro;
    }

    public void setFacturaspuntoexpedicionnro(short facturaspuntoexpedicionnro) {
        this.facturaspuntoexpedicionnro = facturaspuntoexpedicionnro;
    }

    public short getSucursalesid() {
        return sucursalesid;
    }

    public void setSucursalesid(short sucursalesid) {
        this.sucursalesid = sucursalesid;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FacturasAplicacionPagoPK other = (FacturasAplicacionPagoPK) obj;
        if (this.empresasid != other.empresasid) {
            return false;
        }
        if (this.sucursalesid != other.sucursalesid) {
            return false;
        }
        if (this.facturascobroscmpid != other.facturascobroscmpid) {
            return false;
        }
        if (this.facturascobrospuntoexpedicionnro != other.facturascobrospuntoexpedicionnro) {
            return false;
        }
        if (this.facturascobrosnumero != other.facturascobrosnumero) {
            return false;
        }
        if (this.facturascobrosvalorlinea != other.facturascobrosvalorlinea) {
            return false;
        }
        if (this.facturascmpid != other.facturascmpid) {
            return false;
        }
        if (this.facturaspuntoexpedicionnro != other.facturaspuntoexpedicionnro) {
            return false;
        }
        if (this.facturasnumero != other.facturasnumero) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.empresasid;
        hash = 97 * hash + this.sucursalesid;
        hash = 97 * hash + this.facturascobroscmpid;
        hash = 97 * hash + this.facturascobrospuntoexpedicionnro;
        hash = 97 * hash + this.facturascobrosnumero;
        hash = 97 * hash + this.facturascobrosvalorlinea;
        hash = 97 * hash + this.facturascmpid;
        hash = 97 * hash + this.facturaspuntoexpedicionnro;
        hash = 97 * hash + this.facturasnumero;
        return hash;
    }


    
   
}
