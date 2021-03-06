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
public class FacturasCobrosPK implements Serializable {

    private short empresasid;
    private short sucursalesid;
    private short facturascmpid;
    private short facturaspuntoexpedicionnro;
    private int facturasnumero;
    private short facturasvalorlinea;

    public FacturasCobrosPK() {
    }

    public FacturasCobrosPK(short empresasid, short sucursalesid, short facturascmpid, short facturaspuntoexpedicionnro, int facturasnumero, short facturasvalorlinea) {
        this.empresasid = empresasid;
        this.sucursalesid = sucursalesid;
        this.facturascmpid = facturascmpid;
        this.facturaspuntoexpedicionnro = facturaspuntoexpedicionnro;
        this.facturasnumero = facturasnumero;
        this.facturasvalorlinea = facturasvalorlinea;
    }

    public short getEmpresasid() {
        return empresasid;
    }

    public void setEmpresasid(short empresasid) {
        this.empresasid = empresasid;
    }

    public short getSucursalesid() {
        return sucursalesid;
    }

    public void setSucursalesid(short sucursalesid) {
        this.sucursalesid = sucursalesid;
    }

    public short getFacturascmpid() {
        return facturascmpid;
    }

    public void setFacturascmpid(short facturascmpid) {
        this.facturascmpid = facturascmpid;
    }

    public short getFacturaspuntoexpedicionnro() {
        return facturaspuntoexpedicionnro;
    }

    public void setFacturaspuntoexpedicionnro(short facturaspuntoexpedicionnro) {
        this.facturaspuntoexpedicionnro = facturaspuntoexpedicionnro;
    }

    public int getFacturasnumero() {
        return facturasnumero;
    }

    public void setFacturasnumero(int facturasnumero) {
        this.facturasnumero = facturasnumero;
    }

    public short getFacturasvalorlinea() {
        return facturasvalorlinea;
    }

    public void setFacturasvalorlinea(short facturasvalorlinea) {
        this.facturasvalorlinea = facturasvalorlinea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empresasid;
        hash += (int) sucursalesid;
        hash += (int) facturascmpid;
        hash += (int) facturaspuntoexpedicionnro;
        hash += (int) facturasnumero;
        hash += (int) facturasvalorlinea;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturasCobrosPK)) {
            return false;
        }
        FacturasCobrosPK other = (FacturasCobrosPK) object;
        if (this.empresasid != other.empresasid) {
            return false;
        }
        if (this.sucursalesid != other.sucursalesid) {
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
        if (this.facturasvalorlinea != other.facturasvalorlinea) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.serviciopocket.gcmovil.entity.FacturascobrosPK[ empresasid=" + empresasid + ", sucursalesid=" + sucursalesid + ", facturascmpid=" + facturascmpid + ", facturaspuntoexpedicionnro=" + facturaspuntoexpedicionnro + ", facturasnumero=" + facturasnumero + ", facturasvalorlinea=" + facturasvalorlinea + " ]";
    }
}
