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
public class RetencionesPK implements Serializable {

    private short empresasid;
    private short sucursalesid;
    private int clientesid;
    private int retclientetimbrado;
    private long retnumero;

    public RetencionesPK() {
    }

    public RetencionesPK(short empresasid, short sucursalesid, int clientesid, int retclientetimbrado, long retnumero) {
        this.empresasid = empresasid;
        this.sucursalesid = sucursalesid;
        this.clientesid = clientesid;
        this.retclientetimbrado = retclientetimbrado;
        this.retnumero = retnumero;
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

    public int getRetclientetimbrado() {
        return retclientetimbrado;
    }

    public void setRetclientetimbrado(int retclientetimbrado) {
        this.retclientetimbrado = retclientetimbrado;
    }

    public long getRetnumero() {
        return retnumero;
    }

    public void setRetnumero(long retnumero) {
        this.retnumero = retnumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empresasid;
        hash += (int) sucursalesid;
        hash += (int) clientesid;
        hash += (int) retclientetimbrado;
        hash += (int) retnumero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RetencionesPK)) {
            return false;
        }
        RetencionesPK other = (RetencionesPK) object;
        if (this.empresasid != other.empresasid) {
            return false;
        }
        if (this.sucursalesid != other.sucursalesid) {
            return false;
        }
        if (this.clientesid != other.clientesid) {
            return false;
        }
        if (this.retclientetimbrado != other.retclientetimbrado) {
            return false;
        }
        if (this.retnumero != other.retnumero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.movil.gcmovil.modelo.RetencionesPK[empresasid=" + empresasid + ", sucursalesid=" + sucursalesid + ", clientesid=" + clientesid + ", retclientetimbrado=" + retclientetimbrado + ", retnumero=" + retnumero + "]";
    }
}
