package basquet;

import Utilidades.Fichero;
import static basquet.Entrada.pedirCadena;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainBasquet {

    private static Fichero ficheroEquipos;
    private static ListaEquipos misEquipos;
    private static ListaJugadores misJugadores;

    public static void main(String[] args) {

        // Creamos algunos jugadores
        Jugador j1 = new Jugador(new Date(1995, 6, 12), "Manolo");
        Jugador j2 = new Jugador(new Date(1995, 9, 7), "Pepita");
        Jugador j3 = new Jugador(new Date(1995, 8, 17), "Mark");
        Jugador j4 = new Jugador(new Date(1995, 5, 15), "Javier");

        // Creamos equipos
        Equipo e1 = new Equipo("Stucom", "Barcelona", new Date(1998, 2, 28));
        Equipo e2 = new Equipo("Linkdn", "Barcelona", new Date(1988, 2, 28));

        // Vinculamos los jugadores en los equipos
        e1.getJugadores().add(j1);
        e1.getJugadores().add(j2);
        e2.getJugadores().add(j3);
        e2.getJugadores().add(j4);

        // Añado los equipos a un array
        List<Equipo> liga = new ArrayList<>();
        liga.add(e2);
        liga.add(e1);

        int opcion;
        // Aquí siempre inicializamos el nombre del fichero

        ficheroEquipos = new Fichero("basquet.xml");
        // Leemos del fichero por si ya hay clientes guardados

        misEquipos = (ListaEquipos) ficheroEquipos.leer();

        // Cuando lee del fichero, si no hay fichero o no hay datos misClientes será null
        if (misEquipos == null) {
            misEquipos = new ListaEquipos();
        }

        switch (mostrarMenu()) {
            case 1:
                altaEquipo();

                break;
            case 2:
                altaJugador();
                break;
            case 3:
                consultaJugadores(liga);
                break;
            case 4:
                consultaEquipos(liga);
                break;
            case 5:
                System.exit(0);
                break;

            default:
                System.out.println("Opción incorrecta.");

        }

    }

    private static int mostrarMenu() {

        int opcion = -1;

        do {

            System.out.println("*** Jugadores - EQUIPOS ***");
            System.out.println("1. Alta Equipo");
            System.out.println("2. Alta Jugador");
            System.out.println("3. Consulta Jugadores");
            System.out.println("4. Consulta Equipos");
            System.out.println("5. Salir");

            opcion = Entrada.pedirEntero("Escoge una opción");

        } while (opcion < 1 || opcion > 5);
        return opcion;
    }

    private static void altaEquipo() {
        String localidad;
        do {
            localidad = pedirCadena("Localidad: ");

            // La longitud del tfno tiene que ser 9
            if (localidad.length() < 3) {
                System.out.println("Error.!");
            }
        } while (localidad.length() < 9);
        if (misEquipos.existeEquipo(localidad)) {
            System.out.println("Equipo Existente");

        } else {

            String nombre;
            do {

                nombre = pedirCadena("Nombre Equipo");
                if (nombre.equals("")) {
                    System.out.println("No se puede dejar el nombre en blanco");
                }
            } while (nombre.equals(""));

            Date fechaCreacion = pedirFechaCreacion();

            Equipo e = new Equipo(localidad, nombre, fechaCreacion);
            misEquipos.alta(e);
            ficheroEquipos.grabar(misEquipos);
            System.out.println("¡Equipo Creado!");
        }
    }

// PETA en posicion
    private static void altaJugador() {
        String posicion = pedirCadena("Posicion: ALERO/ PIVOTE / BASE");
        if (misJugadores.existeJugador(posicion)) {
            System.out.println("Jugador Existente");

        } else {

            String nombre;
            do {

                nombre = pedirCadena("Nombre");
                if (nombre.equals("")) {
                    System.out.println("No se puede dejar el nombre en blanco");
                }
            } while (nombre.equals(""));

            Date nacimiento = pedirFechaCreacion();

            int canastas = pedirEntero("Numero Canastas: ");

            int asistencias = pedirEntero("Numero Asistencias: ");

            int rebotes = pedirEntero("Numero Rebotes: ");

            Jugador j = new Jugador(canastas, asistencias, rebotes, posicion, nacimiento, nombre);
            misJugadores.alta(j);

            //grabar asin?
            ficheroEquipos.grabar(misJugadores);

        }
    }

    // QUE HAY QUE PASAR POR PARAMETROS?
    public static void consultaJugadores(List<Equipo> liga) {
        // Buscar jugadores por nombre, de manera que no sea necesario introducir el nombre completo.
        List<Jugador> resultado;
        String p = pedirCadena("¿Nombre Jugador?");
        System.out.println("Listado de jugadores con" + p + "en el nombre");
        Consultas.buscarJugadoresPorNombre(liga, p);

        //Buscar jugadores que hayan conseguido un número mayor o igual a un número de canastas especificado como parámetro.
        int p1 = pedirEntero("¿Número Canastas?");
        System.out.println("Listado de jugadores con más de" + p1 + "canastas");
        Consultas.buscarJugadoresPorCanastas(liga, p1);

        // Buscar jugadores que hayan efectuado un número de asistencias dentro de un rango especificado como parámetro.
        int p2 = pedirEntero("¿Número de asistencias: Entre:?");
        int p3 = pedirEntero("¿Número de asistencias: y entre:?");
        System.out.println("Listado de jugadores por asistencias");
        Consultas.buscarJugadoresEntreAsistencias(liga, p2, p3);

        // Buscar jugadores que pertenezcan a una posición específica, por ejemplo: base.
        String p4 = pedirCadena("¿Posicion del jugador:?");
        System.out.println("Listado de jugadores por posicion específica");
        Consultas.buscarJugadoresPorPosicion(liga, p4);

        String p8 = pedirCadena("¿Equipo :?");
        System.out.println("jugador que más canastas ha realizado de un equipo determinado como parámetro.");
        Consultas.buscarJugadorMaxCanastas(p8, liga);

        Date p9 = pedirFechaCreacion();
        System.out.println("Buscar jugadores que hayan nacido en una fecha anterior a una fecha especificada como parámetro.");
        Consultas.buscarJugadoresPorFecha(liga, p9);

        System.out.println("Agrupar los jugadores por la posición del campo y devolver para cada grupo la siguiente información: la media de canastas, asistencias y rebotes.");
        Consultas.buscarJugadoresPorPosicionyMedia(liga);

        //Lo mismo que el punto anterior pero devolviendo la media, el máximo y el mínimo de canastas, asistencias y rebotes.
    }

    // QUE HAY QUE PASAR POR PARAMETROS?
    public static void consultaEquipos(List<Equipo> liga) {
        List<Jugador> misJugadores = new ArrayList<>();
        String p5 = pedirCadena("¿Localidad de tu equipo:?");
        System.out.println("Listado de equipos existentes en una localidad determinada");
        Consultas.buscarEquiposPorLocalidad(liga, p5);

        String p6 = pedirCadena("¿Nombre equipo:?");

        System.out.println("Listado de jugadores a partir del nombre completo del equipo");
        Consultas.buscarJugadoresPorEquipo(p6, liga, misJugadores);

        //Devuelve todos los jugadores de un equipo, que además jueguen en la misma posición (parámetro adicional de la consulta), por ejemplo,alero. ???
        String p7 = pedirCadena("¿Posición del jugador de tu equipo:?");

        System.out.println("Listado de jugadores por posicion específica");
        Consultas.buscarJugadoresEquiposPorPosicion(p7, liga);

    }
}
