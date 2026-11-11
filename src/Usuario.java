import java.util.ArrayList;
import java.util.List;

public class Usuario {

    // Atributos
    private int id;
    private String nombre;
    private List<Material> prestamos;

    // Constructor
    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.prestamos = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Material> getPrestamos() {
        return prestamos;
    }

    // Métodos
    public void prestarMaterial(Material material) throws MaximoPrestamosException, MaterialNoDisponibleException {
        if (cantidadPrestamos() >= 3) {
            throw new MaximoPrestamosException("El usuario ha alcanzado el máximo de 3 préstamos.");
        }

        ((Prestable) material).prestar();
        prestamos.add(material);
    }


    public void devolverMaterial(Material material) throws MaterialNoEncontradoException {
        if (!prestamos.contains(material)) {
            throw new MaterialNoEncontradoException("El usuario " + nombre
                    + " no tiene prestado el material \"" + material.getTitulo()
                    + "\" (ID: " + material.getId() + ").");
        }

        ((Prestable) material).devolver();
        prestamos.remove(material);
    }


    public int cantidadPrestamos() {
        return prestamos.size();
    }
}
