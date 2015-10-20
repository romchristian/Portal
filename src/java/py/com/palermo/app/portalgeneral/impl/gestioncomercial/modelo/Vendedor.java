/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@Table(name = "vendedor")
@XmlType(name = "Vendedor")
@IdClass(value = VendedorPK.class)
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private short empresasid;
    @Id
    private short sucursalesid;
    @Id
    private short vendedorid;
    private Integer vendedorpocketid;
    private String vendedornombre;
    private Short vendedordiaspagarenormal;
    private Short vendedordiaspagarevendedor;
    private Short vendedorpromo;
    private Short vendedorventascontadoid;
    private Short vendedorventascreditoid;
    private Integer vendedorultimafacturanro;
    private Integer vendedorultimocobronro;
    private String vendedorsucursalnombre;
    private Short vendedornumeracionmanual;
    @Temporal(TemporalType.TIMESTAMP)
    private Date vendedorfechacarga = new Date();
    private Short vendedordescargaestado;
    private Short vendedorlistapreciocontado;
    private Short vendedorlistapreciocredito;
    private Short vendedorimpuestoid;
    private Short vendedorimpuestoporcentaje;
    private Short vendedordepositoid;
    private Short vendedorultimavisita;
    private Short vendedorestablecimientonro;
    private Short vendedorpuntoexpedicionnro;
    private Short vendedorusamensajeria;
    private Short vendedorpedidoscmpid;
    private Integer vendedorultimopedidonro;
    private Short vendedorespreciopromocion;
    private Short vendedorestipo;
    private String vendedorpuertocom;
    private String deviceid;

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public Vendedor() {
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

    public short getVendedorid() {
        return vendedorid;
    }

    @XmlElement(name = "VendedorId")
    public void setVendedorid(short vendedorid) {
        this.vendedorid = vendedorid;
    }

    public Integer getVendedorpocketid() {
        return vendedorpocketid;
    }

    @XmlElement(name = "VendedorPocketId")
    public void setVendedorpocketid(Integer vendedorpocketid) {
        this.vendedorpocketid = vendedorpocketid;
    }

    public String getVendedornombre() {
        return vendedornombre;
    }

    @XmlElement(name = "VendedorNombre")
    public void setVendedornombre(String vendedornombre) {
        this.vendedornombre = vendedornombre;
    }

    public Short getVendedordiaspagarenormal() {
        return vendedordiaspagarenormal;
    }

    @XmlElement(name = "VendedorDiasPagareNormal")
    public void setVendedordiaspagarenormal(Short vendedordiaspagarenormal) {
        this.vendedordiaspagarenormal = vendedordiaspagarenormal;
    }

    public Short getVendedordiaspagarevendedor() {
        return vendedordiaspagarevendedor;
    }

    @XmlElement(name = "VendedorDiasPagareVendedor")
    public void setVendedordiaspagarevendedor(Short vendedordiaspagarevendedor) {
        this.vendedordiaspagarevendedor = vendedordiaspagarevendedor;
    }

    public Short getVendedorpromo() {
        return vendedorpromo;
    }

    @XmlElement(name = "VendedorPromo")
    public void setVendedorpromo(Short vendedorpromo) {
        this.vendedorpromo = vendedorpromo;
    }

    public Short getVendedorventascontadoid() {
        return vendedorventascontadoid;
    }

    @XmlElement(name = "VendedorVentasContadoId")
    public void setVendedorventascontadoid(Short vendedorventascontadoid) {
        this.vendedorventascontadoid = vendedorventascontadoid;
    }

    public Short getVendedorventascreditoid() {
        return vendedorventascreditoid;
    }

    @XmlElement(name = "VendedorVentasCreditoId")
    public void setVendedorventascreditoid(Short vendedorventascreditoid) {
        this.vendedorventascreditoid = vendedorventascreditoid;
    }

    public Integer getVendedorultimafacturanro() {
        return vendedorultimafacturanro;
    }

    @XmlElement(name = "VendedorUltimaFacturaNro")
    public void setVendedorultimafacturanro(Integer vendedorultimafacturanro) {
        this.vendedorultimafacturanro = vendedorultimafacturanro;
    }

    public Integer getVendedorultimocobronro() {
        return vendedorultimocobronro;
    }

    @XmlElement(name = "VendedorUltimoCobroNro")
    public void setVendedorultimocobronro(Integer vendedorultimocobronro) {
        this.vendedorultimocobronro = vendedorultimocobronro;
    }

    public String getVendedorsucursalnombre() {
        return vendedorsucursalnombre;
    }

    @XmlElement(name = "VendedorSucursalNombre")
    public void setVendedorsucursalnombre(String vendedorsucursalnombre) {
        this.vendedorsucursalnombre = vendedorsucursalnombre;
    }

    public Short getVendedornumeracionmanual() {
        return vendedornumeracionmanual;
    }

    @XmlElement(name = "VendedorNumeracionManual")
    public void setVendedornumeracionmanual(Short vendedornumeracionmanual) {
        this.vendedornumeracionmanual = vendedornumeracionmanual;
    }

    public Date getVendedorfechacarga() {
        return vendedorfechacarga;
    }

    @XmlElement(name = "VendedorFechaCarga")
    public void setVendedorfechacarga(Date vendedorfechacarga) {
        this.vendedorfechacarga = vendedorfechacarga;
    }

    public Short getVendedordescargaestado() {
        return vendedordescargaestado;
    }

    @XmlElement(name = "VendedorDescargaEstado")
    public void setVendedordescargaestado(Short vendedordescargaestado) {
        this.vendedordescargaestado = vendedordescargaestado;
    }

    public Short getVendedorlistapreciocontado() {
        return vendedorlistapreciocontado;
    }

    @XmlElement(name = "VendedorListaPrecioContado")
    public void setVendedorlistapreciocontado(Short vendedorlistapreciocontado) {
        this.vendedorlistapreciocontado = vendedorlistapreciocontado;
    }

    public Short getVendedorlistapreciocredito() {
        return vendedorlistapreciocredito;
    }

    @XmlElement(name = "VendedorListaPrecioCredito")
    public void setVendedorlistapreciocredito(Short vendedorlistapreciocredito) {
        this.vendedorlistapreciocredito = vendedorlistapreciocredito;
    }

    public Short getVendedorimpuestoid() {
        return vendedorimpuestoid;
    }

    @XmlElement(name = "VendedorImpuestoId")
    public void setVendedorimpuestoid(Short vendedorimpuestoid) {
        this.vendedorimpuestoid = vendedorimpuestoid;
    }

    public Short getVendedorimpuestoporcentaje() {
        return vendedorimpuestoporcentaje;
    }

    @XmlElement(name = "VendedorImpuestoPorcentaje")
    public void setVendedorimpuestoporcentaje(Short vendedorimpuestoporcentaje) {
        this.vendedorimpuestoporcentaje = vendedorimpuestoporcentaje;
    }

    public Short getVendedordepositoid() {
        return vendedordepositoid;
    }

    @XmlElement(name = "VendedorDepositoId")
    public void setVendedordepositoid(Short vendedordepositoid) {
        this.vendedordepositoid = vendedordepositoid;
    }

    public Short getVendedorultimavisita() {
        return vendedorultimavisita;
    }

    @XmlElement(name = "VendedorUltimaVisita")
    public void setVendedorultimavisita(Short vendedorultimavisita) {
        this.vendedorultimavisita = vendedorultimavisita;
    }

    public Short getVendedorestablecimientonro() {
        return vendedorestablecimientonro;
    }

    @XmlElement(name = "VendedorEstablecimientoNro")
    public void setVendedorestablecimientonro(Short vendedorestablecimientonro) {
        this.vendedorestablecimientonro = vendedorestablecimientonro;
    }

    public Short getVendedorpuntoexpedicionnro() {
        return vendedorpuntoexpedicionnro;
    }

    @XmlElement(name = "VendedorPuntoExpedicionNro")
    public void setVendedorpuntoexpedicionnro(Short vendedorpuntoexpedicionnro) {
        this.vendedorpuntoexpedicionnro = vendedorpuntoexpedicionnro;
    }

    public Short getVendedorusamensajeria() {
        return vendedorusamensajeria;
    }

    @XmlElement(name = "VendedorUsaMensajeria")
    public void setVendedorusamensajeria(Short vendedorusamensajeria) {
        this.vendedorusamensajeria = vendedorusamensajeria;
    }

    public Short getVendedorpedidoscmpid() {
        return vendedorpedidoscmpid;
    }

    @XmlElement(name = "VendedorPedidosCmpId")
    public void setVendedorpedidoscmpid(Short vendedorpedidoscmpid) {
        this.vendedorpedidoscmpid = vendedorpedidoscmpid;
    }

    public Integer getVendedorultimopedidonro() {
        return vendedorultimopedidonro;
    }

    @XmlElement(name = "VendedorUltimoPedidoNro")
    public void setVendedorultimopedidonro(Integer vendedorultimopedidonro) {
        this.vendedorultimopedidonro = vendedorultimopedidonro;
    }

    public Short getVendedorespreciopromocion() {
        return vendedorespreciopromocion;
    }

    @XmlElement(name = "VendedoresPrecioPromocion")
    public void setVendedorespreciopromocion(Short vendedorespreciopromocion) {
        this.vendedorespreciopromocion = vendedorespreciopromocion;
    }

    public Short getVendedorestipo() {
        return vendedorestipo;
    }

    @XmlElement(name = "VendedoresTipo")
    public void setVendedorestipo(Short vendedorestipo) {
        this.vendedorestipo = vendedorestipo;
    }

    public String getVendedorpuertocom() {
        return vendedorpuertocom;
    }

    @XmlElement(name = "VendedorPuertoCom")
    public void setVendedorpuertocom(String vendedorpuertocom) {
        this.vendedorpuertocom = vendedorpuertocom;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.empresasid;
        hash = 97 * hash + this.sucursalesid;
        hash = 97 * hash + this.vendedorid;
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
        final Vendedor other = (Vendedor) obj;
        if (this.empresasid != other.empresasid) {
            return false;
        }
        if (this.sucursalesid != other.sucursalesid) {
            return false;
        }
        if (this.vendedorid != other.vendedorid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return vendedornombre;
    }
}
