// Balao.java
public class Balao extends TransporteAereo {
    private String tipoGasLargada;

    public Balao(String nome, int passageirosMax, int velocidadeActual, int altitudeActual, String tipoGasLargada) {
        super(nome, passageirosMax, velocidadeActual, altitudeActual);
        this.tipoGasLargada = tipoGasLargada;
    }

    @Override
    public boolean estaParado() {
        return velocidadeActual == 0; // Balão pode estar parado no ar
    }

    @Override
    public void subir(int metros) {
        this.altitudeActual += metros;
        System.out.println("Balão subindo " + metros + " metros. Altitude atual: " + this.altitudeActual + "m.");
    }

    @Override
    public void descer(int metros) {
        this.altitudeActual -= metros;
        if (this.altitudeActual < 0) this.altitudeActual = 0;
        System.out.println("Balão descendo " + metros + " metros. Altitude atual: " + this.altitudeActual + "m.");
    }

    // Getter and Setter
    public String getTipoGasLargada() {
        return tipoGasLargada;
    }

    public void setTipoGasLargada(String tipoGasLargada) {
        this.tipoGasLargada = tipoGasLargada;
    }
}