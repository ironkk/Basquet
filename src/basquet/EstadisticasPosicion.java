package basquet;

/**
 *
 * @author ironkk
 */

// CLASE FALLIDA! 
public class EstadisticasPosicion {

    private String posicion;
    private double avgBaskets;
    private double avgAsistencias;

    public EstadisticasPosicion(String posicion, double avgBaskets, double avgAsistencias) {
        this.posicion = posicion;
        this.avgBaskets = avgBaskets;
        this.avgAsistencias = avgAsistencias;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public double getAvgBaskets() {
        return avgBaskets;
    }

    public void setAvgBaskets(double avgBaskets) {
        this.avgBaskets = avgBaskets;
    }

    public double getAvgAsistencias() {
        return avgAsistencias;
    }

    public void setAvgAsistencias(double avgAsistencias) {
        this.avgAsistencias = avgAsistencias;
    }

}

// GET --> AVG BASKETS, ASSISTS, REBOUND FROM ALL PLAYERS SAME POSITION

