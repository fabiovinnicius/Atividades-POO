// TransporteAereo.java
public abstract class TransporteAereo extends Transporte {
    protected int altitudeActual;

    public TransporteAereo(String nome, int passageirosMax, int velocidadeActual, int altitudeActual) {
        super(nome, passageirosMax, velocidadeActual);
        this.altitudeActual = altitudeActual;
    }

    public abstract void subir(int metros);
    public abstract void descer(int metros);

    // Getter and Setter
    public int getAltitudeActual() {
        return altitudeActual;
    }

    public void setAltitudeActual(int altitudeActual) {
        this.altitudeActual = altitudeActual;
    }
}