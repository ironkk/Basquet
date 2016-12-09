/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author dam
 */
public class Entrada {
    public static int pedirEntero(String texto) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean error;
        do {
            try {
                System.out.println(texto);
                num = Integer.parseInt(br.readLine());
                error = false;
            } catch (IOException ex) {
                System.out.println("Error de entrada / salida.");
                error = true;
            }
        } while (error);   
        return num;
    }
    
  public static String pedirCadena(String texto) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cadena = "";
        do {
            try {
                System.out.println(texto);
                cadena = br.readLine();
                if (cadena.equals("")) {
                    System.out.println("No se puede dejar el campo en blanco.");
                }
            } catch (IOException ex) {
                System.out.println("Error de entrada / salida.");
            }
        } while (cadena.equals(""));
        return cadena;
    }
  
   public static Date pedirFechaCreacion() {
        int cadena1 =0;
        int cadena2 =0;
        int cadena3 = 0;
        do {
         
                cadena1 = pedirEntero("¿Año de creación?: ");
                 cadena2 = pedirEntero("¿Mes de creación?: ");
                  cadena1 = pedirEntero("Día de creación?: ");
           
    
        } while (cadena1 > 0 && cadena2 > 0 && cadena3 > 0);
      Date fechaCreada = new Date(cadena1, cadena2, cadena3);
      return fechaCreada;
      
    }

}
