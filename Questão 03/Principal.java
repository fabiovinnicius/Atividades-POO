import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Principal {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Funcionario f1 = new Funcionario();
        f1.setNome("Alice Souza");
        try {
            f1.setDataAdmissao(sdf.parse("15/03/2023"));
        } catch (ParseException e) {
            System.out.println("Erro ao converter data para Alice: " + e.getMessage());
        }
        f1.setSalario(3500.00);

        Funcionario f2 = new Funcionario();
        f2.setNome("Bruno Lima");
        try {
            f2.setDataAdmissao(sdf.parse("01/01/2024"));
        } catch (ParseException e) {
            System.out.println("Erro ao converter data para Bruno: " + e.getMessage());
        }
        f2.setSalario(1050.00); // Teste de salário inválido

        Funcionario f3 = new Funcionario();
        f3.setNome("Carla Dias");
        try {
            f3.setDataAdmissao(sdf.parse("20/12/2025")); // Teste de data futura
        } catch (ParseException e) {
            System.out.println("Erro ao converter data para Carla: " + e.getMessage());
        }
        f3.setSalario(2800.00);

        System.out.println("\n--- Dados dos Funcionários ---");

        System.out.println("Funcionário ID: " + f1.getIdentificador());
        System.out.println("Nome: " + f1.getNome());
        System.out.println("Data de Admissão: " + sdf.format(f1.getDataAdmissao()));
        System.out.println("Salário: R$ " + String.format("%.2f", f1.getSalario()));
        System.out.println("--------------------");

        System.out.println("Funcionário ID: " + f2.getIdentificador());
        System.out.println("Nome: " + f2.getNome());
        if (f2.getDataAdmissao() != null) {
            System.out.println("Data de Admissão: " + sdf.format(f2.getDataAdmissao()));
        } else {
            System.out.println("Data de Admissão: Não definida ou inválida.");
        }
        System.out.println("Salário: R$ " + String.format("%.2f", f2.getSalario()));
        System.out.println("--------------------");

        System.out.println("Funcionário ID: " + f3.getIdentificador());
        System.out.println("Nome: " + f3.getNome());
        if (f3.getDataAdmissao() != null) {
            System.out.println("Data de Admissão: " + sdf.format(f3.getDataAdmissao()));
        } else {
            System.out.println("Data de Admissão: Não definida ou inválida.");
        }
        System.out.println("Salário: R$ " + String.format("%.2f", f3.getSalario()));
        System.out.println("--------------------");
    }
}