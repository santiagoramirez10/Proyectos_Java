public class Libro {
    private String titulo;
    private String isbn;
    private String autor;
    private boolean prestado;
    public Libro() {
        this.titulo = "";
        this.isbn = "";
        this.autor = "";
        this.prestado = false;
    }
    public Libro(String titulo, String isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.prestado = false;
    }

    // Método de préstamo
    public void prestamo() {
        if (prestado) {
            System.out.println("El libro ya está prestado.");
        } else {
            prestado = true;
            System.out.println("El libro ha sido prestado.");
        }
    }
    public void devolucion() {
        if (prestado) {
            prestado = false;
            System.out.println("El libro ha sido devuelto.");
        } else {
            System.out.println("El libro ya está en la biblioteca.");
        }
    }

    @Override
    public String toString() {
        return titulo + ", " + isbn + ", " + autor;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isPrestado() {
        return prestado;
    }
}