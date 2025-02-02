package prog.cipfpbatoi;
import java.util.Scanner;

public class Menu {

  private static Scanner scanner = new Scanner(System.in);
  private Agenda agenda;

  // Constructor
  public Menu() {
    this.agenda = new Agenda();  // Creamos una agenda vacía
  }

  // Metodo para mostrar el menú de opciones
  public void iniciar() {
    boolean continuar = true;

    while (continuar) {
      System.out.println("\n----- Menú de Opciones -----");
      System.out.println("1. Crear nuevo evento");
      System.out.println("2. Buscar evento por fecha");
      System.out.println("3. Mostrar el estado actual de la agenda");
      System.out.println("4. Salir");
      System.out.print("Selecciona una opción: ");

      int opcion = GestorIO.llegirEnter("");

      switch (opcion) {
        case 1:
          crearNuevoEvento();
          break;
        case 2:
          buscarEventoPorFecha();
          break;
        case 3:
          mostrarEstadoAgenda();
          break;
        case 4:
          System.out.println("¡Hasta pronto!");
          continuar = false;
          break;
        default:
          System.out.println("Opción no válida. Inténtalo de nuevo.");
      }
    }
  }

  // Metodo para crear un nuevo evento
  private void crearNuevoEvento() {
    String tipo = "";
    String notaDescriptiva = "";
    int diasRestantes = -1;
    String ubicacion = "";

    // Pedir el tipo de evento
    while (true) {
      tipo = GestorIO.llegirText("Introduce el tipo de evento: ");
      if (!tipo.isEmpty()) {
        break;
      } else {
        System.out.println("Error: El tipo de evento no puede estar vacío.");
      }
    }

    // Pedir la nota descriptiva
    while (true) {
      notaDescriptiva = GestorIO.llegirText("Introduce la nota descriptiva: ");
      if (!notaDescriptiva.isEmpty()) {
        break;
      } else {
        System.out.println("Error: La nota descriptiva no puede estar vacía.");
      }
    }

    // pedir los días restantes
    while (diasRestantes < 0) {
      diasRestantes = GestorIO.llegirEnter("Introduce el número de días restantes para el evento (número positivo): ");
      if (diasRestantes < 0) {
        System.out.println("Error: Los días restantes no pueden ser negativos.");
      }
    }

    // Pedir la ubicación, opcional
    ubicacion = GestorIO.llegirText("Introduce la ubicación del evento (deja en blanco si no aplica): ");

    // Crear el evento
    Esdeveniment evento = new Esdeveniment(tipo, notaDescriptiva, ubicacion, diasRestantes);
    agenda.agregarEsdeveniment(evento);
  }

  // Metodo para buscar un evento por fecha
  private void buscarEventoPorFecha() {
    String fechaString = GestorIO.llegirText("Introduce la fecha (dd/mm/yyyy): ");
    Data fechaBusqueda = new Data(fechaString);

    Esdeveniment evento = agenda.buscarEsdeveniment(fechaBusqueda);
    if (evento != null) {
      System.out.println("Evento encontrado:");
      evento.mostrarEsdeveniment();

      // Opción para modificar la fecha
      boolean modificarFecha = GestorIO.solicitarConfirmacio("¿Quieres modificar la fecha de este evento?");
      if (modificarFecha) {
        int diasModificar = GestorIO.llegirEnter("Introduce el número de días para modificar la fecha: ");
        evento.substituirFecha(diasModificar);
      }
    } else {
      System.out.println("No se ha encontrado ningún evento que coincida con esta fecha.");
    }
  }

  // Metodo para mostrar el estado actual de la agenda
  private void mostrarEstadoAgenda() {
    agenda.mostrarAgenda();
  }
}
