public class Libro {
    private String titulo;
    private String autor;  // Para cumplir el mini ejercicio
    private int stock;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.stock = 0;
    }

    public Libro(String titulo, String autor, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.stock = stock;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return titulo + " - " + autor;
    }
}
