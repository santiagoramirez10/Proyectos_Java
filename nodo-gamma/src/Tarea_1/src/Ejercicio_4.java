import java.util.Scanner;
//Primeros n números primos.
public class Ejercicio_4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Escriba un número entero n para mostrar los n primeros números primos: ");
        int n=scanner.nextInt();
        int primos_mostrados=0;
        int m=1;
        while (primos_mostrados<=n){
            int divisores=0;
            for (int i=1;i<=m;i++){
                if (m%i==0){
                    divisores+=1;
                }
            }
            if (divisores<=2){
                System.out.println(m);
                primos_mostrados+=1;
            }
            m+=1;
        }
    }
}