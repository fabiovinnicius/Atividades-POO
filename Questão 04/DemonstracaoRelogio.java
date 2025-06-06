public class DemonstracaoRelogio {

    public static void main(String[] args) {
        Relogio meuRelogio1 = new Relogio();
        Relogio meuRelogio2 = new Relogio();
        Relogio meuRelogio3 = new Relogio();
        Relogio meuRelogio4 = new Relogio();

        System.out.println("Demonstrando inicialização com hora, minuto e segundo:");
        meuRelogio1.inicializar(10, 30, 45);
        meuRelogio1.mostrarHora();
        System.out.println("---");

        System.out.println("Demonstrando inicialização com hora e minuto (segundo = 1):");
        meuRelogio2.inicializar(14, 50);
        meuRelogio2.mostrarHora();
        System.out.println("---");

        System.out.println("Demonstrando inicialização somente com a hora (minuto = 1, segundo = 1):");
        meuRelogio3.inicializar(22);
        meuRelogio3.mostrarHora();
        System.out.println("---");

        System.out.println("Demonstrando inicialização com valores inválidos (e correção):");
        meuRelogio4.inicializar(25, -5, 60);
        meuRelogio4.mostrarHora();
        System.out.println("---");
    }
}