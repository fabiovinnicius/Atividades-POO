import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Classe Pessoa
class Pessoa {
    private String nome;
    private String endereco;
    private Date dataNascimento;
    private String sexo;

    public Pessoa(String nome, String endereco, Date dataNascimento, String sexo) {
        this.nome = nome;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Pessoa [Nome: " + nome + ", Endereço: " + endereco + ", Data Nasc: " + dataNascimento + ", Sexo: " + sexo + "]";
    }
}

// Classe Consulta
class Consulta {
    private Date data;
    private String profissionalSaude;

    public Consulta(Date data, String profissionalSaude) {
        this.data = data;
        this.profissionalSaude = profissionalSaude;
    }

    // Getters
    public Date getData() {
        return data;
    }

    public String getProfissionalSaude() {
        return profissionalSaude;
    }

    // Setters
    public void setData(Date data) {
        this.data = data;
    }

    public void setProfissionalSaude(String profissionalSaude) {
        this.profissionalSaude = profissionalSaude;
    }

    @Override
    public String toString() {
        return "Consulta [Data: " + data + ", Profissional: " + profissionalSaude + "]";
    }
}

// Classe Exame
class Exame {
    private Date data;
    private String profissionalSaude;

    public Exame(Date data, String profissionalSaude) {
        this.data = data;
        this.profissionalSaude = profissionalSaude;
    }

    // Getters
    public Date getData() {
        return data;
    }

    public String getProfissionalSaude() {
        return profissionalSaude;
    }

    // Setters
    public void setData(Date data) {
        this.data = data;
    }

    public void setProfissionalSaude(String profissionalSaude) {
        this.profissionalSaude = profissionalSaude;
    }

    @Override
    public String toString() {
        return "Exame [Data: " + data + ", Profissional: " + profissionalSaude + "]";
    }
}

// Classe Fatura
class Fatura {
    private Date dataVencimento;
    private BigDecimal multa;
    private BigDecimal jurosDiarios;
    private List<Consulta> consultas;
    private List<Exame> exames;

    public Fatura(Date dataVencimento, BigDecimal multa, BigDecimal jurosDiarios) {
        this.dataVencimento = dataVencimento;
        this.multa = multa;
        this.jurosDiarios = jurosDiarios;
        this.consultas = new ArrayList<>();
        this.exames = new ArrayList<>();
    }

    public void adicionarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }

    public void adicionarExame(Exame exame) {
        this.exames.add(exame);
    }

    // Getters
    public Date getDataVencimento() {
        return dataVencimento;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public BigDecimal getJurosDiarios() {
        return jurosDiarios;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public List<Exame> getExames() {
        return exames;
    }

    // Setters
    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    public void setJurosDiarios(BigDecimal jurosDiarios) {
        this.jurosDiarios = jurosDiarios;
    }

    @Override
    public String toString() {
        return "Fatura [Vencimento: " + dataVencimento + ", Multa: " + multa + ", Juros Diarios: " + jurosDiarios +
               ", Consultas: " + consultas.size() + ", Exames: " + exames.size() + "]";
    }
}

// Classe Dependente
class Dependente {
    private BigDecimal preco;
    private Contrato contrato; // 1 contrato
    private Fatura fatura;     // 0..1 fatura

    public Dependente(BigDecimal preco, Contrato contrato) {
        if (contrato == null) {
            throw new IllegalArgumentException("Dependente deve estar associado a um Contrato.");
        }
        this.preco = preco;
        this.contrato = contrato;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    // Getters
    public BigDecimal getPreco() {
        return preco;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public Fatura getFatura() {
        return fatura;
    }

    // Setters
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Dependente [Preço: " + preco + ", Contrato do Titular: " + contrato.getTitular() +
               (fatura != null ? ", Fatura: " + fatura.getDataVencimento() : ", Sem Fatura") + "]";
    }
}

// Classe Contrato
class Contrato {
    private Date dataInicio;
    private String titular;
    private Pessoa pessoaTitular; // 1 Pessoa (titular)
    private List<Dependente> dependentes; // 0..* Dependentes
    private Fatura faturaGeral; // 0..1 Fatura

    public Contrato(Date dataInicio, String titular, Pessoa pessoaTitular) {
        if (pessoaTitular == null) {
            throw new IllegalArgumentException("Contrato deve ter um titular Pessoa.");
        }
        this.dataInicio = dataInicio;
        this.titular = titular;
        this.pessoaTitular = pessoaTitular;
        this.dependentes = new ArrayList<>();
    }

    public void adicionarDependente(Dependente dependente) {
        if (dependente != null) {
            this.dependentes.add(dependente);
        }
    }

    public void setFaturaGeral(Fatura faturaGeral) {
        this.faturaGeral = faturaGeral;
    }

    // Getters
    public Date getDataInicio() {
        return dataInicio;
    }

    public String getTitular() {
        return titular;
    }

    public Pessoa getPessoaTitular() {
        return pessoaTitular;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public Fatura getFaturaGeral() {
        return faturaGeral;
    }

    // Setters
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setPessoaTitular(Pessoa pessoaTitular) {
        this.pessoaTitular = pessoaTitular;
    }

    @Override
    public String toString() {
        return "Contrato [Início: " + dataInicio + ", Titular: " + titular +
               ", Pessoa Titular: " + pessoaTitular.getNome() +
               ", Dependentes: " + dependentes.size() +
               (faturaGeral != null ? ", Fatura Geral: " + faturaGeral.getDataVencimento() : ", Sem Fatura Geral") + "]";
    }
}