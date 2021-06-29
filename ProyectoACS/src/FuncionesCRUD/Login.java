/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncionesCRUD;
import Acceso_BD.ConeccionMYSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class Login {
     public String login(String USUARIO, String CONTRASENIA) {
        try {
            //1 Conectarme a la BD.
            ConeccionMYSQL cc = new ConeccionMYSQL();
            Connection cn = cc.conectar();
            //2 Crear la sentencia SQL.
            String sql = "";
            sql = "SELECT * FROM usuario WHERE ID_USU='" + USUARIO + "'AND PAS_USU='" + CONTRASENIA + "'";
            //3 Preparar la sentencia SQL.
            Statement ps = cn.createStatement();
            ResultSet rs = ps.executeQuery(sql);

            //4 Ejecutar la sentencia SQL.
            if (rs.next()) {

                String sql2 = "";
                sql2 = "SELECT * FROM USUARIOS WHERE PAS_USU='" + CONTRASENIA + "'";
                //3 Preparar la sentencia SQL.
                Statement ps1 = cn.createStatement();
                ResultSet rs2 = ps1.executeQuery(sql);

                //4 Ejecutar la sentencia SQL.
                return "Bienvenido";

            } else {
                return "CLAVE INCORRECTA";
            }

        } catch (Exception e) {
        }
        return "NO CONECTADO";
    }
}
