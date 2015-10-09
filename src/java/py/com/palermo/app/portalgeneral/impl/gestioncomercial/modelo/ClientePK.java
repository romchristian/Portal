/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author cromero
 */
@Embeddable
public class ClientePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "empresasid")
    private short empresasid;
    @Basic(optional = false)
    @Column(name = "sucursalesid")
    private short sucursalesid;
    @Basic(optional = false)
    @Column(name = "cliente_id")
    private long clienteId;

    public ClientePK() {
    }

    public ClientePK(short empresasid, short sucursalesid, long clienteId) {
        this.empresasid = empresasid;
        this.sucursalesid = sucursalesid;
        this.clienteId = clienteId;
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

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empresasid;
        hash += (int) sucursalesid;
        hash += (int) clienteId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientePK)) {
            return false;
        }
        ClientePK other = (ClientePK) object;
        if (this.empresasid != other.empresasid) {
            return false;
        }
        if (this.sucursalesid != other.sucursalesid) {
            return false;
        }
        if (this.clienteId != other.clienteId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.movil.gcmovil.modelo.ClientePK[empresasid=" + empresasid + ", sucursalesid=" + sucursalesid + ", clienteId=" + clienteId + "]";
    }

}
