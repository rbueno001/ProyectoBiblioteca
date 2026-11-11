import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    // Atributos
    private List<Material> materiales;
    private List<Usuario> usuarios;

    // Constructor
    public Biblioteca() {
        this.materiales = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    // Métodos
    public void registrarMaterial(Material material) {
        materiales.add(material);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Material buscarMaterial(String id) throws MaterialNoEncontradoException {
        for (Material material : materiales) {
            if (material.getId().equals(id)) {
                return material;
            }
        }

        throw new MaterialNoEncontradoException("El material no fue encontrado.");
    }

    public Usuario buscarUsuario(int id) throws UsuarioNoEncontradoException {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }

        throw new UsuarioNoEncontradoException("El usuario no fue encontrado.");
    }

    public void prestarMaterial(int usuarioId, String materialId)
            throws UsuarioNoEncontradoException, MaterialNoEncontradoException,
            MaximoPrestamosException, MaterialNoDisponibleException {

        Usuario usuario = buscarUsuario(usuarioId);
        Material material = buscarMaterial(materialId);

        usuario.prestarMaterial(material);
    }

    public void devolverMaterial(int usuarioId, String materialId)
            throws UsuarioNoEncontradoException, MaterialNoEncontradoException {

        Usuario usuario = buscarUsuario(usuarioId);
        Material material = buscarMaterial(materialId);

        usuario.devolverMaterial(material);
    }

}
