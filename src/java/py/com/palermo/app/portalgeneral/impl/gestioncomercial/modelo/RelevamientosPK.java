/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author cromero
 */
public class RelevamientosPK implements Serializable {

    private short empresasid;
    private short sucursalesid;
    private int clientesid;
    private Date relevamientosfecha;

    public RelevamientosPK() {
    }

    public RelevamientosPK(short empresasid, short sucursalesid, int clientesid, Date relevamientosfecha) {
        this.empresasid = empresasid;
        this.sucursalesid = sucursalesid;
        this.clientesid = clientesid;
        this.relevamientosfecha = relevamientosfecha;
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

    public int getClientesid() {
        return clientesid;
    }

    public void setClientesid(int clientesid) {
        this.clientesid = clientesid;
    }

    public Date getRelevamientosfecha() {
        return relevamientosfecha;
    }

    public void setRelevamientosfecha(Date relevamientosfecha) {
        this.relevamientosfecha = relevamientosfecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empresasid;
        hash += (int) sucursalesid;
        hash += (int) clientesid;
        hash += (relevamientosfecha != null ? relevamientosfecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelevamientosPK)) {
            return false;
        }
        RelevamientosPK other = (RelevamientosPK) object;
        if (this.empresasid != other.empresasid) {
            return false;
        }
        if (this.sucursalesid != other.sucursalesid) {
            return false;
        }
        if (this.clientesid != other.clientesid) {
            return false;
        }
        if ((this.relevamientosfecha == null && other.relevamientosfecha != null) || (this.relevamientosfecha != null && !this.relevamientosfecha.equals(other.relevamientosfecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.serviciopocket.gcmovil.entity.RelevamientosPK[ empresasid=" + empresasid + ", sucursalesid=" + sucursalesid + ", clientesid=" + clientesid + ", relevamientosfecha=" + relevamientosfecha + " ]";
    }
}
