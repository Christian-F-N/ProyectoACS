/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_BD;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author HP
 */
public class Modificar {
  public String modificarRol(int id, String descripcion) {
       try {
            ConeccionMYSQL cc = new ConeccionMYSQL();
            Connection cn = cc.conectar();
            String sql = "";
            sql = "UPDATE rol SET DES_ROL ='"+descripcion+"' WHERE ID_ROL ='"+id+"'";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.executeUpdate();
           
            return "1";
        } catch (Exception e) {
            return null;
        }
       
    } 

}
