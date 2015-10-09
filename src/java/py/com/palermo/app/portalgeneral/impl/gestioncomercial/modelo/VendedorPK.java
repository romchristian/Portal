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
public class VendedorPK implements Serializable {

    private short empresasid;
    private short sucursalesid;
    private short vendedorid;

    public VendedorPK() {
    }

    public VendedorPK(short empresasid, short sucursalesid, short vendedorid) {
        this.empresasid = empresasid;
        this.sucursalesid = sucursalesid;
        this.vendedorid = vendedorid;
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

    public short getVendedorid() {
        return vendedorid;
    }

    public void setVendedorid(short vendedorid) {
        this.vendedorid = vendedorid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empresasid;
        hash += (int) sucursalesid;
        hash += (int) vendedorid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendedorPK)) {
            return false;
        }
        VendedorPK other = (VendedorPK) object;
        if (this.empresasid != other.empresasid) {
            return false;
        }
        if (this.sucursalesid != other.sucursalesid) {
            return false;
        }
        if (this.vendedorid != other.vendedorid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.serviciopocket.gcmovil.entity.VendedorPK[ empresasid=" + empresasid + ", sucursalesid=" + sucursalesid + ", vendedorid=" + vendedorid + " ]";
    }
}
