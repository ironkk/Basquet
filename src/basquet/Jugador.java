package basquet;

import java.util.Date;

/**
 *
 * @author ironkk
 */
public class Jugador {

    private int id;

    private int canastas;

    private int asistencias;

    private int rebotes;

    private String posicion;

    private static int contador;

    private Date nacimiento;

    public Jugador(Date nacimiento, String nombre) {
        contador++;
        this.id = contador;
        this.nacimiento = nacimiento;
        this.nombre = nombre;
    }

    public Jugador(String nombre, Date fechaNacimiento, String posicion, int canastas, int asistencias, int rebotes) {
        this(fechaNacimiento, nombre);
        this.canastas = canastas;
        this.asistencias = asistencias;
        this.rebotes = rebotes;
        this.posicion = posicion;
        this.nacimiento = nacimiento;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Jugador() {
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getRebotes() {
        return rebotes;
    }

    public void setRebotes(int rebotes) {
        this.rebotes = rebotes;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public Integer getCanastas() {
        return canastas;
    }

    public void setCanastas(int canastas) {
        this.canastas = canastas;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", canastas=" + canastas + ", asistencias=" + asistencias + ", rebotes=" + rebotes + ", posicion=" + posicion + ", nacimiento=" + nacimiento + ", nombre=" + nombre + '}';
    }

    
}
