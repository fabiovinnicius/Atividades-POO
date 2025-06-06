import java.util.InputMismatchException;
import java.util.Scanner;

public class Cadastro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nomeCompleto = "";
        String ddd = "";
        String numeroTelefone = "";
        boolean cadastroConcluido = false;

        System.out.println("--- Início do Processo de Cadastro ---");

        while (!cadastroConcluido) {
            try {
                // 1. Solicitar Nome Completo
                System.out.print("\nDigite o nome completo: ");
                nomeCompleto = scanner.nextLine().trim(); // .trim() para remover espaços em branco no início/fim

                if (nomeCompleto.isEmpty()) {
                    throw new IllegalArgumentException("O nome completo não pode ser vazio.");
                }

                // 2. Solicitar DDD
                System.out.print("Digite o DDD (ex: 11): ");
                ddd = scanner.nextLine().trim();

                if (!ddd.matches("\\d{2}")) { // Verifica se tem exatamente 2 dígitos numéricos
                    throw new IllegalArgumentException("O DDD deve conter exatamente 2 dígitos inteiros.");
                }

                // 3. Solicitar Número de Telefone
                System.out.print("Digite o número de telefone (8 ou 9 dígitos): ");
                numeroTelefone = scanner.nextLine().trim();

                if (!numeroTelefone.matches("\\d{8}|\\d{9}")) { // Verifica se tem 8 ou 9 dígitos numéricos
                    throw new IllegalArgumentException("O número de telefone deve conter 8 ou 9 dígitos inteiros.");
                }

                // Se chegou até aqui, todas as informações são válidas
                cadastroConcluido = true;
                System.out.println("\n--- Cadastro Realizado com Sucesso! ---");
                System.out.println("Nome Completo: " + nomeCompleto);
                System.out.println("Telefone: (" + ddd + ") " + numeroTelefone);

            } catch (IllegalArgumentException e) {
                System.err.println("Erro no cadastro: " + e.getMessage());
                System.out.println("Por favor, tente novamente.");
                // O loop while fará com que o processo seja reiniciado.
            } catch (InputMismatchException e) {
                System.err.println("Erro de entrada: Tipo de dado inválido. " + e.getMessage());
                scanner.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
                System.out.println("Por favor, tente novamente.");
            } catch (Exception e) {
                System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
                System.out.println("Por favor, tente novamente.");
            }
        }

        scanner.close(); // Fechar o scanner quando não for mais necessário
        System.out.println("\n--- Fim do Processo de Cadastro ---");
    }
}