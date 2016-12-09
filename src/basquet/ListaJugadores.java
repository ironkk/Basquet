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
public class ListaJugadores implements Serializable {

    private ArrayList<Jugador> listaJugador;

    public ListaJugadores() {
        listaJugador = new ArrayList<>();
    }

    public ArrayList<Jugador> getLista() {
        return listaJugador;
    }

    public void setLista(ArrayList<Jugador> listaJugador) {
        this.listaJugador = listaJugador;
    }

    public void alta(Jugador j) {
        listaJugador.add(j);

    }

    public boolean existeJugador (String posicion) {
        for (Jugador j : listaJugador) {
            if (j.getPosicion().equalsIgnoreCase(posicion)) {
                return true;
            }
        }
        return false;
    }
}