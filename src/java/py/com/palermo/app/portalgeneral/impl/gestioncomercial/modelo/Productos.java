/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author cromero
 */
@XmlType(name = "Productos")
public class Productos {

    private Integer ProductoId;
    private String ProductoNombre;
    private Integer ProductoImpuestoId;
    private Integer ProductoImpuestoPorcentaje;
    private Integer ProductoUnidadEstandar;
    private Integer ProductoCantidadVendida;
    private Integer ProductoDescuentoPorc;
    private Integer ProductoGrupo;
    private Integer ProductoStock;
    private Integer EmpaquesId;
    private Integer SaboresId;
    private Integer MarcasId;
    private Integer TipoEmpaqueId;
    private Integer PromoPLM3;
    private String CodigoBarra;
    private Integer ProductoKit;

    public Productos() {
    }


    public Productos(Integer ProductoId, String ProductoNombre, Integer ProductoImpuestoId, Integer ProductoImpuestoPorcentaje, Integer ProductoUnidadEstandar, Integer ProductoCantidadVendida, Integer ProductoDescuentoPorc, Integer ProductoGrupo, Integer ProductoStock, Integer EmpaquesId, Integer SaboresId, Integer MarcasId,Integer TipoEmpaqueId, Integer PromoPLM3, String CodigoBarra,Integer ProductoKit) {
        this.ProductoId = ProductoId;
        this.ProductoNombre = ProductoNombre;
        this.ProductoImpuestoId = ProductoImpuestoId;
        this.ProductoImpuestoPorcentaje = ProductoImpuestoPorcentaje;
        this.ProductoUnidadEstandar = ProductoUnidadEstandar;
        this.ProductoCantidadVendida = ProductoCantidadVendida;
        this.ProductoDescuentoPorc = ProductoDescuentoPorc;
        this.ProductoGrupo = ProductoGrupo;
        this.ProductoStock = ProductoStock;
        this.EmpaquesId = EmpaquesId;
        this.SaboresId = SaboresId;
        this.MarcasId = MarcasId;
        this.TipoEmpaqueId = TipoEmpaqueId;
        this.PromoPLM3 = PromoPLM3;
        this.CodigoBarra = CodigoBarra;
        this.ProductoKit = ProductoKit!= null ? ProductoKit:0;
        
    }

    public Productos(Object[] o) {


        this.ProductoId = (Integer) o[0];
        this.ProductoNombre = (String) o[1];
        this.ProductoImpuestoId = (Integer) o[2];
        this.ProductoImpuestoPorcentaje = (Integer) o[3];
        this.ProductoUnidadEstandar = (Integer) o[4];
        this.ProductoCantidadVendida = (Integer) o[5];
        this.ProductoDescuentoPorc = (Integer) o[6];
        this.ProductoGrupo = (Integer) o[7];
        this.ProductoStock = (Integer) o[8];
        this.EmpaquesId = (Integer) o[9];
        this.SaboresId = (Integer) o[10];
        this.MarcasId = (Integer) o[11];
        this.TipoEmpaqueId = (Integer) o[12];
        this.PromoPLM3 = (Integer) o[13];
        this.CodigoBarra = (String) o[14];
        this.ProductoKit = ((BigDecimal) o[15]) != null ? ((BigDecimal) o[15]).intValue():0;
//        this((Integer) o[0],
//                (String) o[1],
//                (Integer) o[2],
//                (Integer) o[3],
//                (Integer) o[4],
//                (Integer) o[5],
//                (Integer) o[6],
//                (Integer) o[7],
//                (Integer) o[8],
//                (Integer) o[9],
//                (Integer) o[10],
//                (Integer) o[11],
//                (Integer) o[12],
//                (Integer) o[13],
//                (String) o[14],
//                ((Byte) o[15]).intValue());
    }

    public Integer getProductoId() {
        return ProductoId;
    }

    @XmlElement(name = "ProductoId")
    public void setProductoId(Integer ProductoId) {
        this.ProductoId = ProductoId;
    }

    public String getProductoNombre() {
        return ProductoNombre;
    }

    @XmlElement(name = "ProductoNombre")
    public void setProductoNombre(String ProductoNombre) {
        this.ProductoNombre = ProductoNombre;
    }

    public Integer getProductoImpuestoId() {
        return ProductoImpuestoId;
    }

    @XmlElement(name = "ProductoImpuestoId")
    public void setProductoImpuestoId(Integer ProductoImpuestoId) {
        this.ProductoImpuestoId = ProductoImpuestoId;
    }

    public Integer getProductoImpuestoPorcentaje() {
        return ProductoImpuestoPorcentaje;
    }

    @XmlElement(name = "ProductoImpuestoPorcentaje")
    public void setProductoImpuestoPorcentaje(Integer ProductoImpuestoPorcentaje) {
        this.ProductoImpuestoPorcentaje = ProductoImpuestoPorcentaje;
    }

    public Integer getProductoUnidadEstandar() {
        return ProductoUnidadEstandar;
    }

    @XmlElement(name = "ProductoUnidadEstandar")
    public void setProductoUnidadEstandar(Integer ProductoUnidadEstandar) {
        this.ProductoUnidadEstandar = ProductoUnidadEstandar;
    }

    public Integer getProductoCantidadVendida() {
        return ProductoCantidadVendida;
    }

    @XmlElement(name = "ProductoCantidadVendida")
    public void setProductoCantidadVendida(Integer ProductoCantidadVendida) {
        this.ProductoCantidadVendida = ProductoCantidadVendida;
    }

    public Integer getProductoDescuentoPorc() {
        return ProductoDescuentoPorc;
    }

    @XmlElement(name = "ProductoDescuentoPorc")
    public void setProductoDescuentoPorc(Integer ProductoDescuentoPorc) {
        this.ProductoDescuentoPorc = ProductoDescuentoPorc;
    }

    public Integer getProductoGrupo() {
        return ProductoGrupo;
    }

    @XmlElement(name = "ProductoGrupo")
    public void setProductoGrupo(Integer ProductoGrupo) {
        this.ProductoGrupo = ProductoGrupo;
    }

    public Integer getProductoStock() {
        return ProductoStock;
    }

    @XmlElement(name = "ProductoStock")
    public void setProductoStock(Integer ProductoStock) {
        this.ProductoStock = ProductoStock;
    }

    public Integer getEmpaquesId() {
        return EmpaquesId;
    }

    @XmlElement(name = "EmpaquesId")
    public void setEmpaquesId(Integer EmpaquesId) {
        this.EmpaquesId = EmpaquesId;
    }

    public Integer getSaboresId() {
        return SaboresId;
    }

    @XmlElement(name = "SaboresId")
    public void setSaboresId(Integer SaboresId) {
        this.SaboresId = SaboresId;
    }

    public Integer getMarcasId() {
        return MarcasId;
    }

    @XmlElement(name = "MarcasId")
    public void setMarcasId(Integer MarcasId) {
        this.MarcasId = MarcasId;
    }

    public Integer getTipoEmpaqueId() {
        return TipoEmpaqueId;
    }

    @XmlElement(name = "TipoEmpaqueId")
    public void setTipoEmpaqueId(Integer TipoEmpaqueId) {
        this.TipoEmpaqueId = TipoEmpaqueId;
    }

    
    
    public Integer getPromoPLM3() {
        return PromoPLM3;
    }

    @XmlElement(name = "PromoPLM3")
    public void setPromoPLM3(Integer PromoPLM3) {
        this.PromoPLM3 = PromoPLM3;
    }

    public String getCodigoBarra() {
        return CodigoBarra;
    }

    @XmlElement(name = "CodigoBarra")
    public void setCodigoBarra(String CodigoBarra) {
        this.CodigoBarra = CodigoBarra;
    }

    public Integer getProductoKit() {
        return ProductoKit;
    }

    @XmlElement(name = "ProductoKit")
    public void setProductoKit(Integer ProductoKit) {
        this.ProductoKit = ProductoKit;
    }
    
}
