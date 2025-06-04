public class Carro extends TransporteTerrestre implements Motorizado, Conduzivel {
    private int numeroCilindrada;

    public Carro(String nome, int passageirosMax, int velocidadeActual, String tipo, int numeroCilindrada) {
        super(nome, passageirosMax, velocidadeActual, tipo);
        this.numeroCilindrada = numeroCilindrada;
    }

    @Override
    public boolean estaParado() {
        return velocidadeActual == 0;
    }

    @Override
    public void estacionar() {
        if (velocidadeActual == 0) {
            System.out.println("Carro estacionado.");
        } else {
            System.out.println("Para estacionar, o carro precisa estar parado.");
        }
    }

    @Override
    public void ligarMotor() {
        System.out.println("Motor do carro ligado.");
    }

    @Override
    public void abastecer(int numLitros) {
        System.out.println("Carro abastecido com " + numLitros + " litros de combustível.");
    }

    @Override
    public void curvar(float angulo) {
        System.out.println("Carro curvando em um ângulo de " + angulo + " graus.");
    }

    public int getNumeroCilindrada() {
        return numeroCilindrada;
    }

    public void setNumeroCilindrada(int numeroCilindrada) {
        this.numeroCilindrada = numeroCilindrada;
    }
}