/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Date;

/**
 *
 * @author ricardo
 */
public class Bien {
    private String Nombre;
    private String UnidadAcademica;
    private String CodigoTipoBien;
    private String Estado;
    private Double Costo;
    private String adquision;
    private String tarjeta;
    private String tarjetaAux;
    private String cuenta;

    public Bien(){}

    public Bien(String Nombre, String UnidadAcademica, String CodigoTipoBien, String Estado, Double Costo, String adquision, String tarjeta, String tarjetaAux) {
        this.Nombre = Nombre;
        this.UnidadAcademica = UnidadAcademica;
        this.CodigoTipoBien = CodigoTipoBien;
        this.Estado = Estado;
        this.Costo = Costo;
        this.adquision = adquision;
        this.tarjeta = tarjeta;
        this.tarjetaAux = tarjetaAux;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
    
    
    public String getAdquision() {
        return adquision;
    }

    public void setAdquision(String adquision) {
        this.adquision = adquision;
    }



    public Double getCosto() {
        return Costo;
    }

    public void setCosto(Double Costo) {
        this.Costo = Costo;
    }
    
    
    
    public String getNombre() {
        return Nombre;
    }

    public String getUnidadAcademica() {
        return UnidadAcademica;
    }

    public String getCodigoTipoBien() {
        return CodigoTipoBien;
    }

    public String getEstado() {
        return Estado;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public String getTarjetaAux() {
        return tarjetaAux;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setUnidadAcademica(String UnidadAcademica) {
        this.UnidadAcademica = UnidadAcademica;
    }

    public void setCodigoTipoBien(String CodigoTipoBien) {
        this.CodigoTipoBien = CodigoTipoBien;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public void setTarjetaAux(String tarjetaAux) {
        this.tarjetaAux = tarjetaAux;
    }
    
    
    
}
