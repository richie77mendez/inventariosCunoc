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
public class Usuario{
    private String Nombre;
    private String Apellido;
    private String DPI;
    private Date fechaNacimiento;
    private String cargo;
    private String Profesion;
    private String division;
    private String moduloTrabajo;
    private int tipoUsuario;
    private String usuario;
    private String password;

    public Usuario(){}
    
    public Usuario(String Nombre, String Apellido, String DPI, Date fechaNacimiento, String cargo, String Profesion, String division, String moduloTrabajo, int tipoUsuario, String usuario, String password) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DPI = DPI;
        this.fechaNacimiento = fechaNacimiento;
        this.cargo = cargo;
        this.Profesion = Profesion;
        this.division = division;
        this.moduloTrabajo = moduloTrabajo;
        this.tipoUsuario = tipoUsuario;
        this.usuario = usuario;
        this.password = password;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getDPI() {
        return DPI;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCargo() {
        return cargo;
    }

    public String getProfesion() {
        return Profesion;
    }

    public String getDivision() {
        return division;
    }

    public String getModuloTrabajo() {
        return moduloTrabajo;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setProfesion(String Profesion) {
        this.Profesion = Profesion;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public void setModuloTrabajo(String moduloTrabajo) {
        this.moduloTrabajo = moduloTrabajo;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    



   
    
}
