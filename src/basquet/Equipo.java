package basquet;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dam
 */
public class Equipo {
  
    private int id;

    private static int numEquipos = 0;
    
    public int getId() {
        return id;
    }
    
    private String nombre;

    private String localidad;

    private Date fechaCreacion;

    public void setId(int id) {
        this.id = id;
    }

    public Equipo() {
    }
    
    
        private List<Jugador> Jugadores;

    public List<Jugador> getJugadores() {
        return Jugadores;
    }

    public void setJugadores(List<Jugador> Jugadores) {
        this.Jugadores = Jugadores;
    }


    public Equipo(String nombre, String localidad, Date fechaCreacion) {
        numEquipos++;
        this.id = numEquipos;
        this.nombre = nombre;
        this.localidad = localidad;
        this.fechaCreacion = fechaCreacion;
        Jugadores = new ArrayList<>();
    }
    
    

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return "Equipo{" + "nombre=" + nombre + '}';
    }


    
  
}
