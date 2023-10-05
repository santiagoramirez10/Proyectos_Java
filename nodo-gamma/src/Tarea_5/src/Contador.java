public class Contador {
    private int valor;

    // Constructor por defecto
    public Contador() {
        this.valor = 0;
    }

    // Constructor con parámetros
    public Contador(int valor) {
        this.valor = valor;
    }

    // Constructor copia
    public Contador(Contador otroContador) {
        this.valor = otroContador.valor;
    }

    // Método de incremento
    public void incrementar() {
        valor++;
    }

    // Método de decremento
    public void decrementar() {
        valor--;
    }

    // Método de acceso para obtener el valor
    public int getValor() {
        return valor;
    }

    // Método de acceso para establecer el valor
    public void setValor(int valor) {
        this.valor = valor;
    }
}
