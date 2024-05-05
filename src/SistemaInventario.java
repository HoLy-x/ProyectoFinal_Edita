import java.util.Scanner;

public class SistemaInventario {
    private static final String USUARIO_ADMIN = "edita";
    private static final String CONTRASENA_ADMIN = "aitana";

    private static void iniciarSesion(Scanner scanner) {
        while (true) {
            System.out.print("Ingrese el nombre de usuario: ");
            String nombreUsuarioIngresado = scanner.nextLine();

            System.out.print("Ingrese la contraseña: ");
            String contrasenaIngresada = scanner.nextLine();

            if (nombreUsuarioIngresado.equals(USUARIO_ADMIN) && contrasenaIngresada.equals(CONTRASENA_ADMIN)) {
                System.out.println("¡Inicio de sesión del administrador exitoso!");
                break;
            } else {
                System.out.println("Nombre de usuario o contraseña incorrectos. Por favor, inténtelo de nuevo.");
            }
        }
    }


    private static void recopilarInformacionCliente(Scanner scanner) {
        System.out.println("Proporcione la siguiente información:");

        System.out.print("Nombre completo: ");
        String nombreCompleto = scanner.nextLine();

        String dni;
        do {
            System.out.print("DNI: ");
            dni = scanner.nextLine();
        } while (!dni.matches("\\d{8,}"));

        String direccion;
        do {
            System.out.print("Dirección de entrega: ");
            direccion = scanner.nextLine();
            System.out.print("Confirmar dirección: ");
            String confirmarDireccion = scanner.nextLine();
            if (!direccion.equals(confirmarDireccion)) {
                System.out.println("Las direcciones no coinciden. Por favor, inténtelo de nuevo.");
                direccion = "";
            }
        } while (direccion.isEmpty());

        System.out.println("Gracias, " + nombreCompleto + ", por proporcionar la información.");
        System.out.println("Tu DNI: " + dni);
        System.out.println("Tu dirección de entrega: " + direccion);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a tienda Edita");

        String tipoUsuario;
        do {
            System.out.println("¿Eres cliente o administrador? (cliente/admin): ");
            tipoUsuario = scanner.nextLine();
            if (!tipoUsuario.equalsIgnoreCase("cliente") && !tipoUsuario.equalsIgnoreCase("admin")) {
                System.out.println("Opción inválida. Por favor, indique si es cliente o administrador.");
            }
        } while (!tipoUsuario.equalsIgnoreCase("cliente") && !tipoUsuario.equalsIgnoreCase("admin"));

        if (tipoUsuario.equalsIgnoreCase("cliente")) {
            recopilarInformacionCliente(scanner);
        } else if (tipoUsuario.equalsIgnoreCase("admin")) {
            System.out.println("Inicio de sesión del administrador:");
            iniciarSesion(scanner);
        }

        scanner.close();
    }
}
