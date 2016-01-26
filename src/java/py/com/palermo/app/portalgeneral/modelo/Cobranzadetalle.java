/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author christian.romero
 */
@Entity
@Table(name = "conbranzadetalle")
@NamedQueries({
    @NamedQuery(name = "Cobranzadetalle.findAll", query = "SELECT c FROM Cobranzadetalle c")})
public class Cobranzadetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id")
    private String id;
    @Column(name = "vendedorid")
    private Short vendedorid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "pago")
    private BigDecimal pago;
    @JoinColumn(name = "cobranzaid", referencedColumnName = "id")
    @ManyToOne
    private Cobranza cobranza;
    @Column(name = "facturaid")
    private String facturaid;

    public Cobranzadetalle() {

    }

    public Cobranzadetalle(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Short getVendedorid() {
        return vendedorid;
    }

    public void setVendedorid(Short vendedorid) {
        this.vendedorid = vendedorid;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getPago() {
        return pago;
    }

    public void setPago(BigDecimal pago) {
        this.pago = pago;
    }

    public Cobranza getCobranza() {
        return cobranza;
    }

    public void setCobranza(Cobranza cobranza) {
        this.cobranza = cobranza;
    }

    public String getFacturaid() {
        return facturaid;
    }

    public void setFacturaid(String facturaid) {
        this.facturaid = facturaid;
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
        if (!(object instanceof Cobranzadetalle)) {
            return false;
        }
        Cobranzadetalle other = (Cobranzadetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.servicioarthy.modelo.Conbranzadetalle[ id=" + id + " ]";
    }

}
