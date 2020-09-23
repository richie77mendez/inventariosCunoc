package modelos;
import java.sql.Date;
/**
 *
 * @author ricardo
 */
public class Tarjeta {
    private String DPI;
    private String codigoCorrelativo;
    private String division;
    private String modulo;
    private String salon;
    private Date fechaImpresion;
    private String estado;
    
    public Tarjeta(){}

    public Tarjeta(String DPI, String codigoCorrelativo, String division, String modulo, String salon, Date fechaImpresion, String estado) {
        this.DPI = DPI;
        this.codigoCorrelativo = codigoCorrelativo;
        this.division = division;
        this.modulo = modulo;
        this.salon = salon;
        this.fechaImpresion = fechaImpresion;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    


    public String getDPI() {
        return DPI;
    }

    public String getCodigoCorrelativo() {
        return codigoCorrelativo;
    }

    public String getDivision() {
        return division;
    }

    public String getModulo() {
        return modulo;
    }

    public String getSalon() {
        return salon;
    }

    public Date getFechaImpresion() {
        return fechaImpresion;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public void setCodigoCorrelativo(String codigoCorrelativo) {
        this.codigoCorrelativo = codigoCorrelativo;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public void setFechaImpresion(Date fechaImpresion) {
        this.fechaImpresion = fechaImpresion;
    }
    
    
}
