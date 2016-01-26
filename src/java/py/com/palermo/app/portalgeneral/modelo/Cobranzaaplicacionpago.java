/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author christian.romero
 */
@Entity
@Table(name = "cobranzaaplicacionpago")
@NamedQueries({
    @NamedQuery(name = "Cobranzaaplicacionpago.findAll", query = "SELECT c FROM Cobranzaaplicacionpago c")})
public class Cobranzaaplicacionpago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id")
    private String id;
    @Column(name = "mediopagoid")
    private Short mediopagoid;
    @Column(name = "valornumero")
    private String valornumero;
    @Column(name = "valorfecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date valorfecha;
    @Size(max = 255)
    @Column(name = "valorobservacion")
    private String valorobservacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorimporte")
    private BigDecimal valorimporte;
    @Column(name = "vendedorid")
    private Integer vendedorid;
    @Column(name = "cobranzadetalleid")
    private String cobranzaDetalleId;
    @JoinColumn(name = "cobranzaid", referencedColumnName = "id")
    @ManyToOne
    private Cobranza cobranza;
    @Column(name = "documentoid")
    private String documentoId;

    public Cobranzaaplicacionpago() {
    }

   

    public Cobranzaaplicacionpago(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Short getMediopagoid() {
        return mediopagoid;
    }

    public void setMediopagoid(Short mediopagoid) {
        this.mediopagoid = mediopagoid;
    }

    public String getValornumero() {
        return valornumero;
    }

    public void setValornumero(String valornumero) {
        this.valornumero = valornumero;
    }

    public Date getValorfecha() {
        return valorfecha;
    }

    public void setValorfecha(Date valorfecha) {
        this.valorfecha = valorfecha;
    }

    public String getValorobservacion() {
        return valorobservacion;
    }

    public void setValorobservacion(String valorobservacion) {
        this.valorobservacion = valorobservacion;
    }

    public BigDecimal getValorimporte() {
        return valorimporte;
    }

    public void setValorimporte(BigDecimal valorimporte) {
        this.valorimporte = valorimporte;
    }

    public Integer getVendedorid() {
        return vendedorid;
    }

    public void setVendedorid(Integer vendedorid) {
        this.vendedorid = vendedorid;
    }

    public Cobranza getCobranza() {
        return cobranza;
    }

    public void setCobranza(Cobranza cobranza) {
        this.cobranza = cobranza;
    }

    public String getCobranzaDetalleId() {
        return cobranzaDetalleId;
    }

    public void setCobranzaDetalleId(String cobranzaDetalleId) {
        this.cobranzaDetalleId = cobranzaDetalleId;
    }

    public String getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(String documentoId) {
        this.documentoId = documentoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cobranzaaplicacionpago)) {
            return false;
        }
        Cobranzaaplicacionpago other = (Cobranzaaplicacionpago) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.servicioarthy.modelo.Cobranzaaplicacionpago[ id=" + id + " ]";
    }

}
