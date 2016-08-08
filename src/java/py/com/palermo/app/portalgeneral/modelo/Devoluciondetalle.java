/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author christian.romero
 */
@Entity
@Table(name = "devoluciondetalle")
@NamedQueries({
    @NamedQuery(name = "Devoluciondetalle.findAll", query = "SELECT d FROM Devoluciondetalle d")})
public class Devoluciondetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "devolucionhashkey")
    private String devolucionhashkey;
    @Column(name = "linea")
    private Integer linea;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "cantidad")
    private BigInteger cantidad;
    @Column(name = "productoid")
    private Integer productoid;
    @Column(name = "productoumid")
    private Integer productoumid;
    @Size(max = 255)
    @Column(name = "unidadmedidadesc")
    private String unidadmedidadesc;
    @Column(name = "unidadmedidaid")
    private Integer unidadmedidaid;
    @Size(max = 255)
    @Column(name = "hashkey")
    private String hashkey;
    @JoinColumn(name = "devolucionid", referencedColumnName = "id")
    @ManyToOne
    private Devolucion devolucionid;

    public Devoluciondetalle() {
    }

    public Devoluciondetalle(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDevolucionhashkey() {
        return devolucionhashkey;
    }

    public void setDevolucionhashkey(String devolucionhashkey) {
        this.devolucionhashkey = devolucionhashkey;
    }

    public Integer getLinea() {
        return linea;
    }

    public void setLinea(Integer linea) {
        this.linea = linea;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getProductoid() {
        return productoid;
    }

    public void setProductoid(Integer productoid) {
        this.productoid = productoid;
    }

    public Integer getProductoumid() {
        return productoumid;
    }

    public void setProductoumid(Integer productoumid) {
        this.productoumid = productoumid;
    }

    public String getUnidadmedidadesc() {
        return unidadmedidadesc;
    }

    public void setUnidadmedidadesc(String unidadmedidadesc) {
        this.unidadmedidadesc = unidadmedidadesc;
    }

    public Integer getUnidadmedidaid() {
        return unidadmedidaid;
    }

    public void setUnidadmedidaid(Integer unidadmedidaid) {
        this.unidadmedidaid = unidadmedidaid;
    }

    public String getHashkey() {
        return hashkey;
    }

    public void setHashkey(String hashkey) {
        this.hashkey = hashkey;
    }

    public Devolucion getDevolucionid() {
        return devolucionid;
    }

    public void setDevolucionid(Devolucion devolucionid) {
        this.devolucionid = devolucionid;
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
        if (!(object instanceof Devoluciondetalle)) {
            return false;
        }
        Devoluciondetalle other = (Devoluciondetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.app.portalgeneral.modelo.Devoluciondetalle[ id=" + id + " ]";
    }
    
}
