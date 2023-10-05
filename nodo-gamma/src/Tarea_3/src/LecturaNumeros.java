import java.util.ArrayList;
import java.util.Scanner;
public class LecturaNumeros {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = leerNumeros();
        int cantidadDatos = numeros.size();
        int sumatoria = sumaNumeros(numeros);
        double media = calcularMedia(numeros);
        ArrayList<Integer> numerosMayoresMedia = mayoresMedia(numeros, media);
        System.out.println("Se han ingresado: " + cantidadDatos + " datos");
        System.out.println("La suma de los datos ingresados es: " + sumatoria);
        System.out.println("La media de los datos ingresados es: " + media);
        System.out.println("Los valores ingresados fueron: " + numeros);
        System.out.println("Entre ellos hay " + numerosMayoresMedia.size() + " valores que son mayores que la media");
    }

    public static ArrayList<Integer> leerNumeros() {
        ArrayList<Integer> numeros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese los números enteros (ingrese -99 para terminar):");
        int numero;
        do {
            numero = scanner.nextInt();
            if (numero != -99) {
                numeros.add(numero);
            }
        } while (numero != -99);
        return numeros;
    }

    public static int sumaNumeros(ArrayList<Integer> numeros) {
        int sumaElementos = 0;
        for (int numero : numeros) {
            sumaElementos += numero;
        }
        return sumaElementos;
    }

    public static double calcularMedia(ArrayList<Integer> numeros) {
        int cantidad = numeros.size();
        int suma = 0;
        for (int numero : numeros) {
            suma += numero;
        }
        if (cantidad == 0) {
            return 0;
        }
        return (double) (suma / cantidad);
    }

    public static ArrayList<Integer> mayoresMedia(ArrayList<Integer> numeros, double media) {
        ArrayList<Integer> numerosMayores = new ArrayList<>();
        for (int numero : numeros) {
            if (numero > media) {
                numerosMayores.add(numero);
            }
        }
        return (numerosMayores);
    }
}