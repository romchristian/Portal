/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author cromero
 */
@Entity
@Table(name = "opcion")
@XmlType(name = "Opcion")
public class Opcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "opcion_id")
    private Long opcionId;
    @Column(name = "opcion_descripcion")
    private String opcionDescripcion;
    @Column(name = "opcion_tipo")
    private String opcionTipo;
    @Column(name = "pregunta_id")
    private Long preguntaId;
    @Column(name = "orden")
    private Integer orden;
    @JoinColumn(name = "pregunta_id", referencedColumnName = "pregunta_id",insertable=false,updatable=false)
    @ManyToOne
    private Pregunta pregunta;

    public Opcion() {
    }

    public Opcion(Long opcionId) {
        this.opcionId = opcionId;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Long getOpcionId() {
        return opcionId;
    }

    @XmlElement(name = "OpcionId")
    public void setOpcionId(Long opcionId) {
        this.opcionId = opcionId;
    }

    public String getOpcionDescripcion() {
        return opcionDescripcion;
    }

    @XmlElement(name = "OpcionDescripcion")
    public void setOpcionDescripcion(String opcionDescripcion) {
        this.opcionDescripcion = opcionDescripcion;
    }

    public String getOpcionTipo() {
        return opcionTipo;
    }

    @XmlElement(name = "OpcionTipo")
    public void setOpcionTipo(String opcionTipo) {
        this.opcionTipo = opcionTipo;
    }

    public Long getPreguntaId() {
        return preguntaId;
    }

    @XmlElement(name = "PreguntaId")
    public void setPreguntaId(Long preguntaId) {
        this.preguntaId = preguntaId;
    }

    public Integer getOrden() {
        return orden;
    }

    @XmlElement(name = "Orden")
    public void setOrden(Integer orden) {
        this.orden = orden;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opcionId != null ? opcionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opcion)) {
            return false;
        }
        Opcion other = (Opcion) object;
        if ((this.opcionId == null && other.opcionId != null) || (this.opcionId != null && !this.opcionId.equals(other.opcionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.movil.gcmovil.modelo.Opcion[opcionId=" + opcionId + "]";
    }
}
