import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Main {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date dataNascTitular = sdf.parse("01/01/1980");
            Pessoa titularPessoa = new Pessoa("Carlos Silva", "Rua A, 123", dataNascTitular, "Masculino");
            System.out.println(titularPessoa);

            Date dataNascDependente = sdf.parse("10/05/2010");
            Pessoa dependentePessoa = new Pessoa("Ana Silva", "Rua A, 123", dataNascDependente, "Feminino");
            System.out.println(dependentePessoa);

            Date vencimentoFatura1 = sdf.parse("25/06/2025");
            Fatura fatura1 = new Fatura(vencimentoFatura1, new BigDecimal("10.00"), new BigDecimal("0.50"));
            System.out.println(fatura1);

            Date vencimentoFatura2 = sdf.parse("15/07/2025");
            Fatura fatura2 = new Fatura(vencimentoFatura2, new BigDecimal("5.00"), new BigDecimal("0.25"));
            System.out.println(fatura2);

            Date dataConsulta = sdf.parse("01/06/2025");
            Consulta consulta1 = new Consulta(dataConsulta, "Dr. João");
            fatura1.adicionarConsulta(consulta1);
            System.out.println(consulta1);

            Date dataExame = sdf.parse("03/06/2025");
            Exame exame1 = new Exame(dataExame, "Laboratório X");
            fatura1.adicionarExame(exame1);
            System.out.println(exame1);

            Date dataConsulta2 = sdf.parse("05/06/2025");
            Consulta consulta2 = new Consulta(dataConsulta2, "Dra. Maria");
            fatura2.adicionarConsulta(consulta2);
            System.out.println(consulta2);

            Date dataInicioContrato = sdf.parse("01/01/2025");
            Contrato contratoTitular = new Contrato(dataInicioContrato, "Carlos Silva", titularPessoa);
            contratoTitular.setFaturaGeral(fatura1);
            System.out.println(contratoTitular);

            Dependente dependente1 = new Dependente(new BigDecimal("150.00"), contratoTitular);
            dependente1.setFatura(fatura2);
            contratoTitular.adicionarDependente(dependente1); 
            System.out.println(dependente1);

            System.out.println("\n--- Resumo ---");
            System.out.println("Contrato: " + contratoTitular.getTitular());
            System.out.println("  Pessoa Titular: " + contratoTitular.getPessoaTitular().getNome());
            System.out.println("  Dependentes (" + contratoTitular.getDependentes().size() + "):");
            for (Dependente d : contratoTitular.getDependentes()) {
                System.out.println("    - " + d.getPreco() + " (Fatura: " + (d.getFatura() != null ? sdf.format(d.getFatura().getDataVencimento()) : "N/A") + ")");
            }
            System.out.println("  Fatura Geral do Contrato: " + (contratoTitular.getFaturaGeral() != null ? sdf.format(contratoTitular.getFaturaGeral().getDataVencimento()) : "N/A"));
            if (contratoTitular.getFaturaGeral() != null) {
                System.out.println("    Consultas na Fatura Geral (" + contratoTitular.getFaturaGeral().getConsultas().size() + "):");
                for (Consulta c : contratoTitular.getFaturaGeral().getConsultas()) {
                    System.out.println("      - " + sdf.format(c.getData()) + " - " + c.getProfissionalSaude());
                }
                System.out.println("    Exames na Fatura Geral (" + contratoTitular.getFaturaGeral().getExames().size() + "):");
                for (Exame e : contratoTitular.getFaturaGeral().getExames()) {
                    System.out.println("      - " + sdf.format(e.getData()) + " - " + e.getProfissionalSaude());
                }
            }


        } catch (ParseException e) {
            System.err.println("Erro de parse de data: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Erro de argumento inválido: " + e.getMessage());
        }
    }
}