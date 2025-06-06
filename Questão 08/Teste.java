class Pessoa {
String nome;
Pessoa(String nome) {
this.nome = nome;
}
}
public class Teste {
public static void alterarNome(Pessoa p) {
p.nome = "Maria";
}

public static void tentarTrocarReferencia(Pessoa p) {
p = new Pessoa("João");
}
public static void main(String[] args) {
Pessoa pessoa = new Pessoa("Carlos");
System.out.println("Antes: " + pessoa.nome); // Carlos
alterarNome(pessoa);
System.out.println("Depois alterarNome: " + pessoa.nome); // Maria (alteração refletida)
tentarTrocarReferencia(pessoa);
System.out.println("Depois tentarTrocarReferencia: " + pessoa.nome); // Maria (nãomudou para João)
}
}