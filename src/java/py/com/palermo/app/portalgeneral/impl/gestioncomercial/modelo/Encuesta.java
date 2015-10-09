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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author cromero
 */
@Entity
@Table(name = "encuesta")
@XmlType(name = "Encuesta")
public class Encuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "encuesta_id")
    private Long encuestaId;
    @Column(name = "encuesta_nombre")
    private String encuestaNombre;
    @Column(name = "encuesta_inicio")
    @Temporal(TemporalType.DATE)
    private Date encuestaInicio;
    @Column(name = "encuesta_fin")
    @Temporal(TemporalType.DATE)
    private Date encuestaFin;
    @Column(name = "encuesta_estado")
    private String encuestaEstado;

    public Encuesta() {
    }

    public Encuesta(Long encuestaId) {
        this.encuestaId = encuestaId;
    }

    public Long getEncuestaId() {
        return encuestaId;
    }

    @XmlElement(name = "EncuestaId")
    public void setEncuestaId(Long encuestaId) {
        this.encuestaId = encuestaId;
    }

    public String getEncuestaNombre() {
        return encuestaNombre;
    }

    @XmlElement(name = "EncuestaNombre")
    public void setEncuestaNombre(String encuestaNombre) {
        this.encuestaNombre = encuestaNombre;
    }

    public Date getEncuestaInicio() {
        return encuestaInicio;
    }

    @XmlElement(name = "EncuestaInicio")
    public void setEncuestaInicio(Date encuestaInicio) {
        this.encuestaInicio = encuestaInicio;
    }

    public Date getEncuestaFin() {
        return encuestaFin;
    }

    @XmlElement(name = "EncuestaFin")
    public void setEncuestaFin(Date encuestaFin) {
        this.encuestaFin = encuestaFin;
    }

    public String getEncuestaEstado() {
        return encuestaEstado;
    }

    @XmlElement(name = "EncuestaEstado")
    public void setEncuestaEstado(String encuestaEstado) {
        this.encuestaEstado = encuestaEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (encuestaId != null ? encuestaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encuesta)) {
            return false;
        }
        Encuesta other = (Encuesta) object;
        if ((this.encuestaId == null && other.encuestaId != null) || (this.encuestaId != null && !this.encuestaId.equals(other.encuestaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.movil.gcmovil.modelo.Encuesta[encuestaId=" + encuestaId + "]";
    }
}
