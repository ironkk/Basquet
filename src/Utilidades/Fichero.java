/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

/**
 *
 * @author dam
 */
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author stucom
 */
public class Fichero {

    // Atributo para guardar el nombre del fichero
    private String nombre;

    // Constructor
    public Fichero(String nombre) {
        this.nombre = nombre;
    }

    public void grabar(Object o) {
        try {
            XMLEncoder codificador = new XMLEncoder(new FileOutputStream(new File(nombre)));
            codificador.writeObject(o);
            codificador.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error al escribir " + ex.getMessage());
//            ex.printStackTrace();
        }
    }

    public Object leer() {
        try {
            XMLDecoder decodificador = new XMLDecoder(new FileInputStream(new File(nombre)));
            Object o = decodificador.readObject();
            return o;
        } catch (FileNotFoundException ex) {
            System.out.println("Error al leer " + ex.getMessage());
            return null;
        }

    }

}
