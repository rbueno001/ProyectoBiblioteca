public abstract class Material {

    // Atributos
    private String id;
    private String titulo;
    private boolean prestado;

    // Constructor
    public Material(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.prestado = false;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean estaPrestado() {
        return prestado;
    }

    // Setters
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
}