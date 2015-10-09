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
public class CobranzasDetallePK implements Serializable {

    private short empresasid;
    private short sucursalesid;
    private short cobranzascmpid;
    private int cobranzasnumero;
    private short facturascmpid;
    private short facturaspuntoexpedicionnro;
    private int facturasnumero;

    public CobranzasDetallePK() {
    }

    public CobranzasDetallePK(short empresasid, short sucursalesid, short cobranzascmpid, int cobranzasnumero, short facturascmpid, short facturaspuntoexpedicionnro, int facturasnumero) {
        this.empresasid = empresasid;
        this.sucursalesid = sucursalesid;
        this.cobranzascmpid = cobranzascmpid;
        this.cobranzasnumero = cobranzasnumero;
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

    public short getSucursalesid() {
        return sucursalesid;
    }

    public void setSucursalesid(short sucursalesid) {
        this.sucursalesid = sucursalesid;
    }

    public short getCobranzascmpid() {
        return cobranzascmpid;
    }

    public void setCobranzascmpid(short cobranzascmpid) {
        this.cobranzascmpid = cobranzascmpid;
    }

    public int getCobranzasnumero() {
        return cobranzasnumero;
    }

    public void setCobranzasnumero(int cobranzasnumero) {
        this.cobranzasnumero = cobranzasnumero;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empresasid;
        hash += (int) sucursalesid;
        hash += (int) cobranzascmpid;
        hash += (int) cobranzasnumero;
        hash += (int) facturascmpid;
        hash += (int) facturaspuntoexpedicionnro;
        hash += (int) facturasnumero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CobranzasDetallePK)) {
            return false;
        }
        CobranzasDetallePK other = (CobranzasDetallePK) object;
        if (this.empresasid != other.empresasid) {
            return false;
        }
        if (this.sucursalesid != other.sucursalesid) {
            return false;
        }
        if (this.cobranzascmpid != other.cobranzascmpid) {
            return false;
        }
        if (this.cobranzasnumero != other.cobranzasnumero) {
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
    public String toString() {
        return "py.com.palermo.serviciopocket.gcmovil.entity.CobranzasdetallePK[ empresasid=" + empresasid + ", sucursalesid=" + sucursalesid + ", cobranzascmpid=" + cobranzascmpid + ", cobranzasnumero=" + cobranzasnumero + ", facturascmpid=" + facturascmpid + ", facturaspuntoexpedicionnro=" + facturaspuntoexpedicionnro + ", facturasnumero=" + facturasnumero + " ]";
    }
}
