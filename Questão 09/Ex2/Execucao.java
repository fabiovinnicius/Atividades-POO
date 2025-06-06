import java.time.Year;

// Definição da exceção personalizada
class DataException extends Exception {
    private final int diaInvalido;
    private final int mesInvalido;
    private final int anoInvalido;

    public DataException(int dia, int mes, int ano, String message) {
        super(message);
        this.diaInvalido = dia;
        this.mesInvalido = mes;
        this.anoInvalido = ano;
    }

    public String getDataInvalida() {
        return String.format("%02d/%02d/%d", diaInvalido, mesInvalido, anoInvalido);
    }

    @Override
    public String toString() {
        return super.toString() + " Data tentada: " + getDataInvalida();
    }
}

// Definição da classe Data
class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) throws DataException {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        validarData();
    }

    private void validarData() throws DataException {
        if (mes < 1 || mes > 12) {
            throw new DataException(dia, mes, ano, "Mês inválido. Deve estar entre 1 e 12.");
        }

        if (ano < 1) {
            throw new DataException(dia, mes, ano, "Ano inválido. Deve ser maior ou igual a 1.");
        }

        int diasNoMes;
        switch (mes) {
            case 2: // Fevereiro
                diasNoMes = isAnoBissexto() ? 29 : 28;
                break;
            case 4: // Abril
            case 6: // Junho
            case 9: // Setembro
            case 11: // Novembro
                diasNoMes = 30;
                break;
            default: // Meses com 31 dias
                diasNoMes = 31;
                break;
        }

        if (dia < 1 || dia > diasNoMes) {
            throw new DataException(dia, mes, ano, "Dia inválido para o mês/ano especificado.");
        }
    }

    private boolean isAnoBissexto() {
        return Year.of(ano).isLeap();
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%d", dia, mes, ano);
    }
}

// Definição da classe Execucao
public class Execucao {

    public static void main(String[] args) {
        System.out.println("--- Testando datas válidas ---");
        int[][] datasValidas = {
            {1, 1, 2023},
            {31, 12, 2024},
            {29, 2, 2024},  // Ano bissexto
            {15, 6, 1999},
            {1, 1, 1}       // Ano mínimo
        };

        for (int[] dataArr : datasValidas) {
            int dia = dataArr[0];
            int mes = dataArr[1];
            int ano = dataArr[2];
            try {
                Data data = new Data(dia, mes, ano);
                System.out.println("Data criada com sucesso: " + data);
            } catch (DataException e) {
                System.out.println(String.format("ERRO inesperado ao criar data válida (%02d/%02d/%d): %s", dia, mes, ano, e.getMessage()));
            }
        }

        System.out.println("\n--- Testando datas inválidas ---");
        int[][] datasInvalidas = {
            {32, 1, 2023},  // Dia inválido (maior que 31)
            {30, 2, 2023},  // Dia inválido (fevereiro de ano não bissexto)
            {29, 2, 2023},  // Dia inválido (fevereiro de ano não bissexto)
            {15, 0, 2023},  // Mês inválido (0)
            {15, 13, 2023}, // Mês inválido (13)
            {10, 10, 0},    // Ano inválido (0)
            {31, 4, 2023},  // Dia inválido (abril tem 30 dias)
            {1, 1, -5}      // Ano negativo
        };

        for (int[] dataArr : datasInvalidas) {
            int dia = dataArr[0];
            int mes = dataArr[1];
            int ano = dataArr[2];
            try {
                Data data = new Data(dia, mes, ano);
                System.out.println(String.format("ERRO: Data inválida (%02d/%02d/%d) criada indevidamente: %s", dia, mes, ano, data));
            } catch (DataException e) {
                System.out.println("Sucesso ao capturar exceção: " + e);
            }
        }
    }
}