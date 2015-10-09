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
@Table(name = "pregunta")
@XmlType(name = "Pregunta")
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "pregunta_id")
    private Long preguntaId;
    @Column(name = "pregunta_tipo")
    private String preguntaTipo;
    @Column(name = "pregunta_descripcion")
    private String preguntaDescripcion;
    @Column(name = "encuesta_id")
    private Long encuestaId;
    @Column(name = "flujo")
    private String flujo;
    @Column(name = "orden")
    private Integer orden;
    @JoinColumn(name = "encuesta_id", referencedColumnName = "encuesta_id", insertable = false, updatable = false)
    @ManyToOne
    private Encuesta encuesta;

    public Pregunta() {
    }

    public Pregunta(Long preguntaId) {
        this.preguntaId = preguntaId;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public Long getPreguntaId() {
        return preguntaId;
    }

    @XmlElement(name = "PreguntaId")
    public void setPreguntaId(Long preguntaId) {
        this.preguntaId = preguntaId;
    }

    public String getPreguntaTipo() {
        return preguntaTipo;
    }

    @XmlElement(name = "PreguntaTipo")
    public void setPreguntaTipo(String preguntaTipo) {
        this.preguntaTipo = preguntaTipo;
    }

    public String getPreguntaDescripcion() {
        return preguntaDescripcion;
    }

    @XmlElement(name = "PreguntaDescripcion")
    public void setPreguntaDescripcion(String preguntaDescripcion) {
        this.preguntaDescripcion = preguntaDescripcion;
    }

    public Long getEncuestaId() {
        return encuestaId;
    }

    @XmlElement(name = "EncuestaId")
    public void setEncuestaId(Long encuestaId) {
        this.encuestaId = encuestaId;
    }

    public String getFlujo() {
        return flujo;
    }

    @XmlElement(name = "Flujo")
    public void setFlujo(String flujo) {
        this.flujo = flujo;
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
        hash += (preguntaId != null ? preguntaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.preguntaId == null && other.preguntaId != null) || (this.preguntaId != null && !this.preguntaId.equals(other.preguntaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.movil.gcmovil.modelo.Pregunta[preguntaId=" + preguntaId + "]";
    }
}
