import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

abstract class RecursoFerroviario {
    protected String numeroSerie;

    public RecursoFerroviario(String numeroSerie) {
        if (numeroSerie == null || numeroSerie.trim().isEmpty()) {
            throw new IllegalArgumentException("Número de série do recurso ferroviário não pode ser vazio.");
        }
        this.numeroSerie = numeroSerie;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public abstract void imprimirDados();
}

class Vagao extends RecursoFerroviario {
    private String tipo;
    private double capacidadeCarga;
    private double comprimentoTesteiras;
    private double comprimentoEngates;

    public Vagao(String numeroSerie, String tipo, double capacidadeCarga, double comprimentoTesteiras, double comprimentoEngates) {
        super(numeroSerie);
        this.tipo = tipo != null ? tipo : "Não especificado";
        this.capacidadeCarga = capacidadeCarga >= 0 ? capacidadeCarga : 0;
        this.comprimentoTesteiras = comprimentoTesteiras >= 0 ? comprimentoTesteiras : 0;
        this.comprimentoEngates = comprimentoEngates >= 0 ? comprimentoEngates : 0;
    }

    public Vagao(String numeroSerie) {
        this(numeroSerie, null, 0, 0, 0);
    }

    @Override
    public void imprimirDados() {
        System.out.println("--- Dados do Vagão ---");
        System.out.println("Número de Série: " + numeroSerie);
        System.out.println("Tipo: " + tipo);
        System.out.println("Capacidade de Carga: " + capacidadeCarga + " toneladas");
        System.out.println("Comprimento Testeiras: " + comprimentoTesteiras + " metros");
        System.out.println("Comprimento Engates: " + comprimentoEngates + " metros");
    }
}

class Locomotiva extends RecursoFerroviario {
    private double capacidadeTracao;
    private double comprimento;

    public Locomotiva(String numeroSerie, double capacidadeTracao, double comprimento) {
        super(numeroSerie);
        this.capacidadeTracao = capacidadeTracao >= 0 ? capacidadeTracao : 0;
        this.comprimento = comprimento >= 0 ? comprimento : 0;
    }

    public Locomotiva(String numeroSerie) {
        this(numeroSerie, 0, 0);
    }

    @Override
    public void imprimirDados() {
        System.out.println("--- Dados da Locomotiva ---");
        System.out.println("Número de Série: " + numeroSerie);
        System.out.println("Capacidade de Tração: " + capacidadeTracao + " toneladas");
        System.out.println("Comprimento: " + comprimento + " metros");
    }
}

class Trem extends RecursoFerroviario {
    private String prefixo;
    private LocalDate dataFormacao;
    private EstacaoFerroviaria estacaoOrigem;
    private EstacaoFerroviaria estacaoDestino;
    private List<Vagao> vagoes;
    private List<Locomotiva> locomotivas;
    private static final int LIMITE_RECURSOS = 150;

    public Trem(String prefixo, LocalDate dataFormacao, EstacaoFerroviaria estacaoOrigem, EstacaoFerroviaria estacaoDestino, List<Vagao> vagoes, List<Locomotiva> locomotivas) {
        super(prefixo);
        if (prefixo == null || prefixo.trim().isEmpty()) {
            throw new IllegalArgumentException("Prefixo do trem não pode ser vazio.");
        }
        if (dataFormacao == null) {
            throw new IllegalArgumentException("Data de formação do trem não pode ser nula.");
        }
        if (estacaoOrigem == null || estacaoDestino == null) {
            throw new IllegalArgumentException("Estação de origem e destino devem ser definidas.");
        }
        if (estacaoOrigem.equals(estacaoDestino)) {
            throw new IllegalArgumentException("A estação de origem não pode ser igual à estação de destino.");
        }
        if (vagoes == null || locomotivas == null) {
            throw new IllegalArgumentException("Listas de vagões e locomotivas não podem ser nulas.");
        }
        if (vagoes.size() + locomotivas.size() > LIMITE_RECURSOS) {
            throw new IllegalArgumentException("Um trem não pode ter mais do que " + LIMITE_RECURSOS + " recursos.");
        }

        this.prefixo = prefixo;
        this.dataFormacao = dataFormacao;
        this.estacaoOrigem = estacaoOrigem;
        this.estacaoDestino = estacaoDestino;
        this.vagoes = new ArrayList<>(vagoes);
        this.locomotivas = new ArrayList<>(locomotivas);
    }

    @Override
    public void imprimirDados() {
        System.out.println("--- Dados do Trem ---");
        System.out.println("Prefixo: " + prefixo);
        System.out.println("Data de Formação: " + dataFormacao);
        System.out.println("Estação de Origem: " + estacaoOrigem.getSigla() + " - " + estacaoOrigem.getDescricao());
        System.out.println("Estação de Destino: " + estacaoDestino.getSigla() + " - " + estacaoDestino.getDescricao());
        System.out.println("Total de Recursos: " + (vagoes.size() + locomotivas.size()));
        System.out.println("Vagões (" + vagoes.size() + "):");
        for (Vagao v : vagoes) {
            System.out.println("  - Vagão S/N: " + v.getNumeroSerie());
        }
        System.out.println("Locomotivas (" + locomotivas.size() + "):");
        for (Locomotiva l : locomotivas) {
            System.out.println("  - Locomotiva S/N: " + l.getNumeroSerie());
        }
    }
}

class LinhaFerroviaria {
    private int numero;
    private double extensaoMetros;
    private String descricao;
    private List<RecursoFerroviario> recursosEstacionados;

    public LinhaFerroviaria(int numero, double extensaoMetros, String descricao, List<RecursoFerroviario> recursosEstacionados) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Número da linha ferroviária deve ser positivo.");
        }
        if (extensaoMetros <= 0) {
            throw new IllegalArgumentException("Extensão da linha ferroviária deve ser positiva.");
        }
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição da linha ferroviária não pode ser vazia.");
        }
        this.numero = numero;
        this.extensaoMetros = extensaoMetros;
        this.descricao = descricao;
        this.recursosEstacionados = recursosEstacionados != null ? new ArrayList<>(recursosEstacionados) : new ArrayList<>();
    }

    public LinhaFerroviaria(int numero, double extensaoMetros, String descricao) {
        this(numero, extensaoMetros, descricao, null);
    }

    public int getNumero() {
        return numero;
    }

    public void adicionarRecurso(RecursoFerroviario recurso) {
        if (recurso != null) {
            recursosEstacionados.add(recurso);
        }
    }

    public void imprimirDados() {
        System.out.println("--- Dados da Linha Ferroviária ---");
        System.out.println("Número: " + numero);
        System.out.println("Extensão: " + extensaoMetros + " metros");
        System.out.println("Descrição: " + descricao);
        System.out.println("Recursos Estacionados (" + recursosEstacionados.size() + "):");
        if (recursosEstacionados.isEmpty()) {
            System.out.println("  Nenhum recurso estacionado.");
        } else {
            for (RecursoFerroviario r : recursosEstacionados) {
                System.out.println("  - " + r.getClass().getSimpleName() + ": " + r.getNumeroSerie());
            }
        }
    }
}

class EstacaoFerroviaria {
    private String sigla;
    private String descricao;
    private List<LinhaFerroviaria> linhasFerroviarias;

    public EstacaoFerroviaria(String sigla, String descricao, List<LinhaFerroviaria> linhasFerroviarias) {
        if (sigla == null || sigla.trim().isEmpty()) {
            throw new IllegalArgumentException("Sigla da estação não pode ser vazia.");
        }
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição da estação não pode ser vazia.");
        }
        if (linhasFerroviarias == null || linhasFerroviarias.isEmpty()) {
            throw new IllegalArgumentException("Uma estação ferroviária deve ter pelo menos uma linha.");
        }
        this.sigla = sigla;
        this.descricao = descricao;
        this.linhasFerroviarias = new ArrayList<>(linhasFerroviarias);
    }

    public String getSigla() {
        return sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void adicionarLinha(LinhaFerroviaria linha) {
        if (linha != null) {
            linhasFerroviarias.add(linha);
        }
    }

    public void imprimirDados() {
        System.out.println("=== Dados da Estação Ferroviária ===");
        System.out.println("Sigla: " + sigla);
        System.out.println("Descrição: " + descricao);
        System.out.println("Linhas Ferroviárias (" + linhasFerroviarias.size() + "):");
        for (LinhaFerroviaria linha : linhasFerroviarias) {
            linha.imprimirDados();
            System.out.println("------------------------------------");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstacaoFerroviaria that = (EstacaoFerroviaria) o;
        return Objects.equals(sigla, that.sigla);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sigla);
    }
}

public class ProgramaFerroviario {
    public static void main(String[] args) {
        System.out.println("--- Demonstração do Sistema Ferroviário ---");

        Locomotiva locomotiva1 = new Locomotiva("L001", 1200, 20);
        Vagao vagao1 = new Vagao("V001", "Carga Geral", 50, 15, 1.5);
        Vagao vagao2 = new Vagao("V002", "Tanque", 60, 18, 1.5);
        Vagao vagao3 = new Vagao("V003", "Container", 45, 12, 1.5);

        List<Locomotiva> locomotivasTrem = new ArrayList<>();
        locomotivasTrem.add(locomotiva1);

        List<Vagao> vagoesTrem = new ArrayList<>();
        vagoesTrem.add(vagao1);
        vagoesTrem.add(vagao2);
        vagoesTrem.add(vagao3);

        List<LinhaFerroviaria> linhasEstacaoA = new ArrayList<>();
        EstacaoFerroviaria estacaoA = new EstacaoFerroviaria("ETA", "Estação Principal A", linhasEstacaoA);

        List<LinhaFerroviaria> linhasEstacaoB = new ArrayList<>();
        EstacaoFerroviaria estacaoB = new EstacaoFerroviaria("ETB", "Estação de Destino B", linhasEstacaoB);

        Trem trem1 = new Trem("NAG1010", LocalDate.of(2025, 6, 5), estacaoA, estacaoB, vagoesTrem, locomotivasTrem);

        List<RecursoFerroviario> recursosLinha101 = new ArrayList<>();
        recursosLinha101.add(trem1);

        LinhaFerroviaria linha101 = new LinhaFerroviaria(101, 50000, "Linha expressa entre ETA e ETB", recursosLinha101);

        estacaoA.adicionarLinha(linha101);
        estacaoB.adicionarLinha(linha101);

        System.out.println("\n");
        locomotiva1.imprimirDados();
        System.out.println("\n");
        vagao1.imprimirDados();
        System.out.println("\n");
        trem1.imprimirDados();
        System.out.println("\n");
        linha101.imprimirDados();
        System.out.println("\n");
        estacaoA.imprimirDados();
        System.out.println("\n");
        estacaoB.imprimirDados();

        System.out.println("\n--- Fim da Demonstração ---");
    }
}