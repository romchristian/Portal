/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial;

import py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo.Vendedor;



/**
 *
 * @author cromero
 */
public class ConsultasPalermo {

    public static String getEmpresa() {
        return " select TOP 1 [ID Sucursales] as empresaId,   "
             + "              [Razon Social]  as razonSocial, "
             + "              [RUC]           as ruc          "
             + " from [PAR_Sucursales];                       ";
    }

    public static String getCosultaVendedorUltimoNroFactura(Vendedor v) {
        return " SELECT [Ultimo Numero] FROM [Vta_Comprobantes Numeros]  "
                + " WHERE [Id Comprobantes Numero] = 1                   "
                + " AND [Id Sucursales] = " + v.getSucursalesid()
                + " AND [Punto Expedicion] = " + v.getVendedorpuntoexpedicionnro();
    }

    public static String getConsultaClientes(Vendedor v) {
        return " 	SELECT C.[ID Clientes]                                                                          "
                + " 		, ISNULL(C.[Razon Social],'') AS 'RazonSocial'                                                  "
                + " 		, CASE ISNULL(convert(varchar(15),C.Ruc),convert(varchar(15),'')) WHEN '' THEN ISNULL(CONVERT(varchar(15),C.[Cedula Nro]),convert(varchar(15),'')) ELSE convert(varchar(15),C.Ruc) END "
                + " 		, ISNULL(C.[Razon Social],'') AS Propietario                                                    "  //Cambio temporal el propietario es la razon social por ahora para que imprima bien
                + " 		, ISNULL(C.Telefono,'') AS Telefono                                                             "
                + " 		, ISNULL(C.Direccion,'') AS Direccion                                                           "
                + " 		, ISNULL(C.[Precio Contado],0) AS PrecioContado                                                 "
                + " 		, ISNULL(cast(C.[Id listas Precios Contado] as int),cast(0 as int)) AS IdListasPreciosContado                             "
                + " 		, ISNULL(cast(C.[ID Listas Precios] as int),cast(0 as int)) AS IdListasPrecios                                            "
                + " 		, cast(C.[ID Vendedores] as int) AS IdVendedores                                                             "
                + " 		, CASE ISNULL(C.[Clasificacion 11],'NO') WHEN 'SI' THEN 1 ELSE 0 END  As DescuentoId            "
                + " 		, 0 As LimiteDeCredito                                                                          "
                + " 		, 0 AS ClientesSaldo                                                                            "
                + " 		, 0 AS ClientesPlazo                                                                            "
                + " 		, 0 As CanalesId                                                                                "
                + " 		, ISNULL(cast(C.EstadoCanal as int), cast(0 as int)) AS CanalesEstado                                                     "
                + " 		, ISNULL(cast((case when C.vigencia_bonificacion is not null and DATEADD(dd, 0, DATEDIFF(dd, 0, GETDATE())) >= cast(C.vigencia_bonificacion as datetime) then 0 else -1 end) as int), cast(0 as int)) AS PromoPLM3 "
                + " 		, (Case When [clasificacion 11]='NO' or [clasificacion 11] is null or [clasificacion 11]='' THEN 'NO' Else 'SI' end) AS Mayorista                                               "
                + " 		, C.[Canales]                                                                                   "
                + " 		, C.encuesta_id                                                                                 "
                + " 		, C.encuesta_estado                                                                             "
                + " 		, CASE WHEN (cast(C.mensaje_desde as datetime) <=  DATEADD(dd, 0, DATEDIFF(dd, 0, GETDATE()))  and cast(C.mensaje_vigencia as datetime) >= DATEADD(dd, 0, DATEDIFF(dd, 0, GETDATE()))) THEN C.mensaje  ELSE NULL end  as mensaje  "
                + "             , [NombreComercial]                                                                             "
                + " 	FROM [VTA_Clientes] C                                                                                   "
                + " 	WHERE C.[ID Vendedores] = "+ v.getVendedorid() +" "
                + " 		AND C.[ID Sucursales] = "+ v.getSucursalesid()+" "
                + " 	ORDER BY C.[Razon Social]	                                                                        ";
                
    }

    public static String getConsultaCanales() {
        return "select CanalesId, CanalesDescripcion from canales";
    }

    public static String getConsultaSabores() {
        return "select 0 as SaboresId, 'No definido' as SaboresDescripcion , 0 as SaboresOrden";
    }

    public static String getConsultaMotivosNoVenta() {
        return "select cast(motivosnoventasid as integer) as motivosnoventasid,\n"
                + "        cast(motivosnoventasnombre as varchar(40)) from motivosnoventas\n"
                + "where motivosnoventasestado = 0 or motivosnoventasestado is null";
    }

    public static String getConsultaTipoEmpaques() {
        return "select cast(0 as integer) as TipoEmpaqueId , 'No definido' as TipoEmpaqueDescripcion";
    }

    public static String getConsultaEmpaques() {
        return "select cast(0 as integer) as EmpaqueId , 'No definido' as EmpaqueDescripcion, cast(0 as integer) as EmpaqueOrden";
    }

    public static String getConsultaMarcas() {
        return "select cast(0 as integer) as MarcasId , 'No definido' as MarcasDescripcion, cast(0 as integer) as MarcasOrden"
                + " UNION ALL "
                + " select cast(1 as integer) as MarcasId , 'PALERMO' as MarcasDescripcion, cast(0 as integer) as MarcasOrden ";
    }

    public static String getConsultaProcutos(Vendedor v) {
        return "select convert(int,p.[ID Productos]) as ProductoId,\n"
                + "                                  p.[Descripcion] as ProductoNombre, \n"
                + "                                  cast(p.[ID Impuesto] as int) as ProductoImpuestoId, \n"
                + "                                  convert(int,(case when i.[Porcentaje] = 0.1 then i.[Porcentaje]*100 when i.[Porcentaje] =10 then i.[Porcentaje] else i.[Porcentaje] end)) as  ProductoImpuestoPorcentaje ,\n"
                + "                                  cast(p.[ID Unidad Estandar] as int) as  ProductoUnidadEstandar ,\n"
                + "                                  0 as  ProductoCantidadVendida ,\n"
                + "                                  ISNULL(cast(p.[Descuento Porcentaje] as int),cast(0 as int)) as ProductoDescuentoPorc ,\n"
                + "                                  0 as  ProductoGrupo ,\n"
                + "                                  s.[Cantidad] as  ProductoStock ,\n"
                + "                                  0 as  EmpaquesId ,\n"
                + "                                  0 as  SaboresId ,\n"
                + "                                  (CASE when p.[Descripcion] like '%PALERMO%' then 1 else 0 end) as  MarcasId ,\n"
                + "                                  0 as  TipoEmpaqueId ,\n"
                + "                                  ISNULL(cast(p.[PromoPLM3] as int),cast(0 as int)) as PromoPLM3 ,\n"
                + "                                  ISNULL(p.[Codigo Barra],0) as CodigoBarra,\n"
                + "                                  ISNULL(p.[ProductoKit],0) as ProductoKit\n"
                + " from STK_Productos p \n"
                + " join PAR_Impuestos i on \n"
                + " i.[ID Impuestos] = p.[ID Impuesto]\n"
                + " join \n"
                + " (SELECT STK_Stock.[ID Productos] AS IdProducto,\n"
                + "                                          [ID Vendedores] AS IdVendedor,\n"
                + "                                          Cantidad," + v.getEmpresasid() + " as empresasId," + v.getSucursalesid() + " as sucursalesId FROM \n"
                + "                                          VTA_Vendedores VTA_Vendedores JOIN  STK_Stock STK_Stock\n"
                + "                                          ON VTA_Vendedores.[ID Sucursales] = STK_Stock.[ID Sucursales] \n"
                + "                                          AND VTA_Vendedores.[ID Depositos] = STK_Stock.[ID Depositos] JOIN \n"
                + "                                          STK_Productos STK_Productos\n"
                + "                                          ON [STK_Stock].[ID Sucursales] = STK_Productos.[ID Sucursales]\n"
                + "                                          AND [STK_Stock].[ID Productos] = STK_Productos.[ID Productos] \n"
                + "                                          AND ISNULL(STK_Productos.[Activo], 0) = 1\n"
                + "                                          AND STK_Productos.[ID Productos] <> '000'\n"
                + "                                          AND VTA_Vendedores.[ID Sucursales] = " + v.getSucursalesid() + "\n"
                + "                                          AND VTA_Vendedores.[ID Vendedores] = " + v.getVendedorid() + "\n"
                + "                                          AND [Punto Expedicion] IS NOT NULL WHERE Cantidad >= 0) s\n"
                + "                                          \n"
                + " on s.IdProducto = p.[ID Productos]                                      \n"
                + " where p.Activo = 1 and p.[MostrarPocket] = 1 \n"
                + " order by p.[ProductoNombre]";
    }

    public static String getComposicionPromo() {
        return "select\n"
                + "convert(int,C.ID_Productos) as ProductoIdKit, \n"
                + "convert(int,C.STK_Productos_ID_Productos) as ProductoId, \n"
                + "convert(int,C.Cantidad) as CantidadProducto,\n"
                + "C.Imprimible\n"
                + "from ComposicionPromo C\n"
                + "join STK_Productos p \n"
                + "on C.ID_Productos = p.[ID Productos]\n"
                + "and C.ID_Sucursales = p.[ID Sucursales]\n"
                + "and C.ID_Codigo_Rapido = p.[ID Codigo Rapido]\n"
                + "where p.ProductoKit = 1\n"
                + "and cast(p.PromoVigenciaDesde as datetime) <= getdate()\n"
                + "and cast(p.PromoVigencia as datetime) >= getdate()\n"
                + "and p.Activo = 1 ";
    }

    public static String getConsultaCantMaximaClientePromo(Vendedor v) {
        return String.format("select \n"
                + "convert(int,P.ID_Productos) as ProductoId,\n"
                + "P.ID_Clientes as ClientesId,\n"
                + "convert(int,P.Cantidad) as Cantidad\n"
                + "from CantMaximaPromoCliente P\n"
                + "join [VTA_Clientes] C\n"
                + "on C.[ID Clientes] = P.ID_Clientes\n"
                + " join STK_Productos pr\n"
                + " on P.[ID_Sucursales] = pr.[ID Sucursales]\n"
                + " and P.[ID_Productos] = pr.[ID Productos]\n"
                + " and P.[ID_Codigo_Rapido] = pr.[ID Codigo Rapido]"
                + "WHERE C.[ID Vendedores] = %d\n"
                + " AND C.[ID Sucursales] = %d"
                + " and cast(pr.PromoVigenciaDesde as datetime) <= getdate()\n"
                + " and cast(pr.PromoVigencia as datetime) >= getdate()"
                + " and pr.Activo = 1",
                v.getVendedorid(), v.getSucursalesid()).toString();
    }

    public static String getConsultaVisitas(Vendedor v) {
        return "select cast(VTA_FrecuenciasdeVisitas.[ID Vendedores] as int) AS IdVendedor\n"
                + ",cast(VTA_FrecuenciasdeVisitas.[Dia de Semana] as  int) AS DiaSemana\n"
                + ",cast(VTA_FrecuenciasdeVisitas.[Secuencia Visitas] as int) AS SecuenciaVisita\n"
                + ",cast(VTA_FrecuenciasdeVisitas.[ID Clientes] as int) AS IdCliente \n"
                + ",cast(0 as int) AS EstadoFactura                                 \n"
                + ",cast(0 as int) AS EstadoCobranza                            \n"
                + ",cast(1 as int)   AS EmpresasId                              \n"
                + ",cast(1  as int) AS SucursalesId                             \n"
                + "                                             	FROM   [VTA_Frecuencias de Visitas] VTA_FrecuenciasdeVisitas                                                       \n"
                + "                                             	JOIN   VTA_Vendedores VTA_Vendedores ON VTA_Vendedores.[ID Vendedores] = VTA_FrecuenciasdeVisitas.[ID Vendedores]  \n"
                + "                                             	WHERE VTA_Vendedores.[ID Sucursales] = " + v.getSucursalesid() + "                                                                                    \n"
                + "                                             		AND VTA_FrecuenciasdeVisitas.[ID Vendedores] = " + v.getVendedorid() + "                                                                        \n"
                + "                                             		AND [Punto Expedicion] IS NOT NULL                                                                                         \n"
                + "                                             		AND [ID Clientes] IN (select [ID Clientes]                                                                                 \n"
                + "                                             								FROM   [VTA_Clientes] AS VTA_Clientes                                                  \n"
                + "                                             								WHERE VTA_Clientes.[ID Vendedores] = " + v.getVendedorid() + ")                                                         \n"
                + "                                             	ORDER BY VTA_FrecuenciasdeVisitas.[ID Vendedores],[Dia de Semana],[Secuencia Visitas]";
    }

    public static String getConsultaBancos() {
        return "SELECT \n"
                + "      [ID Bancos] as BancosId\n"
                + "      ,[Nombre] as BancosNombre\n"
                + "      \n"
                + "  FROM [FIN_Bancos]";
    }

    public static String getConsultaMediosPago(Vendedor vendedor) {
        return "select [ID Medios Pagos] as MediosPagosId,\n"
                + "       [Descripcion] as MediosPagosNombreAbr, \n"
                + "       [Tipo Medio Pago] as MediosPagosTipo,\n"
                + "       1 as EmpresasId,\n"
                + vendedor.getSucursalesid() + " as SucursalesId\n"
                + "from [VTA_Medios de Pagos] where [Tipo Medio Pago] <> 8";
    }

    public static String getConsultaUnidadesMedida() {
        return "select cast([Id Unidades Medidas] as int) as UnidadesMedidaId,\n"
                + "       [Descripcion] as UnidadesMedidaNombre,\n"
                + "        SUBSTRING ( Descripcion , 1, 4 ) as UnidadesMedidaAbreviado,\n"
                + "        cast(1 as int) as UnidadesMedidaEstado\n"
                + "  from [STK_Unidades de Medidas]";
    }

    public static String getConsultaProductosMedida() {
        return "select   convert(int,um.[Id Productos])  as ProductosId,\n"
                + "         cast(um.[ID Unidades Medidas] as int)  as ProductosUM,\n"
                + "         u.[Descripcion] as ProductosUMNombre,\n"
                + "         cast(um.[Cantidad] as int) as ProductosUMCantidad,\n"
                + "         0.00 as ProductosUMLitros,\n"
                + "         0.00 as ProductosUMKilos\n"
                + "                 from [STK_UM de Productos] um\n"
                + "                 join [STK_Productos] p on um.[ID Productos] = p.[ID Productos]\n"
                + "                 join [STK_Unidades de Medidas] u on u.[ID Unidades Medidas] = um.[ID Unidades Medidas]\n"
                + "                  where p.[Activo] = 1 \n"
                //   + "                  and um.[Id Productos] not in(502,503)\n"
                + "                  order by 1,2,3";
    }

    public static String getConsultaPrecios() {
        return "select \n"
                + "convert(int,v.[ID Productos]) as ProductoId,\n"
                + "cast(v.[ID Unidades Medidas] as int) as ProductoUM, \n"
                + "cast(v.[ID Listas Precios] as int) as PreciosPreciosId, \n"
                + "cast(v.[Cantidad Inicial] as int) as PreciosDesde,\n"
                + "cast(v.[Cantidad Final] as int) as PreciosHasta,\n"
                + "v.[Importe] as PreciosImporte\n"
                + "from [VTA_Precios de Ventas] v \n"
                + "join [STK_Productos] p on p.[ID Productos] = v.[ID Productos]\n"
                + "where p.[Activo] = 1\n"
                + "order by 1,2,3";
    }

    public static String getConsultaFPendientes(Vendedor v) {
        return "SELECT cast(VTA_CComprobantesdeVentas.[ID Comprobantes Ventas] as int) AS IDComprobantesVentas,                                                                          \n"
                + "                                             		cast(VTA_Vendedores.[Punto Expedicion] as int) AS PEXP                                                                                                                              \n"
                + "                                             		,cast(VTA_CComprobantesdeVentas.[Numero] as int) as Numero                                                                                                                    \n"
                + "                                             		,VTA_CComprobantesdeVentas.[Fecha]                                                                                                                      \n"
                + "                                             		,Vencimiento                                                                                                                                            \n"
                + "                                             		,cast(VTA_CComprobantesdeVentas.[ID Clientes] as int) AS IDClientes                                                                                                  \n"
                + "                                             		,'R' AS TipoComprobante                                                                                                                                 \n"
                + "                                             		,CASE WHEN [Forma Pago] = 'O' THEN 'R' ELSE 'O' END AS FormaPago                                                                                        \n"
                + "                                             		,[Importe Gravada ML] AS ImporteGravadaML                                                                                                               \n"
                + "                                             		,ISNULL([Importe Descuento ML],0) AS ImporteDescuentoML                                                                                                 \n"
                + "                                             		,[Importe Impuesto ML] AS ImporteImpuestoML                                                                                                             \n"
                + "                                             		,VTA_CComprobantesdeVentas.[Importe Total ML] AS ImporteTotal                                                                                           \n"
                + "                                             		,VTA_FacturasCreditos.[Importe Pago ML] AS ImportePago                                                                                                  \n"
                + "                                             		,'T' AS Descarga                                                                                                                                        \n"
                + "                                             		,'S' AS Impresion                                                                                                                                       \n"
                + "                                             		,CASE WHEN VTA_CComprobantesdeVentas.STATUS = '00' THEN 'N' ELSE 'S' END AS Anulacion                                                                   \n"
                + "                                             		,'S' AS Pendientes                                                                                                                                      \n"
                + "                                             		,cast(VTA_CComprobantesdeVentas.[ID Vendedores] as int)                                                                                                             \n"
                + "                                             		,cast(" + v.getEmpresasid() + " as int) AS EmpresasId                                                                                                                                     \n"
                + "                                             		,cast(" + v.getSucursalesid() + " as int) AS SucursalesId                                                                                                                                   \n"
                + "                                            	FROM    [VTA_Facturas Creditos] VTA_FacturasCreditos                                                                                           \n"
                + "                                            		INNER JOIN  [VTA_C Comprobantes de Ventas] VTA_CComprobantesdeVentas                                                                       \n"
                + "                                            			ON VTA_CComprobantesdeVentas.[Origen] = VTA_FacturasCreditos.[Origen]                                                                               \n"
                + "                                            			AND VTA_CComprobantesdeVentas.[ID Sucursales] = VTA_FacturasCreditos.[ID Sucursales]                                                                \n"
                + "                                            			AND VTA_CComprobantesdeVentas.[ID Vendedores] = VTA_FacturasCreditos.[ID Vendedores]                                                                \n"
                + "                                            			AND VTA_CComprobantesdeVentas.[ID Comprobantes Ventas] = VTA_FacturasCreditos.[ID Comprobantes Ventas]                                              \n"
                + "                                            			AND VTA_CComprobantesdeVentas.Numero = VTA_FacturasCreditos.Numero                                                                                  \n"
                + "                                            		INNER JOIN    [VTA_Comprobantes de Ventas] VTA_ComprobantesdeVentas                                                                        \n"
                + "                                            			ON VTA_FacturasCreditos.[ID Sucursales] = VTA_ComprobantesdeVentas.[ID Sucursales]                                                                  \n"
                + "                                            			AND VTA_FacturasCreditos.[ID Comprobantes Ventas] = VTA_ComprobantesdeVentas.[ID Comprobantes Ventas]                                               \n"
                + "                                            		INNER JOIN    VTA_Clientes VTA_Clientes                                                                                                    \n"
                + "                                            			ON VTA_FacturasCreditos.[ID Sucursales] = VTA_Clientes.[ID Sucursales]                                                                              \n"
                + "                                            			AND VTA_FacturasCreditos.[ID Clientes] = VTA_Clientes.[ID Clientes]                                                                                 \n"
                + "                                            		INNER JOIN    VTA_Vendedores VTA_Vendedores                                                                                                \n"
                + "                                            			ON VTA_Clientes.[ID Vendedores] = VTA_Vendedores.[ID Vendedores]                                                                                    \n"
                + "                                            	WHERE VTA_FacturasCreditos.Origen = 2                                                                                                                       \n"
                + "                                            		AND VTA_ComprobantesdeVentas.[Tipo Comprobante] = 2                                                                                                     \n"
                + "                                            		AND VTA_FacturasCreditos.[Importe ML] > VTA_FacturasCreditos.[Importe Pago ML]                                                                          \n"
                + "                                            		AND ISNULL(VTA_FacturasCreditos.[Status], '00') = '00'                                                                                                  \n"
                + "                                            		AND VTA_Vendedores.[Punto Expedicion] = " + v.getVendedorpuntoexpedicionnro() + "                                                                                                                         \n"
                + "                                             	UNION ALL                                                                                                                                                   \n"
                + "                                             	SELECT cast(VTA_CComprobantesdeVentas.[ID Comprobantes Ventas] as int) AS IDComprobantesVentas                                                                           \n"
                + "                                             		,cast(VTA_Vendedores.[Punto Expedicion] as int) AS PEXP                                                                                                                             \n"
                + "                                             		,cast(VTA_CComprobantesdeVentas.Numero as int) as Numero                                                                                                                       \n"
                + "                                             		,VTA_CComprobantesdeVentas.Fecha, Vencimiento                                                                                                           \n"
                + "                                             		,cast(VTA_CComprobantesdeVentas.[ID Clientes] as int) AS IDClientes                                                                                                  \n"
                + "                                             		,'O' AS TipoComprobante                                                                                                                                 \n"
                + "                                             		,CASE WHEN [Forma Pago] = 'O' THEN 'R' ELSE 'O' END AS FormaPago                                                                                        \n"
                + "                                             		,[Importe Gravada ML] AS ImporteGravadaML                                                                                                               \n"
                + "                                             		,ISNULL([Importe Descuento ML],0) AS ImporteDescuentoML                                                                                                 \n"
                + "                                             		,[Importe Impuesto ML] AS ImporteImpuestoML                                                                                                             \n"
                + "                                             		,VTA_CComprobantesdeVentas.[Importe Total ML] AS ImporteTotal                                                                                           \n"
                + "                                             		,((VTA_CComprobantesdeVentas.[Importe Total ML] - VTA_FormasdeCancelacion.[Importe Pago ML]) + VTA_FacturasCreditos.[Importe Pago ML]) AS ImportePago   \n"
                + "                                             		,'T' AS Descarga, 'S' AS Impresion                                                                                                                      \n"
                + "                                             		,CASE WHEN VTA_CComprobantesdeVentas.STATUS = '00' THEN 'N' ELSE 'S' END AS Anulacion                                                                   \n"
                + "                                             		,'S' AS Pendientes                                                                                                                                      \n"
                + "                                             		,cast(VTA_CComprobantesdeVentas.[ID Vendedores] as int)                                                                                                              \n"
                + "                                             		,cast(" + v.getEmpresasid() + " as int) AS EmpresasId                                                                                                                                     \n"
                + "                                             		,cast(" + v.getSucursalesid() + " as int) AS SucursalesId                                                                                                                                   \n"
                + "                                             	FROM    [VTA_Formas de Cancelacion] VTA_FormasdeCancelacion                                                                                    \n"
                + "                                             		INNER JOIN   [VTA_Facturas Creditos] VTA_FacturasCreditos                                                                                  \n"
                + "                                             			ON VTA_FormasdeCancelacion.Origen = VTA_FacturasCreditos.Origen                                                                                     \n"
                + "                                             			AND VTA_FormasdeCancelacion.[ID Sucursales] = VTA_FacturasCreditos.[ID Sucursales]                                                                  \n"
                + "                                             			AND VTA_FormasdeCancelacion.[ID Comprobantes] = VTA_FacturasCreditos.[ID Comprobantes Ventas]                                                       \n"
                + "                                             			AND VTA_FormasdeCancelacion.Numero = VTA_FacturasCreditos.Numero                                                                                    \n"
                + "                                             			AND VTA_FormasdeCancelacion.[ID Vendedores] = VTA_FacturasCreditos.[ID Vendedores]                                                                  \n"
                + "                                             			AND VTA_FormasdeCancelacion.[Numero Valor] = VTA_FacturasCreditos.Cuota                                                                             \n"
                + "                                             		INNER JOIN    [VTA_C Comprobantes de Ventas] VTA_CComprobantesdeVentas                                                                     \n"
                + "                                             			ON VTA_FormasdeCancelacion.Origen = VTA_CComprobantesdeVentas.Origen                                                                                \n"
                + "                                             			AND VTA_FormasdeCancelacion.[ID Sucursales] = VTA_CComprobantesdeVentas.[ID Sucursales]                                                             \n"
                + "                                             			AND VTA_FormasdeCancelacion.[ID Comprobantes] = VTA_CComprobantesdeVentas.[ID Comprobantes Ventas]                                                  \n"
                + "                                             			AND VTA_FormasdeCancelacion.Numero = VTA_CComprobantesdeVentas.Numero                                                                               \n"
                + "                                             			AND VTA_FormasdeCancelacion.[ID Vendedores] = VTA_CComprobantesdeVentas.[ID Vendedores]                                                             \n"
                + "                                             		INNER JOIN    [VTA_Medios de Pagos] VTA_MediosdePagos                                                                                      \n"
                + "                                             			ON  VTA_FormasdeCancelacion.[ID Sucursales] = VTA_MediosdePagos.[ID Sucursales]                                                                     \n"
                + "                                             			AND VTA_FormasdeCancelacion.[ID Medios Pagos] = VTA_MediosdePagos.[ID Medios Pagos]                                                                 \n"
                + "                                             		INNER JOIN   VTA_Clientes VTA_Clientes                                                                                                     \n"
                + "                                             			ON  VTA_FacturasCreditos.[ID Sucursales] = VTA_Clientes.[ID Sucursales]                                                                             \n"
                + "                                             			AND VTA_FacturasCreditos.[ID Clientes] = VTA_Clientes.[ID Clientes]                                                                                 \n"
                + "                                             		INNER JOIN    VTA_Vendedores VTA_Vendedores                                                                                                \n"
                + "                                             			ON VTA_Clientes.[ID Vendedores] = VTA_Vendedores.[ID Vendedores]                                                                                    \n"
                + "                                             	WHERE VTA_MediosdePagos.[Tipo Medio Pago] <> 2 AND VTA_FacturasCreditos.[Importe ML] > VTA_FacturasCreditos.[Importe Pago ML]                               \n"
                + "                                             		AND ISNULL(VTA_FacturasCreditos.[Status], '00') = '00'                                                                                                  \n"
                + "                                             		AND VTA_Vendedores.[Punto Expedicion] = " + v.getVendedorpuntoexpedicionnro() + "                                                                                                                         \n"
                + "                                             	ORDER BY cast(VTA_CComprobantesdeVentas.[ID Comprobantes Ventas] as int),VTA_CComprobantesdeVentas.Fecha,cast(VTA_CComprobantesdeVentas.[Numero] as int)    ; ";
    }
}
