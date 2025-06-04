// TransporteTerrestre.java
public abstract class TransporteTerrestre extends Transporte {
    protected String tipo;

    public TransporteTerrestre(String nome, int passageirosMax, int velocidadeActual, String tipo) {
        super(nome, passageirosMax, velocidadeActual);
        this.tipo = tipo;
    }

    public abstract void estacionar();

    // Getter and Setter
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}