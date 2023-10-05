import java.util.Scanner;
//Determinar si el número n es primo.
public class Ejercicio_3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Escriba un número entero n para mostrar si es primo o no: ");
        int n=scanner.nextInt();
        int divisores=0;
        for (int i=1;i<=n;i++){
            if (n%i==0){
                divisores+=1;
            }
        }
        if (divisores>2){
            System.out.println(n+" NO es un número primo.");
        }
        else {
            System.out.println(n+" SÍ es un número primo.");
        }
    }
}
