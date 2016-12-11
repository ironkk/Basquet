package basquet;

import Utilidades.Entrada;
import Utilidades.Fichero;
import static Utilidades.Entrada.pedirCadena;
import static Utilidades.Entrada.pedirEntero;
import static Utilidades.Entrada.pedirFechaCreacion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ironkk
 */
public class MainBasquet {

    private static Fichero ficheroEquipo;
    private static ListaEquipos listaEquipos;
    

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

        // Aquí siempre inicializamos el nombre del fichero
        ficheroEquipo = new Fichero("basquet.xml");
        // Leemos del fichero por si ya hay clientes guardados

        listaEquipos = (ListaEquipos) ficheroEquipo.leer();

        // Cuando lee del fichero, si no hay fichero o no hay datos listaEquipos será null
        if (listaEquipos == null) {
            listaEquipos = new ListaEquipos();
            ficheroEquipo.grabar(listaEquipos);
        }
        switch (mostrarMenu()) {
            case 1:
                altaEquipo();
                break;
            case 2:
                altaJugador();
                break;
            case 3:
                switch (menuJugadores()) {
                    case 1:
                        System.out.println(listaEquipos.JugadoresNombre(pedirCadena("¿Nombre Jugador?: ")));
                        break;
                    case 2:
                        System.out.println(listaEquipos.JugadoresNumeroCanastasMayor(pedirEntero("¿Canastas?: ")));
                        break;
                    case 3:
                        System.out.println(listaEquipos.JugadoresNumeroCanastasEntre(pedirEntero("¿Min Canastas?: "), Entrada.pedirEntero("¿Max Canastas?: ")));
                        break;
                    case 4:
                        System.out.println(listaEquipos.JugadoresPorPosicion(pedirCadena("¿Posición del Jugador? (BASE/ALERO/PIVOTE): ")));
                        break;
                    case 5:
                        // System.out.println(listaEquipos.JugadoresNacimientoAnteriorA(pedirFechaNacimiento("s")));
                        break;
                    case 6:
                        // System.out.println(listaEquipos.JugadoresPorMedia(posicion, 0, 0));
                        break;
                    case 7:
                        // System.out.println(listaEquipos.);
                        break;
                    case 8:
                        System.out.println("¡Adiós!");
                        break;
                }
                break;
            case 4:
                switch (menuEquipos()) {
                    case 1:
                        System.out.println(listaEquipos.EquiposPorLocalidad(pedirCadena("¿Localidad del Equipo?: ")));
                        break;
                    case 2:
                        System.out.println(listaEquipos.JugadoresPorEquipo(pedirCadena("¿Nombre Equipo?: ")));
                        break;
                    case 3:
                        System.out.println(listaEquipos.JugadoresEquipoPosicion(pedirCadena("¿Nombre Equipo?: "), pedirCadena("¿Posición Jugador?: ")));
                        break;
                    case 4:
                        System.out.println(listaEquipos.JugadorMasCanastasEquipo(pedirCadena("¿Nombre Equipo?: ")));
                        break;
                    case 5:
                        System.out.println("¡Adiós!");
                        break;
                }
                break;

            case 5:
                System.out.println("¡Adiós!");
                System.exit(0);
                break;

            default:
                System.out.println("Opción incorrecta.");
                break;

        }

    }

    /*  if (listaEquipos.existeEquipo(localidad)) {
            System.out.println("Equipo Existente");

        } else {
     */
    private static void altaEquipo() {
        String nombre;
        do {
            nombre = pedirCadena("Nombre Equipo");
            if (nombre.equals("")) {
                System.out.println("No se puede dejar el nombre en blanco");
            }
        } while (nombre.equals(""));
        if (listaEquipos.existeEquipo(nombre)) {
            System.out.println("¡Lo sentimos! Equipo Existente");
            System.exit(0);

        } else {

            String localidad = pedirCadena("Localidad: ");
               

            Date fechaCreacion = pedirFechaCreacion("DIA|MES|AÑO");

            Equipo e = new Equipo(nombre, localidad, fechaCreacion);
            System.out.println(e);
            listaEquipos.alta(e);
            ficheroEquipo.grabar(listaEquipos);
            System.out.println("¡Equipo Creado!");
        }
    }

    private static void altaJugador() {
        String nombre;
        do {
            nombre = pedirCadena("Nombre");
            if (nombre.equals("")) {
                System.out.println("No se puede dejar el nombre en blanco");
            }
        } while (nombre.equals(""));
        Date fechaNacimiento = Entrada.pedirFechaNacimiento("DIA|MES|AÑO");
        String posicion = pedirCadena("Posición: BASE / PIVOTE / ALERO");

        int canastas = pedirEntero("Numero Canastas: ");

        int asistencias = pedirEntero("Numero Asistencias: ");

        int rebotes = pedirEntero("Numero Rebotes: ");

        listaEquipos.mostrarEquipos();
        System.out.println("");
        String nombreEquipo = pedirCadena("¿Nombre Equipo?: ");
        System.out.println("");
        Jugador j = new Jugador(nombre, fechaNacimiento, posicion, canastas, asistencias, rebotes);
        Equipo e = listaEquipos.NombreEquipo(nombreEquipo);
        System.out.println(e);
        e.altaJugadores(j);
        ficheroEquipo.grabar(listaEquipos);
        System.out.println("¡Jugador Creado!");

    }

    private static int mostrarMenu() {

        int opcion = 0;

        do {

            System.out.println("*** Jugadores - EQUIPOS ***");
            System.out.println("");
            System.out.println("1. Alta Equipo.");
            System.out.println("2. Alta Jugador.");
            System.out.println("3. Consultas Jugadores.");
            System.out.println("4. Consultas Equipos.");
            System.out.println("5. Salir.");

            opcion = pedirEntero("Escoge una opción: ");

        } while (opcion < 1 || opcion > 5);
        return opcion;
    }

    public static int menuJugadores() {
        int opcion = 0;
        do {

            System.out.println("*** Consultas Jugadores ***");
            System.out.println("");
            System.out.println("1. Buscar jugadores por nombre, de manera que no sea necesario introducir el nombre completo.");
            System.out.println("2. Buscar jugadores que hayan conseguido un número mayor o igual a un número de canastas especificado como parámetro.");
            System.out.println("3. Buscar jugadores que hayan efectuado un número de asistencias dentro de un rango especificado como parámetro.");
            System.out.println("4. Buscar jugadores que pertenezcan a una posición específica, por ejemplo: base/alero/pivote");
            System.out.println("5. Buscar jugadores que hayan nacido en una fecha anterior a una fecha especificada como parámetro.");
            System.out.println("6. Agrupar los jugadores por la posición del campo y devolver para cada grupo la siguiente información: la media de canastas, asistencias y rebotes.");
            System.out.println("7. Lo mismo que el punto anterior pero devolviendo la media, el máximo y el mínimo de canastas, asistencias y rebotes.");
            System.out.println("8. Salir");

            opcion = pedirEntero("Escoge una opción: ");
        } while (opcion == 0);
        return opcion;
    }

    public static int menuEquipos() {
        int opcion = 0;
        do {
            System.out.println("*** Consultas Jugadores ***");
            System.out.println("");
            System.out.println("1. Listado de equipos existentes en una localidad determinada.");
            System.out.println("2. Listado de jugadores a partir del nombre completo del equipo.");
            System.out.println("3. Listado de jugadores por posicion específica.");
            System.out.println("4. Jugador que más canastas ha realizado de un equipo determinado como parámetro.");
            System.out.println("5. Salir");
            opcion = pedirEntero("Escoge una opción: ");
        } while (opcion == 0);
        return opcion;
    }

}
