
package manejadores;

import modelos.Usuario;
import main.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ricardo
 */
public class manejadorLogin extends Conectar{
    
    public boolean loginUsuario(Usuario usuario) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        //CONEXION A LA BASE DE DATOS
        Connection con = conectarDB();
        //CODIGO SQL PARA INGRESAR DATOS
        String sql = "SELECT * FROM Usuario WHERE Usuario=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            rs = ps.executeQuery();
            
                if (rs.next()) {
                    if (usuario.getPassword().equals(rs.getString(11)) && rs.getString(9).equals("0")) {
                        usuario.setNombre(rs.getString(1));
                        usuario.setApellido(rs.getString(2));
                        usuario.setProfesion(rs.getString(3));
                        usuario.setUsuario(rs.getString(4));
                        return true;
                    }
                }else{
                    return false;
                }
                return false;
        }catch(SQLException e){
            return false;
        }
    }
   
}
