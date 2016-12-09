/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquet;
/**
 * Created by User on 06/11/2016.
 */

public class EstadisticasPosicion {

 
    private String position;
    private double avgBaskets;
    private int minBaskets;
    private int maxBaskets;

    public EstadisticasPosicion(String position, double avgBaskets, int minBaskets, int maxBaskets) {
        this.position = position;
        this.avgBaskets = avgBaskets;
        this.minBaskets = minBaskets;
        this.maxBaskets = maxBaskets;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }



    public double getAvgBaskets() {
        return avgBaskets;
    }

    public void setAvgBaskets(double avgBaskets) {
        this.avgBaskets = avgBaskets;
    }

    public int getMinBaskets() {
        return minBaskets;
    }

    public void setMinBaskets(int minBaskets) {
        this.minBaskets = minBaskets;
    }

    public int getMaxBaskets() {
        return maxBaskets;
    }

    public void setMaxBaskets(int maxBaskets) {
        this.maxBaskets = maxBaskets;
    }
}


// GET --> AVG BASKETS, ASSISTS, REBOUND FROM ALL PLAYERS SAME POSITION

