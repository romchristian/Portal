/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author cromero
 */
@XmlType(name = "Clientes")
public class Clientes implements Serializable {

    private Integer ClientesId;
    private String ClientesNombre;
    private String ClientesRUC;
    private String ClientesPropietario;
    private String ClientesTelefono;
    private String ClientesDireccion;
    private Short ClientesCambiaPrecio;
    private Short ClientesPrecioContadoId;
    private Short ClientesPrecioCreditoId;
    private BigDecimal ClientesLimiteDeCredito;
    private Integer DescuentosID;
    private Short VendedorId;
    private Integer ClientesPlazo;
    private BigDecimal ClientesSaldo;
    private Integer ClientesFormaCompra;
    private Integer CanalesId;
    private Short CanalesEstado;
    private Short PromoPLM3;
    private String Mayorista;
    private String CanalesNombre;
    private Integer EncuestaId;
    private Short EncuestaEstado;
    private String Mensaje;
    private String NombreComercial;

    public Clientes() {
    }

    public Clientes(Object[] o) {
        this.ClientesId = (Integer) o[0];
        this.ClientesNombre = (String) o[1];
        this.ClientesRUC = (String) o[2];
        this.ClientesPropietario = (String) o[3];
        this.ClientesTelefono = (String) o[4];
        this.ClientesDireccion = ((String) o[5]);
        this.ClientesCambiaPrecio = ((Boolean) o[6]) ? Integer.valueOf(1).shortValue() : Integer.valueOf(0).shortValue();
        this.ClientesPrecioContadoId = ((Integer) o[7]).shortValue();
        this.ClientesPrecioCreditoId = ((Integer) o[8]).shortValue();
        this.VendedorId = ((Integer) o[9]).shortValue();
        this.DescuentosID = (Integer) o[10];
        this.ClientesLimiteDeCredito = new BigDecimal((Integer) o[11]);
        this.ClientesSaldo = new BigDecimal((Integer) o[12]);
        this.ClientesPlazo = (Integer) o[13];
        this.CanalesId = (Integer) o[14];
        this.CanalesEstado = ((Integer) o[15]).shortValue();
        this.PromoPLM3 = ((Integer) o[16]).shortValue();
        this.Mayorista = (String) o[17];
        this.CanalesNombre = (String) o[18];
        this.EncuestaId = (Integer) o[19];
        this.EncuestaEstado = (Short) o[20];
        this.Mensaje = (String) o[21];
        this.NombreComercial = (String) o[22];
        //this.ClientesFormaCompra = (Integer) o[0];
    }

    public Clientes(Object[] o, Canales[] canales) {
        this(o);
        for (int i = 0; i < canales.length; i++) {
            if (this.CanalesNombre != null) {
                if (this.CanalesNombre.trim().compareToIgnoreCase(canales[i].getCanalesDescripcion().trim()) == 0) {
                    this.CanalesId = canales[i].getCanalesId();
                    break;
                }
            }
        }
    }

    public Short getClientesCambiaPrecio() {
        return ClientesCambiaPrecio;
    }

    @XmlElement(name = "ClientesCambiaPrecio", required = true)
    public void setClientesCambiaPrecio(Short ClientesCambiaPrecio) {
        this.ClientesCambiaPrecio = ClientesCambiaPrecio;
    }

    public String getClientesDireccion() {
        return ClientesDireccion;
    }

    @XmlElement(name = "ClientesDireccion")
    public void setClientesDireccion(String ClientesDireccion) {
        this.ClientesDireccion = ClientesDireccion;
    }

    public Integer getClientesId() {
        return ClientesId;
    }

    @XmlElement(name = "ClientesId", required = true)
    public void setClientesId(Integer ClientesId) {
        this.ClientesId = ClientesId;
    }

    public String getClientesNombre() {
        return ClientesNombre;
    }

    @XmlElement(name = "ClientesNombre")
    public void setClientesNombre(String ClientesNombre) {
        this.ClientesNombre = ClientesNombre;
    }

    public Short getClientesPrecioContadoId() {
        return ClientesPrecioContadoId;
    }

    @XmlElement(name = "ClientesPrecioContadoId", required = true)
    public void setClientesPrecioContadoId(Short ClientesPrecioContadoId) {
        this.ClientesPrecioContadoId = ClientesPrecioContadoId;
    }

    public Short getClientesPrecioCreditoId() {
        return ClientesPrecioCreditoId;
    }

    @XmlElement(name = "ClientesPrecioCreditoId", required = true)
    public void setClientesPrecioCreditoId(Short ClientesPrecioCreditoId) {
        this.ClientesPrecioCreditoId = ClientesPrecioCreditoId;
    }

    public String getClientesPropietario() {
        return ClientesPropietario;
    }

    @XmlElement(name = "ClientesPropietario")
    public void setClientesPropietario(String ClientesPropietario) {
        this.ClientesPropietario = ClientesPropietario;
    }

    public String getClientesRUC() {
        return ClientesRUC;
    }

    @XmlElement(name = "ClientesRUC")
    public void setClientesRUC(String ClientesRUC) {
        this.ClientesRUC = ClientesRUC;
    }

    public String getClientesTelefono() {
        return ClientesTelefono;
    }

    @XmlElement(name = "ClientesTelefono", defaultValue = " ")
    public void setClientesTelefono(String ClientesTelefono) {
        this.ClientesTelefono = ClientesTelefono;
    }

    public Integer getDescuentosID() {
        return DescuentosID;
    }

    @XmlElement(name = "DescuentosID", required = true)
    public void setDescuentosID(Integer DescuentosID) {
        this.DescuentosID = DescuentosID;
    }

    public Short getVendedorId() {
        return VendedorId;
    }

    @XmlElement(name = "VendedorId", required = true)
    public void setVendedorId(Short VendedorId) {
        this.VendedorId = VendedorId;
    }

    public BigDecimal getClientesLimiteDeCredito() {
        return ClientesLimiteDeCredito;
    }

    @XmlElement(name = "ClientesLimiteDeCredito", required = true)
    public void setClientesLimiteDeCredito(BigDecimal ClientesLimiteDeCredito) {
        this.ClientesLimiteDeCredito = ClientesLimiteDeCredito;
    }

    public Integer getClientesPlazo() {
        return ClientesPlazo;
    }

    @XmlElement(name = "ClientesPlazo", required = true)
    public void setClientesPlazo(Integer ClientesPlazo) {
        this.ClientesPlazo = ClientesPlazo;
    }

    public BigDecimal getClientesSaldo() {
        return ClientesSaldo;
    }

    @XmlElement(name = "ClientesSaldo", required = true)
    public void setClientesSaldo(BigDecimal ClientesSaldo) {
        this.ClientesSaldo = ClientesSaldo;
    }

    public Integer getClientesFormaCompra() {
        return ClientesFormaCompra;
    }

    @XmlElement(name = "ClientesFormaCompra", required = true)
    public void setClientesFormaCompra(Integer ClientesFormaCompra) {
        this.ClientesFormaCompra = ClientesFormaCompra;
    }

    public Integer getCanalesId() {
        return CanalesId;
    }

    @XmlElement(name = "CanalesId")
    public void setCanalesId(Integer CanalesId) {
        this.CanalesId = CanalesId;
    }

    public Short getCanalesEstado() {
        return CanalesEstado;
    }

    @XmlElement(name = "CanalesEstado")
    public void setCanalesEstado(Short CanalesEstado) {
        this.CanalesEstado = CanalesEstado;
    }

    public Short getPromoPLM3() {
        return PromoPLM3;
    }

    @XmlElement(name = "PromoPLM3")
    public void setPromoPLM3(Short PromoPLM3) {
        this.PromoPLM3 = PromoPLM3;
    }

    public String getMayorista() {
        return Mayorista;
    }

    @XmlElement(name = "Mayorista")
    public void setMayorista(String Mayorista) {
        this.Mayorista = Mayorista;
    }

    public Integer getEncuestaId() {
        return EncuestaId;
    }

    @XmlElement(name = "EncuestaId")
    public void setEncuestaId(Integer EncuestaId) {
        this.EncuestaId = EncuestaId;
    }

    public Short getEncuestaEstado() {
        return EncuestaEstado;
    }

    @XmlElement(name = "EncuestaEstado")
    public void setEncuestaEstado(Short EncuestaEstado) {
        this.EncuestaEstado = EncuestaEstado;
    }

    public String getMensaje() {
        return Mensaje;
    }

    @XmlElement(name = "Mensaje")
    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public String getNombreComercial() {
        return NombreComercial;
    }

    @XmlElement(name = "NombreComercial")
    public void setNombreComercial(String NombreComercial) {
        this.NombreComercial = NombreComercial;
    }




}
