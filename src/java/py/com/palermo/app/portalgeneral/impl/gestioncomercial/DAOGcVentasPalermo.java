/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import java.util.List;

import javax.persistence.EntityManager;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Bancos;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Canales;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.CantMaximaClientesPromo;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Cliente;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Clientes;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Cobranzas;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.CobranzasAplicacionPago;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.CobranzasCobros;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.CobranzasDetalle;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.ComposicionPromo;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Facturas;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.FacturasAplicacionPago;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.FacturasCobros;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.FacturasDetalle;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Marcas;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.MediosPagos;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.MotivosNoVentas;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Precios;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Productos;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.ProductosMedidas;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Relevamientos;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Retenciones;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.UnidadesMedida;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Vendedor;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Visitas;
import py.com.palermo.app.portalgeneral.interfaz.NoHayCmpCobranzaException;
import py.com.palermo.app.portalgeneral.interfaz.NoInsertoCobranzasException;
import py.com.palermo.app.portalgeneral.interfaz.NoInsertoFacturasException;
import py.com.palermo.app.portalgeneral.interfaz.NoInsertoRelevamientosException;
import py.com.palermo.app.portalgeneral.interfaz.NoInsertoRetencionesException;
import py.com.palermo.app.portalgeneral.interfaz.SinDetallesFacturasException;
import py.com.palermo.app.portalgeneral.servicio.response.BancosResponse;
import py.com.palermo.app.portalgeneral.servicio.response.CanalesResponse;
import py.com.palermo.app.portalgeneral.servicio.response.CantMaximaClientePromoResponse;
import py.com.palermo.app.portalgeneral.servicio.response.CierreCobranzaResponse;
import py.com.palermo.app.portalgeneral.servicio.response.CierreFacturaResponse;
import py.com.palermo.app.portalgeneral.servicio.response.CierreRetencionesResponse;
import py.com.palermo.app.portalgeneral.servicio.response.ClientesResponse;
import py.com.palermo.app.portalgeneral.servicio.response.ComposicionPromoResponse;
import py.com.palermo.app.portalgeneral.servicio.response.FacturasResponse;
import py.com.palermo.app.portalgeneral.servicio.response.GuardarRelevamientosResponse;
import py.com.palermo.app.portalgeneral.servicio.response.MarcasResponse;
import py.com.palermo.app.portalgeneral.servicio.response.MediosPagosResponse;
import py.com.palermo.app.portalgeneral.servicio.response.MotivosNoVentasResponse;
import py.com.palermo.app.portalgeneral.servicio.response.PreciosResponse;
import py.com.palermo.app.portalgeneral.servicio.response.ProductosMedidasResponse;
import py.com.palermo.app.portalgeneral.servicio.response.ProductosResponse;
import py.com.palermo.app.portalgeneral.servicio.response.UnidadesMedidaResponse;
import py.com.palermo.app.portalgeneral.servicio.response.VendedorResponse;
import py.com.palermo.app.portalgeneral.servicio.response.VisitasResponse;

/**
 *
 * @author cromero
 */
public abstract class DAOGcVentasPalermo {

    public abstract EntityManager getEM();

    public VendedorResponse getVendedor(Vendedor v) {
        VendedorResponse R = new VendedorResponse();

        if (v == null) {
            R.setCodRetorno(UtilCons.COD_ERROR);
            return R;
        }

        R.setVendedor(v);
        R.setCodRetorno(UtilCons.COD_EXITO);
        return R;
    }

    public Integer getVendedorUltimoNroFactura(Vendedor v) {
        Integer ultimonro = 0;
        EntityManager em = getEM();

        try {
            ultimonro = (Integer) em.createNativeQuery(ConsultasPalermo.getCosultaVendedorUltimoNroFactura(v)).getSingleResult();
        } catch (Exception e) {
        } finally {
            em.close();
        }

        return ultimonro;
    }

    public ClientesResponse getClientes(Vendedor v) {
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("GCVentasPalermoASUPU");
        EntityManager em = getEM();

        ClientesResponse R = new ClientesResponse();

        List<Object[]> lista = em.createNativeQuery(ConsultasPalermo.getConsultaClientes(v)).getResultList();

        if (lista.size() > 0) {
            Clientes[] clientes = new Clientes[lista.size()];
            Canales[] canales = getArrayCanales();

            for (int i = 0; i < lista.size(); i++) {
                clientes[i] = new Clientes(lista.get(i), canales);
            }

            R.setCodRetorno(UtilCons.COD_EXITO);
            R.setClientes(clientes);
        } else {
            R.setCodRetorno(UtilCons.COD_ERROR);
        }

        em.close();

        return R;
    }

    public CantMaximaClientePromoResponse GetCantidadesMaximaClientePromo(Vendedor v) {
        EntityManager em = getEM();
        CantMaximaClientePromoResponse R = new CantMaximaClientePromoResponse();
        List<Object[]> lista = em.createNativeQuery(ConsultasPalermo.getConsultaCantMaximaClientePromo(v)).getResultList();

        em.close();

        if (lista.size() > 0) {
            CantMaximaClientesPromo[] cantMaximaClientesPromo = new CantMaximaClientesPromo[lista.size()];

            for (int i = 0; i < lista.size(); i++) {
                cantMaximaClientesPromo[i] = new CantMaximaClientesPromo(lista.get(i));
            }

            R.setCodRetorno(UtilCons.COD_EXITO);
            R.setCantMaximaClientesPromos(cantMaximaClientesPromo);
        } else {

            CantMaximaClientesPromo[] cantMaximaClientesPromo = new CantMaximaClientesPromo[0];
            R.setCantMaximaClientesPromos(cantMaximaClientesPromo);
            R.setCodRetorno(UtilCons.COD_EXITO);
        }

        return R;
    }

    public ComposicionPromoResponse GetComposicionesPromo(Vendedor v) {
        EntityManager em = getEM();
        ComposicionPromoResponse R = new ComposicionPromoResponse();
        List<Object[]> lista = em.createNativeQuery(ConsultasPalermo.getComposicionPromo()).getResultList();
        em.close();
        if (lista.size() > 0) {
            ComposicionPromo[] composiciones = new ComposicionPromo[lista.size()];

            for (int i = 0; i < lista.size(); i++) {
                composiciones[i] = new ComposicionPromo(lista.get(i));
            }

            Productos[] productos = getProductos(v).getProductos();

            List<ComposicionPromo> listaaux = new ArrayList<>();

            List<Productos> productoskit = new ArrayList<>();

            if (productos != null) {
                for (int i = 0; i < productos.length; i++) {
                    Productos p = productos[i];
                    if (p.getProductoKit() == 1) {
                        productoskit.add(p);
                    }
                }
            }

            for (int i = 0; i < composiciones.length; i++) {
                ComposicionPromo c = composiciones[i];
                for (Productos p : productoskit) {
                    if (c.getProductoIdKit().equals(p.getProductoId())) {
                        listaaux.add(c);
                    }
                }
            }

            composiciones = new ComposicionPromo[listaaux.size()];

            composiciones = listaaux.toArray(composiciones);

            System.out.println("Composiciones: " + composiciones.length);

            R.setCodRetorno(UtilCons.COD_EXITO);
            R.setComposicionesPromo(composiciones);
        } else {
            ComposicionPromo[] composiciones = new ComposicionPromo[0];
            R.setCodRetorno(UtilCons.COD_EXITO);
            R.setComposicionesPromo(composiciones);
        }

        return R;
    }

    private Canales[] getArrayCanales() {
        EntityManager em = getEM();
        List<Object[]> lista = em.createNativeQuery(ConsultasPalermo.getConsultaCanales()).getResultList();

        em.close();
        Canales[] R = new Canales[lista.size()];

        for (int i = 0; i < lista.size(); i++) {
            R[i] = new Canales(lista.get(i));
        }
        return R;
    }

    public MotivosNoVentasResponse getMotivoNoVenta() {
        EntityManager em = getEM();
        MotivosNoVentasResponse R = new MotivosNoVentasResponse();
        List<Object[]> lista = em.createNativeQuery(ConsultasPalermo.getConsultaMotivosNoVenta()).getResultList();
        em.close();
        if (lista.size() > 0) {
            MotivosNoVentas[] motivos = new MotivosNoVentas[lista.size()];

            for (int i = 0; i < lista.size(); i++) {
                motivos[i] = new MotivosNoVentas(lista.get(i));
            }

            R.setCodRetorno(UtilCons.COD_EXITO);
            R.setMotivosNoVentas(motivos);
        } else {
            R.setCodRetorno(UtilCons.COD_ERROR);
        }

        return R;
    }

    public MarcasResponse getMarcas() {
        EntityManager em = getEM();
        MarcasResponse R = new MarcasResponse();
        List<Object[]> lista = em.createNativeQuery(ConsultasPalermo.getConsultaMarcas()).getResultList();
        em.close();

        if (lista.size() > 0) {
            Marcas[] marcas = new Marcas[lista.size()];

            for (int i = 0; i < lista.size(); i++) {
                marcas[i] = new Marcas(lista.get(i));
            }

            R.setCodRetorno(UtilCons.COD_EXITO);
            R.setMarcas(marcas);
        } else {
            R.setCodRetorno(UtilCons.COD_ERROR);
        }

        return R;
    }

    public CanalesResponse getCanales() {
        EntityManager em = getEM();
        CanalesResponse R = new CanalesResponse();
        List<Object[]> lista = em.createNativeQuery(ConsultasPalermo.getConsultaCanales()).getResultList();
        em.close();
        if (lista.size() > 0) {
            Canales[] canales = new Canales[lista.size()];

            for (int i = 0; i < lista.size(); i++) {
                canales[i] = new Canales(lista.get(i));
            }

            R.setCodRetorno(UtilCons.COD_EXITO);
            R.setCanales(canales);
        } else {
            R.setCodRetorno(UtilCons.COD_ERROR);
        }

        return R;
    }

    public ProductosResponse getProductos(Vendedor v) {
        EntityManager em = getEM();
        ProductosResponse R = new ProductosResponse();
        List<Object[]> lista = em.createNativeQuery(ConsultasPalermo.getConsultaProcutos(v)).getResultList();
        em.close();
        if (lista.size() > 0) {
            Productos[] productos = new Productos[lista.size()];

            for (int i = 0; i < lista.size(); i++) {
                productos[i] = new Productos(lista.get(i));
            }

            R.setCodRetorno(UtilCons.COD_EXITO);
            R.setProductos(productos);
        } else {
            R.setCodRetorno(UtilCons.COD_ERROR);
        }

        return R;
    }

    public VisitasResponse getVisitas(Vendedor v) {
        EntityManager em = getEM();
        VisitasResponse R = new VisitasResponse();
        List<Object[]> lista = em.createNativeQuery(ConsultasPalermo.getConsultaVisitas(v)).getResultList();
        em.close();

        if (lista.size() > 0) {
            Visitas[] visitas = new Visitas[lista.size()];

            for (int i = 0; i < lista.size(); i++) {
                visitas[i] = new Visitas(lista.get(i));
            }

            R.setCodRetorno(UtilCons.COD_EXITO);
            R.setVisitas(visitas);
        } else {
            R.setCodRetorno(UtilCons.COD_ERROR);
        }

        return R;
    }

    public BancosResponse getBancos() {
        EntityManager em = getEM();
        BancosResponse R = new BancosResponse();

        List<Object[]> lista = em.createNativeQuery(ConsultasPalermo.getConsultaBancos()).getResultList();

        em.close();
        if (lista.size() > 0) {
            Bancos[] bancos = new Bancos[lista.size()];

            for (int i = 0; i < lista.size(); i++) {
                bancos[i] = new Bancos(lista.get(i));
            }

            R.setCodRetorno(UtilCons.COD_EXITO);
            R.setBancos(bancos);
        } else {
            R.setCodRetorno(UtilCons.COD_ERROR);
        }

        return R;
    }

    public MediosPagosResponse getMediosPagos(Vendedor v) {
        EntityManager em = getEM();
        MediosPagosResponse R = new MediosPagosResponse();
        List<Object[]> lista = em.createNativeQuery(ConsultasPalermo.getConsultaMediosPago(v)).getResultList();
        em.close();
        if (lista.size() > 0) {
            MediosPagos[] mediospagos = new MediosPagos[lista.size()];

            for (int i = 0; i < lista.size(); i++) {
                mediospagos[i] = new MediosPagos(lista.get(i));
            }

            R.setCodRetorno(UtilCons.COD_EXITO);
            R.setMediosPagos(mediospagos);
        } else {
            R.setCodRetorno(UtilCons.COD_ERROR);
        }

        return R;
    }

    public UnidadesMedidaResponse getUnidadesMedida() {
        EntityManager em = getEM();
        UnidadesMedidaResponse R = new UnidadesMedidaResponse();
        List<Object[]> lista = em.createNativeQuery(ConsultasPalermo.getConsultaUnidadesMedida()).getResultList();
        em.close();
        if (lista.size() > 0) {
            UnidadesMedida[] unidadesmedidas = new UnidadesMedida[lista.size()];

            for (int i = 0; i < lista.size(); i++) {
                unidadesmedidas[i] = new UnidadesMedida(lista.get(i));
            }

            R.setCodRetorno(UtilCons.COD_EXITO);
            R.setUnidadesMedida(unidadesmedidas);
        } else {
            R.setCodRetorno(UtilCons.COD_ERROR);
        }

        return R;
    }

    public FacturasResponse GetFPendientes(Vendedor v) {
        EntityManager em = getEM();
        FacturasResponse R = new FacturasResponse();
        List<Object[]> lista = em.createNativeQuery(ConsultasPalermo.getConsultaFPendientes(v)).getResultList();
        em.close();

        if (lista.size() > 0) {
            Facturas[] facturas = new Facturas[lista.size()];

            for (int i = 0; i < lista.size(); i++) {
                facturas[i] = new Facturas(lista.get(i));
            }

            R.setCodRetorno(UtilCons.COD_EXITO);
            R.setFacturas(facturas);
        } else {
            R.setCodRetorno(UtilCons.COD_ERROR);
        }

        return R;
    }

    public PreciosResponse GetPrecios() {
        EntityManager em = getEM();
        PreciosResponse R = new PreciosResponse();
        List<Object[]> lista = em.createNativeQuery(ConsultasPalermo.getConsultaPrecios()).getResultList();
        em.close();

        if (lista.size() > 0) {
            Precios[] precios = new Precios[lista.size()];

            for (int i = 0; i < lista.size(); i++) {
                precios[i] = new Precios(lista.get(i));
            }

            R.setCodRetorno(UtilCons.COD_EXITO);
            R.setPrecios(precios);
        } else {
            R.setCodRetorno(UtilCons.COD_ERROR);
        }

        return R;
    }

    public ProductosMedidasResponse GetProductosMedidas() {
        EntityManager em = getEM();
        ProductosMedidasResponse R = new ProductosMedidasResponse();
        List<Object[]> lista = em.createNativeQuery(ConsultasPalermo.getConsultaProductosMedida()).getResultList();
        em.close();
        if (lista.size() > 0) {
            ProductosMedidas[] productosMedidas = new ProductosMedidas[lista.size()];

            for (int i = 0; i < lista.size(); i++) {
                productosMedidas[i] = new ProductosMedidas(lista.get(i));
            }

            R.setCodRetorno(UtilCons.COD_EXITO);
            R.setProductosMedidas(productosMedidas);
        } else {
            R.setCodRetorno(UtilCons.COD_ERROR);
        }

        return R;
    }

    public int SetCanalCliente(int clienteId, int canalId, int canalEstado) {

        EntityManager em = getEM();
        System.out.println("Estoy en set Canal Cliente");
        System.out.println("ClienteId : " + clienteId);
        System.out.println("CanalId : " + canalId);
        System.out.println("CanalEstado : " + canalEstado);
        String cadena = "update [VTA_Clientes] "
                + " set Canales = (select CanalesDescripcion from Canales where CanalesId = " + canalId + "),"
                + " EstadoCanal = " + canalEstado + " WHERE [ID Clientes]  = " + clienteId;
        System.out.println("Cadena : " + cadena);

        try {
            em.getTransaction().begin();
            em.createNativeQuery(cadena).executeUpdate();
            System.out.println("Se ejecuto correctamente");
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(ex.getMessage() + " : " + ex.getCause());
            try {
                em.getTransaction().rollback();
            } catch (Exception e) {
                System.err.println("No se pudo hacer rollback");
            }
            return UtilCons.COD_ERROR;
        } finally {
            em.close();
        }

        return UtilCons.COD_EXITO;
    }

    public int SetEncuestaEstadoCliente(int clienteId, int encuestaId, int encuestaEstado) {

        EntityManager em = getEM();

        String cadena = " update [VTA_Clientes] "
                + " set encuesta_estado =  encuesta_estado + 1 "
                + " WHERE [ID Clientes]  = " + clienteId
                + " AND encuesta_id = " + encuestaId;

        System.out.println("Cadena : " + cadena);

        try {
            em.getTransaction().begin();
            em.createNativeQuery(cadena).executeUpdate();
            System.out.println("Se ejecuto correctamente");
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.err.println(ex.getMessage() + " : " + ex.getCause());
            try {
                em.getTransaction().rollback();
            } catch (Exception e) {
                System.err.println("No se pudo hacer rollback");
            }
            return UtilCons.COD_ERROR;
        } finally {
            em.close();
        }

        return UtilCons.COD_EXITO;
    }

    public int SetEncuestaClientes(long encuestaId, List<Cliente> clientes) {

        System.out.println("HOLAAAAAAAAAAAAAA Estoy en GC VENTASSSSSSSSSSSSS");
        EntityManager em = getEM();

        if (clientes != null) {
            System.out.println("Entre 1");
            String cadena = " update [VTA_Clientes] "
                    + " set encuesta_id = null, encuesta_estado = null "
                    + "  WHERE encuesta_id  = " + encuestaId + ";";
            System.out.println("Cadena : " + cadena);

            StringBuilder sb = new StringBuilder(cadena);
            if (!clientes.isEmpty()) {
                sb.append(" update [VTA_Clientes] set encuesta_id = ").append(encuestaId).append(" , encuesta_estado = 0 WHERE [ID Clientes]  in ( ");
                for (int i = 0; i < clientes.size(); i++) {
                    Cliente c = clientes.get(i);
                    if (i == clientes.size() - 1) {
                        sb.append(c.getClientePK().getClienteId());
                    } else {
                        sb.append(c.getClientePK().getClienteId()).append(",");
                    }

                }

                sb.append(" );");
            }
            System.out.println("Consulta: " + sb.toString());

            try {
                em.getTransaction().begin();
                System.out.println("Ejecuta 1");
                em.createNativeQuery(sb.toString()).executeUpdate();
                System.out.println("Ejecuta 2");

                System.out.println("Se ejecuto correctamente");

                em.getTransaction().commit();
            } catch (Exception ex) {
                System.err.println(ex.getMessage() + " : " + ex.getCause());
                try {
                    em.getTransaction().rollback();
                } catch (Exception e) {
                    System.err.println("No se pudo hacer rollback");
                }
                return UtilCons.COD_ERROR;
            } finally {
                em.close();
            }
        }
        return UtilCons.COD_EXITO;
    }

    public boolean ReponerStock(Vendedor v) {
        return true;
    }

    public CierreFacturaResponse efectuarCierreFacturas(List<Facturas> listaFacturas, Vendedor v)
            throws NoInsertoFacturasException {
        EntityManager em = getEM();
        CierreFacturaResponse R = new CierreFacturaResponse();
        try {
            em.getTransaction().begin();

            for (Facturas f : listaFacturas) {
                if (f.getFacturasestadoanulacion().compareToIgnoreCase("S") != 0) {
                    if (f.getFacturasdetalleList() == null || (f.getFacturasdetalleList() != null && f.getFacturasdetalleList().isEmpty())) {
                        throw new SinDetallesFacturasException(null);
                    }
                }
            }

            int ultimoNroDeFactura = 0;

            Comparator<Facturas> comp = new Comparator<Facturas>() {

                @Override
                public int compare(Facturas o1, Facturas o2) {
                    return o1.getFacturasnumero() > o2.getFacturasnumero() ? 1 : -1;
                }
            };

            Collections.sort(listaFacturas, comp);

            boolean hayColumnasAdicionales = false;

            try {
                String consulta2 = "SELECT COLUMN_NAME "
                        + " FROM INFORMATION_SCHEMA.COLUMNS"
                        + " WHERE TABLE_NAME = 'VTA_C Comprobantes de Ventas' AND TABLE_SCHEMA='dbo'"
                        + " and COLUMN_NAME = 'gpslat'";

                String columnaLat = (String) em.createNativeQuery(consulta2).getSingleResult();

                hayColumnasAdicionales = true;
            } catch (Exception e) {
                System.out.println("No hay columna gpsLat");
            }

            for (Facturas f : listaFacturas) {
                System.out.println("Inserta");
                List<FacturasDetalle> detalles = f.getFacturasdetalleList();

                String consulta;
                if (!hayColumnasAdicionales) {
                    consulta = "INSERT INTO [VTA_C Comprobantes de Ventas] ("
                            + "[Origen],"
                            + "[ID Sucursales],"
                            + "[ID Vendedores],"
                            + "[ID Comprobantes Ventas],"
                            + "[Numero],"
                            + "[Fecha],"
                            + "[ID Clientes],"
                            + "[Forma Pago],"
                            + "[ID Listas Precios],"
                            + "[ID Depositos],"
                            + "[ID Moneda Extranjera],"
                            + "[Cotizacion Comprobante],"
                            + "[Importe Impuesto ML],"
                            + "[Importe Impuesto ME],"
                            + "[Importe Gravada ML],"
                            + "[Importe Gravada ME],"
                            + "[Importe Exenta ML],"
                            + "[Importe Exenta ME],"
                            + "[Importe Total ML],"
                            + "[Importe Total ME],"
                            + "[Fecha Descarga],"
                            + "[Status],"
                            + "[Autorizacion],"
                            + "[Fecha Cierre],"
                            + "[Importe Descuento ML],"
                            + "[Importe Descuento ME],"
                            + "[IVA Exenta])"
                            + "Values ("
                            + "2, " /*[Origen]*/
                            + v.getSucursalesid() + ", " /*[ID Sucursales]*/
                            + v.getVendedorid() + ", " /*[ID Vendedores]*/
                            + f.getFacturascmpid() + ", " /*[ID Comprobantes Ventas]*/
                            + f.getFacturasnumero() + ", " /*[Numero]*/
                            + (f.getFacturasfecha() == null ? "NULL" : getFechaParaSQL(f.getFacturasfecha())) + ", " /*[Fecha]*/
                            + f.getClientesid() + ", " /*[ID Clientes]*/
                            + (f.getFacturastipoprecio().compareToIgnoreCase("C") == 0 ? "'C'" : "'O'") + ", " /*[Forma Pago]*/
                            + (detalles.isEmpty() ? 0 : detalles.get(0).getPreciosid()) + ", "
                            + "NULL, " /*[ID Depositos]*/
                            + "NULL , "/*[ID Moneda Extranjera]*/
                            + "NULL ,  "/*[Cotizacion Comprobante]*/
                            + "0 , "/*[Importe Impuesto ML]*/
                            + "0 , "/*[Importe Impuesto ME]*/
                            + f.getFacturassubtotal() + ", " /*[Importe Gravada ML]*/
                            + "0 , "/*[Importe Gravada ME]*/
                            + "0 , "/*[Importe Exenta ML]*/
                            + "0 , "/*[Importe Exenta ME]*/
                            + f.getFacturastotal() + ", "/*[Importe Total ML]*/
                            + "0 , "/*[Importe Total ME]*/
                            + "CONVERT(DATETIME,CONVERT(VARCHAR(10),GETDATE(),103)), " /*[Fecha Descarga]*/
                            + (f.getFacturasestadoanulacion().compareToIgnoreCase("N") == 0 ? "'00'" : "'11'") + ", "/*[Status]*/
                            + "NULL , "/*[Autorizacion]*/
                            + "NULL , "/*[Fecha Cierre]*/
                            + "NULL , "/*[Importe Descuento ML]*/
                            + "NULL , "/*[Importe Descuento ME]*/
                            + "0" /*[IVA Exenta]*/
                            + ")";
                } else {

                    consulta = "INSERT INTO [VTA_C Comprobantes de Ventas] ("
                            + "[Origen],"
                            + "[ID Sucursales],"
                            + "[ID Vendedores],"
                            + "[ID Comprobantes Ventas],"
                            + "[Numero],"
                            + "[Fecha],"
                            + "[ID Clientes],"
                            + "[Forma Pago],"
                            + "[ID Listas Precios],"
                            + "[ID Depositos],"
                            + "[ID Moneda Extranjera],"
                            + "[Cotizacion Comprobante],"
                            + "[Importe Impuesto ML],"
                            + "[Importe Impuesto ME],"
                            + "[Importe Gravada ML],"
                            + "[Importe Gravada ME],"
                            + "[Importe Exenta ML],"
                            + "[Importe Exenta ME],"
                            + "[Importe Total ML],"
                            + "[Importe Total ME],"
                            + "[Fecha Descarga],"
                            + "[Status],"
                            + "[Autorizacion],"
                            + "[Fecha Cierre],"
                            + "[Importe Descuento ML],"
                            + "[Importe Descuento ME],"
                            + "[IVA Exenta],"
                            + "gpslat,"
                            + "gpslong)"
                            + "Values ("
                            + "2, " /*[Origen]*/
                            + v.getSucursalesid() + ", " /*[ID Sucursales]*/
                            + v.getVendedorid() + ", " /*[ID Vendedores]*/
                            + f.getFacturascmpid() + ", " /*[ID Comprobantes Ventas]*/
                            + f.getFacturasnumero() + ", " /*[Numero]*/
                            + (f.getFacturasfecha() == null ? "NULL" : getFechaParaSQL(f.getFacturasfecha())) + ", " /*[Fecha]*/
                            + f.getClientesid() + ", " /*[ID Clientes]*/
                            + (f.getFacturastipoprecio().compareToIgnoreCase("C") == 0 ? "'C'" : "'O'") + ", " /*[Forma Pago]*/
                            + (detalles.isEmpty() ? 0 : detalles.get(0).getPreciosid()) + ", "
                            + "NULL, " /*[ID Depositos]*/
                            + "NULL , "/*[ID Moneda Extranjera]*/
                            + "NULL ,  "/*[Cotizacion Comprobante]*/
                            + "0 , "/*[Importe Impuesto ML]*/
                            + "0 , "/*[Importe Impuesto ME]*/
                            + f.getFacturassubtotal() + ", " /*[Importe Gravada ML]*/
                            + "0 , "/*[Importe Gravada ME]*/
                            + "0 , "/*[Importe Exenta ML]*/
                            + "0 , "/*[Importe Exenta ME]*/
                            + f.getFacturastotal() + ", "/*[Importe Total ML]*/
                            + "0 , "/*[Importe Total ME]*/
                            + "CONVERT(DATETIME,CONVERT(VARCHAR(10),GETDATE(),103)), " /*[Fecha Descarga]*/
                            + (f.getFacturasestadoanulacion().compareToIgnoreCase("N") == 0 ? "'00'" : "'11'") + ", "/*[Status]*/
                            + "NULL , "/*[Autorizacion]*/
                            + "NULL , "/*[Fecha Cierre]*/
                            + "NULL , "/*[Importe Descuento ML]*/
                            + "NULL , "/*[Importe Descuento ME]*/
                            + "0," /*[IVA Exenta]*/
                            + "'" + f.getFacturasgpslat() + "'," /*gpsLat*/
                            + "'" + f.getFacturasgpslong() + "'" /*gpsLong*/
                            + ")";
                }

                System.out.println("INSERT :" + consulta);
                //Inserta la cabecera.

                em.createNativeQuery(consulta).executeUpdate();

                for (FacturasDetalle fd : detalles) {

                    int promoPLM3 = fd.getPromoplm3() < 0 ? 0 : fd.getPromoplm3();
                    String insertDetalle = "INSERT INTO [VTA_D Comprobantes de Ventas] VALUES "
                            + "("
                            + " 2,"/*[Origen]*/
                            + v.getSucursalesid() + "," /*[ID Sucursales]*/
                            + v.getVendedorid() + "," /*[ID Vendedores]*/
                            + f.getFacturascmpid() + "," /*[ID Comprobantes Ventas]*/
                            + f.getFacturasnumero() + ", " /*[Numero]*/
                            + "/*@FacturasLinea,*/"/*[ID Linea] Es autonumerico no hace falta insertar en esta implementacion*/
                            + fd.getProductosid() + ","/*[ID Productos]*/
                            + v.getVendedordepositoid() + ", "/*[ID Depositos]*/
                            + fd.getProductosum() + ", "/*[ID Unidades Medidas]*/
                            + fd.getFacturascantidad() + "," /*[Cantidad Envase]*/
                            + " NULL, " /*[ID Impuestos]*/
                            + fd.getFacturasprecios() + ", " /*[Precio Venta ML]*/
                            + "0, "/*[Precio Venta ME]*/
                            + fd.getFacturaspreciosoriginal() + ", " /*[Precio Venta Original ML]*/
                            + "0, " /*[Total Linea ME]*/
                            + fd.getFacturaslineatotal() + ", " /*[Total Linea ML]*/
                            + "NULL, " /*[Importe Impuesto ML]*/
                            + "0, " /*[Importe Impuesto ME]*/
                            + (f.getFacturasestadoanulacion().compareToIgnoreCase("N") == 0 ? "'00'" : "'11'") + ", "/*[Status]*/
                            + "NULL," /*[Autorizacion]*/
                            + "NULL, " /*[Importe Descuento ML]*/
                            + "NULL, " /*[Importe Descuento ME]*/
                            + "0, " /*[Descuento Porcentaje]*/
                            + fd.getFacturaslineadescuento() + ", " /*[Descuento Importe]*/
                            + (fd.getFacturaspromocion().compareTo('N') == 0 ? 0 : 1) + ", "/*[Promocion]*/
                            + promoPLM3 + ", " /*[PromoPlm3]*/
                            + fd.getPromoid()
                            + ")";

                    System.out.println("INSERT DETALLE:" + insertDetalle);

                    em.createNativeQuery(insertDetalle).executeUpdate();
                }

                for (FacturasCobros fc : f.getFacturascobrosList()) {
                    int medioPagoTipo = getMedioPagoTipo(fc.getMediospagosid().intValue());

                    Integer mediosPagosId = 0;
                    Integer bancosid = 0;
                    Integer valornumero = 0;
                    Date valorVencimiento = null;
                    Date valorFecha = null;

                    switch (medioPagoTipo) {
                        case 1://Efectivo
                        case 7://Nota Credito
                        case 8://Otros
                        case 9://Otros
                            mediosPagosId = fc.getMediospagosid().intValue();
                            bancosid = null;
                            valornumero = null;
                            valorVencimiento = null;
                            valorFecha = null;
                            break;
                        case 2://Cheque diferido
                        case 5://Cheque dia
                            mediosPagosId = fc.getMediospagosid().intValue();
                            bancosid = fc.getBancoid().intValue();
                            valornumero = fc.getFacturasvalornumero();
                            valorVencimiento = fc.getFacturasvalorvencimiento();
                            valorFecha = fc.getFacturasvalorfecha();
                            break;
                        case 3://Pagare a la orden
                        case 6:// Pagare vendedor
                            mediosPagosId = fc.getMediospagosid().intValue();
                            bancosid = null;
                            valornumero = fc.getFacturasvalornumero();
                            valorVencimiento = fc.getFacturasvalorvencimiento();
                            valorFecha = fc.getFacturasvalorfecha();
                            break;
                    }

                    em.createNativeQuery("INSERT INTO [VTA_Formas de Cancelacion] "
                            + " ( [Origen],[ID Sucursales],[ID Comprobantes],[Numero],[ID Linea],[ID Medios Pagos],[ID Bancos],[Numero Valor],[Fecha Vencimiento],"
                            + "  [Propietario],[Estado],[Importe Pago ML],[Importe Pago ME],[ID Vendedores],[Observacion],[Status],[Autorizacion],[Fecha Deposito],"
                            + "   [Depositado],[Deposito Confirmado],[ID Clientes],[RetClienteTimbrado],[RetNumero] "
                            + " ) "
                            + " VALUES "
                            + "("
                            + "2, "/*[Origen]*/
                            + v.getSucursalesid() + ", "/*[ID Sucursales]*/
                            + f.getFacturascmpid() + ", "/*[ID Comprobantes]*/
                            + f.getFacturasnumero() + ", "/*[Numero]*/
                            + fc.getFacturasvalorlinea() + ", "/*[ID Linea]*/
                            + mediosPagosId + ", "/*[ID Medios Pagos]*/
                            + (bancosid == null ? "NULL" : bancosid) + ", " /*[ID Bancos]*/
                            + (valornumero == null ? "NULL" : valornumero) + ", " /*[Numero Valor]*/
                            + (valorVencimiento == null ? "NULL" : getFechaParaSQL(valorVencimiento)) + ", " /*[Fecha Vencimiento]*/
                            + "0, " /*[Propietario]*/
                            + "0, " /*[Estado]*/
                            + (fc.getFacturasvalorimporte() == null ? 0 : fc.getFacturasvalorimporte().doubleValue()) + ", " /*[Importe Pago ML]*/
                            + "0, " /*[Importe Pago ME]*/
                            + v.getVendedorid() + ", " /*[ID Vendedores]*/
                            + "'" + fc.getFacturasvalorobservacion() + "', " /*[Observacion]*/
                            + (f.getFacturasestadoanulacion().compareToIgnoreCase("N") == 0 ? "'00'" : "'11'") + ", " /*[Status]*/
                            + "NULL,  " /*[Autorizacion]*/
                            + "NULL, " /*[Fecha Deposito]*/
                            + "NULL, " /*[Depositado]*/
                            + "NULL, " /*[Deposito Confirmado]*/
                            + (fc.getClientesid() == 0 ? "NULL" : fc.getClientesid()) + ","
                            + (fc.getRetclientetimbrado() == 0 ? "NULL" : fc.getRetclientetimbrado()) + ","
                            + (fc.getRetnumero() == 0 ? "NULL" : fc.getRetnumero())
                            + ")") /*[ID Clientes]*/.executeUpdate();

                }

                for (FacturasAplicacionPago a : f.getFacturasAplicacionPagosList()) {
                    String consultaInsertApps = "INSERT INTO [VTA_AplicacionPagos] "
                            + " ([Id Sucursales],[Origen],[Id Comprobantes],[Id Vendedores],[Numero],[Id Linea],[Origen CVTA],[Id Comprobantes Ventas],[Numero CVTA],[Importe Aplicacion]) "
                            + " VALUES "
                            + " ( "
                            + a.getSucursalesid() + ","
                            + "2,"
                            + a.getFacturascobroscmpid() + ","
                            + v.getVendedorid() + ","
                            + a.getFacturascobrosnumero() + ","
                            + a.getFacturascobrosvalorlinea() + ","
                            + "2,"
                            + a.getFacturascmpid() + ","
                            + a.getFacturasnumero() + ","
                            + a.getMonto()
                            + " );";

                    em.createNativeQuery(consultaInsertApps).executeUpdate();
                }

                if (f.getFacturastipocomprobante().compareToIgnoreCase("R") == 0) {
                    em.createNativeQuery("INSERT INTO [VTA_Facturas Creditos] Values "
                            + "("
                            + "2, "
                            + v.getSucursalesid() + ", "
                            + f.getFacturascmpid() + ", "
                            + f.getFacturasnumero() + ", "
                            + "1, "
                            + f.getClientesid() + ", "
                            + getFechaParaSQL(f.getFacturasfecha()) + ", "
                            + f.getFacturastotal() + ", "
                            + "0, "
                            + getFechaParaSQL(f.getFacturasvencimiento()) + ", "
                            + "0, "
                            + "0, "
                            + v.getVendedorid() + ", "
                            + (f.getFacturasestadoanulacion().compareToIgnoreCase("N") == 0 ? "'00'" : "'11'") + ", "
                            + "NULL "
                            + ")").executeUpdate();
                }

                ultimoNroDeFactura = f.getFacturasnumero();
            }

            em.createNativeQuery("UPDATE [Vta_Comprobantes Numeros] "
                    + " SET [Ultimo Numero] = " + ultimoNroDeFactura
                    + " WHERE [Id Comprobantes Numero] = 1 "
                    + " AND [Id Sucursales] = " + v.getSucursalesid()
                    + " AND [Punto Expedicion] = " + v.getVendedorpuntoexpedicionnro()).executeUpdate();

            R.setCodRetorno(listaFacturas.size());
            R.setMensaje("Facturas se cerro correctamente");

            em.getTransaction().commit();

        } catch (SinDetallesFacturasException e) {
            System.err.println(e.getMessage());
            R.setMensaje(e.getMessage());
            R.setCodRetorno(-1);
            try {
                em.getTransaction().rollback();
            } catch (Exception ex) {
                System.err.println("No se pudo hacer rollback");
            }

            throw new RuntimeException(e);//NoInsertoFacturasException(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            R.setCodRetorno(-1);
            try {
                em.getTransaction().rollback();
            } catch (Exception ex) {
                System.err.println("No se pudo hacer rollback");
            }
            throw new RuntimeException(e);
        } finally {
            em.close();
        }

        return R;
    }

    public GuardarRelevamientosResponse efectuarCierreRelevamientos(List<Relevamientos> listaRelevamientos, Vendedor v)
            throws NoInsertoRelevamientosException {
        EntityManager em = getEM();
        GuardarRelevamientosResponse R = new GuardarRelevamientosResponse();
        try {
            em.getTransaction().begin();

            for (Relevamientos r : listaRelevamientos) {
                em.createNativeQuery(" INSERT INTO [dbo].[relevamientos] "
                        + "            ([empresasid]                                               "
                        + "            ,[sucursalesid]                                             "
                        + "            ,[clientesid]                                               "
                        + "            ,[relevamientosfecha]                                       "
                        + "            ,[motivosnoventasid]                                        "
                        + "            ,[relevamientosestadodescarga]                              "
                        + "            ,[vendedoresid])                                            "
                        + "      VALUES                                                            "
                        + "            (" + r.getEmpresasid() + "                                  "
                        + "            ," + r.getSucursalesid() + "                                "
                        + "            ," + r.getClientesid() + "                                  "
                        + "            ," + getFechaParaSQL(r.getRelevamientosfecha()) + "          "
                        + "            ," + r.getMotivosnoventasid() + "                           "
                        + "            ,1                                                          "//relevamientosestadodescarga
                        + "            ," + r.getVendedoresid() + ")").executeUpdate();
            }

            R.setCodRetorno(listaRelevamientos.size());
            R.setMensaje("Relevamientos se cerro correctamente");
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            R.setCodRetorno(-1);
            try {
                em.getTransaction().rollback();
            } catch (Exception ex) {
                System.err.println("No se pudo hacer rollback");
            }

            throw new NoInsertoRelevamientosException(e.getMessage());
        } finally {
            em.close();
        }

        return R;
    }

    public CierreRetencionesResponse efectuarCierreRetenciones(List<Retenciones> listaRetenciones, Vendedor v)
            throws NoInsertoRetencionesException {
        EntityManager em = getEM();
        CierreRetencionesResponse R = new CierreRetencionesResponse();
        try {
            em.getTransaction().begin();

            for (Retenciones r : listaRetenciones) {
                String consultaInsert = "INSERT INTO [VTA_Retenciones] "
                        + " ([Id Sucursales],[Id Clientes],[RetClienteTimbrado],[RetNumero],[RetRazonSocialRetenido],[RetRucRetenido],[RetFechaRetencion],[RetValorSinIVA],[RetPorcentajeIVA],"
                        + " [RetPorcentajeRenta],[RetImporteIVA],[RetImporteRenta],[RetImporteRetIVA],[RetImporteSaldo]) "
                        + " VALUES "
                        + " ( "
                        + r.getSucursalesid() + ","
                        + r.getClientesid() + ","
                        + r.getRetclientetimbrado() + ","
                        + r.getRetnumero() + ","
                        + "'" + r.getRetrazonsocialretenido() + "',"
                        + "'" + r.getRetrucretenido() + "',"
                        + (r.getRetfecharetencion() == null ? "NULL" : getFechaParaSQL(r.getRetfecharetencion())) + ","
                        + r.getRetvalorsiniva() + ","
                        + r.getRetporcentajeiva() + ","
                        + r.getRetporcentajerenta() + ","
                        + r.getRetimporteiva() + ","
                        + r.getRetimporterenta() + ","
                        + r.getRetimporteret() + ","
                        + r.getRetimportesaldo()
                        + " );";

                System.out.println("Insert Retencion : " + consultaInsert);

                em.createNativeQuery(consultaInsert).executeUpdate();
            }

            R.setCodRetorno(listaRetenciones.size());
            R.setMensaje("Retenciones se cerro correctamente");
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            R.setCodRetorno(-1);
            try {
                em.getTransaction().rollback();
            } catch (Exception ex) {
                System.err.println("No se pudo hacer rollback");
            }

            throw new NoInsertoRetencionesException(e.getMessage());
        } finally {
            em.close();
        }

        return R;
    }

    public CierreCobranzaResponse efectuarCierreCobranzas(List<Cobranzas> listaConbranzas, Vendedor v)
            throws NoInsertoCobranzasException {
        EntityManager em = getEM();
        CierreCobranzaResponse R = new CierreCobranzaResponse();
        try {
            em.getTransaction().begin();

            for (Cobranzas c : listaConbranzas) {
                if (c.getCobranzasestadoanulacion() != 'S') {
                    if (c.getCobranzasdetalleList() == null || (c.getCobranzasdetalleList() != null && c.getCobranzasdetalleList().isEmpty())) {
                        throw new SinDetallesFacturasException(null);
                    }
                }
            }

            int cmpid = getComprobanteCobranzaId(em);

            boolean hayColumnasAdicionales = false;

            try {

                String consulta2 = "SELECT COLUMN_NAME "
                        + " FROM INFORMATION_SCHEMA.COLUMNS"
                        + " WHERE TABLE_NAME = 'COB_C Comprobantes de Cobranzas' AND TABLE_SCHEMA='dbo'"
                        + " and COLUMN_NAME = 'gpslat'";

                String columnaLat = (String) em.createNativeQuery(consulta2).getSingleResult();

                hayColumnasAdicionales = true;
            } catch (Exception e) {
            }

            for (Cobranzas c : listaConbranzas) {
                Integer numeroCobranza;

                if (cmpid == 0) {
                    throw new NoHayCmpCobranzaException();
                }

                System.out.println("Cobranza 1");

                numeroCobranza = (Integer) em.createNativeQuery("SELECT  cast((MAX(Numero)  + 1) as int)  "
                        + " FROM [COB_C Comprobantes de Cobranzas] WITH (TABLOCKX) "
                        + " WHERE [ID Sucursales] =" + v.getSucursalesid()
                        + " AND [ID Comprobantes Cobranzas] =" + cmpid
                        + " AND Origen = 1").getSingleResult();

                System.out.println("Cobranza 2: " + numeroCobranza);

                //Inserto cabecera de cobranzas
                String consulta;

                if (!hayColumnasAdicionales) {
                    consulta = "INSERT INTO [COB_C Comprobantes de Cobranzas] "
                            + "("
                            + "[ID Sucursales],"
                            + "[ID Comprobantes Cobranzas],"
                            + "[Numero],"
                            + "[Fecha],"
                            + "[ID Clientes],"
                            + "[ID Cobradores],"
                            + "[Importe Recibo ML],"
                            + "[Importe Facturas Canceladas ML],"
                            + "[Importe Recibo ME],"
                            + "[Importe Facturas Canceladas ME],"
                            + "[Diferencia Pago ME],"
                            + "[Diferencia Pago ML],"
                            + "[ID Moneda Extranjera],"
                            + "[Cotizacion],"
                            + "[Origen],"
                            + "[Fecha Descarga],"
                            + "[Status],"
                            + "[Autorizacion],"
                            + "[Fecha Cierre]"
                            + ")"
                            + "VALUES "
                            + "("
                            + v.getSucursalesid() + "," /*[ID Sucursales]*/
                            + cmpid + "," /*[ID Comprobantes Cobranzas]*/
                            + numeroCobranza + ", " /*[Numero]*/
                            + getFechaParaSQL(c.getCobranzasfecha()) + "," /*[Fecha]*/
                            + c.getClientesid() + ", " /*[ID Clientes]*/
                            + "NULL, " /*[ID Cobradores]*/
                            + c.getCobranzastotal().doubleValue() + ", " /*[Importe Recibo ML]*/
                            + getImporteFacturasCanceladas(c) + ", " /*[Importe Facturas Canceladas ML]*/
                            + "0, " /*[Importe Recibo ME]*/
                            + "0, " /*[Importe Facturas Canceladas ME]*/
                            + "NULL, " /*[Diferencia Pago ME]*/
                            + "NULL, " /*[Diferencia Pago ML]*/
                            + "NULL, " /*[ID Moneda Extranjera]*/
                            + "NULL, " /*[Cotizacion]*/
                            + "1, " /*[Origen]*/
                            + "CONVERT(DATETIME,CONVERT(VARCHAR(10),GETDATE(),103)),"/*[Fecha Descarga]*/
                            + "'00', " /*[Status]*/
                            + "NULL," /*[Autorizacion]*/
                            + "NULL" /*[Fecha Cierre]*/
                            + ")";
                } else {
                    consulta = "INSERT INTO [COB_C Comprobantes de Cobranzas] "
                            + "("
                            + "[ID Sucursales],"
                            + "[ID Comprobantes Cobranzas],"
                            + "[Numero],"
                            + "[Fecha],"
                            + "[ID Clientes],"
                            + "[ID Cobradores],"
                            + "[Importe Recibo ML],"
                            + "[Importe Facturas Canceladas ML],"
                            + "[Importe Recibo ME],"
                            + "[Importe Facturas Canceladas ME],"
                            + "[Diferencia Pago ME],"
                            + "[Diferencia Pago ML],"
                            + "[ID Moneda Extranjera],"
                            + "[Cotizacion],"
                            + "[Origen],"
                            + "[Fecha Descarga],"
                            + "[Status],"
                            + "[Autorizacion],"
                            + "[Fecha Cierre],"
                            + "gpslat,"
                            + "gpslong"
                            + ")"
                            + "VALUES "
                            + "("
                            + v.getSucursalesid() + "," /*[ID Sucursales]*/
                            + cmpid + "," /*[ID Comprobantes Cobranzas]*/
                            + numeroCobranza + ", " /*[Numero]*/
                            + getFechaParaSQL(c.getCobranzasfecha()) + "," /*[Fecha]*/
                            + c.getClientesid() + ", " /*[ID Clientes]*/
                            + "NULL, " /*[ID Cobradores]*/
                            + c.getCobranzastotal().doubleValue() + ", " /*[Importe Recibo ML]*/
                            + getImporteFacturasCanceladas(c) + ", " /*[Importe Facturas Canceladas ML]*/
                            + "0, " /*[Importe Recibo ME]*/
                            + "0, " /*[Importe Facturas Canceladas ME]*/
                            + "NULL, " /*[Diferencia Pago ME]*/
                            + "NULL, " /*[Diferencia Pago ML]*/
                            + "NULL, " /*[ID Moneda Extranjera]*/
                            + "NULL, " /*[Cotizacion]*/
                            + "1, " /*[Origen]*/
                            + "CONVERT(DATETIME,CONVERT(VARCHAR(10),GETDATE(),103)),"/*[Fecha Descarga]*/
                            + "'00', " /*[Status]*/
                            + "NULL," /*[Autorizacion]*/
                            + "NULL," /*[Fecha Cierre]*/
                            + "'" + c.getCobranzasgpslat() + "',"
                            + "'" + c.getCobranzasgpslong() + "'"
                            + ")";
                }

                String cadenaCab = consulta;
                System.out.println("Insert Conbranza: " + cadenaCab);
                em.createNativeQuery(cadenaCab).executeUpdate();

                int linea = 0;
                for (CobranzasDetalle d : c.getCobranzasdetalleList()) {
                    System.out.println("Cobranza Detalle: ");
                    System.out.println("Cobranza Detalle  Factura: " + d.getFacturas());
                    String cadenaDetalle = "INSERT INTO [COB_D Comprobantes de Cobranzas] VALUES "
                            + "("
                            + "1," /*[Origen]*/
                            + v.getSucursalesid() + "," /*[ID Sucursales]*/
                            + cmpid + "," /*[ID Comprobantes Cobranzas]*/
                            + numeroCobranza + "," /*[Numero]*/
                            + (++linea) + ","
                            + "2," /*[Origen Comprobantes]*/
                            + d.getFacturascmpid() + "," /*[ID Comprobantes Ventas]*/
                            + d.getFacturasnumero() + "," /*[Numero CVta]*/
                            + (d.getFacturas().getFacturastipocomprobante().compareToIgnoreCase("O") == 0
                                    ? d.getFacturasnumero() : 1) + "," /*[Cuota CVta]*/
                            + getFechaParaSQL(d.getFacturas().getFacturasfecha()) + "," /*[Fecha CVta]*/
                            + getFechaParaSQL(d.getFacturas().getFacturasvencimiento()) + "," /*[Vencimiento CVta]*/
                            + "0," /*[Importe Original CVta ML]*/
                            + d.getCobranzaspago() + "," /*[Importe Pago CVta ML]*/
                            + getImporteFacturasCanceladas(d) + "," /*[Importe Saldo Cvta ML]*/
                            + "0," /*[Importe Original Cvta ME]*/
                            + "NULL," /*[Importe Pago Cvta ME]*/
                            + "0," /*[Importe Pagol Cvta ME]*/
                            + d.getVendedorid() + "," /*[ID Vendedores]*/
                            + "NULL" /*[Autorizacion]*/
                            + ")";

                    System.out.println("Insert Conbranza Detalle: " + cadenaDetalle);

                    em.createNativeQuery(cadenaDetalle).executeUpdate();
                    System.out.println("Cobranza Inserto: ");
                }

                linea = 0;
                for (CobranzasCobros cc : c.getCobranzascobrosList()) {
                    int medioPagoTipo = getMedioPagoTipo(cc.getMediospagosid().intValue());

                    Integer mediosPagosId = 0;
                    Integer bancosid = 0;
                    Integer valornumero = 0;
                    Date valorVencimiento = null;
                    Date valorFecha = null;

                    switch (medioPagoTipo) {
                        case 1://Efectivo
                        case 7://Nota Credito
                        case 8://Otros
                        case 9://Retencion
                            mediosPagosId = cc.getMediospagosid().intValue();
                            bancosid = null;
                            valornumero = null;
                            valorVencimiento = null;
                            valorFecha = null;
                            break;
                        case 2://Cheque diferido
                        case 5://Cheque dia
                            mediosPagosId = cc.getMediospagosid().intValue();
                            bancosid = cc.getBancoid().intValue();
                            valornumero = cc.getCobranzasvalornumero();
                            valorVencimiento = cc.getCobranzasvalorvencimiento();
                            valorFecha = cc.getCobranzasfechavalor();
                            break;
                        case 3://Pagare a la orden
                        case 6:// Pagare vendedor
                            mediosPagosId = cc.getMediospagosid().intValue();
                            bancosid = null;
                            valornumero = cc.getCobranzasvalornumero();
                            valorVencimiento = cc.getCobranzasvalorvencimiento();
                            valorFecha = cc.getCobranzasfechavalor();
                            break;
                    }

                    em.createNativeQuery("INSERT INTO [VTA_Formas de Cancelacion] "
                            + " ( [Origen],[ID Sucursales],[ID Comprobantes],[Numero],[ID Linea],[ID Medios Pagos],[ID Bancos],[Numero Valor],[Fecha Vencimiento],"
                            + "  [Propietario],[Estado],[Importe Pago ML],[Importe Pago ME],[ID Vendedores],[Observacion],[Status],[Autorizacion],[Fecha Deposito],"
                            + "   [Depositado],[Deposito Confirmado],[ID Clientes],[RetClienteTimbrado],[RetNumero] "
                            + " ) "
                            + " VALUES "
                            + "("
                            + "1," /*[Origen]*/
                            + v.getSucursalesid() + "," /*[ID Sucursales]*/
                            + cmpid + "," /*[ID Comprobantes]*/
                            + numeroCobranza + "," /*[Numero]*/
                            + cc.getCobranzaslinea() + "," /*[ID Linea]*/
                            + mediosPagosId + "," /*[ID Medios Pagos]*/
                            + (bancosid == null ? "NULL" : bancosid) + ", " /*[ID Bancos]*/
                            + (valornumero == null ? "NULL" : valornumero) + ", " /*[Numero Valor]*/
                            + (valorVencimiento == null ? "NULL" : getFechaParaSQL(valorVencimiento)) + ", " /*[Fecha Vencimiento]*/
                            + "0, " /*[Propietario]*/
                            + "0, " /*[Estado]*/
                            + cc.getCobranzasvalorimporte().doubleValue() + ", " /*[Importe Pago ML]*/
                            + "0, " /*[Importe Pago ME]*/
                            + v.getVendedorid() + ", " /*[ID Vendedores]*/
                            + "'" + cc.getCobranzasvalorobservacion() + "', " /*[Observacion]*/
                            + "'00', " /*[Status]*/
                            + "NULL, " /*[Autorizacion]*/
                            + "NULL, " /*[Fecha Deposito]*/
                            + "NULL, " /*[Depositado]*/
                            + "NULL, "/*[Deposito Confirmado]*/
                            + cc.getClientesid() + ", "
                            + cc.getRetclientetimbrado() + ", "
                            + cc.getRetnumero()
                            + " )").executeUpdate();
                }

                //Hibernate.initialize(c.getCobranzasAplicacionPagosList());
                for (CobranzasAplicacionPago cap : c.getCobranzasAplicacionPagosList()) {
                    String consultaInsertApps = "INSERT INTO [VTA_AplicacionPagos] "
                            + " ([Id Sucursales],[Origen],[Id Comprobantes],[Id Vendedores],[Numero],[Id Linea],[Origen CVTA],[Id Comprobantes Ventas],[Numero CVTA],[Importe Aplicacion]) "
                            + " VALUES "
                            + " ( "
                            + cap.getSucursalesid() + ","
                            + "1,"
                            + cmpid + ","
                            + v.getVendedorid() + ","
                            + numeroCobranza + ","
                            + cap.getCobranzascobroslinea() + ","
                            + "2,"
                            + cap.getFacturascmpid() + ","
                            + cap.getFacturasnumero() + ","
                            + cap.getMonto()
                            + " );";

                    em.createNativeQuery(consultaInsertApps).executeUpdate();
                }
            }

            R.setCodRetorno(listaConbranzas.size());
            R.setMensaje("Cobranzas se cerro correctamente");
            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            R.setCodRetorno(-1);
            try {
                em.getTransaction().rollback();
            } catch (Exception ex) {
                System.err.println("No se pudo hacer rollback");
            }

            throw new RuntimeException(e);
        }

        return R;
    }

    private String getFechaParaSQL(Date fecha) {
        Timestamp t = new Timestamp(fecha.getTime());
        return "'" + t.toString().replace("-", "") + "'";
    }

    public int getComprobanteCobranzaId(EntityManager em) {

        Integer R = 0;
        try {
            R = (Integer) em.createNativeQuery("SELECT TOP 1 cast([compIdActual] as int) \n"
                    + "  FROM [comprobanteCobranzaActual]").getSingleResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return R;
    }

    private double getImporteFacturasCanceladas(Cobranzas c) {
        double R;
        BigDecimal totalFacturas = new BigDecimal(0);
        BigDecimal totalPagos = new BigDecimal(0);

        for (CobranzasDetalle d : c.getCobranzasdetalleList()) {

            Facturas f = d.getFacturas();
            System.out.println("Comprueba total : " + f);
            totalFacturas = totalFacturas.add(f.getFacturastotal());
            totalPagos = totalPagos.add(f.getFacturaspagos());
        }

        R = (totalFacturas.subtract(totalPagos).add(c.getCobranzastotal())).doubleValue();

        return R;
    }

    private double getImporteFacturasCanceladas(CobranzasDetalle d) {
        Facturas f = d.getFacturas();
        return (f.getFacturastotal().subtract(f.getFacturaspagos()).add(d.getCobranzaspago())).doubleValue();
    }

    private int getMedioPagoTipo(Integer mediospagosid) {
        EntityManager em = getEM();
        Integer R = 0;
        try {
            R = (Integer) em.createNativeQuery("SELECT [Tipo Medio Pago]\n"
                    + "  FROM [VTA_Medios de Pagos]\n"
                    + "  where [ID Medios Pagos] = " + mediospagosid).getSingleResult();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return R;
    }
}
