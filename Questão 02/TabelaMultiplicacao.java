import java.util.Scanner;
public class TabelaMultiplicacao {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Digite o valor de n: ");
int n = scanner.nextInt();
for (int i = 1; i <= n; i++) {
for (int j = 1; j <= i; j++) {
System.out.print((i * j) + " ");
}
System.out.println();
}
}
}