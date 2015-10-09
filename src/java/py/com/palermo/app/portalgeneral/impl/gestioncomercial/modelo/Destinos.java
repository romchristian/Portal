/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author cromero
 */
@Entity
@Table(name = "destinos")
@XmlType(name = "Destinos")
@IdClass(value = DestinosPK.class)
@NamedQueries({
    @NamedQuery(name = "Destinos.findAll", query = "SELECT d FROM Destinos d")})
public class Destinos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    
    @Column(name = "empresasid")
    private short empresasid;
    @Id
    @Basic(optional = false)
    
    @Column(name = "destinosid")
    private short destinosid;
    @Basic(optional = false)
    
    @Column(name = "destinosdescripcion")
    private String destinosdescripcion;

    public Destinos() {
    }

    public short getEmpresasid() {
        return empresasid;
    }

    @XmlElement(name = "EmpresasId")
    public void setEmpresasid(short empresasid) {
        this.empresasid = empresasid;
    }

    public short getDestinosid() {
        return destinosid;
    }

    @XmlElement(name = "DestinosId")
    public void setDestinosid(short destinosid) {
        this.destinosid = destinosid;
    }

    @XmlElement(name = "DestinosDescripcion")
    public String getDestinosdescripcion() {
        return destinosdescripcion;
    }

    public void setDestinosdescripcion(String destinosdescripcion) {
        this.destinosdescripcion = destinosdescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.empresasid;
        hash = 97 * hash + this.destinosid;
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
        final Destinos other = (Destinos) obj;
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
        return "py.com.palermo.serviciopocket.gcmovil.entity.Destinos[ destinosPK=" + destinosid + " ]";
    }
}
