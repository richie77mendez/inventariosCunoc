/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadores;

import modelos.Usuario;
import main.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ricardo
 */
public class manejadorUsuario extends Conectar {

    //METODO PARA REGISTRAR UN NUEVO USUARIO
    public boolean registrarGerente(Usuario gerente,DefaultTableModel tableGerente,javax.swing.JTextField nombreText,
            javax.swing.JTextField apellidoText,javax.swing.JTextField dpiText, Date fechaNacimiento,
            javax.swing.JTextField cargoText, javax.swing.JTextField profesionText, javax.swing.JComboBox divisionText,
            javax.swing.JComboBox moduloText, javax.swing.JComboBox tipoUsuarioText, javax.swing.JTextField usuarioText,
            javax.swing.JTextField passText) throws SQLException {
        PreparedStatement ps = null;
        //CONEXION A LA BASE DE DATOS
        Connection con = conectarDB();
        //CODIGO SQL PARA INGRESAR DATOS
        String sql = "INSERT INTO Usuario(Nombre, Apellido, DPI, FechaNacimiento,Cargo, Profesion, Division,ModuloTrabajo,TipoUsuario,Usuario, Password) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, gerente.getNombre());
            ps.setString(2, gerente.getApellido());
            ps.setString(3, gerente.getDPI());
            ps.setDate(4, gerente.getFechaNacimiento());
            ps.setString(5, gerente.getCargo());
            ps.setString(6, gerente.getProfesion());
            ps.setString(7, gerente.getDivision());
            ps.setString(8, gerente.getModuloTrabajo());
            ps.setInt(9, gerente.getTipoUsuario());
            ps.setString(10, gerente.getUsuario());
            ps.setString(11, gerente.getPassword());
            ps.execute();
            
            Object[] fila = new Object[11];
            fila[0] = nombreText.getText();
            fila[1] = apellidoText.getText();
            fila[2] = dpiText.getText();
            fila[3] = fechaNacimiento.getDate();
            fila[4] = cargoText.getText();
            fila[5] = profesionText.getText();
            fila[6] = divisionText.getSelectedItem();
            fila[7] = moduloText.getSelectedItem();
            fila[8] = tipoUsuarioText.getSelectedItem();
            fila[9] = usuarioText.getText();
            fila[10] = passText.getText();
            tableGerente.addRow(fila);
            JOptionPane.showMessageDialog(null, "USUARIO CREADO");
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
    public void busquedaGerente(javax.swing.JTable tableGerente, javax.swing.JTextField nombreText,
            javax.swing.JTextField apellidoText,javax.swing.JTextField dpiText, Date fechaNacimiento,
            javax.swing.JTextField cargoText, javax.swing.JTextField profesionText, javax.swing.JComboBox divisionText,
            javax.swing.JComboBox moduloText, javax.swing.JComboBox tipoUsuarioText, javax.swing.JTextField usuarioText,
            javax.swing.JTextField passText, javax.swing.JLabel usuaris){
     PreparedStatement ps = null;
      ResultSet rs = null;
      
      try{
          Conectar objCon = new Conectar();
          Connection conn = objCon.conectarDB();
          int Fila = tableGerente.getSelectedRow();
          String usuario = tableGerente.getValueAt(Fila, 9).toString();
          ps = conn.prepareStatement("SELECT * FROM Usuario WHERE Usuario=?");
          ps.setString(1, usuario);
          rs = ps.executeQuery();
          
            while(rs.next()){
                nombreText.setText(rs.getString("Nombre"));
                apellidoText.setText(rs.getString("Apellido"));
                dpiText.setText(rs.getString("DPI"));
                cargoText.setText("Cargo");
                profesionText.setText(rs.getString("Profesion"));
                divisionText.setSelectedItem(rs.getString("Division"));
                moduloText.setSelectedItem(rs.getString("ModuloTrabajo"));
                tipoUsuarioText.setSelectedIndex(rs.getInt("TipoUsuario"));
                usuarioText.setText(rs.getString("Usuario"));
                usuaris.setText(rs.getString("Usuario"));
                passText.setText(rs.getString("Password"));
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
            String sql = "SELECT * FROM Usuario WHERE "+tipoBusqueda+"= '"+buscar+"';";
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

}


