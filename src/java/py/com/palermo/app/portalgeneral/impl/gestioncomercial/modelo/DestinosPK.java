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
public class DestinosPK implements Serializable {

    private short empresasid;
    private short destinosid;

    public DestinosPK() {
    }

    public DestinosPK(short empresasid, short destinosid) {
        this.empresasid = empresasid;
        this.destinosid = destinosid;
    }

    public short getEmpresasid() {
        return empresasid;
    }

    public void setEmpresasid(short empresasid) {
        this.empresasid = empresasid;
    }

    public short getDestinosid() {
        return destinosid;
    }

    public void setDestinosid(short destinosid) {
        this.destinosid = destinosid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empresasid;
        hash += (int) destinosid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DestinosPK)) {
            return false;
        }
        DestinosPK other = (DestinosPK) object;
        if (this.empresasid != other.empresasid) {
            return false;
        }
        if (this.destinosid != other.destinosid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.serviciopocket.gcmovil.entity.DestinosPK[ empresasid=" + empresasid + ", destinosid=" + destinosid + " ]";
    }
}
