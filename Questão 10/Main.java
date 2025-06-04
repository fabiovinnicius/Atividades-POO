// Main.java
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Testando Implementação da Interface Motorizado ---");

        Aviao meuAviao = new Aviao("Boeing 747", 400, 800, 10000, 4);
        Carro meuCarro = new Carro("Ford Focus", 5, 60, "Sedan", 1600);

        System.out.println("\nVerificando Avião (Motorizado):");
        meuAviao.ligarMotor();
        meuAviao.abastecer(5000);
        System.out.println("Avião parado? " + meuAviao.estaParado());
        meuAviao.setVelocidadeActual(0); // Simulating stop
        meuAviao.setAltitudeActual(0);
        System.out.println("Avião parado agora? " + meuAviao.estaParado());


        System.out.println("\nVerificando Carro (Motorizado):");
        meuCarro.ligarMotor();
        meuCarro.abastecer(50);
        System.out.println("Carro parado? " + meuCarro.estaParado());
        meuCarro.setVelocidadeActual(0); // Simulating stop
        System.out.println("Carro parado agora? " + meuCarro.estaParado());


        System.out.println("\n--- Testando Implementação da Interface Conduzivel ---");

        Bicicleta minhaBicicleta = new Bicicleta("Caloi", 1, 15, "Mountain Bike", 2);

        System.out.println("\nVerificando Avião (Conduzivel):");
        meuAviao.curvar(30.5f);

        System.out.println("\nVerificando Carro (Conduzivel):");
        meuCarro.curvar(45.0f);

        System.out.println("\nVerificando Bicicleta (Conduzivel):");
        minhaBicicleta.curvar(25.0f);


        System.out.println("\n--- Testando Métodos Específicos de Cada Classe ---");

        System.out.println("\nAvião:");
        meuAviao.subir(500);
        meuAviao.descer(200);

        System.out.println("\nBalão:");
        Balao meuBalao = new Balao("Hot Air", 2, 10, 500, "Hélio");
        meuBalao.subir(100);
        meuBalao.descer(50);
        System.out.println("Balão parado? " + meuBalao.estaParado());


        System.out.println("\nCarro:");
        meuCarro.setVelocidadeActual(0); // Ensure it's stopped for parking
        meuCarro.estacionar();
        meuCarro.setVelocidadeActual(30);
        meuCarro.estacionar(); // Should not park if not stopped

        System.out.println("\nBicicleta:");
        minhaBicicleta.setVelocidadeActual(0); // Ensure it's stopped for parking
        minhaBicicleta.estacionar();
        minhaBicicleta.setVelocidadeActual(5);
        minhaBicicleta.estacionar(); // Should not park if not stopped
    }
}