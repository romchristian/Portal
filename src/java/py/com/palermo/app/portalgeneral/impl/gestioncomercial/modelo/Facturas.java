/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
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
@Table(name = "facturas")
@IdClass(FacturasPK.class)
@XmlType(name = "Facturas")
public class Facturas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private short empresasid;
    @Id
    private short sucursalesid;
    @Id
    private short facturascmpid;
    @Id
    private short facturaspuntoexpedicionnro;
    @Id
    private int facturasnumero;
    @Column(name = "facturasfecha", updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date facturasfecha;
    @Column(name = "facturasvencimiento", updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date facturasvencimiento;
    @Column(name = "clientesid", updatable = true)
    private Integer clientesid;
    @Column(name = "facturastipocomprobante", updatable = true)
    private String facturastipocomprobante;
    @Column(name = "facturastipoprecio", updatable = true)
    private String facturastipoprecio;
    @Column(name = "facturassubtotal", updatable = true)
    private BigDecimal facturassubtotal;
    @Column(name = "facturasdescuento", updatable = true)
    private BigDecimal facturasdescuento;
    @Column(name = "facturasimpuesto", updatable = true)
    private BigDecimal facturasimpuesto;
    @Column(name = "facturastotal", updatable = true)
    private BigDecimal facturastotal;
    @Column(name = "facturaspagos", updatable = true)
    private BigDecimal facturaspagos;
    @Column(name = "facturasestadodescarga", updatable = true)
    private String facturasestadodescarga;
    @Column(name = "facturasestadoimpresion", updatable = true)
    private String facturasestadoimpresion;
    @Column(name = "facturasestadoanulacion", updatable = true)
    private String facturasestadoanulacion;
    @Column(name = "facturaspendientes",updatable = true)
    private String facturaspendientes;
    @Column(name = "vendedorid", updatable = true)
    private short vendedorid;
    @Basic(optional = false)
    @Column(name = "descuentosproductosid", updatable = true)
    private short descuentosproductosid;

    @Column(name = "facturasgpslat",updatable = true)
    private String facturasgpslat;
    @Column(name = "facturasgpslong",updatable = true)
    private String facturasgpslong;

    

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturas")
    private List<FacturasCobros> facturascobrosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturas")
    private List<FacturasDetalle> facturasdetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturas",fetch=FetchType.EAGER)
    private List<FacturasAplicacionPago> facturasAplicacionPagosList;

    public Facturas() {
    }

    public Facturas(short facturascmpid,
            short facturaspuntoexpedicionnro,
            int facturasnumero,
            Date facturasfecha,
            Date facturasvencimiento,
            Integer clientesid,
            String facturastipocomprobante,
            String facturastipoprecio,
            BigDecimal facturassubtotal,
            BigDecimal facturasdescuento,
            BigDecimal facturasimpuesto,
            BigDecimal facturastotal,
            BigDecimal facturaspagos,
            String facturasestadodescarga,
            String facturasestadoimpresion,
            String facturasestadoanulacion,
            String facturaspendientes,
            short vendedorid,
            short empresasid,
            short sucursalesid) {
        this.facturascmpid = facturascmpid;
        this.facturaspuntoexpedicionnro = facturaspuntoexpedicionnro;
        this.facturasnumero = facturasnumero;
        this.facturasfecha = facturasfecha;
        this.facturasvencimiento = facturasvencimiento;
        this.clientesid = clientesid;
        this.facturastipocomprobante = facturastipocomprobante;
        this.facturastipoprecio = facturastipoprecio;
        this.facturassubtotal = facturassubtotal;
        this.facturasdescuento = facturasdescuento;
        this.facturasimpuesto = facturasimpuesto;
        this.facturastotal = facturastotal;
        this.facturaspagos = facturaspagos;
        this.facturasestadodescarga = facturasestadodescarga;
        this.facturasestadoimpresion = facturasestadoimpresion;
        this.facturasestadoanulacion = facturasestadoanulacion;
        this.facturaspendientes = facturaspendientes;
        this.vendedorid = vendedorid;
        this.empresasid = empresasid;
        this.sucursalesid = sucursalesid;
    }

    public Facturas(Object[] o) {
        this(((Integer) o[0]).shortValue(),
                ((Integer) o[1]).shortValue(),
                (Integer) o[2],
                (Date) o[3],
                (Date) o[4],
                (Integer) o[5],
                (String) o[6],
                (String) o[7],
                (BigDecimal) o[8],
                (BigDecimal) o[9],
                (BigDecimal) o[10],
                (BigDecimal) o[11],
                (BigDecimal) o[12],
                (String) o[13],
                (String) o[14],
                (String) o[15],
                (String) o[16],
                ((Integer) o[17]).shortValue(),
                ((Integer) o[18]).shortValue(),
                ((Integer) o[19]).shortValue());
    }

    public short getFacturascmpid() {
        return facturascmpid;
    }

    @XmlElement(name = "FacturasCmpId")
    public void setFacturascmpid(short facturascmpid) {
        this.facturascmpid = facturascmpid;
    }

    public short getFacturaspuntoexpedicionnro() {
        return facturaspuntoexpedicionnro;
    }

    @XmlElement(name = "FacturasPuntoExpedicionNro")
    public void setFacturaspuntoexpedicionnro(short facturaspuntoexpedicionnro) {
        this.facturaspuntoexpedicionnro = facturaspuntoexpedicionnro;
    }

    public int getFacturasnumero() {
        return facturasnumero;
    }

    @XmlElement(name = "FacturasNumero")
    public void setFacturasnumero(int facturasnumero) {
        this.facturasnumero = facturasnumero;
    }

    public Date getFacturasfecha() {
        return facturasfecha;
    }

    @XmlElement(name = "FacturasFecha")
    public void setFacturasfecha(Date facturasfecha) {
        this.facturasfecha = facturasfecha;
    }

    public Date getFacturasvencimiento() {
        return facturasvencimiento;
    }

    @XmlElement(name = "FacturasVencimiento")
    public void setFacturasvencimiento(Date facturasvencimiento) {
        this.facturasvencimiento = facturasvencimiento;
    }

    public Integer getClientesid() {
        return clientesid;
    }

    @XmlElement(name = "ClientesId")
    public void setClientesid(Integer clientesid) {
        this.clientesid = clientesid;
    }

    public String getFacturastipocomprobante() {
        return facturastipocomprobante;
    }

    @XmlElement(name = "FacturasTipoComprobante")
    public void setFacturastipocomprobante(String facturastipocomprobante) {
        this.facturastipocomprobante = facturastipocomprobante;
    }

    public String getFacturastipoprecio() {
        return facturastipoprecio;
    }

    @XmlElement(name = "FacturasTipoPrecio")
    public void setFacturastipoprecio(String facturastipoprecio) {
        this.facturastipoprecio = facturastipoprecio;
    }

    public BigDecimal getFacturassubtotal() {
        return facturassubtotal;
    }

    @XmlElement(name = "FacturasSubTotal")
    public void setFacturassubtotal(BigDecimal facturassubtotal) {
        this.facturassubtotal = facturassubtotal;
    }

    public BigDecimal getFacturasdescuento() {
        return facturasdescuento;
    }

    @XmlElement(name = "FacturasDescuento")
    public void setFacturasdescuento(BigDecimal facturasdescuento) {
        this.facturasdescuento = facturasdescuento;
    }

    public BigDecimal getFacturasimpuesto() {
        return facturasimpuesto;
    }

    @XmlElement(name = "FacturasImpuesto")
    public void setFacturasimpuesto(BigDecimal facturasimpuesto) {
        this.facturasimpuesto = facturasimpuesto;
    }

    public BigDecimal getFacturastotal() {
        return facturastotal;
    }

    @XmlElement(name = "FacturasTotal")
    public void setFacturastotal(BigDecimal facturastotal) {
        this.facturastotal = facturastotal;
    }

    public BigDecimal getFacturaspagos() {
        return facturaspagos;
    }

    @XmlElement(name = "FacturasPagos")
    public void setFacturaspagos(BigDecimal facturaspagos) {
        this.facturaspagos = facturaspagos;
    }

    public String getFacturasestadodescarga() {
        return facturasestadodescarga;
    }

    @XmlElement(name = "FacturasEstadoDescarga")
    public void setFacturasestadodescarga(String facturasestadodescarga) {
        this.facturasestadodescarga = facturasestadodescarga;
    }

    public String getFacturasestadoimpresion() {
        return facturasestadoimpresion;
    }

    @XmlElement(name = "FacturasEstadoImpresion")
    public void setFacturasestadoimpresion(String facturasestadoimpresion) {
        this.facturasestadoimpresion = facturasestadoimpresion;
    }

    public String getFacturasestadoanulacion() {
        return facturasestadoanulacion;
    }

    @XmlElement(name = "FacturasEstadoAnulacion")
    public void setFacturasestadoanulacion(String facturasestadoanulacion) {
        this.facturasestadoanulacion = facturasestadoanulacion;
    }

    public String getFacturaspendientes() {
        return facturaspendientes;
    }

    @XmlElement(name = "FacturasPendientes")
    public void setFacturaspendientes(String facturaspendientes) {
        this.facturaspendientes = facturaspendientes;
    }

    public short getVendedorid() {
        return vendedorid;
    }

    @XmlElement(name = "VendedorId")
    public void setVendedorid(short vendedorid) {
        this.vendedorid = vendedorid;
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

    public short getDescuentosproductosid() {
        return descuentosproductosid;
    }

    @XmlElement(name = "DescuentosProductosId")
    public void setDescuentosproductosid(short descuentosproductosid) {
        this.descuentosproductosid = descuentosproductosid;
    }

    public String getFacturasgpslat() {
        return facturasgpslat;
    }


    @XmlElement(name = "FacturasGpsLat")
    public void setFacturasgpslat(String facturasgpslat) {
        this.facturasgpslat = facturasgpslat;
    }

    public String getFacturasgpslong() {
        return facturasgpslong;
    }

    @XmlElement(name = "FacturasGpsLong")
    public void setFacturasgpslong(String facturasgpslong) {
        this.facturasgpslong = facturasgpslong;
    }





    public List<FacturasCobros> getFacturascobrosList() {
        return facturascobrosList;
    }

    public void setFacturascobrosList(List<FacturasCobros> facturascobrosList) {
        this.facturascobrosList = facturascobrosList;
    }

    public List<FacturasDetalle> getFacturasdetalleList() {
        return facturasdetalleList;
    }

    public void setFacturasdetalleList(List<FacturasDetalle> facturasdetalleList) {
        this.facturasdetalleList = facturasdetalleList;
    }

    public List<FacturasAplicacionPago> getFacturasAplicacionPagosList() {
        return facturasAplicacionPagosList;
    }

    public void setFacturasAplicacionPagosList(List<FacturasAplicacionPago> facturasAplicacionPagosList) {
        this.facturasAplicacionPagosList = facturasAplicacionPagosList;
    }

    

    @Override
    public String toString() {
        return "py.com.palermo.serviciopocket.gcmovil.entity.Facturas[ facturasPK=" + facturasnumero + " ]";
    }
}
