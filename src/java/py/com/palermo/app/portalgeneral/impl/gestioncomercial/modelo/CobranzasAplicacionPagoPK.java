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
public class CobranzasAplicacionPagoPK implements Serializable {

    private short empresasid;
    private short sucursalesid;
    private short cobranzascobroscmpid;
    private int cobranzascobrosnumero;
    private short cobranzascobroslinea;
    private short facturascmpid;
    private short facturaspuntoexpedicionnro;
    private int facturasnumero;

    public CobranzasAplicacionPagoPK() {
    }

    public CobranzasAplicacionPagoPK(short empresasid, short sucursalesid, short cobranzascobroscmpid, int cobranzascobrosnumero, short cobranzascobroslinea, short facturascmpid, short facturaspuntoexpedicionnro, int facturasnumero) {
        this.empresasid = empresasid;
        this.sucursalesid = sucursalesid;
        this.cobranzascobroscmpid = cobranzascobroscmpid;
        this.cobranzascobrosnumero = cobranzascobrosnumero;
        this.cobranzascobroslinea = cobranzascobroslinea;
        this.facturascmpid = facturascmpid;
        this.facturaspuntoexpedicionnro = facturaspuntoexpedicionnro;
        this.facturasnumero = facturasnumero;
    }

    public short getCobranzascobroscmpid() {
        return cobranzascobroscmpid;
    }

    public void setCobranzascobroscmpid(short cobranzascobroscmpid) {
        this.cobranzascobroscmpid = cobranzascobroscmpid;
    }

    public short getCobranzascobroslinea() {
        return cobranzascobroslinea;
    }

    public void setCobranzascobroslinea(short cobranzascobroslinea) {
        this.cobranzascobroslinea = cobranzascobroslinea;
    }

    public int getCobranzascobrosnumero() {
        return cobranzascobrosnumero;
    }

    public void setCobranzascobrosnumero(int cobranzascobrosnumero) {
        this.cobranzascobrosnumero = cobranzascobrosnumero;
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
        final CobranzasAplicacionPagoPK other = (CobranzasAplicacionPagoPK) obj;
        if (this.empresasid != other.empresasid) {
            return false;
        }
        if (this.sucursalesid != other.sucursalesid) {
            return false;
        }
        if (this.cobranzascobroscmpid != other.cobranzascobroscmpid) {
            return false;
        }
        if (this.cobranzascobrosnumero != other.cobranzascobrosnumero) {
            return false;
        }
        if (this.cobranzascobroslinea != other.cobranzascobroslinea) {
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
        int hash = 5;
        hash = 59 * hash + this.empresasid;
        hash = 59 * hash + this.sucursalesid;
        hash = 59 * hash + this.cobranzascobroscmpid;
        hash = 59 * hash + this.cobranzascobrosnumero;
        hash = 59 * hash + this.cobranzascobroslinea;
        hash = 59 * hash + this.facturascmpid;
        hash = 59 * hash + this.facturaspuntoexpedicionnro;
        hash = 59 * hash + this.facturasnumero;
        return hash;
    }


    
}
