public abstract class Transporte {
    protected String nome;
    protected int passageirosMax;
    protected int velocidadeActual;

    public abstract boolean estaParado();

    public Transporte(String nome, int passageirosMax, int velocidadeActual) {
        this.nome = nome;
        this.passageirosMax = passageirosMax;
        this.velocidadeActual = velocidadeActual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPassageirosMax() {
        return passageirosMax;
    }

    public void setPassageirosMax(int passageirosMax) {
        this.passageirosMax = passageirosMax;
    }

    public int getVelocidadeActual() {
        return velocidadeActual;
    }

    public void setVelocidadeActual(int velocidadeActual) {
        this.velocidadeActual = velocidadeActual;
    }
}