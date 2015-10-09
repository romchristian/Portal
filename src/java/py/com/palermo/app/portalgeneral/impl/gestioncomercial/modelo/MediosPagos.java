/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.app.portalgeneral.impl.gestioncomercial.modelo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author cromero
 */
@XmlType(name = "MediosPagos")
public class MediosPagos {

    private Integer MediosPagosId;
    private String MediosPagosNombreAbr;
    private Integer MediosPagosTipo;
    private Integer EmpresasId;
    private Integer SucursalesId;

    public MediosPagos() {
    }



    public MediosPagos(Integer MediosPagosId, String MediosPagosNombreAbr, Integer MediosPagosTipo, Integer EmpresasId, Integer SucursalesId) {
        this.MediosPagosId = MediosPagosId;
        this.MediosPagosNombreAbr = MediosPagosNombreAbr;
        this.MediosPagosTipo = MediosPagosTipo;
        this.EmpresasId = EmpresasId;
        this.SucursalesId = SucursalesId;
    }

    public MediosPagos(Object[] o) {
        this(((Short) o[0]).intValue(),
                (String) o[1],
                (Integer) o[2],
                (Integer) o[3],
                (Integer) o[4]);
    }

    public Integer getMediosPagosId() {
        return MediosPagosId;
    }

    @XmlElement(name = "MediosPagosId")
    public void setMediosPagosId(Integer MediosPagosId) {
        this.MediosPagosId = MediosPagosId;
    }

    public String getMediosPagosNombreAbr() {
        return MediosPagosNombreAbr;
    }

    @XmlElement(name = "MediosPagosNombreAbr")
    public void setMediosPagosNombreAbr(String MediosPagosNombreAbr) {
        this.MediosPagosNombreAbr = MediosPagosNombreAbr;
    }

    public Integer getMediosPagosTipo() {
        return MediosPagosTipo;
    }

    @XmlElement(name = "MediosPagosTipo")
    public void setMediosPagosTipo(Integer MediosPagosTipo) {
        this.MediosPagosTipo = MediosPagosTipo;
    }

    public Integer getEmpresasId() {
        return EmpresasId;
    }

    @XmlElement(name = "EmpresasId")
    public void setEmpresasId(Integer EmpresasId) {
        this.EmpresasId = EmpresasId;
    }

    public Integer getSucursalesId() {
        return SucursalesId;
    }

    @XmlElement(name = "SucursalesId")
    public void setSucursalesId(Integer SucursalesId) {
        this.SucursalesId = SucursalesId;
    }
}
