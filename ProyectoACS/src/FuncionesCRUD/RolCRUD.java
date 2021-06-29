package FuncionesCRUD;

import Acceso_BD.ConeccionMYSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class RolCRUD {

  

    public void insertarRol(int id, String des) {
        try {
            ConeccionMYSQL cc = new ConeccionMYSQL();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "INSERT INTO rol VALUES (?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, des);

            //5
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Okey, se insertó correctamente");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: Contáctate con el administrador");
        }
    }

    public void borrarRol(int id) {
        try {
              ConeccionMYSQL cc = new ConeccionMYSQL();
    Connection cn = cc.conectar();
    String sql = "";
            sql = "DELETE FROM rol WHERE ID_ROL = '" + id + "'";
            PreparedStatement ps = cn.prepareStatement(sql);
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Ok, se eliminó correctamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void modificarRol(int id, String des) {
        try {
  ConeccionMYSQL cc = new ConeccionMYSQL();
    Connection cn = cc.conectar();
    String sql = "";
            sql = "UPDATE rol SET ID_ROL = '" + id + "', DES_ROL = '" + des + "'";
            PreparedStatement ps = cn.prepareStatement(sql);
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Ok, se modificó correctamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public String[] cargarRol(int id) {
        try {
              ConeccionMYSQL cc = new ConeccionMYSQL();
    Connection cn = cc.conectar();
    String sql = "";
            String registros[] = new String[2];
            sql = "SELECT * FROM usuario WHERE ID_USU LIKE '%" + id + "%'";
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("ID_ROL");
                registros[1] = rs.getString("DES_ROL");
            }
            return registros;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
}
