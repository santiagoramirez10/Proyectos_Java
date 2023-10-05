import java.util.Scanner;
//Primeros n múltiplos de m.
public class Ejercicio_2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Escriba un número entero n para mostrar los n primeros dígitos: ");
        int n=scanner.nextInt();
        System.out.printf("Escriba un número entero m para mostrar los multiplos de m: ");
        int m=scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println(m*i);
        }
    }
}
