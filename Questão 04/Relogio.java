public class Relogio {

    private int hora;
    private int minuto;
    private int segundo;

    public void inicializar(int hora, int minuto, int segundo) {
        if (hora >= 0 && hora <= 23) {
            this.hora = hora;
        } else {
            System.out.println("Hora inválida. Usando 0.");
            this.hora = 0;
        }

        if (minuto >= 0 && minuto <= 59) {
            this.minuto = minuto;
        } else {
            System.out.println("Minuto inválido. Usando 0.");
            this.minuto = 0;
        }

        if (segundo >= 0 && segundo <= 59) {
            this.segundo = segundo;
        } else {
            System.out.println("Segundo inválido. Usando 0.");
            this.segundo = 0;
        }
        System.out.printf("Relógio inicializado para %02d:%02d:%02d%n", this.hora, this.minuto, this.segundo);
    }

    public void inicializar(int hora, int minuto) {
        inicializar(hora, minuto, 1);
    }

    public void inicializar(int hora) {
        inicializar(hora, 1, 1);
    }

    public void mostrarHora() {
        System.out.printf("Hora atual: %02d:%02d:%02d%n", hora, minuto, segundo);
    }
}