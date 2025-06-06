import java.util.Date;

class Funcionario {

    private String nome;
    private Date dataAdmissao;
    private double salario;
    private int identificador;
    private static int proximoIdentificador = 1;

    public Funcionario() {
        this.identificador = proximoIdentificador++;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataAdmissao() {
        return this.dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        Date hoje = new Date();
        if (dataAdmissao.after(hoje)) {
            System.out.println("Erro: Data de admissão não pode ser no futuro. Data não alterada para o funcionário " + this.nome + " (ID: " + this.identificador + ").");
        } else {
            this.dataAdmissao = dataAdmissao;
        }
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        if (salario < 1100.00) {
            System.out.println("Erro: Salário não pode ser inferior a R$ 1.100,00. Salário não alterado para o funcionário " + this.nome + " (ID: " + this.identificador + ").");
        } else {
            this.salario = salario;
        }
    }

    public int getIdentificador() {
        return this.identificador;
    }
}