import java.util.Scanner;
//Primeros n números pares.
public class Ejercicio_1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Escriba un número entero n para mostrar esos n primeros números pares: ");
        int n=scanner.nextInt();
        for (int i = 2; i <= n*2; i += 2) {
            System.out.println(i);
        }
    }
}
