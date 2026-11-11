public class Revista extends Material implements Prestable {

    // Atributos
    private int numero;

    // Constructor
    public Revista(String id, String titulo, int numero) {
        super(id, titulo);
        this.numero = numero;
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
