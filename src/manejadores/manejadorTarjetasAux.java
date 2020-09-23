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
import modelos.TarjetaAux;
import modelos.Usuario;

/**
 *
 * @author ricardo
 */
public class manejadorTarjetasAux extends Conectar {
        //METODO PARA REGISTRAR UN NUEVO USUARIO
     public boolean registrarTarjetaAux(TarjetaAux tarjetaAux) throws SQLException {
        PreparedStatement ps = null;
        //CONEXION A LA BASE DE DATOS
        Connection con = conectarDB();
        //CODIGO SQL PARA INGRESAR DATOS
        String sql = "INSERT INTO TarjetaAuxiliar(DPI,codigoCorrelativo,Division,Modulo,Salon,FechaImpresion,Estado) VALUES(?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tarjetaAux.getDPI());
            ps.setString(2, tarjetaAux.getCodigoCorrelativo());
            ps.setString(3, tarjetaAux.getDivision());
            ps.setString(4, tarjetaAux.getModulo());
            ps.setString(5, tarjetaAux.getSalon());
            ps.setDate(6, tarjetaAux.getFechaImpresion());
            ps.setString(7, tarjetaAux.getEstado());
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
 public void busquedaTarjetaAux(javax.swing.JTable tableAux, javax.swing.JLabel usuaris){
     PreparedStatement ps = null;
      ResultSet rs = null;
      
      try{
          Conectar objCon = new Conectar();
          Connection conn = objCon.conectarDB();
          int Fila = tableAux.getSelectedRow();
          String usuario = tableAux.getValueAt(Fila, 9).toString();
          ps = conn.prepareStatement("SELECT DPI FROM Usuario WHERE Usuario=? AND TipoUsuario=2");
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
            String sql = "SELECT * FROM Usuario WHERE "+tipoBusqueda+"= '"+buscar+"' AND TipoUsuario=2;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println(sql);
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
