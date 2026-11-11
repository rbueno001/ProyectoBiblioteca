import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroErrores {

    // Métodos
    public void registrar(Exception e, String usuario, String operacion) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (FileWriter archivo = new FileWriter("errores.log", true)) {
            archivo.write(LocalDateTime.now().format(formato)
                    + " - El usuario " + usuario
                    + " intentó " + operacion
                    + ", pero ocurrió " + e.getClass().getSimpleName()
                    + ": " + e.getMessage()
                    + System.lineSeparator());
        } catch (IOException ex) {
            System.out.println("Error al registrar la excepción: " + ex.getMessage());
        }
    }
}
