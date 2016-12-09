/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquet;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author dam
 */
public class ListaEquipos implements Serializable {

    private ArrayList<Equipo> listaEquipo;

    public ListaEquipos() {
        listaEquipo = new ArrayList<>();
    }

    public ArrayList<Equipo> getLista() {
        return listaEquipo;
    }

    public void setLista(ArrayList<Equipo> listaEquipo) {
        this.listaEquipo = listaEquipo;
    }

    public void alta(Equipo e) {
        listaEquipo.add(e);

    }

    public boolean existeEquipo(String localidad) {
        for (Equipo c : listaEquipo) {
            if (c.getLocalidad().equalsIgnoreCase(localidad)) {
                return true;
            }
        }
        return false;
    }
}
