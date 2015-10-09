/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author cromero
 */
@XmlType(name = "Visitas")
public class Visitas implements Serializable {

    private short VendedorId;
    private short VisitasDias;
    private short VisitasOrden;
    private int ClientesId;
    private short ClientesVisitaEstadoFactura;
    private short ClientesVisitaEstadoCobranza;
    private short EmpresasId;
    private short SucursalesId;

    public Visitas() {
    }

    
    public Visitas(short VendedorId, short VisitasDias, short VisitasOrden, int ClientesId, short ClientesVisitaEstadoFactura, short ClientesVisitaEstadoCobranza, short EmpresasId, short SucursalesId) {
        this.VendedorId = VendedorId;
        this.VisitasDias = VisitasDias;
        this.VisitasOrden = VisitasOrden;
        this.ClientesId = ClientesId;
        this.ClientesVisitaEstadoFactura = ClientesVisitaEstadoFactura;
        this.ClientesVisitaEstadoCobranza = ClientesVisitaEstadoCobranza;
        this.EmpresasId = EmpresasId;
        this.SucursalesId = SucursalesId;
    }

    public Visitas(Object[] o) {
        this(((Integer) o[0]).shortValue(),
                ((Integer) o[1]).shortValue(),
                ((Integer) o[2]).shortValue(),
                (Integer) o[3],
                ((Integer) o[4]).shortValue(),
                ((Integer) o[5]).shortValue(),
                ((Integer) o[6]).shortValue(),
                ((Integer) o[7]).shortValue());
    }

    public short getVendedorId() {
        return VendedorId;
    }

    @XmlElement(name = "VendedorId")
    public void setVendedorId(short VendedorId) {
        this.VendedorId = VendedorId;
    }

    public short getVisitasDias() {
        return VisitasDias;
    }

    @XmlElement(name = "VisitasDias")
    public void setVisitasDias(short VisitasDias) {
        this.VisitasDias = VisitasDias;
    }

    public short getVisitasOrden() {
        return VisitasOrden;
    }

    @XmlElement(name = "VisitasOrden")
    public void setVisitasOrden(short VisitasOrden) {
        this.VisitasOrden = VisitasOrden;
    }

    public int getClientesId() {
        return ClientesId;
    }

    @XmlElement(name = "ClientesId")
    public void setClientesId(int ClientesId) {
        this.ClientesId = ClientesId;
    }

    public short getClientesVisitaEstadoFactura() {
        return ClientesVisitaEstadoFactura;
    }

    @XmlElement(name = "ClientesVisitaEstadoFactura")
    public void setClientesVisitaEstadoFactura(short ClientesVisitaEstadoFactura) {
        this.ClientesVisitaEstadoFactura = ClientesVisitaEstadoFactura;
    }

    public short getClientesVisitaEstadoCobranza() {
        return ClientesVisitaEstadoCobranza;
    }

    @XmlElement(name = "ClientesVisitaEstadoCobranza")
    public void setClientesVisitaEstadoCobranza(short ClientesVisitaEstadoCobranza) {
        this.ClientesVisitaEstadoCobranza = ClientesVisitaEstadoCobranza;
    }

    public short getEmpresasId() {
        return EmpresasId;
    }

    @XmlElement(name = "EmpresasId")
    public void setEmpresasId(short EmpresasId) {
        this.EmpresasId = EmpresasId;
    }

    public short getSucursalesId() {
        return SucursalesId;
    }

    @XmlElement(name = "SucursalesId")
    public void setSucursalesId(short SucursalesId) {
        this.SucursalesId = SucursalesId;
    }
}
