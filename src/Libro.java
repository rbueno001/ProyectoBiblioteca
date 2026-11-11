public class Libro extends Material implements Prestable {

    // Atributos
    private String autor;
    private String isbn;

    // Constructor
    public Libro(String id, String titulo, String autor, String isbn) {
        super(id, titulo);
        this.autor = autor;
        this.isbn = isbn;
    }

    // Métodos
    @Override
    public void prestar() throws MaterialNoDisponibleException {
        if (estaPrestado()) {
            throw new MaterialNoDisponibleException("El material ya está prestado.");
        }

        setPrestado(true);
    }

    @Override
    public void devolver() {
        setPrestado(false);
    }
}
