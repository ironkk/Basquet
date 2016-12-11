/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquet;

import Utilidades.Entrada;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ironkk
 */
public class ListaEquipos implements Serializable {

    private ArrayList<Equipo> listaEquipo;

    public ListaEquipos() {
        listaEquipo = new ArrayList<>();
    }

    public ArrayList<Equipo> getLista() {
        return listaEquipo;
    }

    public ListaEquipos(ArrayList<Equipo> listaEquipo) {
        this.listaEquipo = listaEquipo;
    }

    public void setLista(ArrayList<Equipo> listaEquipo) {
        this.listaEquipo = listaEquipo;
    }

    public void alta(Equipo p) {
        listaEquipo.add(p);
    }

    public void mostrarEquipos() {
       for(Equipo e: listaEquipo){
            System.out.println(e.getNombre());
       }
    }

    public Equipo NombreEquipo(String nombre) {
        for (Equipo e : listaEquipo) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null;
    }
    
 /* 
     public List<Equipo> getEquiposLocalidad(String localidad){
        List<Equipo> equipos = new ArrayList<>();
        for (Equipo e:lista){
            if (e.getCiudad().toLowerCase().equals(localidad.toLowerCase()))
                equipos.add(e);
        }
        return equipos;
    }
     */
    // CONSULTAS JUGADORES
     public List<Jugador> JugadoresNombre(String nombre) {
        List<Jugador> jugadores = new ArrayList<>();
        listaEquipo.forEach((e) -> {
            e.getJugadores().stream().filter((j) -> (j.getNombre().toLowerCase().contains(nombre.toLowerCase()))).forEachOrdered((j) -> {
                jugadores.add(j);
            });
        });
        return jugadores;
    }
     
     public List<Jugador> JugadoresNumeroCanastasMayor(int canastas) {
        List<Jugador> Jugadores = new ArrayList<>();
        listaEquipo.forEach((e) -> {
            e.getJugadores().stream().filter((j) -> (j.getCanastas() >= canastas)).forEachOrdered((j) -> {
                Jugadores.add(j);
            });
        });
        return Jugadores;
    }

    public List<Jugador> JugadoresNumeroCanastasEntre(int min, int max) {
        List<Jugador> Jugadores = new ArrayList<>();
        listaEquipo.forEach((e) -> {
            e.getJugadores().stream().filter((j) -> (j.getCanastas() >= min && j.getCanastas() <= max)).forEachOrdered((j) -> {
                Jugadores.add(j);
            });
        });
        return Jugadores;
    }

    public List<Jugador> JugadoresPorPosicion(String posicion) {
        List<Jugador> Jugadores = new ArrayList<>();
        listaEquipo.forEach((e) -> {
            e.getJugadores().stream().filter((j) -> (j.getPosicion().equalsIgnoreCase(posicion))).forEachOrdered((j) -> {
                Jugadores.add(j);
            });
        });
        return Jugadores;
    }

    public List<Jugador> JugadoresNacimientoAnteriorA(String texto) {
        Date fechaNacimiento = Entrada.pedirFechaCreacion("DIA|MES|AÑO");
        List<Jugador> Jugadores = new ArrayList<>();
        listaEquipo.forEach((e) -> {
            e.getJugadores().stream().filter((j) -> (j.getNacimiento().before(fechaNacimiento))).forEachOrdered((j) -> {
                Jugadores.add(j);
            });
        });
        return Jugadores;
    }

    public List<Jugador> JugadoresPorMedia(String posicion, double avgBaskets, double avgAsistencias) {
        List<Jugador> Jugadores = new ArrayList<>();
        listaEquipo.forEach((e) -> {
            e.getJugadores().forEach((j) -> {
                for (int i = 0; i < Jugadores.size(); i++) {
                    if (j.getPosicion().equalsIgnoreCase(posicion)) {
                        //   avgBaskets = avgBaskets + Jugadores[i]; 
                    }
                }
            });
        });
        return Jugadores;
    }

    public List<Jugador> JugadoresPorEquipo(String nombre) {
        for (Equipo e : listaEquipo) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e.getJugadores();
            }
        }
        return null;
    }
    
       public List<Jugador> JugadoresEquipoPosicion(String nombre, String posicion) {
        List<Jugador> Jugadores = new ArrayList<>();
        listaEquipo.stream().filter((e) -> (e.getNombre().equalsIgnoreCase(posicion))).forEachOrdered((e) -> {
            e.getJugadores().stream().filter((j) -> (j.getPosicion().equalsIgnoreCase(posicion))).forEachOrdered((j) -> {
                Jugadores.add(j);
            });
        });
        return Jugadores;
    }

       // CONSULTAS EQUIPOS
    public List<Equipo> EquiposPorLocalidad(String localidad) {
        List<Equipo> Equipos = new ArrayList<>();
        listaEquipo.stream().filter((e) -> (e.getLocalidad().equalsIgnoreCase(localidad))).forEachOrdered((e) -> {
            Equipos.add(e);
        });
        return Equipos;
    }

    public Jugador JugadorMasCanastasEquipo(String equipo) {
        Jugador max = null;
        for (Equipo e : listaEquipo) {
            if (e.getNombre().equalsIgnoreCase(equipo)) {
                max = e.getJugadores().get(0);
                for (Jugador j : e.getJugadores()) {
                    if (j.getCanastas() >= max.getCanastas()) {
                        max = j;
                    }
                }
            }
        }
        return max;
    }

    public boolean existeEquipo(String nombre) {
        for (Equipo e : listaEquipo) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ListaEquipos{" + "listaEquipo=" + listaEquipo + '}';
    }
    
    
}
