/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
@Table(name = "respuestas")
//@SequenceGenerator(name="respuesta_seq",sequenceName="respuesta_seq",initialValue=1,allocationSize=1)
@XmlType(name = "Respuesta")
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "respuesta_id")
    private Long respuestaId;
    
    @Column(name = "empresasid")
    private short empresasId;

    @Column(name = "sucursalesid")
    private short sucursalesId;

    @Column(name = "cliente_id")
    private long clienteId;

    @Column(name = "encuesta_id")
    private long encuestaId;

    @Column(name = "pregunta_id")
    private long preguntaId;
    @Column(name = "opcion_id")
    private long opcionId;
    @Column(name = "resp_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date respFecha;
    @Column(name = "resp_valor_texto")
    private String respValorTexto;
    @Column(name = "resp_valor_numerico")
    private int respValorNumerico;

    public Respuesta() {
    }

    public Long getRespuestaId() {
        return respuestaId;
    }

    @XmlElement(name = "RespuestaId")
    public void setRespuestaId(Long respuestaId) {
        this.respuestaId = respuestaId;
    }

    public short getEmpresasId() {
        return empresasId;
    }

    @XmlElement(name = "EmpresasId")
    public void setEmpresasId(short empresasId) {
        this.empresasId = empresasId;
    }

    public short getSucursalesId() {
        return sucursalesId;
    }

    @XmlElement(name = "SucursalesId")
    public void setSucursalesId(short sucursalesId) {
        this.sucursalesId = sucursalesId;
    }

    public long getClienteId() {
        return clienteId;
    }

    @XmlElement(name = "ClienteId")
    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public long getEncuestaId() {
        return encuestaId;
    }

    @XmlElement(name = "EncuestaId")
    public void setEncuestaId(long encuestaId) {
        this.encuestaId = encuestaId;
    }

    public long getPreguntaId() {
        return preguntaId;
    }

    @XmlElement(name = "PreguntaId")
    public void setPreguntaId(long preguntaId) {
        this.preguntaId = preguntaId;
    }

    public long getOpcionId() {
        return opcionId;
    }

    @XmlElement(name = "OpcionId")
    public void setOpcionId(long opcionId) {
        this.opcionId = opcionId;
    }

    public Date getRespFecha() {
        return respFecha;
    }

    @XmlElement(name = "RespFecha")
    public void setRespFecha(Date respFecha) {
        this.respFecha = respFecha;
    }

    public int getRespValorNumerico() {
        return respValorNumerico;
    }

    @XmlElement(name = "RespValorNumerico")
    public void setRespValorNumerico(int respValorNumerico) {
        this.respValorNumerico = respValorNumerico;
    }
    
    public String getRespValorTexto() {
        return respValorTexto;
    }

    @XmlElement(name = "RespValorTexto")
    public void setRespValorTexto(String respValorTexto) {
        this.respValorTexto = respValorTexto;
    }

    @Override
    public String toString() {
        return "py.com.palermo.movil.gcmovil.modelo.Respuestas[respuestasPK=" + respuestaId + "]";
    }
}
