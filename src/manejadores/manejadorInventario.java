/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadores;

import gui.bienDialog;
import gui.encargadoDialog;
import gui.infoDialog;
import gui.trasladosForm;
import static gui.trasladosForm.dpiNuevoText;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import main.Conectar;

/**
 *
 * @author ricardo
 */
public class manejadorInventario {
    
    
    public void verInfo(String codigoTarjeta){
      infoDialog info = new infoDialog();
      PreparedStatement ps = null;
      ResultSet rs = null;
      
      PreparedStatement psU = null;
      ResultSet rsU = null;
      
      String codigoTarjetaR,codigoTarjetaRA,division = null,modulo = null,salon = null,fechaImpresion = null,estado = null;
      String nombre = null,apellido = null,DPI = null,fechaNacimiento = null,cargo = null,profesion = null,divisionU = null,moduloTrabajo = null,tipoUsuario = null,usuario = null;
      try{
          Conectar objCon = new Conectar();
          Connection conn = objCon.conectarDB();
          if (codigoTarjeta.contains("A")) {
              codigoTarjetaR = codigoTarjeta.replaceAll("A", "");
              ps = conn.prepareStatement("SELECT * FROM Tarjeta WHERE codigoCorrelativo=?");
              ps.setString(1, codigoTarjetaR);
              rs = ps.executeQuery();
              while(rs.next()){
                DPI = rs.getString("DPI");
                codigoTarjetaR = rs.getString("codigoCorrelativo");
                division = rs.getString("Division");
                modulo = rs.getString("Modulo");
                salon = rs.getString("Salon");
                fechaImpresion = rs.getString("FechaImpresion");
                estado = rs.getString("Estado");
              }
              info.informacionTarjeta(DPI, codigoTarjetaR, division, modulo,salon,fechaImpresion,estado );
          }else if(codigoTarjeta.contains("B")){
              codigoTarjetaRA = codigoTarjeta.replaceAll("B", "");
              ps = conn.prepareStatement("SELECT * FROM TarjetaAuxiliar WHERE codigoCorrelativo=?");
              ps.setString(1, codigoTarjetaRA);
              rs = ps.executeQuery();
              while(rs.next()){
                DPI = rs.getString("DPI");
                codigoTarjetaR = rs.getString("codigoCorrelativo");
                division = rs.getString("Division");
                modulo = rs.getString("Modulo");
                salon = rs.getString("Salon");
                fechaImpresion = rs.getString("FechaImpresion");
                estado = rs.getString("Estado");
              }
               info.informacionTarjeta(DPI, codigoTarjetaRA, division, modulo,salon,fechaImpresion,estado );
          }
                    
            

          psU = conn.prepareStatement("SELECT * FROM Usuario WHERE DPI=?");
          psU.setString(1, DPI);
          rsU = psU.executeQuery();  
          while(rsU.next()){
                nombre = rsU.getString("Nombre");
                apellido = rsU.getString("Apellido");
                DPI = rsU.getString("DPI");
                fechaNacimiento = rsU.getString("FechaNacimiento");
                cargo = rsU.getString("Cargo");
                profesion = rsU.getString("Profesion");
                divisionU = rsU.getString("Division");
                moduloTrabajo = rsU.getString("ModuloTrabajo");
                tipoUsuario = rsU.getString("TipoUsuario");
                usuario = rsU.getString("Usuario");
            }      
          info.informacionUsuario(nombre,apellido,DPI,fechaNacimiento,cargo,profesion,divisionU,moduloTrabajo,tipoUsuario,usuario);
          info.setVisible(true);
      }catch(SQLException e){
      
      }
    }

    public void verInfoEncargado(String dpi) throws SQLException{
      encargadoDialog info = new encargadoDialog();
      
      String nombre = null,apellido = null,DPI = null,fechaNacimiento = null,cargo = null,profesion = null,divisionU = null,moduloTrabajo = null,tipoUsuario = null,usuario = null;
      
      PreparedStatement psU = null;
      ResultSet rsU = null;
      Conectar objCon = new Conectar();
      Connection conn = objCon.conectarDB();
        psU = conn.prepareStatement("SELECT * FROM Usuario WHERE DPI=?");
          psU.setString(1, dpi);
          rsU = psU.executeQuery();  

          while(rsU.next()){
                nombre = rsU.getString("Nombre");
                apellido = rsU.getString("Apellido");
                DPI = rsU.getString("DPI");
                fechaNacimiento = rsU.getString("FechaNacimiento");
                cargo = rsU.getString("Cargo");
                profesion = rsU.getString("Profesion");
                divisionU = rsU.getString("Division");
                moduloTrabajo = rsU.getString("ModuloTrabajo");
                tipoUsuario = rsU.getString("TipoUsuario");
                usuario = rsU.getString("Usuario");
            }      
          if (tipoUsuario.equals("1")) {
              trasladosForm.dpiLabel.setText(DPI);
              trasladosForm.nombreLabel.setText(nombre);
          }else{
              trasladosForm.dpiAuxLabel.setText(DPI);
              trasladosForm.nombreAuxLabel.setText(nombre);
          }   
          info.informacionUsuario(nombre,apellido,DPI,fechaNacimiento,cargo,profesion,divisionU,moduloTrabajo,tipoUsuario,usuario);
          info.setVisible(true);
    }
    
    public void verInfoBien(String codigoTarjeta) throws SQLException{
    bienDialog info = new bienDialog();
      String nombre = null,unidadAcademica = null,codigoTipoBien = null,adquisicion = null,
             costo = null,estado = null,cuenta = null,tarjeta = null,tarjetaAux = null;
      
      PreparedStatement psU = null;
      ResultSet rsU = null;
      Conectar objCon = new Conectar();
      Connection conn = objCon.conectarDB();
        psU = conn.prepareStatement("SELECT * FROM Bien WHERE Tarjeta_codigoCorrelativo=?");
          psU.setString(1, codigoTarjeta);
          rsU = psU.executeQuery();  

          while(rsU.next()){
                nombre = rsU.getString("Nombre");
                unidadAcademica = rsU.getString("UnidadAcademica");
                codigoTipoBien = rsU.getString("CodigoTipoBien");
                adquisicion = rsU.getString("Adquision");
                costo = rsU.getString("Costo");
                estado = rsU.getString("Estado");
                cuenta = rsU.getString("Cuenta");
                tarjeta = rsU.getString("Tarjeta_codigoCorrelativo");
                tarjetaAux = rsU.getString("Tarjeta_codigoCorrelativo");
            }      
          info.informacionBien(nombre,unidadAcademica,codigoTipoBien,adquisicion,costo,estado,cuenta,tarjeta,tarjetaAux);
          info.setVisible(true);
    }
    
    public void buscarEncargado(String dpi) throws SQLException{
      encargadoDialog info = new encargadoDialog();
      
      String nombre = null,apellido = null,DPI = null,fechaNacimiento = null,cargo = null,profesion = null,divisionU = null,moduloTrabajo = null,tipoUsuario = null,usuario = null;
      
      PreparedStatement psU = null;
      ResultSet rsU = null;
      Conectar objCon = new Conectar();
      Connection conn = objCon.conectarDB();
        psU = conn.prepareStatement("SELECT * FROM Usuario WHERE DPI=?");
          psU.setString(1, dpi);
          rsU = psU.executeQuery();  

          while(rsU.next()){
                nombre = rsU.getString("Nombre");
                apellido = rsU.getString("Apellido");
                DPI = rsU.getString("DPI");
                fechaNacimiento = rsU.getString("FechaNacimiento");
                cargo = rsU.getString("Cargo");
                profesion = rsU.getString("Profesion");
                divisionU = rsU.getString("Division");
                moduloTrabajo = rsU.getString("ModuloTrabajo");
                tipoUsuario = rsU.getString("TipoUsuario");
                usuario = rsU.getString("Usuario");
            }      
          if (tipoUsuario==null) {
            JOptionPane.showMessageDialog(null, "El DPI ingresado NO esta registrado en la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            trasladosForm.dpiNuevoText.setText("");
          }else{
            if (tipoUsuario.equals("1")) {
                trasladosForm.dpiNuevoText.setText(DPI);
                trasladosForm.nombreNuevoLabel.setText(nombre);
                info.informacionUsuario(nombre,apellido,DPI,fechaNacimiento,cargo,profesion,divisionU,moduloTrabajo,tipoUsuario,usuario);
                info.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "El DPI ingresado no corresponde a un Encargado Titular", "ERROR", JOptionPane.ERROR_MESSAGE);
                trasladosForm.dpiNuevoText.setText("");
            }     
          } 
    }
    
    public void buscarEncargadoAux(String dpi) throws SQLException{
      encargadoDialog info = new encargadoDialog();
      
      String nombre = null,apellido = null,DPI = null,fechaNacimiento = null,cargo = null,profesion = null,divisionU = null,moduloTrabajo = null,tipoUsuario = null,usuario = null;
      
      PreparedStatement psU = null;
      ResultSet rsU = null;
      Conectar objCon = new Conectar();
      Connection conn = objCon.conectarDB();
        psU = conn.prepareStatement("SELECT * FROM Usuario WHERE DPI=?");
          psU.setString(1, dpi);
          rsU = psU.executeQuery();  

          while(rsU.next()){
                nombre = rsU.getString("Nombre");
                apellido = rsU.getString("Apellido");
                DPI = rsU.getString("DPI");
                fechaNacimiento = rsU.getString("FechaNacimiento");
                cargo = rsU.getString("Cargo");
                profesion = rsU.getString("Profesion");
                divisionU = rsU.getString("Division");
                moduloTrabajo = rsU.getString("ModuloTrabajo");
                tipoUsuario = rsU.getString("TipoUsuario");
                usuario = rsU.getString("Usuario");
            }      
          if (tipoUsuario == null) {
              JOptionPane.showMessageDialog(null, "El DPI ingresado NO esta registrado en la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
              trasladosForm.dpiNuevoAuxText.setText("");
          }else{
              if (tipoUsuario.equals("2")) {
                trasladosForm.dpiNuevoAuxText.setText(DPI);
                trasladosForm.nombreNuevoLabel1.setText(nombre);
                info.informacionUsuario(nombre,apellido,DPI,fechaNacimiento,cargo,profesion,divisionU,moduloTrabajo,tipoUsuario,usuario);
                info.setVisible(true);
              }else{
                JOptionPane.showMessageDialog(null, "El DPI ingresado no corresponde a un Encargado Auxiliar", "ERROR", JOptionPane.ERROR_MESSAGE);
                trasladosForm.dpiNuevoAuxText.setText("");
             }   
          }
          
    }
    
    public void trasladoEncargado(String dpi, String nuevoDpi,String codigoTarjeta,int tipo) throws SQLException{
        if (dpi.equals(nuevoDpi)) {
           JOptionPane.showMessageDialog(null, "No puedo hacer un traslado entre el mismo encargado.", "ALERTA", JOptionPane.WARNING_MESSAGE);
        }else{
            PreparedStatement ps = null;
             PreparedStatement psL = null;
            //CONEXION A LA BASE DE DATOS
            Conectar objCon = new Conectar();
            Connection con = objCon.conectarDB();
            //CODIGO SQL PARA INGRESAR DATOS
            String sqlE = "UPDATE Tarjeta SET DPI='"+nuevoDpi+"' WHERE codigoCorrelativo='"+codigoTarjeta+"'";
            String sqlEA = "UPDATE TarjetaAuxiliar SET DPI='"+nuevoDpi+"' WHERE codigoCorrelativo='"+codigoTarjeta+"'";
            String log = "INSERT INTO LogTraslados(dpiViejo,dpiNuevo,fechaTraslado,codigoTarjeta,TrasladoDe) VALUES(?,?,?,?,?)";
        try {
                java.util.Date dateIngreso =  new java.util.Date();
                long di = dateIngreso.getTime();
                java.sql.Date fechaIngreso = new java.sql.Date(di);
                if (tipo==1) {
                    ps = con.prepareStatement(sqlE);
                    psL = con.prepareStatement(log);
                    psL.setString(1, dpi);
                    psL.setString(2, nuevoDpi);
                    psL.setDate(3, fechaIngreso);
                    psL.setString(4, codigoTarjeta);
                    psL.setString(5, "Tarjeta Responsabilidad");
                }else{
                    ps = con.prepareStatement(sqlEA);
                    psL = con.prepareStatement(log);
                    psL.setString(1, dpi);
                    psL.setString(2, nuevoDpi);
                    psL.setDate(3, fechaIngreso);
                    psL.setString(4, codigoTarjeta);
                    psL.setString(5, "Tarjeta Responsabilidad Auxiliar");
                }
                ps.execute();
                psL.execute();

                JOptionPane.showMessageDialog(null, "TRASLADO REALIZADO CON EXITO", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException e) {

                } finally {
                    try {
                        con.close();
                    } catch (SQLException e) {

                    }
                } 
        }
        
    }
    
    public void imprimirPDF(){
        
    }    
}
