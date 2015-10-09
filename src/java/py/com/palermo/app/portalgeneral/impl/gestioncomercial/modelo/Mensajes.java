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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "mensajes")
@NamedQueries({
    @NamedQuery(name = "Mensajes.findAll", query = "SELECT m FROM Mensajes m")})
@XmlType(name = "Mensajes")
public class Mensajes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "mensajesid")
    private Integer mensajesid;
    @Basic(optional = false)
    @Column(name = "mensajesestado")
    private char mensajesestado;
    @Basic(optional = false)
    @Column(name = "mensajesorigen")
    private short mensajesorigen;
    @Basic(optional = false)
    @Column(name = "mensajesdestino")
    private short mensajesdestino;
    @Basic(optional = false)
    @Column(name = "mensajesfecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mensajesfecha;
    @Column(name = "mensajesminutosvalidez")
    private Short mensajesminutosvalidez;
    @Column(name = "mensajestexto")
    private String mensajestexto;
    @Column(name = "mensajestipo")
    private Short mensajestipo;

    public Mensajes() {
    }

    public Mensajes(Integer mensajesid) {
        this.mensajesid = mensajesid;
    }

    public Mensajes(Integer mensajesid, char mensajesestado, short mensajesorigen, short mensajesdestino, Date mensajesfecha) {
        this.mensajesid = mensajesid;
        this.mensajesestado = mensajesestado;
        this.mensajesorigen = mensajesorigen;
        this.mensajesdestino = mensajesdestino;
        this.mensajesfecha = mensajesfecha;
    }

    public Integer getMensajesid() {
        return mensajesid;
    }

    @XmlElement(name = "MensajesId")
    public void setMensajesid(Integer mensajesid) {
        this.mensajesid = mensajesid;
    }

    public char getMensajesestado() {
        return mensajesestado;
    }

    @XmlElement(name = "MensajesEstado")
    public void setMensajesestado(char mensajesestado) {
        this.mensajesestado = mensajesestado;
    }

    public short getMensajesorigen() {
        return mensajesorigen;
    }

    @XmlElement(name = "MensajesOrigen")
    public void setMensajesorigen(short mensajesorigen) {
        this.mensajesorigen = mensajesorigen;
    }

    public short getMensajesdestino() {
        return mensajesdestino;
    }

    @XmlElement(name = "MensajesDestino")
    public void setMensajesdestino(short mensajesdestino) {
        this.mensajesdestino = mensajesdestino;
    }

    public Date getMensajesfecha() {
        return mensajesfecha;
    }

    @XmlElement(name = "MensajesFecha")
    public void setMensajesfecha(Date mensajesfecha) {
        this.mensajesfecha = mensajesfecha;
    }

    public Short getMensajesminutosvalidez() {
        return mensajesminutosvalidez;
    }

    @XmlElement(name = "MensajesMinutosValidez")
    public void setMensajesminutosvalidez(Short mensajesminutosvalidez) {
        this.mensajesminutosvalidez = mensajesminutosvalidez;
    }

    public String getMensajestexto() {
        return mensajestexto;
    }

    @XmlElement(name = "MensajesTexto")
    public void setMensajestexto(String mensajestexto) {
        this.mensajestexto = mensajestexto;
    }

    public Short getMensajestipo() {
        return mensajestipo;
    }

    @XmlElement(name = "MensajesTipo")
    public void setMensajestipo(Short mensajestipo) {
        this.mensajestipo = mensajestipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mensajesid != null ? mensajesid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensajes)) {
            return false;
        }
        Mensajes other = (Mensajes) object;
        if ((this.mensajesid == null && other.mensajesid != null) || (this.mensajesid != null && !this.mensajesid.equals(other.mensajesid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.serviciopocket.gcmovil.entity.Mensajes[ mensajesid=" + mensajesid + " ]";
    }
}
