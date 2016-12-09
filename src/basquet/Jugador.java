package basquet;


import java.time.LocalDate;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public Jugador(Date nacimiento, String nombre) {
        contador++;
        this.id = contador;
        this.nacimiento = nacimiento;
        this.nombre = nombre;
    }
    

    public Jugador(int canastas, int asistencias, int rebotes, String posicion, Date nacimiento, String nombre) {
        this(nacimiento, nombre);
        this.canastas = canastas;
        this.asistencias = asistencias;
        this.rebotes = rebotes;
        this.posicion = posicion;
        this.nacimiento = nacimiento;
        this.nombre = nombre;
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

    private Date nacimiento;

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

    public int getId() {
        return id;
    }
 
    
    

}
