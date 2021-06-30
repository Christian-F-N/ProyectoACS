/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso_BD;

import Objetos.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio
 */
public class Consultas {

    ResultSet datos, dato;
    Statement st;
    Connection cn;

    public Consultas() {
        ConeccionMYSQL con = new ConeccionMYSQL();
        cn = con.conectar();
    }

    public ArrayList<Cooperativa> consultarCooperativas() {
        ArrayList<Cooperativa> cops = new ArrayList();
        String consulta = "Select * from Cooperativa";
        Cooperativa cop;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
            while (datos.next()) {
                cop = new Cooperativa();
                cop.setId(datos.getInt(1));
                cop.setNombre(datos.getString(2));
                cop.setRUC(datos.getString(3));
                cop.setDireccion(datos.getString(4));
                cop.setTelefono(datos.getString(5));
                cop.setCorreo(datos.getString(6));

                cops.add(cop);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cops;
    }

    public ArrayList<Bus> consultarBuses() {
        ArrayList<Bus> buss = new ArrayList();
        String consulta = "Select * from Bus";
        Bus bus;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
            while (datos.next()) {
                bus = new Bus();
                bus.setId(datos.getInt(1));
                bus.setPlaca(datos.getString(2));
                bus.setAño(datos.getInt(3));
                bus.setMarca(datos.getString(4));
                bus.setCoopetativa(new Consultas().consultarCooperativa(datos.getInt(5)));

                buss.add(bus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return buss;
    }

    public ArrayList<Asiento> consultarAsientos() {
        ArrayList<Asiento> asis = new ArrayList();
        String consulta = "Select * from asiento";
        Asiento asi;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
            while (datos.next()) {
                asi = new Asiento();
                asi.setId(datos.getInt(1));
                asi.setNumero(datos.getString(2));
                asi.setUbicacion(datos.getString(3));
                asi.setBus(new Consultas().consultarBus(datos.getInt(4)));

                asis.add(asi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asis;
    }

    public ArrayList<Rol> consultarRoles() {
        ArrayList<Rol> rols = new ArrayList();
        String consulta = "Select * from rol";
        Rol rol;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
            while (datos.next()) {
                rol = new Rol();
                rol.setId(datos.getInt(1));
                rol.setDescripcion(datos.getString(2));

                rols.add(rol);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rols;
    }

    public ArrayList<Usuario> consultarUsuarios() {
        ArrayList<Usuario> usus = new ArrayList();
        String consulta = "Select * from usuario";
        Usuario usu;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
            while (datos.next()) {
                usu = new Usuario();
                usu.setId(datos.getInt(1));
                usu.setCedula(datos.getString(2));
                usu.setNombre(datos.getString(3));
                usu.setApellido(datos.getString(4));
                usu.setTelefono(datos.getString(5));
                usu.setCorreo(datos.getString(6));
                usu.setDireccion(datos.getString(7));
                usu.setContraseña(datos.getString(8));
                usu.setRol(new Consultas().consultarRol(datos.getInt(9)));

                usus.add(usu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usus;
    }

    public ArrayList<Ciudad> consultarCiudades() {
        ArrayList<Ciudad> cius = new ArrayList();
        String consulta = "Select * from ciudad";
        Ciudad ciu;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
            while (datos.next()) {
                ciu = new Ciudad();
                ciu.setId(datos.getInt(1));
                ciu.setNombre(datos.getString(2));
                ciu.setCodigoPostal(datos.getString(3));

                cius.add(ciu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cius;
    }

    public ArrayList<Ruta> consultarRutas() {
        ArrayList<Ruta> ruts = new ArrayList();
        String consulta = "Select * from ruta";
        Ruta rut;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
            while (datos.next()) {
                rut = new Ruta();
                rut.setId(datos.getInt(1));
                rut.setCiudadOrigen(new Consultas().consultarCiudad(datos.getInt(2)));
                rut.setCiudadDestino(new Consultas().consultarCiudad(datos.getInt(3)));
                rut.setFechaHoraSalida(datos.getDate(4));
                rut.setFechaHoraLlegada(datos.getDate(5));
                rut.setPrecioPasaje(datos.getDouble(6));
                rut.setEstado(datos.getString(7));
                rut.setBus(new Consultas().consultarBus(datos.getInt(8)));
                rut.setUsuario(new Consultas().consultarUsuario(datos.getInt(9)));

                ruts.add(rut);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ruts;
    }

    public ArrayList<Cliente> consultarClientes() {
        ArrayList<Cliente> clis = new ArrayList();
        String consulta = "Select * from cliente";
        Cliente cli;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
            while (datos.next()) {
                cli = new Cliente();
                cli.setId(datos.getInt(1));
                cli.setCedula(datos.getString(2));
                cli.setNombre(datos.getString(3));
                cli.setApellido(datos.getString(4));
                cli.setTelefono(datos.getString(5));
                cli.setCorreo(datos.getString(6));
                cli.setDireccion(datos.getString(7));
                cli.setContraseña(datos.getString(8));

                clis.add(cli);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clis;
    }

    public ArrayList<Reserva> consultarReservas() {
        ArrayList<Reserva> ress = new ArrayList();
        String consulta = "Select * from reserva";
        Reserva res;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
            while (datos.next()) {
                res = new Reserva();
                res.setId(datos.getInt(1));
                res.setRuta(new Consultas().consultarRuta(datos.getInt(2)));
                res.setCliente(new Consultas().consultarCliente(datos.getInt(3)));
                res.setAsiento(new Consultas().consultarAsiento(datos.getInt(4)));
                res.setEstado(datos.getString(5));

                ress.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ress;
    }

    public ArrayList<Cooperativa> consultarCooperativas(String condicion) {
        ArrayList<Cooperativa> cops = new ArrayList();
        String consulta = "Select * from Cooperativa " + condicion;
        Cooperativa cop;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
            while (datos.next()) {
                cop = new Cooperativa();
                cop.setId(datos.getInt(1));
                cop.setNombre(datos.getString(2));
                cop.setRUC(datos.getString(3));
                cop.setDireccion(datos.getString(4));
                cop.setTelefono(datos.getString(5));
                cop.setCorreo(datos.getString(6));

                cops.add(cop);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cops;
    }

    public ArrayList<Bus> consultarBuses(String condicion) {
        ArrayList<Bus> buss = new ArrayList();
        String consulta = "Select * from Bus " + condicion;
        Bus bus;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
            while (datos.next()) {
                bus = new Bus();
                bus.setId(datos.getInt(1));
                bus.setPlaca(datos.getString(2));
                bus.setAño(datos.getInt(3));
                bus.setMarca(datos.getString(4));
                bus.setCoopetativa(new Consultas().consultarCooperativa(datos.getInt(5)));

                buss.add(bus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return buss;
    }

    public ArrayList<Asiento> consultarAsientos(String condicion) {
        ArrayList<Asiento> asis = new ArrayList();
        String consulta = "Select * from asiento " + condicion;
        Asiento asi;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
            while (datos.next()) {
                asi = new Asiento();
                asi.setId(datos.getInt(1));
                asi.setNumero(datos.getString(2));
                asi.setUbicacion(datos.getString(3));
                asi.setBus(new Consultas().consultarBus(datos.getInt(4)));

                asis.add(asi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asis;
    }

    public ArrayList<Rol> consultarRoles(String condicion) {
        ArrayList<Rol> rols = new ArrayList();
        String consulta = "Select * from rol " + condicion;
        Rol rol;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
            while (datos.next()) {
                rol = new Rol();
                rol.setId(datos.getInt(1));
                rol.setDescripcion(datos.getString(2));

                rols.add(rol);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rols;
    }

    public ArrayList<Usuario> consultarUsuarios(String condicion) {
        ArrayList<Usuario> usus = new ArrayList();
        String consulta = "Select * from usuario " + condicion;
        Usuario usu;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
            while (datos.next()) {
                usu = new Usuario();
                usu.setId(datos.getInt(1));
                usu.setCedula(datos.getString(2));
                usu.setNombre(datos.getString(3));
                usu.setApellido(datos.getString(4));
                usu.setTelefono(datos.getString(5));
                usu.setCorreo(datos.getString(6));
                usu.setDireccion(datos.getString(7));
                usu.setContraseña(datos.getString(8));
                usu.setRol(new Consultas().consultarRol(datos.getInt(9)));

                usus.add(usu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usus;
    }

    public ArrayList<Ciudad> consultarCiudad(String condicion) {
        ArrayList<Ciudad> cius = new ArrayList();
        String consulta = "Select * from ciudad " + condicion;
        Ciudad ciu;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
            while (datos.next()) {
                ciu = new Ciudad();
                ciu.setId(datos.getInt(1));
                ciu.setNombre(datos.getString(2));
                ciu.setCodigoPostal(datos.getString(3));

                cius.add(ciu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cius;
    }

    public ArrayList<Ruta> consultarRuta(String condicion) {
        ArrayList<Ruta> ruts = new ArrayList();
        String consulta = "Select * from ruta " + condicion;
        Ruta rut;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
            while (datos.next()) {
                rut = new Ruta();
                rut.setId(datos.getInt(1));
                rut.setCiudadOrigen(new Consultas().consultarCiudad(datos.getInt(2)));
                rut.setCiudadDestino(new Consultas().consultarCiudad(datos.getInt(3)));
                rut.setFechaHoraSalida(datos.getDate(4));
                rut.setFechaHoraLlegada(datos.getDate(5));
                rut.setPrecioPasaje(datos.getDouble(6));
                rut.setEstado(datos.getString(7));
                rut.setBus(new Consultas().consultarBus(datos.getInt(8)));
                rut.setUsuario(new Consultas().consultarUsuario(datos.getInt(9)));

                ruts.add(rut);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ruts;
    }

    public ArrayList<Cliente> consultarCliente(String condicion) {
        ArrayList<Cliente> clis = new ArrayList();
        String consulta = "Select * from cliente " + condicion;
        Cliente cli;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
            while (datos.next()) {
                cli = new Cliente();
                cli.setId(datos.getInt(1));
                cli.setCedula(datos.getString(2));
                cli.setNombre(datos.getString(3));
                cli.setApellido(datos.getString(4));
                cli.setTelefono(datos.getString(5));
                cli.setCorreo(datos.getString(6));
                cli.setDireccion(datos.getString(7));
                cli.setContraseña(datos.getString(8));

                clis.add(cli);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clis;
    }

    public ArrayList<Reserva> consultarReserva(String condicion) {
        ArrayList<Reserva> ress = new ArrayList();
        String consulta = "Select * from reserva " + condicion;
        Reserva res;
        try {
            st = cn.createStatement();
            datos = st.executeQuery(consulta);
            while (datos.next()) {
                res = new Reserva();
                res.setId(datos.getInt(1));
                res.setRuta(new Consultas().consultarRuta(datos.getInt(2)));
                res.setCliente(new Consultas().consultarCliente(datos.getInt(3)));
                res.setAsiento(new Consultas().consultarAsiento(datos.getInt(4)));
                res.setEstado(datos.getString(5));

                ress.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ress;
    }

    public Cooperativa consultarCooperativa(int Id) {
        String consulta = "Select * from Cooperativa where ID_COP=" + Id;
        Cooperativa cop = null;
        try {
            st = cn.createStatement();
            dato = st.executeQuery(consulta);
            if (!dato.next()) {

                return null;
            }
            cop = new Cooperativa();
            cop.setId(dato.getInt(1));
            cop.setNombre(dato.getString(2));
            cop.setRUC(dato.getString(3));
            cop.setDireccion(dato.getString(4));
            cop.setTelefono(dato.getString(5));
            cop.setCorreo(dato.getString(6));

        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cop;
    }

    public Bus consultarBus(int Id) {
        String consulta = "Select * from bus where ID_BUS=" + Id;
        Bus bus = null;
        try {
            st = cn.createStatement();
            dato = st.executeQuery(consulta);
            if (!dato.next()) {

                return null;
            }
            bus = new Bus();
            bus.setId(dato.getInt(1));
            bus.setPlaca(dato.getString(2));
            bus.setAño(dato.getInt(3));
            bus.setMarca(dato.getString(4));
            bus.setCoopetativa(new Consultas().consultarCooperativa(dato.getInt(5)));

        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bus;
    }

    public Asiento consultarAsiento(int Id) {
        String consulta = "Select * from Asiento where ID_ASI=" + Id;
        Asiento asi = null;
        try {
            st = cn.createStatement();
            dato = st.executeQuery(consulta);
            if (!dato.next()) {

                return null;
            }
            asi = new Asiento();
            asi.setId(dato.getInt(1));
            asi.setNumero(dato.getString(2));
            asi.setUbicacion(dato.getString(3));
            asi.setBus(new Consultas().consultarBus(dato.getInt(4)));

        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asi;
    }

    public Rol consultarRol(int Id) {
        String consulta = "Select * from rol where ID_ROL=" + Id;
        Rol rol = null;
        try {
            st = cn.createStatement();
            dato = st.executeQuery(consulta);
            if (!dato.next()) {

                return null;
            }
            rol = new Rol();
            rol.setId(dato.getInt(1));
            rol.setDescripcion(dato.getString(2));

        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rol;
    }

    public Usuario consultarUsuario(int Id) {
        String consulta = "Select * from usuario where ID_USU=" + Id;
        Usuario usu = null;
        try {
            st = cn.createStatement();
            dato = st.executeQuery(consulta);
            if (!dato.next()) {

                return null;
            }
            usu = new Usuario();
            usu.setId(dato.getInt(1));
            usu.setCedula(dato.getString(2));
            usu.setNombre(dato.getString(3));
            usu.setApellido(dato.getString(4));
            usu.setTelefono(dato.getString(5));
            usu.setCorreo(dato.getString(6));
            usu.setDireccion(dato.getString(7));
            usu.setContraseña(dato.getString(8));
            usu.setRol(new Consultas().consultarRol(dato.getInt(9)));

        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usu;
    }

    public Ciudad consultarCiudad(int Id) {
        String consulta = "Select * from ciudad where ID_CIU=" + Id;
        Ciudad ciu = null;
        try {
            st = cn.createStatement();
            dato = st.executeQuery(consulta);
            if (!dato.next()) {

                return null;
            }
            ciu = new Ciudad();
            ciu.setId(dato.getInt(1));
            ciu.setNombre(dato.getString(2));
            ciu.setCodigoPostal(dato.getString(3));

        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ciu;
    }

    public Ruta consultarRuta(int Id) {
        String consulta = "Select * from ruta where ID_RUT=" + Id;
        Ruta rut = null;
        try {
            st = cn.createStatement();
            dato = st.executeQuery(consulta);
            if (!dato.next()) {

                return null;
            }
            rut = new Ruta();
            rut.setId(dato.getInt(1));
            rut.setCiudadOrigen(new Consultas().consultarCiudad(dato.getInt(2)));
            rut.setCiudadDestino(new Consultas().consultarCiudad(dato.getInt(3)));
            rut.setFechaHoraSalida(dato.getDate(4));
            rut.setFechaHoraLlegada(dato.getDate(5));
            rut.setPrecioPasaje(dato.getDouble(6));
            rut.setEstado(dato.getString(7));
            rut.setBus(new Consultas().consultarBus(dato.getInt(8)));
            rut.setUsuario(new Consultas().consultarUsuario(dato.getInt(9)));

        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rut;
    }

    public Cliente consultarCliente(int Id) {
        String consulta = "Select * from cliente where ID_CLI=" + Id;
        Cliente cli = null;
        try {
            st = cn.createStatement();
            dato = st.executeQuery(consulta);
            if (!dato.next()) {

                return null;
            }
            cli = new Cliente();
            cli.setId(dato.getInt(1));
            cli.setCedula(dato.getString(2));
            cli.setNombre(dato.getString(3));
            cli.setApellido(dato.getString(4));
            cli.setTelefono(dato.getString(5));
            cli.setCorreo(dato.getString(6));
            cli.setDireccion(dato.getString(7));
            cli.setContraseña(dato.getString(8));

        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cli;
    }

    public Reserva consultarReserva(int Id) {
        String consulta = "Select * from reserva where ID_RES=" + Id;
        Reserva res = null;
        try {
            st = cn.createStatement();
            dato = st.executeQuery(consulta);
            if (!dato.next()) {

                return null;
            }
            res = new Reserva();
            res.setId(datos.getInt(1));
            res.setRuta(new Consultas().consultarRuta(datos.getInt(2)));
            res.setCliente(new Consultas().consultarCliente(datos.getInt(3)));
            res.setAsiento(new Consultas().consultarAsiento(datos.getInt(4)));
            res.setEstado(datos.getString(5));

        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public int consultarIdUltimaCooperativa() {
        String consulta = "Select max(ID_COP) From Cooperativa";
        int id = 0;
        try {
            st = cn.createStatement();
            dato = st.executeQuery(consulta);
            if (!dato.next()) {
                return 0;
            }
            id = dato.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public int consultarIdUltimoBus() {
        String consulta = "Select max(ID_BUS) From bus";
        int id = 0;
        try {
            st = cn.createStatement();
            dato = st.executeQuery(consulta);
            if (!dato.next()) {
                return 0;
            }
            id = dato.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public int consultarIdUltimoAsiento() {
        String consulta = "Select max(ID_ASI) From asiento";
        int id = 0;
        try {
            st = cn.createStatement();
            dato = st.executeQuery(consulta);
            if (!dato.next()) {
                return 0;
            }
            id = dato.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public int consultarIdUltimoRol() {
        String consulta = "Select max(ID_ROL) From rol";
        int id = 0;
        try {
            st = cn.createStatement();
            dato = st.executeQuery(consulta);
            if (!dato.next()) {
                return 0;
            }
            id = dato.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public int consultarIdUltimoUsuario() {
        String consulta = "Select max(ID_USU) From usuario";
        int id = 0;
        try {
            st = cn.createStatement();
            dato = st.executeQuery(consulta);
            if (!dato.next()) {
                return 0;
            }
            id = dato.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public int consultarIdUltimaCiudad() {
        String consulta = "Select max(ID_CIU) From ciudad";
        int id = 0;
        try {
            st = cn.createStatement();
            dato = st.executeQuery(consulta);
            if (!dato.next()) {
                return 0;
            }
            id = dato.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public int consultarIdUltimaRuta() {
        String consulta = "Select max(ID_RUT) From ruta";
        int id = 0;
        try {
            st = cn.createStatement();
            dato = st.executeQuery(consulta);
            if (!dato.next()) {
                return 0;
            }
            id = dato.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public int consultarIdUltimoCliente() {
        String consulta = "Select max(ID_CLI) From cliente";
        int id = 0;
        try {
            st = cn.createStatement();
            dato = st.executeQuery(consulta);
            if (!dato.next()) {
                return 0;
            }
            id = dato.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public int consultarIdUltimaReserva() {
        String consulta = "Select max(ID_RES) From reserva";
        int id = 0;
        try {
            st = cn.createStatement();
            dato = st.executeQuery(consulta);
            if (!dato.next()) {
                return 0;
            }
            id = dato.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(ConeccionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public String login(int USUARIO, String CONTRASENIA) {
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
            if (!rs.next()) {
                return "CLAVE INCORRECTA";

            } else {
                return "Bienvenido";

            }

        } catch (Exception e) {
        }
        return "NO CONECTADO";
    }
}
