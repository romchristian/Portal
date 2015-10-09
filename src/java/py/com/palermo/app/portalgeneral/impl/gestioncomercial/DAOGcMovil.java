/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Cliente;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Cobranzas;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.CobranzasAplicacionPago;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.CobranzasCobros;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.CobranzasDetalle;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Encuesta;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Facturas;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.FacturasAplicacionPago;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.FacturasCobros;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.FacturasDetalle;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Mensajes;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Opcion;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Pregunta;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Relevamientos;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Respuesta;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Retenciones;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.TimeIgnoringComparator;
import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Vendedor;
import py.com.palermo.app.portalgeneral.interfaz.AccesoDenegadoException;

/**
 *
 * @author cromero
 */
@Stateless
public class DAOGcMovil {

    @PersistenceContext(unitName = "GCMovilPU")
    private EntityManager em;

    public Vendedor getVendedor(int pocketid) throws AccesoDenegadoException {
        Vendedor R = null;

        System.out.println("pocketid : " + pocketid);
        try {
            R = (Vendedor) em.createQuery("SELECT v from Vendedor v where v.vendedorpocketid = :pocketid").setParameter("pocketid", pocketid).getSingleResult();

            //em.merge(R);
        } catch (Exception e) {
            throw new AccesoDenegadoException();
        }

        return R;
    }

    public void setVendedorUltimoNroFactura(Integer vendedorUltimoNroFactura, Vendedor v) {
        v.setVendedorultimafacturanro(vendedorUltimoNroFactura);
        v.setVendedorfechacarga(new Date());
        v.setVendedordescargaestado(new Integer(0).shortValue());

        try {

            em.merge(v);

        } catch (Exception ex) {
            System.err.println(ex.getMessage() + " : " + ex.getCause());

        }
    }

    public Encuesta[] getEncuestas() {

        List<Encuesta> lista = em.createQuery("select e from Encuesta e where current_date() between e.encuestaInicio and e.encuestaFin and e.encuestaEstado = 'ACTIVO' ") //.setParameter(1, new Date(), TemporalType.DATE)
                //.setParameter(2, "ACTIVO").
                .getResultList();

        if (lista == null) {
            lista = new ArrayList<>();
        }

        Encuesta[] array = new Encuesta[lista.size()];
        Encuesta[] R = lista.toArray(array);

        return R;
    }

    public Pregunta[] getPreguntas() {

        List<Pregunta> lista = em.createQuery("select p from Pregunta p where :hoy between p.encuesta.encuestaInicio and p.encuesta.encuestaFin and p.encuesta.encuestaEstado = :estado").
                setParameter("hoy", new Date(), TemporalType.DATE).
                setParameter("estado", "ACTIVO").
                getResultList();

        if (lista == null) {
            lista = new ArrayList<>();
        }

        Pregunta[] array = new Pregunta[lista.size()];
        Pregunta[] R = lista.toArray(array);

        return R;
    }

    public Opcion[] getOpciones() {

        List<Opcion> lista = em.createQuery("select o from Opcion o where :hoy  between o.pregunta.encuesta.encuestaInicio and o.pregunta.encuesta.encuestaFin and o.pregunta.encuesta.encuestaEstado = :estado").
                setParameter("hoy", new Date(), TemporalType.DATE).
                setParameter("estado", "ACTIVO").
                getResultList();

        if (lista == null) {
            lista = new ArrayList<>();
        }

        Opcion[] array = new Opcion[lista.size()];
        Opcion[] R = lista.toArray(array);

        return R;
    }

    public void guardaFacturasPendientes(Vendedor v, Facturas[] facturas) {
        limpiaFacturaYCobranzas(v);

        if (facturas != null) {
            for (int i = 0; i < facturas.length; i++) {

                try {

                    em.merge(facturas[i]);

                } catch (Exception ex) {
                    System.err.println(ex.getMessage() + " : " + ex.getCause());

                }
            }
        }
    }

    public void verificaFacturasNoDescargadas(Vendedor v) {
//        List<Facturas> listFacturas = em.createQuery("SELECT f from Facturas f where f.empresasid = :emp AND f.sucursalesid = :suc AND f.facturaspuntoexpedicionnro = :pexp AND f.facturasestadodescarga != 'T'")
//                .setParameter("emp", v.getEmpresasid())
//                .setParameter("suc", v.getSucursalesid())
//                .setParameter("pexp", v.getVendedorpuntoexpedicionnro()).getResultList();
//
//        List<Cobranzas> listCobranzas = em.createQuery("SELECT c from Cobranzas c where c.empresasid = :emp AND c.sucursalesid = :suc AND c.cobranzascmpid = :pexp AND c.cobranzasestadodescarga != 'T'")
//                .setParameter("emp", v.getEmpresasid())
//                .setParameter("suc", v.getSucursalesid())
//                .setParameter("pexp", v.getVendedorpuntoexpedicionnro()).getResultList();
//
//        List<Relevamientos> listRelevamientos = em.createQuery("DELETE FROM Relevamientos r "
//                + " where r.vendedoresid = :vid "
//                + " and r.empresasid = :emp "
//                + " and r.sucursalesid = :suc"
//                + " and r.relevamientosestadodescarga = 1 ")
//                .setParameter("vid", v.getVendedorid())
//                .setParameter("emp", v.getEmpresasid())
//                .setParameter("suc", v.getSucursalesid()).getResultList();
//
//        if (!listCobranzas.isEmpty() || !listFacturas.isEmpty() || !listRelevamientos.isEmpty()) {
//            throw new NoSeDercargoException("");
//        }
    }

    private void limpiaFacturaYCobranzas(Vendedor v) {
        String prefCobranzasApp = "where c.empresasid = :emp AND c.sucursalesid = :suc AND c.cobranzascobroscmpid = :pexp";
        String prefFacturasApp = "where f.empresasid = :emp AND f.sucursalesid = :suc AND f.facturascobrospuntoexpedicionnro = :pexp";
        String prefFacturas = "where f.empresasid = :emp AND f.sucursalesid = :suc AND f.facturaspuntoexpedicionnro = :pexp";
        String prefCobranzas = "where c.empresasid = :emp AND c.sucursalesid = :suc AND c.cobranzascmpid = :pexp";

        ejecutaDeleteFacturasOCobranzas("DELETE FROM FacturasAplicacionPago f " + prefFacturasApp, v);
        ejecutaDeleteFacturasOCobranzas("DELETE FROM CobranzasAplicacionPago c " + prefCobranzasApp, v);

        ejecutaDeleteFacturasOCobranzas("DELETE FROM FacturasCobros f " + prefFacturas, v);
        ejecutaDeleteFacturasOCobranzas("DELETE FROM FacturasDetalle f " + prefFacturas, v);
        ejecutaDeleteFacturasOCobranzas("DELETE FROM CobranzasCobros c " + prefCobranzas, v);
        ejecutaDeleteFacturasOCobranzas("DELETE FROM CobranzasDetalle c " + prefCobranzas, v);
        ejecutaDeleteFacturasOCobranzas("DELETE FROM Cobranzas c " + prefCobranzas, v);
        ejecutaDeleteFacturasOCobranzas("DELETE FROM Facturas f " + prefFacturas, v);

        try {

            System.out.println("HOLA 4");
            em.createQuery("DELETE FROM Relevamientos r "
                    + " where r.vendedoresid = :vid "
                    + " and r.empresasid = :emp "
                    + " and r.sucursalesid = :suc").setParameter("vid", v.getVendedorid()).setParameter("emp", v.getEmpresasid()).setParameter("suc", v.getSucursalesid()).executeUpdate();

            System.out.println("HOLA 5");
            em.createQuery("DELETE FROM Retenciones r "
                    + " where r.vendedoresid = :vid "
                    + " and r.empresasid = :emp "
                    + " and r.sucursalesid = :suc").setParameter("vid", (new Short(v.getVendedorid()).intValue())).setParameter("emp", v.getEmpresasid()).setParameter("suc", v.getSucursalesid()).executeUpdate();
            System.out.println("HOLA 6");

        } catch (Exception ex) {
            System.err.println(ex.getMessage() + " : " + ex.getCause());

        }

    }

    private void ejecutaDeleteFacturasOCobranzas(String cadena, Vendedor v) {

        try {
            em.createQuery(cadena).setParameter("emp", v.getEmpresasid()).setParameter("suc", v.getSucursalesid()).setParameter("pexp", v.getVendedorpuntoexpedicionnro()).executeUpdate();

        } catch (Exception ex) {
            System.err.println(ex.getMessage() + " : " + ex.getCause());

        }
    }

    public int AnularFactura(int cmpId, int puntoExpedicionNro, int comprobanteNro, Vendedor vendedor) {

        try {
            Facturas f = (Facturas) em.createQuery(" SELECT f from Facturas f "
                    + " where f.facturascmpid = :cmpId "
                    + " and f.facturaspuntoexpedicionnro = :puntoexp "
                    + " and f.facturasnumero = :nro "
                    + " and f.empresasid = :empresaid "
                    + " and f.sucursalesid = :sucid ").setParameter("cmpId", cmpId).setParameter("puntoexp", puntoExpedicionNro).setParameter("empresaid", vendedor.getEmpresasid()).setParameter("sucid", vendedor.getSucursalesid()).getSingleResult();

            f.setFacturasestadoanulacion("S");
            em.merge(f);

        } catch (Exception ex) {
            System.err.println(ex.getMessage() + " : " + ex.getCause());
            return UtilCons.COD_ERROR;

        }
        return UtilCons.COD_EXITO;

    }

    public int SetRespuestas(List<Respuesta> lista) {
        int retVal = 1;

        try {

            for (Respuesta r : lista) {
                r.setRespuestaId(null);
                em.merge(r);
            }

        } catch (Exception ex) {
            return -1;
        }
        return retVal;
    }

    public int SetRespuestaEncuesta(Respuesta r) {
        int retVal = 1;

        try {

            em.merge(r);

        } catch (Exception ex) {

            return -1;
        }
        return retVal;
    }

    public int SetRespuestaEncuesta2(Respuesta r) {
        int retVal = 1;

        Long maxId = 0l;
        try {

            maxId = (Long) em.createQuery("select MAX(e.respuestaId) from Respuesta e").getSingleResult();

        } catch (Exception e) {
            maxId = 0l;
        }

        if (maxId == null) {
            maxId = 0l;
        }
        Long id = maxId + 1;

        r.setRespuestaId(id);

        String insert
                = " insert into respuestas ( "
                + " respuesta_id, "
                + " empresasid, "
                + " sucursalesid, "
                + " cliente_id, "
                + " encuesta_id, "
                + " pregunta_id, "
                + " opcion_id, "
                + " resp_fecha, "
                + " resp_valor_numerico, "
                + " resp_valor_texto)"
                + " values ("
                + r.getRespuestaId() + ", "
                + r.getEmpresasId() + ", "
                + r.getSucursalesId() + ", "
                + r.getClienteId() + ", "
                + r.getEncuestaId() + ", "
                + r.getPreguntaId() + ", "
                + r.getOpcionId() + ", "
                + "'" + r.getRespFecha() + "', "
                + r.getRespValorNumerico() + ", "
                + " NULL)";

        System.out.println("CADENA : " + insert);

        try {

            em.createNativeQuery(insert).executeUpdate();

        } catch (Exception ex) {
            return -1;
        }
        return retVal;
    }

    public int SetFactura(Facturas cabecera, FacturasDetalle[] detalle, FacturasCobros[] cobros, FacturasAplicacionPago[] aplicaciones, Vendedor vendedor) {
        int retVal = 1;

        try {

            //Inserto o actualizo cabecera y sus detalle
            cabecera.setFacturasestadodescarga("S");

            em.merge(cabecera);

            for (int i = 0; i < detalle.length; i++) {

                detalle[i].setFacturas(cabecera);
                em.merge(detalle[i]);
            }

            //Limpiar aplicaciones anteriores para evitar duplicación
            List<FacturasAplicacionPago> aplicacionesAnteriores = em.createQuery(" select fc from FacturasAplicacionPago fc "
                    + " where fc.empresasid = :empresaid "
                    + " and fc.sucursalesid = :sucursalid "
                    + " and fc.facturascmpid = :cmpid"
                    + " and fc.facturaspuntoexpedicionnro = :expnro "
                    + " and fc.facturasnumero = :numero ").setParameter("empresaid", cabecera.getEmpresasid()).setParameter("sucursalid", cabecera.getSucursalesid()).setParameter("cmpid", cabecera.getFacturascmpid()).setParameter("expnro", cabecera.getFacturaspuntoexpedicionnro()).setParameter("numero", cabecera.getFacturasnumero()).getResultList();

            if (aplicacionesAnteriores != null && !aplicacionesAnteriores.isEmpty()) {
                Iterator<FacturasAplicacionPago> it = aplicacionesAnteriores.iterator();

                while (it.hasNext()) {
                    FacturasAplicacionPago fc = it.next();
                    it.remove();
                    em.remove(fc);
                }
            }

            //Limpiar cobros anteriores para evitar duplicación
            List<FacturasCobros> cobrosAnteriores = em.createQuery(" select fc from FacturasCobros fc "
                    + " where fc.empresasid = :empresaid "
                    + " and fc.sucursalesid = :sucursalid "
                    + " and fc.facturascmpid = :cmpid"
                    + " and fc.facturaspuntoexpedicionnro = :expnro "
                    + " and fc.facturasnumero = :numero ").setParameter("empresaid", cabecera.getEmpresasid()).setParameter("sucursalid", cabecera.getSucursalesid()).setParameter("cmpid", cabecera.getFacturascmpid()).setParameter("expnro", cabecera.getFacturaspuntoexpedicionnro()).setParameter("numero", cabecera.getFacturasnumero()).getResultList();

            if (cobrosAnteriores != null && !cobrosAnteriores.isEmpty()) {
                Iterator<FacturasCobros> it = cobrosAnteriores.iterator();

                while (it.hasNext()) {
                    FacturasCobros fc = it.next();
                    it.remove();
                    em.remove(fc);
                }
            }

            // Fin de la limpieza
            for (int i = 0; i < cobros.length; i++) {

                cobros[i].setFacturas(cabecera);
                em.merge(cobros[i]);
            }

            for (int i = 0; i < aplicaciones.length; i++) {
                FacturasAplicacionPago fa = aplicaciones[i];
                fa.setFacturas(cabecera);
                if (fa.getFacturascobrospuntoexpedicionnro() == 0) {
                    System.out.println("----------ERROR DEL PUNTO DE EXPEDICION -----------");
                    System.out.println("Vendedor Id: " + vendedor.getVendedorid());
                    System.out.println("Vendedor Nombre: " + vendedor.getVendedornombre());
                    System.out.println("Factura : " + fa.getFacturascobrosnumero());
                    System.out.println("----------FIN DE ERROR DEL PUNTO DE EXPEDICION -----------");
                    fa.setFacturascobrospuntoexpedicionnro(vendedor.getVendedorpuntoexpedicionnro());
                }
                em.merge(aplicaciones[i]);
            }

            //Actualizo la ultima factura en el vendedor
            vendedor.setVendedorultimafacturanro(cabecera.getFacturasnumero());
            em.merge(vendedor);

        } catch (Exception ex) {
            System.err.println(ex.getMessage() + " : " + ex.getCause());
            throw new RuntimeException(ex);
            //return -1;
        }

        return retVal;
    }

    public int SetCobranza(Cobranzas cabecera, CobranzasDetalle[] detalle, CobranzasCobros[] cobros, CobranzasAplicacionPago[] aplicaciones, Vendedor vendedor) {
        int vendedorId = vendedor.getVendedorid();
        int retVal = 1;

        try {

            //Inserto o actualizo cabecera y sus detalle            
            cabecera.setVendedorid(vendedorId);

            em.merge(cabecera);
            if (detalle != null) {

                for (int i = 0; i < detalle.length; i++) {

                    CobranzasDetalle cd = detalle[i];
                    cd.setCobranzas(cabecera);
                    em.merge(cd);

                    //Actualizo el monto pagado en la factura
                    Facturas f = (Facturas) em.createQuery("SELECT d from Facturas d "
                            + " where d.empresasid = :emp "
                            + " and d.sucursalesid = :suc "
                            + " and d.facturascmpid = :cmpid "
                            + " and d.facturaspuntoexpedicionnro = :pexp "
                            + " and d.facturasnumero = :nro").setParameter("emp", cd.getEmpresasid()).setParameter("suc", cd.getSucursalesid()).setParameter("cmpid", cd.getFacturascmpid()).setParameter("pexp", cd.getFacturaspuntoexpedicionnro()).setParameter("nro", cd.getFacturasnumero()).getSingleResult();
                    f.setFacturaspagos(f.getFacturaspagos().add(cd.getCobranzaspago()));

                    em.merge(f);
                }

            } else {
                retVal = 0;
            }

            if (cobros != null) {

                for (int i = 0; i < cobros.length; i++) {

                    cobros[i].setCobranzas(cabecera);
                    em.merge(cobros[i]);
                }
            } else {
                retVal = 0;
            }

            for (int i = 0; i < aplicaciones.length; i++) {
                aplicaciones[i].setCobranzas(cabecera);
                em.merge(aplicaciones[i]);
            }

            //Actualizo la ultima factura en el vendedor
            vendedor.setVendedorultimocobronro(cabecera.getCobranzasnumero());
            em.merge(vendedor);

        } catch (Exception ex) {
            System.err.println(ex.getMessage() + " : " + ex.getCause());

            return -1;
        }

        return retVal;
    }

    public int SetRetencion(Retenciones nuevo, Vendedor vendedor) {
        int retVal = 1;

        try {

            nuevo.setRetestadodescarga('N');
            nuevo.setVendedoresid(vendedor.getVendedorid());
            em.merge(nuevo);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());

            retVal = -1;
        }
        return retVal;
    }

    public int SetRelevamiento(Relevamientos nuevo, Vendedor vendedor) {
        int retVal = 1;

        try {

            nuevo.setRelevamientosestadodescarga(new Integer(0).shortValue());
            em.merge(nuevo);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            retVal = -1;
        }

        return retVal;
    }

    public List<Cliente> getClientesEncuesta(long encuestaId) {

        List<Cliente> R = em.createNamedQuery("Cliente.findPorEncuesta").setParameter(1, encuestaId).getResultList();

        return R;
    }

    public List<Cobranzas> getCobranzasParaCierre(Vendedor vendedor) {

        List<Cobranzas> R = em.createQuery("SELECT c from Cobranzas c "
                + " where c.empresasid = :emp "
                + " and c.sucursalesid = :suc "
                + " and c.cobranzascmpid = :cmpid "
                + " and c.cobranzasestadodescarga != 'T'").setParameter("emp", vendedor.getEmpresasid()).setParameter("suc", vendedor.getSucursalesid()).setParameter("cmpid", vendedor.getVendedorpuntoexpedicionnro()).getResultList();

        return R;
    }

    public void confirmaDescargaEnVendedor(Vendedor vendedor) {
        vendedor.setVendedordescargaestado(new Integer(vendedor.getVendedordescargaestado() + 1).shortValue());
        em.merge(vendedor);
    }

    public List<Facturas> getFacturasParaCierre(Vendedor vendedor) {

        List<Facturas> R = em.createQuery("SELECT f from Facturas f "
                + " where f.empresasid = :emp "
                + " and f.sucursalesid = :suc "
                + " and f.vendedorid = :vid "
                + " and f.facturaspendientes != 'S' "
                + " and f.facturasestadodescarga != 'T'").setParameter("emp", vendedor.getEmpresasid()).setParameter("suc", vendedor.getSucursalesid()).setParameter("vid", vendedor.getVendedorid()).getResultList();

        return R;
    }

    public List<Retenciones> getRetencionesParaCierre(Vendedor vendedor) {

        List<Retenciones> R = em.createQuery("SELECT r from Retenciones r "
                + " where r.empresasid = :emp "
                + " and r.sucursalesid = :suc "
                + " and r.vendedoresid = :vid "
                + " and r.retestadodescarga != 'T'"
                + " and retimporteret > r.retimportesaldo").setParameter("emp", vendedor.getEmpresasid()).setParameter("suc", vendedor.getSucursalesid()).setParameter("vid", (new Short(vendedor.getVendedorid()).intValue())).getResultList();

        return R;
    }

    public List<FacturasDetalle> getDetallesFactura(Facturas f) {

        List<FacturasDetalle> R = em.createQuery("SELECT d from FacturasDetalle d "
                + " where d.empresasid = :empid"
                + " and d.sucursalesid = :sucid"
                + " and d.facturascmpid = :cmpid"
                + " and d.facturaspuntoexpedicionnro = :puntoexp"
                + " and d.facturasnumero = :nro ").setParameter("empid", f.getEmpresasid()).setParameter("sucid", f.getSucursalesid()).setParameter("cmpid", f.getFacturascmpid()).setParameter("puntoexp", f.getFacturaspuntoexpedicionnro()).setParameter("nro", f.getFacturasnumero()).getResultList();

        return R;
    }

    public List<FacturasCobros> getCobrosFactura(Facturas f) {

        List<FacturasCobros> R = em.createQuery("SELECT c from FacturasCobros c "
                + " where c.empresasid = :empid"
                + " and c.sucursalesid = :sucid"
                + " and c.facturascmpid = :cmpid"
                + " and c.facturaspuntoexpedicionnro = :puntoexp"
                + " and c.facturasnumero = :nro ").setParameter("empid", f.getEmpresasid()).setParameter("sucid", f.getSucursalesid()).setParameter("cmpid", f.getFacturascmpid()).setParameter("puntoexp", f.getFacturaspuntoexpedicionnro()).setParameter("nro", f.getFacturasnumero()).getResultList();

        return R;
    }

    public void corrigeFechaSiEstaMal(Facturas f) {
        TimeIgnoringComparator comp = new TimeIgnoringComparator();
        Calendar c1 = new GregorianCalendar();
        c1.setTime(f.getFacturasfecha());

        Calendar c2 = new GregorianCalendar();
        c1.setTime(new Date());

        if (comp.compare(c1, c2) != 0) {

            f.setFacturasfecha(new Date());
            c2.setTime(f.getFacturasvencimiento());
            if (comp.compare(c1, c2) == 0) {
                f.setFacturasvencimiento(new Date());
            }
        }

        em.merge(f);

    }

    public List<CobranzasDetalle> getDetallesCobranzas(Cobranzas c) {
        List<CobranzasDetalle> R = em.createQuery("SELECT d from CobranzasDetalle d where d.cobranzas = :cobranza").setParameter("cobranza", c).getResultList();
        return R;
    }

    public List<CobranzasCobros> getCobrosCobranzas(Cobranzas c) {

        List<CobranzasCobros> R = em.createQuery("SELECT d from CobranzasCobros d where d.cobranzas = :cobranza").setParameter("cobranza", c).getResultList();

        return R;
    }

    public List<CobranzasAplicacionPago> getAplicacionesCobranzas(Cobranzas c) {
        List<CobranzasAplicacionPago> R = em.createQuery("SELECT a from CobranzasAplicacionPago a where a.cobranzas = :cobranza").setParameter("cobranza", c).getResultList();
        return R;
    }

    public List<Relevamientos> getRelevamientosParaCierre(Vendedor vendedor) {

        List<Relevamientos> R = em.createQuery("SELECT r from Relevamientos r "
                + " where r.empresasid = :emp "
                + " and r.sucursalesid = :suc "
                + " and r.vendedoresid = :vid "
                + " and r.relevamientosestadodescarga != 1").setParameter("emp", vendedor.getEmpresasid()).setParameter("suc", vendedor.getSucursalesid()).setParameter("vid", vendedor.getVendedorid()).getResultList();

        return R;
    }

    public void actualiza(Object o) {
        em.merge(o);
    }
}
