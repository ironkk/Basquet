package basquet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ironkk
 */
public class Equipo {

    private int id;

    private static int numEquipos = 0;

    private String nombre;

    private String localidad;

    private Date fechaCreacion;
    private List<Jugador> Jugadores;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipo() {
    }

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

    public void altaJugadores(Jugador j) {
        Jugadores.add(j);
    }

    @Override
    public String toString() {
        return "Equipo{" + "id=" + id + ", nombre=" + nombre + ", localidad=" + localidad + ", fechaCreacion=" + fechaCreacion + ", Jugadores=" + Jugadores + '}';
    }

  

}
