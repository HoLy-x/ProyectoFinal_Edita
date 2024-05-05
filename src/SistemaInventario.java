import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class SistemaInventario {

    // Lista para almacenar las blusas disponibles y carrito
    private static List<String[]> blusasDisponibles = new ArrayList<>();
    private static List<String[]> carrito = new ArrayList<>();

    //cliente
    private static String[] recopilarInformacionCliente(Scanner scanner) {
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

        return new String[]{nombreCompleto, dni, direccion};
    }
}
