import java.util.Scanner;

public class GestorIO {

    private static Scanner scanner = new Scanner(System.in);

    public static int leerEntero(String mensaje) {
        int entero = 0;
        boolean datoValido = false;

        while (!datoValido) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                entero = scanner.nextInt();
                datoValido = true;
            } else {
                System.out.println("Error: Debes introducir un número entero.");
                scanner.next();
            }
        }
        scanner.nextLine();
        return entero;
    }

    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public static boolean solicitarConfirmacion(String mensaje) {
        boolean confirmacion = false;
        boolean datoValido = false;

        while (!datoValido) {
            System.out.print(mensaje + " (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();

            if (respuesta.equals("s")) {
                confirmacion = true;
                datoValido = true;
            } else if (respuesta.equals("n")) {
                confirmacion = false;
                datoValido = true;
            } else {
                System.out.println("Error: Debes introducir 's' para sí o 'n' para no.");
            }
        }
        return confirmacion;
    }

    public static void cerrar() {
        scanner.close();
    }
}