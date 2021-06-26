/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

/**
 *
 * @author HP
 */
public class Reserva {
      int id;
    String estado;
    Ruta ruta;
    Cliente cliente;
    Asiento asiento;
    
    public Reserva() {
       
    }

    public Reserva(int id, String estado, Ruta ruta, Cliente cliente, Asiento asiento) {
        this.id = id;
        this.estado = estado;
        this.ruta = ruta;
        this.cliente = cliente;
        this.asiento = asiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }
    
            
    
}
