package FuncionesCRUD;

import Acceso_BD.ConeccionMYSQL;
import Acceso_BD.Consultas;
import Interfaces.Rol;
import Objetos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioCRUD {

    public void insertarUsuario(int id, String cedula, String nombre, String apellido,
            String telefono, String correo, String direccion, String contraseña, String rol) {
        try {
            ConeccionMYSQL cc = new ConeccionMYSQL();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "INSERT INTO usuario VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, cedula);
            ps.setString(3, nombre);
            ps.setString(4, apellido);
            ps.setString(5, telefono);
            ps.setString(6, correo);
            ps.setString(7, direccion);
            ps.setString(8, contraseña);
            ps.setString(9, rol);
            //5
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Okey, se insertó correctamente");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Contáctate con el administrador");
        }
    }

    public void borrarUsuario(int id) {
        try {
            ConeccionMYSQL cc = new ConeccionMYSQL();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "DELETE FROM usuario WHERE ID_USU = '" + id + "'";
            PreparedStatement ps = cn.prepareStatement(sql);
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Ok, se eliminó correctamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void modificarEstudiante(int id, String cedula, String nombre, String apellido,
            String telefono, String correo, String direccion, String contraseña, String rol) {
        try {
            ConeccionMYSQL cc = new ConeccionMYSQL();
            Connection cn = cc.conectar();
            String sql = "";

            sql = "UPDATE usuario SET ID_USU = '" + id
                    + "', CED_USU = '" + cedula
                    + "', NOM_USU = '" + nombre
                    + "', APE_USU = '" + apellido
                    + "', TEL_USU = '" + telefono
                    + "', COR_USU = '" + correo
                    + "', DIR_USU = '" + direccion
                    + "', PAS_USU = '" + contraseña
                    + "WHERE ID_ROL_PER = '" + rol + "'";
            PreparedStatement ps = cn.prepareStatement(sql);
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Ok, se modificó correctamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /*
    public String[] cargarUsuarios(int id) {
        try {
            ConeccionMYSQL cc = new ConeccionMYSQL();
            Connection cn = cc.conectar();
            String sql = "";
            String registros[] = new String[9];
            sql = "SELECT * FROM usuario WHERE ID_USU LIKE '%" + id + "%'";
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while (rs.next()) {
                Usuario user= new Usuario();
                registros[0] = rs.getString("ID_USU");
                registros[1] = rs.getString("CED_USU");
                registros[2] = rs.getString("NOM_USU");
                registros[3] = rs.getString("APE_USU");
                registros[4] = rs.getString("TEL_USU");
                registros[5] = rs.getString("COR_USU");
                registros[6] = rs.getString("DIR_USU");
                registros[7] = rs.getString("PAS_USU");
                registros[8] = rs.getString("ID_ROL_PER");
            }
            return registros;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
     */
    public List<Usuario> cargarUsuarios(int id) {
        List<Usuario> Usuarios = new ArrayList<>();
        try {
            ConeccionMYSQL cc = new ConeccionMYSQL();
            Connection cn = cc.conectar();
            String sql = "";

            sql = "SELECT * FROM usuario WHERE ID_USU LIKE '%" + id + "%'";
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while (rs.next()) {

                Usuario user = new Usuario();
                user.setId(rs.getInt("ID_USU"));
                user.setCedula(rs.getString("CED_USU"));
                user.setNombre(rs.getString("NOM_USU"));
                user.setApellido(rs.getString("APE_USU"));
                user.setTelefono(rs.getString("TEL_USU"));
                user.setCorreo(rs.getString("COR_USU"));
                user.setDireccion(rs.getString("DIR_USU"));
                user.setContraseña(rs.getString("PAS_USU"));
               
            }
            return Usuarios;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

}
