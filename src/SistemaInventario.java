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

    //mostrar productos disponibles:
    private static void mostrarProductosDispo() {
        System.out.println("Productos disponibles:");

        for (int i = 0; i < blusasDisponibles.size(); i++) {
            String[] blusa = blusasDisponibles.get(i);
            System.out.println((i + 1) + ". Talla: " + blusa[0] + ", Color: " + blusa[1] + ", Modelo: " + blusa[2] + ", Precio: $" + blusa[3] + ", Cantidad disponible: " + blusa[4]);
        }
    }
    // Método para agregar productos al carrito
    private static void agregarAlCarrito(Scanner scanner) {
        do {
            mostrarProductosDispo();
            System.out.print("Ingrese el número del producto que desea agregar al carrito (o '0' para terminar): ");
            int opcion = Integer.parseInt(scanner.nextLine());

            if (opcion == 0) {
                break;
            }

            if (opcion < 1 || opcion > blusasDisponibles.size()) {
                System.out.println("Opción inválida.");
                continue;
            }

            String[] productoSeleccionado = blusasDisponibles.get(opcion - 1);



            if (Integer.parseInt(productoSeleccionado[4]) <= 0) {
                System.out.println("Lo sentimos, el producto seleccionado no está disponible en este momento.");
                continue;
            }


            int newStock = Integer.parseInt(productoSeleccionado[4]) - 1;
            productoSeleccionado[4] = String.valueOf(newStock);
            carrito.add(productoSeleccionado);
            System.out.println("Producto agregado al carrito: " + productoSeleccionado[2]);
        } while (true);
    }
    private static void generarRecibo(String[] datosCliente) {
        String nombreCompleto = datosCliente[0];
        String dni = datosCliente[1];
        String direccion = datosCliente[2];

        System.out.println("\n--- RECIBO ---");
        System.out.println("Cliente: " + nombreCompleto);
        System.out.println("DNI: " + dni);
        System.out.println("Dirección de entrega: " + direccion);
        System.out.println("\nProductos comprados:");

        double total = 0;
        for (String[] producto : carrito) {
            System.out.println("Talla: " + producto[0] + ", Color: " + producto[1] + ", Modelo: " + producto[2] + ", Precio: $" + producto[3]);
            total += Double.parseDouble(producto[3]);
        }

        System.out.println("\nTotal a pagar: $" + total);
        System.out.println("--- ¡Gracias por su compra! ---");
    }


    public static void main(String[] args) {

        // Blusa escote Espalda
        blusasDisponibles.add(new String[]{"S", "Azul", "Escote de Espalda", "25.99", "10"});
        blusasDisponibles.add(new String[]{"S", "Fuxia", "Escote de Espalda", "25.99", "10"});
        blusasDisponibles.add(new String[]{"S", "Blanco", "Escote de Espalda", "25.99", "10"});

        blusasDisponibles.add(new String[]{"M", "Azul", "Escote de Espalda", "25.99", "10"});
        blusasDisponibles.add(new String[]{"M", "Fuxia", "Escote de Espalda", "25.99", "10"});
        blusasDisponibles.add(new String[]{"M", "Blanco", "Escote de Espalda", "25.99", "10"});

        blusasDisponibles.add(new String[]{"L", "Azul", "Escote de Espalda", "25.99", "10"});
        blusasDisponibles.add(new String[]{"L", "Fuxia", "Escote de Espalda", "25.99", "10"});
        blusasDisponibles.add(new String[]{"L", "Blanco", "Escote de Espalda", "25.99", "10"});

        // Blusa Sin Mangas
        blusasDisponibles.add(new String[]{"S", "Azul", "Sin mangas", "19.99", "15"});
        blusasDisponibles.add(new String[]{"S", "Fuxia", "Sin mangas", "19.99", "15"});
        blusasDisponibles.add(new String[]{"S", "Blanco", "Sin mangas", "19.99", "15"});

        blusasDisponibles.add(new String[]{"M", "Azul", "Sin mangas", "19.99", "15"});
        blusasDisponibles.add(new String[]{"M", "Fuxia", "Sin mangas", "19.99", "15"});
        blusasDisponibles.add(new String[]{"M", "Blanco", "Sin mangas", "19.99", "15"});

        blusasDisponibles.add(new String[]{"L", "Azul", "Sin mangas", "19.99", "15"});
        blusasDisponibles.add(new String[]{"L", "Fuxia", "Sin mangas", "19.99", "15"});
        blusasDisponibles.add(new String[]{"L", "Blanco", "Sin mangas", "19.99", "15"});

        //blusas Manga corta
        blusasDisponibles.add(new String[]{"S", "Azul", "Manga corta", "29.99", "8"});
        blusasDisponibles.add(new String[]{"S", "Fuxia", "Manga corta", "29.99", "8"});
        blusasDisponibles.add(new String[]{"S", "Blanco", "Manga corta", "29.99", "8"});

        blusasDisponibles.add(new String[]{"M", "Azul", "Manga corta", "29.99", "8"});
        blusasDisponibles.add(new String[]{"M", "Fuxia", "Manga corta", "29.99", "8"});
        blusasDisponibles.add(new String[]{"M", "Blanco", "Manga corta", "29.99", "8"});

        blusasDisponibles.add(new String[]{"L", "Azul", "Manga corta", "29.99", "8"});
        blusasDisponibles.add(new String[]{"L", "Fuxia", "Manga corta", "29.99", "8"});
        blusasDisponibles.add(new String[]{"L", "Blanco", "Manga corta", "29.99","8"});


        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la tienda Edita");
        String[] datosCliente = recopilarInformacionCliente(scanner);

        // Agrega productos al carrito
        System.out.println("\n--- Carrito de compras ---");
        agregarAlCarrito(scanner);

        // Genera el recibo de compra
        generarRecibo(datosCliente);

}

}
