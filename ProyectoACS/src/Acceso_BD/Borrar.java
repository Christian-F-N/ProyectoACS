/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Borrar {
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
    public void borrarAsiento(int id) {
        try {
            ConeccionMYSQL cc = new ConeccionMYSQL();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "DELETE FROM asiento WHERE ID_ASI  = '" + id + "'";
            PreparedStatement ps = cn.prepareStatement(sql);
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Ok, se eliminó correctamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void borrarBus(int id) {
    try {
            ConeccionMYSQL cc = new ConeccionMYSQL();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "DELETE FROM bus WHERE ID_BUS  = '" + id + "'";
            PreparedStatement ps = cn.prepareStatement(sql);
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Ok, se eliminó correctamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void borrarCiudad(int id) {
        try {
            ConeccionMYSQL cc = new ConeccionMYSQL();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "DELETE FROM ciudad WHERE ID_CIU = '" + id + "'";
            PreparedStatement ps = cn.prepareStatement(sql);
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Ok, se eliminó correctamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void borrarCliente(int id) {
        try {
            ConeccionMYSQL cc = new ConeccionMYSQL();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "DELETE FROM cliente WHERE ID_CLI  = '" + id + "'";
            PreparedStatement ps = cn.prepareStatement(sql);
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Ok, se eliminó correctamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void borrarCooperativa(int id) {
        try {
            ConeccionMYSQL cc = new ConeccionMYSQL();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "DELETE FROM cooperativa  WHERE ID_COP  = '" + id + "'";
            PreparedStatement ps = cn.prepareStatement(sql);
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Ok, se eliminó correctamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
      
    }
    public void borrarReserva(int id) {
        try {
            ConeccionMYSQL cc = new ConeccionMYSQL();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "DELETE FROM reserva  WHERE ID_RES  = '" + id + "'";
            PreparedStatement ps = cn.prepareStatement(sql);
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Ok, se eliminó correctamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void borrarRol(int id) {
        try {
            ConeccionMYSQL cc = new ConeccionMYSQL();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "DELETE FROM rol WHERE ID_ROL  = '" + id + "'";
            PreparedStatement ps = cn.prepareStatement(sql);
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Ok, se eliminó correctamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void borrarRuta(int id) {
        try {
            ConeccionMYSQL cc = new ConeccionMYSQL();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "DELETE FROM ruta WHERE ID_RUT  = '" + id + "'";
            PreparedStatement ps = cn.prepareStatement(sql);
            int n = ps.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Ok, se eliminó correctamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    
    
}
