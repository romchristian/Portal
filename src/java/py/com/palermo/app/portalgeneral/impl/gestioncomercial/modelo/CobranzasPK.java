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
public class CobranzasPK implements Serializable {

    private short empresasid;
    private short sucursalesid;
    private short cobranzascmpid;
    private int cobranzasnumero;

    public CobranzasPK() {
    }

    public CobranzasPK(short empresasid, short sucursalesid, short cobranzascmpid, int cobranzasnumero) {
        this.empresasid = empresasid;
        this.sucursalesid = sucursalesid;
        this.cobranzascmpid = cobranzascmpid;
        this.cobranzasnumero = cobranzasnumero;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empresasid;
        hash += (int) sucursalesid;
        hash += (int) cobranzascmpid;
        hash += (int) cobranzasnumero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CobranzasPK)) {
            return false;
        }
        CobranzasPK other = (CobranzasPK) object;
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
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.serviciopocket.gcmovil.entity.CobranzasPK[ empresasid=" + empresasid + ", sucursalesid=" + sucursalesid + ", cobranzascmpid=" + cobranzascmpid + ", cobranzasnumero=" + cobranzasnumero + " ]";
    }
}
