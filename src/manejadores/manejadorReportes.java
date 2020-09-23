/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadores;

import gui.encargadoDialog;
import gui.trasladosForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import main.Conectar;

/**
 *
 * @author ricardo
 */
public class manejadorReportes {
    
     public void logTraslados(javax.swing.JTable tableGerente,javax.swing.table.DefaultTableModel modelo){
    try{
            modelo = new DefaultTableModel();
            tableGerente.setModel(modelo);
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conectar conn = new Conectar();
            Connection con = conn.conectarDB();
            String sql = "SELECT * FROM LogTraslados;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("Encargado Anterior");
            modelo.addColumn("Encargado Nuevo");
            modelo.addColumn("Fecha Traslado");
            modelo.addColumn("Codigo Tarjeta");
            modelo.addColumn("Tipo Traslado");
                while(rs.next()){
                    Object[] filas  = new Object[cantidadColumnas];
                        for (int i = 0; i < cantidadColumnas; i++) {
                            filas[i] = rs.getObject(i + 1);
                        }
                    modelo.addRow(filas);
                }
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
          
          info.informacionUsuario(nombre,apellido,DPI,fechaNacimiento,cargo,profesion,divisionU,moduloTrabajo,tipoUsuario,usuario);
          info.setVisible(true);
    }
}
