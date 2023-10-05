public class CuentaCorriente {
    private String numeroCuenta;
    private double saldo;
    public CuentaCorriente() {
        this.numeroCuenta = "";
        this.saldo = 0.0;
    }
    public CuentaCorriente(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }
    public CuentaCorriente(CuentaCorriente otraCuenta) {
        this.numeroCuenta = otraCuenta.numeroCuenta;
        this.saldo = otraCuenta.saldo;
    }
    public void ingreso(double cantidad) {
        saldo += cantidad;
    }
    public void egreso(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
    public void reintegro(double cantidad) {
        saldo += cantidad;
    }
    public void transferencia(CuentaCorriente cuentaDestino, double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            cuentaDestino.ingreso(cantidad);
        } else {
            System.out.println("Saldo insuficiente para realizar la transferencia.");
        }
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}