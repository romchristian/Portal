/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.interfaz;

import javax.ejb.Local;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Cobranzas;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.CobranzasAplicacionPago;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.CobranzasCobros;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.CobranzasDetalle;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Facturas;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.FacturasAplicacionPago;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.FacturasCobros;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.FacturasDetalle;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Relevamientos;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Respuesta;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Retenciones;
import py.com.palermo.app.portalgeneral.servicio.response.BancosResponse;
import py.com.palermo.app.portalgeneral.servicio.response.CanalesResponse;
import py.com.palermo.app.portalgeneral.servicio.response.CantMaximaClientePromoResponse;
import py.com.palermo.app.portalgeneral.servicio.response.CierreCobranzaResponse;
import py.com.palermo.app.portalgeneral.servicio.response.CierreFacturaResponse;
import py.com.palermo.app.portalgeneral.servicio.response.CierreRetencionesResponse;
import py.com.palermo.app.portalgeneral.servicio.response.ClientesResponse;
import py.com.palermo.app.portalgeneral.servicio.response.ComposicionPromoResponse;
import py.com.palermo.app.portalgeneral.servicio.response.EncuestaResponse;
import py.com.palermo.app.portalgeneral.servicio.response.FacturasResponse;
import py.com.palermo.app.portalgeneral.servicio.response.GuardarRelevamientosResponse;
import py.com.palermo.app.portalgeneral.servicio.response.MarcasResponse;
import py.com.palermo.app.portalgeneral.servicio.response.MediosPagosResponse;
import py.com.palermo.app.portalgeneral.servicio.response.MotivosNoVentasResponse;
import py.com.palermo.app.portalgeneral.servicio.response.OpcionResponse;
import py.com.palermo.app.portalgeneral.servicio.response.PreciosResponse;
import py.com.palermo.app.portalgeneral.servicio.response.PreguntaResponse;
import py.com.palermo.app.portalgeneral.servicio.response.ProductosMedidasResponse;
import py.com.palermo.app.portalgeneral.servicio.response.ProductosResponse;
import py.com.palermo.app.portalgeneral.servicio.response.UnidadesMedidaResponse;
import py.com.palermo.app.portalgeneral.servicio.response.UsuarioResponse;
import py.com.palermo.app.portalgeneral.servicio.response.VendedorResponse;
import py.com.palermo.app.portalgeneral.servicio.response.VisitasResponse;

/**
 *
 * @author cromero
 */

@Local
public interface IServicio {

    //Metodos GET
    
    UsuarioResponse getUsuario(String deviceId);
    
    public VendedorResponse getVendedor(String deviceId);

    public EncuestaResponse getEncuestas(String deviceId);

    public PreguntaResponse getPreguntas(String deviceId);

    public int SetRespuestaEncuesta(Respuesta r,String deviceId);

    public int SetRespuestas(Respuesta[] lista,String deviceId);

    public OpcionResponse getOpciones(String deviceId);

    public MotivosNoVentasResponse getMotivosNoVentas(String deviceId);

    public ClientesResponse getClientes(String deviceId);

    public MarcasResponse getMarcas(String deviceId);

    public CanalesResponse getCanales(String deviceId);

    public ProductosResponse getProductos(String deviceId);

    public VisitasResponse getVisitas(String deviceId);

    public BancosResponse getBancos(String deviceId);

    public MediosPagosResponse getMediosPagos(String deviceId);

    public UnidadesMedidaResponse getUnidadesMedida(String deviceId);

    public FacturasResponse getFacturasPendientes(String deviceId);

    public ProductosMedidasResponse getProductosMedidas(String deviceId);

    public PreciosResponse getPrecios(String deviceId);

    public ComposicionPromoResponse getComposicionesPromo(String deviceId);

    public CantMaximaClientePromoResponse getCantidadesMaximaClientePromo(String deviceId);

    // Operaciones
    
    public boolean reponerStock(String deviceId);

    public int anularFactura(int cmpId, int puntoExpedicionNro, int comprobanteNro, String deviceId);

    public int setFactura(Facturas cabecera, FacturasDetalle[] detalle, FacturasCobros[] cobros,FacturasAplicacionPago[] aplicaciones, String deviceId);

    public int setRetencion(Retenciones retencion, String deviceId);

    public int setCobranza(Cobranzas cabecera, CobranzasDetalle[] detalle, CobranzasCobros[] cobros, CobranzasAplicacionPago[] aplicaciones,String deviceId);

    public int setRelevamiento(Relevamientos nuevo, String deviceId);

    public int setCanalCliente(int clienteId, int canalId, int canalEstado, String deviceId);
    
    public int setEncuestaClientes(long encuestaId, String clave);
    
    
    // Cierres 

    public CierreCobranzaResponse efectuarCierreDeCobranzas(int cantCobranzas, double montoCobrado, String deviceId);

    public CierreFacturaResponse efectuarCierreDeFacturas(int cantFacturas, double montoFacturado, String deviceId);

    public GuardarRelevamientosResponse efectuarCierreMotivoNoVentas(String deviceId);

    public CierreRetencionesResponse efectuarCierreDeRetenciones(String deviceId);
}
