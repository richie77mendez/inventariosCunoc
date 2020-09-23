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
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import main.Conectar;
import modelos.Bien;

/**
 *
 * @author ricardo
 */
public class manejadorBienes extends Conectar{
        //METODO PARA REGISTRAR UN NUEVO USUARIO
    public boolean registrarBien(Bien bien,DefaultTableModel tableGerente) throws SQLException {
        PreparedStatement ps = null;
        //CONEXION A LA BASE DE DATOS
        Connection con = conectarDB();
        //CODIGO SQL PARA INGRESAR DATOS
        String sql = "INSERT INTO Bien(Nombre,UnidadAcademica,CodigoTipoBien,Adquision,Costo,Estado,Cuenta, Tarjeta_codigoCorrelativo,TarjetaAuxiliar_codigoCorrelativo) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, bien.getNombre());
            ps.setString(2, bien.getUnidadAcademica());
            ps.setString(3, bien.getCodigoTipoBien());
            ps.setString(4, bien.getAdquision());
            ps.setDouble(5, bien.getCosto());
            ps.setString(6, bien.getEstado());
            ps.setString(7, bien.getCuenta());
            ps.setString(8, bien.getTarjeta());
            ps.setString(9, bien.getTarjetaAux());
            ps.execute();
            
            Object[] fila = new Object[11];
            fila[0] = bien.getNombre();
            fila[1] = bien.getUnidadAcademica();
            fila[2] = bien.getCodigoTipoBien();
            fila[3] = bien.getAdquision();
            fila[4] = bien.getCosto();
            fila[5] = bien.getEstado();
            fila[6] = bien.getCuenta();
            fila[7] = bien.getTarjeta();
            fila[8] = bien.getTarjetaAux();
            tableGerente.addRow(fila);
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

    //METODO PARA ELIMINAR UN GERENTE
    public boolean eliminarGerente(javax.swing.JTable tableGerente, DefaultTableModel modelo) throws SQLException {
        PreparedStatement ps = null;
        //CONEXION A LA BASE DE DATOS
        
        Connection con = conectarDB();
        //CODIGO SQL PARA INGRESAR DATOS
        int Fila = tableGerente.getSelectedRow();
        String usuario = tableGerente.getValueAt(Fila, 9).toString();
        
        String sql = "DELETE FROM Usuario WHERE Usuario=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.execute();
            modelo.removeRow(Fila);
            JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO");
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
            String sql = "SELECT * FROM Bien WHERE "+tipoBusqueda+"= '"+buscar+"'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            modelo.addColumn("Nombre");
            modelo.addColumn("Unidad Academica");
            modelo.addColumn("Codigo Bien");
            modelo.addColumn("Adquisicion");
            modelo.addColumn("Costo");
            modelo.addColumn("Estado");
            modelo.addColumn("Cuenta");
            modelo.addColumn("Tarjeta R");
            modelo.addColumn("Tarjeta RA");
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
}
