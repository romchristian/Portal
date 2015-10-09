/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author cromero
 */
@Entity
@Table(name = "relevamientos")
@IdClass(RelevamientosPK.class)
@XmlType(name = "Relevamientos")
public class Relevamientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private short empresasid;
    @Id
    private short sucursalesid;
    @Id
    private int clientesid;
    @Id
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date relevamientosfecha;
    @Column(name = "motivosnoventasid")
    private Integer motivosnoventasid;
    @Column(name = "relevamientosestadodescarga")
    private Short relevamientosestadodescarga;
    @Basic(optional = false)
    @Column(name = "vendedoresid")
    private short vendedoresid;

    public Relevamientos() {
    }

    public short getEmpresasid() {
        return empresasid;
    }

    @XmlElement(name = "EmpresasId")
    public void setEmpresasid(short empresasid) {
        this.empresasid = empresasid;
    }

    public short getSucursalesid() {
        return sucursalesid;
    }

    @XmlElement(name = "SucursalesId")
    public void setSucursalesid(short sucursalesid) {
        this.sucursalesid = sucursalesid;
    }

    public int getClientesid() {
        return clientesid;
    }

    @XmlElement(name = "ClientesId")
    public void setClientesid(int clientesid) {
        this.clientesid = clientesid;
    }

    public Date getRelevamientosfecha() {
        return relevamientosfecha;
    }

    @XmlElement(name = "RelevamientosFecha")
    public void setRelevamientosfecha(Date relevamientosfecha) {
        this.relevamientosfecha = relevamientosfecha;
    }

    public Integer getMotivosnoventasid() {
        return motivosnoventasid;
    }

    @XmlElement(name = "MotivosNoVentasId")
    public void setMotivosnoventasid(Integer motivosnoventasid) {
        this.motivosnoventasid = motivosnoventasid;
    }

    public Short getRelevamientosestadodescarga() {
        return relevamientosestadodescarga;
    }

    @XmlElement(name = "RelevamientosEstadoDescarga")
    public void setRelevamientosestadodescarga(Short relevamientosestadodescarga) {
        this.relevamientosestadodescarga = relevamientosestadodescarga;
    }

    public short getVendedoresid() {
        return vendedoresid;
    }

    @XmlElement(name = "VendedoresId")
    public void setVendedoresid(short vendedoresid) {
        this.vendedoresid = vendedoresid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.empresasid;
        hash = 31 * hash + this.sucursalesid;
        hash = 31 * hash + this.clientesid;
        hash = 31 * hash + (this.relevamientosfecha != null ? this.relevamientosfecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Relevamientos other = (Relevamientos) obj;
        if (this.empresasid != other.empresasid) {
            return false;
        }
        if (this.sucursalesid != other.sucursalesid) {
            return false;
        }
        if (this.clientesid != other.clientesid) {
            return false;
        }
        if (this.relevamientosfecha != other.relevamientosfecha && (this.relevamientosfecha == null || !this.relevamientosfecha.equals(other.relevamientosfecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.serviciopocket.gcmovil.entity.Relevamientos[ relevamientosPK=" + relevamientosfecha + " ]";
    }
}
