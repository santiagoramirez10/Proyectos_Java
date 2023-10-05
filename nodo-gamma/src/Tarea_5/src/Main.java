// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        CuentaCorriente cuenta = new CuentaCorriente("1017240851", 1000.0);
        double saldoActual = cuenta.getSaldo();
        System.out.println("Saldo actual: " + saldoActual);//Imprimir saldo actual
        cuenta.ingreso(500.0);//Ingresar dinero
        saldoActual = cuenta.getSaldo();//Actualizar saldo
        System.out.println("Saldo después del ingreso: " + saldoActual);//Saldo actual después del ingreso
        cuenta.egreso(200.0);//Retirar dinero
        saldoActual = cuenta.getSaldo();
        System.out.println("Saldo después del egreso: " + saldoActual);
        cuenta.reintegro(100.0);//Reintegrar saldo
        saldoActual = cuenta.getSaldo();//Actualizar saldo
        System.out.println("Saldo después del reintegro: " + saldoActual);//Saldo actual después del reintegro
        CuentaCorriente otraCuenta = new CuentaCorriente("9876543210", 2000.0);
        cuenta.transferencia(otraCuenta, 400.0);//Se transfieren 300 de la primera cuenta a la segunda
        double saldoCuenta1 = cuenta.getSaldo();
        double saldoCuenta2 = otraCuenta.getSaldo();
        System.out.println("Saldo de la primera cuenta después de la transferencia: " + saldoCuenta1);
        System.out.println("Saldo de la segunda cuenta después de la transferencia: " + saldoCuenta2);
    }
}