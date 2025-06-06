import java.util.ArrayList;
import java.util.List;

class Pessoa {
    protected String nome;
    protected String endereco;
    protected int idade;
    protected String cpf;
    protected char sexo;

    public Pessoa(String nome, String endereco, int idade, String cpf, char sexo) {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public void andar() {
        System.out.println(nome + " está andando.");
    }

    public void imprimirValores() {
        System.out.println("--- Dados da Pessoa ---");
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("CPF: " + cpf);
        System.out.println("Sexo: " + sexo);
    }
}

class Paciente extends Pessoa {
    private String doenca;
    private String medicacao;

    public Paciente(String nome, String endereco, int idade, String cpf, char sexo, String doenca, String medicacao) {
        super(nome, endereco, idade, cpf, sexo);
        this.doenca = doenca;
        this.medicacao = medicacao;
    }

    public void sentirDor() {
        System.out.println(nome + " está sentindo dor devido à(o) " + doenca + ".");
    }

    public void terAlta() {
        System.out.println(nome + " recebeu alta do hospital!");
    }

    @Override
    public void imprimirValores() {
        super.imprimirValores();
        System.out.println("--- Dados do Paciente ---");
        System.out.println("Doença: " + doenca);
        System.out.println("Medicação: " + medicacao);
    }
}

class Medico extends Pessoa {
    private String crm;
    private double salario;
    private String especializacao;

    // Construtor
    public Medico(String nome, String endereco, int idade, String cpf, char sexo, String crm, double salario, String especializacao) {
        super(nome, endereco, idade, cpf, sexo);
        this.crm = crm;
        this.salario = salario;
        this.especializacao = especializacao;
    }

    public void darPlantao() {
        System.out.println("Dr(a). " + nome + " está dando plantão como " + especializacao + ".");
    }

    @Override
    public void imprimirValores() {
        super.imprimirValores();
        System.out.println("--- Dados do Médico ---");
        System.out.println("CRM: " + crm);
        System.out.println("Salário: R$" + String.format("%.2f", salario));
        System.out.println("Especialização: " + especializacao);
    }
}

class Hospital {
    private String nome;
    private String endereco;
    private List<Paciente> pacientes;
    private List<Medico> medicos;

    // Construtor
    public Hospital(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
    }

    public void adicionarPaciente(Paciente paciente) {
        this.pacientes.add(paciente);
        System.out.println(paciente.nome + " foi admitido(a) no " + nome + ".");
    }

    public void adicionarMedico(Medico medico) {
        this.medicos.add(medico);
        System.out.println("Dr(a). " + medico.nome + " foi contratado(a) pelo " + nome + ".");
    }

    public void imprimirValores() {
        System.out.println("\n=== Informações do Hospital ===");
        System.out.println("Nome do Hospital: " + nome);
        System.out.println("Endereço do Hospital: " + endereco);

        System.out.println("\n--- Pacientes no Hospital ---");
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            for (Paciente p : pacientes) {
                p.imprimirValores();
                System.out.println("-------------------------");
            }
        }

        System.out.println("\n--- Equipe Médica no Hospital ---");
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
        } else {
            for (Medico m : medicos) {
                m.imprimirValores();
                System.out.println("-------------------------");
            }
        }
    }
}

public class SistemaHospitalar {
    public static void main(String[] args) {
        Pessoa pessoaGenerica = new Pessoa("Ana Silva", "Rua das Flores, 10", 30, "111.222.333-44", 'F');
        pessoaGenerica.imprimirValores();
        pessoaGenerica.andar();
        System.out.println("\n");

        Paciente paciente1 = new Paciente("João Pereira", "Av. Brasil, 1000", 55, "555.666.777-88", 'M', "Diabetes Tipo 2", "Insulina");
        paciente1.imprimirValores();
        paciente1.andar();
        paciente1.sentirDor();
        System.out.println("\n");

        Paciente paciente2 = new Paciente("Maria Oliveira", "Rua da Paz, 50", 28, "999.888.777-66", 'F', "Crise de Asma", "Bombinha de Alívio");
        paciente2.imprimirValores();
        paciente2.terAlta();
        System.out.println("\n");
        Medico medico1 = new Medico("Carlos Souza", "Rua do Saber, 123", 45, "123.456.789-00", 'M', "CRM/SP 12345", 15000.00, "Cardiologista");
        medico1.imprimirValores();
        medico1.andar();
        medico1.darPlantao();
        System.out.println("\n");
        Medico medico2 = new Medico("Patrícia Lima", "Av. Central, 456", 38, "098.765.432-11", 'F', "CRM/RJ 54321", 12000.00, "Pediatra");
        medico2.imprimirValores();
        medico2.darPlantao();
        System.out.println("\n");
        Hospital meuHospital = new Hospital("Hospital Central", "Praça da Saúde, 789");
        meuHospital.adicionarPaciente(paciente1);
        meuHospital.adicionarPaciente(paciente2);
        meuHospital.adicionarMedico(medico1);
        meuHospital.adicionarMedico(medico2);
        meuHospital.imprimirValores();
    }
}