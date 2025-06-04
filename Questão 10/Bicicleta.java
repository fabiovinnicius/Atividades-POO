public class Bicicleta extends TransporteTerrestre implements Conduzivel {
    private int numeroRodas;

    public Bicicleta(String nome, int passageirosMax, int velocidadeActual, String tipo, int numeroRodas) {
        super(nome, passageirosMax, velocidadeActual, tipo);
        this.numeroRodas = numeroRodas;
    }

    @Override
    public boolean estaParado() {
        return velocidadeActual == 0;
    }

    @Override
    public void estacionar() {
        if (velocidadeActual == 0) {
            System.out.println("Bicicleta estacionada.");
        } else {
            System.out.println("Para estacionar, a bicicleta precisa estar parada.");
        }
    }

    @Override
    public void curvar(float angulo) {
        System.out.println("Bicicleta curvando em um ângulo de " + angulo + " graus.");
    }

    public int getNumeroRodas() {
        return numeroRodas;
    }

    public void setNumeroRodas(int numeroRodas) {
        this.numeroRodas = numeroRodas;
    }
}