/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.Conectar;
import modelos.Tarjeta;
import modelos.Usuario;

/**
 *
 * @author ricardo
 */
public class manejadorTarjetas extends Conectar{
        //METODO PARA REGISTRAR UN NUEVO USUARIO
    public boolean registrarTarjeta(Tarjeta tarjeta) throws SQLException {
        PreparedStatement ps = null;
        //CONEXION A LA BASE DE DATOS
        Connection con = conectarDB();
        //CODIGO SQL PARA INGRESAR DATOS
        String sql = "INSERT INTO Tarjeta(DPI,codigoCorrelativo,Division,Modulo,Salon,FechaImpresion,Estado) VALUES(?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tarjeta.getDPI());
            ps.setString(2, tarjeta.getCodigoCorrelativo());
            ps.setString(3, tarjeta.getDivision());
            ps.setString(4, tarjeta.getModulo());
            ps.setString(5, tarjeta.getSalon());
            ps.setDate(6, tarjeta.getFechaImpresion());
            ps.setString(7, tarjeta.getEstado());
            ps.execute();

            return true;
        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println("error: " + e);
            }
        }
    }

    //METODO PARA PODER MODIFICAR LOS DATOS DE UN GERENTE
    public boolean modificarGerente(String nombre, String apellido, String DPI, Date FechaNacimiento,
            String cargo, String profesion, String division, String moduloTrabajo, int tipoUsuario,
            String password, String nuevoUsuario, String usuario) throws SQLException {
        PreparedStatement ps = null;
        //CONEXION A LA BASE DE DATOS
        Connection con = conectarDB();
        //CODIGO SQL PARA INGRESAR DATOS
        String sql = "UPDATE Usuario SET Nombre='"+nombre+"', Apellido='"+apellido+"', DPI='"+DPI+
                "', FechaNacimiento='"+FechaNacimiento+"', Cargo='"+cargo+"', Profesion='"+profesion+
                "', Division='"+division+"', ModuloTrabajo='"+moduloTrabajo+"', TipoUsuario='"+tipoUsuario+
                "',Usuario='"+nuevoUsuario+"', Password='"+password+"' WHERE Usuario='"+usuario+"'";
        try {
            ps = con.prepareStatement(sql);
          
            ps.execute();

            JOptionPane.showMessageDialog(null, "USUARIO MODIFICADO");
            return true;
        } catch (SQLException e) {
            System.err.println("ERROR: " + e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println("error: " + e);
            }
        }
    }

    

    //METODO PARA REALIZAR UNA BUSQUEDA DE DATOS EN LA DATA BASE
public void busquedaTarjeta(javax.swing.JTable tableEncargado, javax.swing.JLabel usuaris){
     PreparedStatement ps = null;
      ResultSet rs = null;
      
      try{
          Conectar objCon = new Conectar();
          Connection conn = objCon.conectarDB();
          int Fila = tableEncargado.getSelectedRow();
          String usuario = tableEncargado.getValueAt(Fila, 9).toString();
          ps = conn.prepareStatement("SELECT DPI FROM Usuario WHERE Usuario=? AND TipoUsuario=1");
          ps.setString(1, usuario);
          rs = ps.executeQuery();
          
            while(rs.next()){
                usuaris.setText(rs.getString("DPI"));
            }
      }catch(SQLException e){
      
      }
    }  
public void filtraciones(javax.swing.JTable tableGerente,javax.swing.table.DefaultTableModel modelo, String tipoBusqueda, Object buscar){
    try{
            modelo = new DefaultTableModel();
            tableGerente.setModel(modelo);
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conectar conn = new Conectar();
            Connection con = conn.conectarDB();
            String sql = "SELECT * FROM Usuario WHERE "+tipoBusqueda+"= '"+buscar+"' AND TipoUsuario=1;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("DPI");
            modelo.addColumn("Fecha Nacimiento");
            modelo.addColumn("Cargo");
            modelo.addColumn("Profesion");
            modelo.addColumn("Division");
            modelo.addColumn("Modulo");
            modelo.addColumn("Tipo");
            modelo.addColumn("Usuario");
            modelo.addColumn("Password");
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
public String codigoTarjeta(){
     PreparedStatement ps = null;
      ResultSet rs = null;
      
      try{
          Conectar objCon = new Conectar();
          Connection con = conectarDB();
          String sql= ("SELECT codigoCorrelativo FROM Tarjeta ORDER BY codigoCorrelativo DESC LIMIT 1");
          ps = con.prepareStatement(sql);
          rs = ps.executeQuery();
          
            while(rs.next()){
                int codigo = Integer.parseInt(rs.getString("codigoCorrelativo"));
                codigo++;
                String codigoNuevo = String.valueOf(codigo);
                return codigoNuevo;
            }
      }catch(SQLException e){
      
      }
        return null;
}
public static Date getDate() {
    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
    Date now = new Date();
    return now;
}
}
