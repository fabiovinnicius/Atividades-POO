public class ExemploVariaveis {
static int contadorDeObjetos = 0;
String nome;
public ExemploVariaveis(String nome) {
this.nome = nome;
contadorDeObjetos++;
}
public void exibirInformacoes() {
System.out.println("Nome: " + nome);
System.out.println("Contador de objetos: " + contadorDeObjetos);
}
public static void main(String[] args) {
ExemploVariaveis obj1 = new ExemploVariaveis("Objeto 1");
ExemploVariaveis obj2 = new ExemploVariaveis("Objeto 2");
obj1.exibirInformacoes();
obj2.exibirInformacoes();
}
}