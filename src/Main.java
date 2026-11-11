public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        RegistroErrores registroErrores = new RegistroErrores();

        // Usuarios
        Usuario usuario1 = new Usuario(1, "Alexander Bueno");
        Usuario usuario2 = new Usuario(2, "Henry Sandoval");
        Usuario usuario3 = new Usuario(3, "Rolanda Oliver");

        biblioteca.registrarUsuario(usuario1);
        biblioteca.registrarUsuario(usuario2);
        biblioteca.registrarUsuario(usuario3);

        // Libros
        biblioteca.registrarMaterial(new Libro("L1", "Cien años de soledad", "Gabriel García Márquez", "ISBN1"));
        biblioteca.registrarMaterial(new Libro("L2", "La isla bajo el mar", "Isabel Allende", "ISBN2"));
        biblioteca.registrarMaterial(new Libro("L3", "Cocorí", "Joaquín Gutiérrez", "ISBN3"));
        biblioteca.registrarMaterial(new Libro("L4", "El Moto", "Joaquín García Monge", "ISBN4"));
        biblioteca.registrarMaterial(new Libro("L5", "Única mirando al mar", "Fernando Contreras Castro", "ISBN5"));
        biblioteca.registrarMaterial(new Libro("L6", "En una silla de ruedas", "Carmen Lyra", "ISBN6"));
        biblioteca.registrarMaterial(new Libro("L7", "Don Quijote de la Mancha", "Miguel de Cervantes", "ISBN7"));
        biblioteca.registrarMaterial(new Libro("L8", "La Ilíada", "Homero", "ISBN8"));
        biblioteca.registrarMaterial(new Libro("L9", "La Odisea", "Homero", "ISBN9"));
        biblioteca.registrarMaterial(new Libro("L10", "El Principito", "Antoine de Saint-Exupéry", "ISBN10"));
        biblioteca.registrarMaterial(new Libro("L11", "Un grito desesperado", "Carlos Cuauhtémoc Sánchez", "ISBN11"));
        biblioteca.registrarMaterial(new Libro("L12", "Los ojos de mi princesa", "Carlos Cuauhtémoc Sánchez", "ISBN12"));
        biblioteca.registrarMaterial(new Libro("L13", "Juventud en éxtasis", "Carlos Cuauhtémoc Sánchez", "ISBN13"));

        // Revistas
        biblioteca.registrarMaterial(new Revista("R1", "Cosmopolitan", 1));
        biblioteca.registrarMaterial(new Revista("R2", "Vanidades", 1));
        biblioteca.registrarMaterial(new Revista("R3", "Tú", 1));
        biblioteca.registrarMaterial(new Revista("R4", "National Geographic", 1));
        biblioteca.registrarMaterial(new Revista("R5", "Forbes", 1));
        biblioteca.registrarMaterial(new Revista("R6", "Game Informer", 1));
        biblioteca.registrarMaterial(new Revista("R7", "PC Gamer", 1));

        // Préstamos
        try {
            biblioteca.prestarMaterial(1, "L1");
            System.out.println("Alexander solicitó Cien años de soledad correctamente.");
        } catch (BibliotecaException e) {
            System.out.println(e.getMessage());
            registroErrores.registrar(e, "Alexander Bueno (ID: 1)", "solicitar el libro \"Cien años de soledad\" (L1)");
        } finally {
            System.out.println("Finalizó el intento de préstamo.");
        }

        try {
            biblioteca.prestarMaterial(2, "L1");
        } catch (BibliotecaException e) {
            System.out.println(e.getMessage());
            registroErrores.registrar(e, "Henry Sandoval (ID: 2)", "solicitar el libro \"Cien años de soledad\" (L1)");
        } finally {
            System.out.println("Finalizó el intento de préstamo.");
        }

        try {
            biblioteca.prestarMaterial(1, "L99");
        } catch (BibliotecaException e) {
            System.out.println(e.getMessage());
            registroErrores.registrar(e, "Alexander Bueno (ID: 1)", "solicitar el material con ID L99");
        } finally {
            System.out.println("Finalizó el intento de préstamo.");
        }

        try {
            biblioteca.prestarMaterial(99, "L2");
        } catch (BibliotecaException e) {
            System.out.println(e.getMessage());
            registroErrores.registrar(e, "con ID 99 (no encontrado)", "solicitar el libro \"La isla bajo el mar\" (L2)");
        } finally {
            System.out.println("Finalizó el intento de préstamo.");
        }

        try {
            biblioteca.prestarMaterial(1, "L2");
            System.out.println("Alexander solicitó La isla bajo el mar correctamente.");
        } catch (BibliotecaException e) {
            System.out.println(e.getMessage());
            registroErrores.registrar(e, "Alexander Bueno (ID: 1)", "solicitar el libro \"La isla bajo el mar\" (L2)");
        } finally {
            System.out.println("Finalizó el intento de préstamo.");
        }

        try {
            biblioteca.prestarMaterial(1, "L3");
            System.out.println("Alexander solicitó Cocorí correctamente.");
        } catch (BibliotecaException e) {
            System.out.println(e.getMessage());
            registroErrores.registrar(e, "Alexander Bueno (ID: 1)", "solicitar el libro \"Cocorí\" (L3)");
        } finally {
            System.out.println("Finalizó el intento de préstamo.");
        }

        try {
            biblioteca.prestarMaterial(1, "R1");
        } catch (BibliotecaException e) {
            System.out.println(e.getMessage());
            registroErrores.registrar(e, "Alexander Bueno (ID: 1)", "solicitar la revista \"Cosmopolitan\" (R1)");
        } finally {
            System.out.println("Finalizó el intento de préstamo.");
        }

        try {
            biblioteca.prestarMaterial(3, "L10");
            System.out.println("Rolanda solicitó El Principito correctamente.");
        } catch (BibliotecaException e) {
            System.out.println(e.getMessage());
            registroErrores.registrar(e, "Rolanda Oliver (ID: 3)", "solicitar el libro \"El Principito\" (L10)");
        } finally {
            System.out.println("Finalizó el intento de préstamo.");
        }

        try {
            biblioteca.prestarMaterial(3, "R4");
            System.out.println("Rolanda solicitó National Geographic correctamente.");
            System.out.println("Préstamos activos de Rolanda: " + usuario3.cantidadPrestamos());
        } catch (BibliotecaException e) {
            System.out.println(e.getMessage());
            registroErrores.registrar(e, "Rolanda Oliver (ID: 3)", "solicitar la revista \"National Geographic\" (R4)");
        } finally {
            System.out.println("Finalizó el intento de préstamo.");
        }

        // Devoluciones
        try {
            biblioteca.devolverMaterial(1, "L1");
            System.out.println("Alexander devolvió Cien años de soledad correctamente.");
            System.out.println("Préstamos activos de Alexander: " + usuario1.cantidadPrestamos());
        } catch (BibliotecaException e) {
            System.out.println(e.getMessage());
            registroErrores.registrar(e, "Alexander Bueno (ID: 1)", "devolver el libro \"Cien años de soledad\" (L1)");
        } finally {
            System.out.println("Finalizó el intento de devolución.");
        }

        try {
            biblioteca.devolverMaterial(3, "L10");
            System.out.println("Rolanda devolvió El Principito correctamente.");
            System.out.println("Préstamos activos de Rolanda: " + usuario3.cantidadPrestamos());
        } catch (BibliotecaException e) {
            System.out.println(e.getMessage());
            registroErrores.registrar(e, "Rolanda Oliver (ID: 3)", "devolver el libro \"El Principito\" (L10)");
        } finally {
            System.out.println("Finalizó el intento de devolución.");
        }

        try {
            biblioteca.devolverMaterial(2, "L3");
            System.out.println("Devolución realizada correctamente.");
        } catch (BibliotecaException e) {
            System.out.println(e.getMessage());
            registroErrores.registrar(e, "Henry Sandoval (ID: 2)", "devolver el libro \"Cocorí\" (L3)");
        } finally {
            System.out.println("Finalizó el intento de devolución.");
        }

    }
}
