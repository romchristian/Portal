/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial;

import javax.ejb.EJB;
import javax.ejb.Stateless;
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
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Vendedor;
import py.com.palermo.app.portalgeneral.interfaz.AccesoDenegadoException;

import py.com.palermo.app.portalgeneral.interfaz.IServicio;
import py.com.palermo.app.portalgeneral.modelo.Rol;
import py.com.palermo.app.portalgeneral.modelo.Usuario;
import py.com.palermo.app.portalgeneral.servicio.UsuarioDAO;
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
@Stateless
public class ServicioGestionComercial implements IServicio {

    @EJB
    private UsuarioDAO usuarioDAO;
    @EJB
    private DAOGcMovil dAOGcMovil;
    @EJB
    private Proxy proxy;

    @Override
    public UsuarioResponse getUsuario(String deviceId) {
        UsuarioResponse R = new UsuarioResponse();
        R.setMensaje("Fallo");
        Usuario u = usuarioDAO.getUsuario(deviceId);
        System.out.println("Usuario : " + u);
        if (u != null) {
            R.setUsuario(u);
            R.setMensaje("exito");
            Rol[] array = new Rol[u.getRoles().size()];
            R.setRoles(u.getRoles().toArray(array));
        }

        return R;
    }

    @Override
    public VendedorResponse getVendedor(String deviceId) {

        DAOGcVentasPalermo gcVentas = null;
        Vendedor v = null;
        try {
            
            v = dAOGcMovil.getVendedor(1);
            if (v == null) {
                throw new AccesoDenegadoException();
            }
            gcVentas = proxy.getContenedorGCVentas(v.getSucursalesid());
            
            if (gcVentas == null) {
                throw new AccesoDenegadoException();
            }
            

            dAOGcMovil.verificaFacturasNoDescargadas(v);

            dAOGcMovil.setVendedorUltimoNroFactura(gcVentas.getVendedorUltimoNroFactura(v), v);

        } catch (AccesoDenegadoException ex) {
            System.err.println(ex.getMessage());
            VendedorResponse R = new VendedorResponse();
            R.setCodRetorno(UtilCons.COD_ACCESO_DENEGADO);
            R.setMensaje(UtilCons.MENSAJE_ACCESO_DENEGADO);
            return R;
        }
        return gcVentas.getVendedor(v);
    }

    @Override
    public EncuestaResponse getEncuestas(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreguntaResponse getPreguntas(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int SetRespuestaEncuesta(Respuesta r, String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int SetRespuestas(Respuesta[] lista, String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OpcionResponse getOpciones(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MotivosNoVentasResponse getMotivosNoVentas(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClientesResponse getClientes(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MarcasResponse getMarcas(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CanalesResponse getCanales(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductosResponse getProductos(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VisitasResponse getVisitas(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BancosResponse getBancos(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MediosPagosResponse getMediosPagos(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UnidadesMedidaResponse getUnidadesMedida(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FacturasResponse getFacturasPendientes(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductosMedidasResponse getProductosMedidas(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreciosResponse getPrecios(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ComposicionPromoResponse getComposicionesPromo(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CantMaximaClientePromoResponse getCantidadesMaximaClientePromo(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reponerStock(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int anularFactura(int cmpId, int puntoExpedicionNro, int comprobanteNro, String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int setFactura(Facturas cabecera, FacturasDetalle[] detalle, FacturasCobros[] cobros, FacturasAplicacionPago[] aplicaciones, String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int setRetencion(Retenciones retencion, String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int setCobranza(Cobranzas cabecera, CobranzasDetalle[] detalle, CobranzasCobros[] cobros, CobranzasAplicacionPago[] aplicaciones, String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int setRelevamiento(Relevamientos nuevo, String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int setCanalCliente(int clienteId, int canalId, int canalEstado, String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int setEncuestaClientes(long encuestaId, String clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CierreCobranzaResponse efectuarCierreDeCobranzas(int cantCobranzas, double montoCobrado, String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CierreFacturaResponse efectuarCierreDeFacturas(int cantFacturas, double montoFacturado, String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GuardarRelevamientosResponse efectuarCierreMotivoNoVentas(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CierreRetencionesResponse efectuarCierreDeRetenciones(String deviceId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
