/*
 * Clase auxiliar para tener los metodos con las consultas necesarias 
* para el ejercicio de Alfredo
 */
package basquet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dam
 */
public class Consultas {

    public static void buscarEquiposPorLocalidad(List<Equipo> todosEquipos, String localidad) {
        List<Equipo> equipos = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            if (e.getLocalidad().equalsIgnoreCase(localidad)) {
                equipos.add(e);
                System.out.println(equipos.toString());
            }
        }

    }

    //Devuelve todos los jugadores de un equipo, a partir del nombre completo del equipo.
    public static void buscarJugadoresPorEquipo(String nombre, List<Equipo> todosEquipos,  List<Jugador> misJugadores) {
        List<Jugador> jugadoresPorEquipo = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : misJugadores) {
                // Problema de Mayúsculas y minúsculas
                String nombreCompleto = e.getNombre().toLowerCase();
                String nombreMinusculas = nombre.toLowerCase();
                // Miramos si contiene una parte del nombre
                if (nombreCompleto.contains(nombreMinusculas)) {
                   jugadoresPorEquipo.add(j);
                    System.out.println(jugadoresPorEquipo.toString());
                   
                }
            }
        }

    }

    public static List<Jugador> buscarJugadorMaxCanastas(String nombre, List<Equipo> todosEquipos) {
        List<Jugador> jugadorMaxCanastas = null;
        for (Equipo e : todosEquipos) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                Collections.max(e.getJugadores(), new Comparator<Jugador>() {

                    public int compare(Jugador j1, Jugador j2) {

                        return j1.getCanastas().compareTo(j2.getCanastas());

                        // it can also return 0, and 1
                    }

                });
            }

        }

        return jugadorMaxCanastas;
    }
     public static void buscarJugadoresEquiposPorPosicion(String posicion, List<Equipo> todosEquipos) {
        List<Jugador> equipos = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores()) {
                if (j.getPosicion().equalsIgnoreCase(posicion)) {

                    equipos.add(j);
                       System.out.println(equipos.toString());
                }
            }
        }
    }

    public static void buscarJugadoresPorNombre(List<Equipo> todosEquipos, String nombre) {
        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores()) {
                // Problema de Mayúsculas y minúsculas
                String nombreCompleto = j.getNombre().toLowerCase();
                String nombreMinusculas = nombre.toLowerCase();
                // Miramos si contiene una parte del nombre
                if (nombreCompleto.contains(nombreMinusculas)) {
                    jugadores.add(j);
                    System.out.println(jugadores.toString());
                }
                
            }
        }
        
    public static void buscarJugadoresPorCanastas(List<Equipo> todosEquipos, int canastas) {
        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores()) {
                if (j.getCanastas() >= canastas) {
                    jugadores.add(j);
                    System.out.println(jugadores.toString());
                }
            }
        }
    }

    public static void buscarJugadoresPorFecha(List<Equipo> todosEquipos, Date nacimiento) {
        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores()) {
                if (j.getNacimiento().before(nacimiento)) {
                    jugadores.add(j);
                    System.out.println(jugadores.toString());
                    
                }
            }
        }
    }

    public static void buscarJugadoresPorPosicionyMedia(List<Equipo> todosEquipos) {
        List<String> misPosiciones = new ArrayList();
        misPosiciones.add("PIVOTE");
        misPosiciones.add("ALERO");
        misPosiciones.add("BASE");

        for (int i = 0; i < misPosiciones.size(); i++) {
            for (Equipo e : todosEquipos) {
                for (Jugador j : e.getJugadores()) {

                    if (j.getPosicion().equalsIgnoreCase(misPosiciones.get(i))) {
                        System.out.println("Nombre: " + j.getNombre() + "Posicion: " + j.getPosicion());
                    }

                }
            }
        }

    }

    public static List<Jugador> buscarJugadoresPorPosicionyMediayMax(List<Equipo> todosEquipos, int Mediacanastas, int Mediaasistencias, int Mediarebotes, int Maxcanastas, int Maxasistencias, int Maxrebotes, int Mincanastas, int Minasistencias, int Minrebotes, String posicion) {
        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores()) {
                if (j.getPosicion().equalsIgnoreCase(posicion)) {

                    // media ? dnde la añado
                    jugadores.add(j);
                }
            }
        }
        return jugadores;
    }

    public static void buscarJugadoresEntreAsistencias(List<Equipo> todosEquipos, int asistenciasMin, int asistenciasMax) {
        List<Jugador> jugadoresAsistencias = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores()) {
                if (j.getAsistencias() >= asistenciasMin && j.getAsistencias() <= asistenciasMax) {
                    jugadoresAsistencias.add(j);
                    System.out.println(  jugadoresAsistencias.toString());
                  
                }
            }
        }
    }

    public static void buscarJugadoresPorPosicion(List<Equipo> todosEquipos, String posicion) {
        List<Jugador> jugadores = new ArrayList<>();
        for (Equipo e : todosEquipos) {
            for (Jugador j : e.getJugadores()) {
                if (j.getPosicion().equalsIgnoreCase(posicion)) {
                    jugadores.add(j);
                    System.out.println(jugadores.toString());
                }
            }
        }
    }

}
