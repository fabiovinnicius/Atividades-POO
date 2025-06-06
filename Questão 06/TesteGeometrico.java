
abstract class ObjetoGeometrico {

    public abstract void mostrarDados();

    public abstract double calcularArea();

    public abstract double calcularPerimetro();
}

class Circulo extends ObjetoGeometrico {
    private double coordX;
    private double coordY;
    private double raio;


    public Circulo(double coordX, double coordY, double raio) {
        this.coordX = coordX;
        this.coordY = coordY;
        if (raio <= 0) {
            throw new IllegalArgumentException("O raio do círculo deve ser positivo.");
        }
        this.raio = raio;
    }

    @Override
    public void mostrarDados() {
        System.out.println("--- Dados do Círculo ---");
        System.out.println("Centro: (" + coordX + ", " + coordY + ")");
        System.out.println("Raio: " + raio);
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }
}

class Retangulo extends ObjetoGeometrico {
    private double lado1;
    private double lado2; 

    public Retangulo(double lado1, double lado2) {
        if (lado1 <= 0 || lado2 <= 0) {
            throw new IllegalArgumentException("Os lados do retângulo devem ser positivos.");
        }
        this.lado1 = lado1;
        this.lado2 = lado2;
    }
    @Override
    public void mostrarDados() {
        System.out.println("--- Dados do Retângulo ---");
        System.out.println("Lado 1 (Base): " + lado1);
        System.out.println("Lado 2 (Altura): " + lado2);
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
    }
    @Override
    public double calcularArea() {
        return lado1 * lado2;
    }
    @Override
    public double calcularPerimetro() {
        return 2 * lado1 + 2 * lado2;
    }
}

class Triangulo extends ObjetoGeometrico {
    private double ladoA;
    private double ladoB;
    private double ladoC;

    public Triangulo(double ladoA, double ladoB, double ladoC) {
        if (ladoA <= 0 || ladoB <= 0 || ladoC <= 0) {
            throw new IllegalArgumentException("Os lados do triângulo devem ser positivos.");
        }
        if (!((ladoA + ladoB > ladoC) && (ladoA + ladoC > ladoB) && (ladoB + ladoC > ladoA))) {
            throw new IllegalArgumentException("Os lados fornecidos não formam um triângulo válido.");
        }
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    @Override
    public void mostrarDados() {
        System.out.println("--- Dados do Triângulo ---");
        System.out.println("Lado A: " + ladoA);
        System.out.println("Lado B: " + ladoB);
        System.out.println("Lado C: " + ladoC);
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
    }
    @Override
    public double calcularArea() {
        double s = (ladoA + ladoB + ladoC) / 2;
        return Math.sqrt(s * (s - ladoA) * (s - ladoB) * (s - ladoC));
    }
    @Override
    public double calcularPerimetro() {
        return ladoA + ladoB + ladoC;
    }
}

public class TesteGeometrico {
    public static void main(String[] args) {
        System.out.println("--- Testando Objetos Geométricos ---");
        try {
            Circulo meuCirculo = new Circulo(0, 0, 5);
            meuCirculo.mostrarDados();
            System.out.println("----------------------------------\n");

            Circulo circuloPequeno = new Circulo(1, 2, 1.5);
            circuloPequeno.mostrarDados();
            System.out.println("----------------------------------\n");
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao criar Círculo: " + e.getMessage());
            System.out.println("----------------------------------\n");
        }
        try {
            Retangulo meuRetangulo = new Retangulo(10, 5);
            meuRetangulo.mostrarDados();
            System.out.println("----------------------------------\n");

            Retangulo retanguloQuadrado = new Retangulo(7, 7);
            retanguloQuadrado.mostrarDados();
            System.out.println("----------------------------------\n");
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao criar Retângulo: " + e.getMessage());
            System.out.println("----------------------------------\n");
        }
        try {
            Triangulo meuTriangulo = new Triangulo(3, 4, 5);
            meuTriangulo.mostrarDados();
            System.out.println("----------------------------------\n");

            Triangulo trianguloEquilatero = new Triangulo(6, 6, 6);
            trianguloEquilatero.mostrarDados();
            System.out.println("----------------------------------\n");

        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao criar Triângulo: " + e.getMessage());
            System.out.println("----------------------------------\n");
        }
    }
}