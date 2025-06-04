public class Aviao extends TransporteAereo implements Motorizado, Conduzivel {
    private int numeroMotores;

    public Aviao(String nome, int passageirosMax, int velocidadeActual, int altitudeActual, int numeroMotores) {
        super(nome, passageirosMax, velocidadeActual, altitudeActual);
        this.numeroMotores = numeroMotores;
    }

    @Override
    public boolean estaParado() {
        return velocidadeActual == 0 && altitudeActual == 0;
    }

    @Override
    public void subir(int metros) {
        this.altitudeActual += metros;
        System.out.println("Avião subindo " + metros + " metros. Altitude atual: " + this.altitudeActual + "m.");
    }

    @Override
    public void descer(int metros) {
        this.altitudeActual -= metros;
        if (this.altitudeActual < 0) this.altitudeActual = 0;
        System.out.println("Avião descendo " + metros + " metros. Altitude atual: " + this.altitudeActual + "m.");
    }

    @Override
    public void ligarMotor() {
        System.out.println("Motores do avião ligados.");
    }

    @Override
    public void abastecer(int numLitros) {
        System.out.println("Avião abastecido com " + numLitros + " litros de combustível.");
    }

    @Override
    public void curvar(float angulo) {
        System.out.println("Avião curvando em um ângulo de " + angulo + " graus.");
    }

    public int getNumeroMotores() {
        return numeroMotores;
    }

    public void setNumeroMotores(int numeroMotores) {
        this.numeroMotores = numeroMotores;
    }
}