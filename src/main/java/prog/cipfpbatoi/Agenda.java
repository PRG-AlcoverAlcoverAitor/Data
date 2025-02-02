package prog.cipfpbatoi;

public class Agenda {

  // Atributos para los tres eventos
  private Esdeveniment esdeveniment1;
  private Esdeveniment esdeveniment2;
  private Esdeveniment esdeveniment3;

  // Constructor
  public Agenda() {
    this.esdeveniment1 = null;
    this.esdeveniment2 = null;
    this.esdeveniment3 = null;
  }

  /**
   * Añade un evento a la agenda.
   * Si ya hay 3 eventos, reemplaza el que tenga la fecha más antigua.
   * Si el evento ya ha tenido lugar, no se añade.
   */
  public void agregarEsdeveniment(Esdeveniment esdeveniment) {
    Data fechaActual = new Data();

    // Verificar si el evento ya ha tenido lugar
    if (fechaActual.esPosteriorA(esdeveniment.fechaEsdeviment)) {
      System.out.println("Este evento ya ha tenido lugar y no se añadirá.");
      return;
    }

    // Si hay espacio (alguno de los tres eventos está vacío)
    if (esdeveniment1 == null) {
      esdeveniment1 = esdeveniment;
      System.out.println("Evento añadido correctamente en la posición 1.");
    } else if (esdeveniment2 == null) {
      esdeveniment2 = esdeveniment;
      System.out.println("Evento añadido correctamente en la posición 2.");
    } else if (esdeveniment3 == null) {
      esdeveniment3 = esdeveniment;
      System.out.println("Evento añadido correctamente en la posición 3.");
    } else {
      // No hay espacio, sustituir el evento con la fecha más antigua
      Esdeveniment eventoMasAntiguo = esdeveniment1;
      if (esdeveniment2 != null && esdeveniment2.fechaEsdeviment.getDiesDeDiferencia(eventoMasAntiguo.fechaEsdeviment) > 0) {
        eventoMasAntiguo = esdeveniment2;
      }
      if (esdeveniment3 != null && esdeveniment3.fechaEsdeviment.getDiesDeDiferencia(eventoMasAntiguo.fechaEsdeviment) > 0) {
        eventoMasAntiguo = esdeveniment3;
      }

      // Sustituir el evento más antiguo
      if (eventoMasAntiguo == esdeveniment1) {
        esdeveniment1 = esdeveniment;
      } else if (eventoMasAntiguo == esdeveniment2) {
        esdeveniment2 = esdeveniment;
      } else {
        esdeveniment3 = esdeveniment;
      }

      System.out.println("No había espacio. Se ha sustituido el evento con la fecha más antigua.");
    }
  }

  /**
   * Pregunta al usuario si desea añadir una ubicación y una fecha para el evento.
   * Si se decide agregar una fecha, se pedirá el número de días restantes.
   */
  public Esdeveniment crearNuevoEventoConUbicacionYFecha(String tipo, String notaDescriptiva) {
    String ubicacion = "";
    int diasRestantes = -1;

    // Preguntar si desea añadir ubicación
    boolean deseaUbicacion = GestorIO.solicitarConfirmacio("¿Deseas añadir una ubicación al evento?");
    if (deseaUbicacion) {
      ubicacion = GestorIO.llegirText("Introduce la ubicación del evento: ");
    }

    // Preguntar si desea añadir días restantes
    boolean deseaFecha = GestorIO.solicitarConfirmacio("¿Deseas añadir una fecha (días restantes)?");
    if (deseaFecha) {
      while (diasRestantes < 0) {
        diasRestantes = GestorIO.llegirEnter("Introduce el número de días restantes para el evento (número positivo): ");
        if (diasRestantes < 0) {
          System.out.println("Error: Los días restantes no pueden ser negativos.");
        }
      }
    }

    // Crear y devolver el evento con los datos proporcionados
    return new Esdeveniment(tipo, notaDescriptiva, ubicacion, diasRestantes);
  }

  /**
   * Busca un evento en función de la fecha proporcionada.
   * Devuelve el evento que tenga la misma fecha o esté más próximo.
   */
  public Esdeveniment buscarEsdeveniment(Data fecha) {
    Esdeveniment eventoCercano = null;
    long menorDiferencia = Long.MAX_VALUE;

    if (esdeveniment1 != null) {
      long diferencia = esdeveniment1.fechaEsdeviment.getDiesDeDiferencia(fecha);
      if (diferencia >= 0 && diferencia < menorDiferencia) {
        menorDiferencia = diferencia;
        eventoCercano = esdeveniment1;
      }
    }
    if (esdeveniment2 != null) {
      long diferencia = esdeveniment2.fechaEsdeviment.getDiesDeDiferencia(fecha);
      if (diferencia >= 0 && diferencia < menorDiferencia) {
        menorDiferencia = diferencia;
        eventoCercano = esdeveniment2;
      }
    }
    if (esdeveniment3 != null) {
      long diferencia = esdeveniment3.fechaEsdeviment.getDiesDeDiferencia(fecha);
      if (diferencia >= 0 && diferencia < menorDiferencia) {
        menorDiferencia = diferencia;
        eventoCercano = esdeveniment3;
      }
    }

    return eventoCercano;
  }

  /**
   * Muestra toda la información de los eventos almacenados en la agenda.
   * Si no hay eventos, informa de ello.
   */
  public void mostrarAgenda() {
    boolean hayEventos = false;

    if (esdeveniment1 != null) {
      esdeveniment1.mostrarEsdeveniment();
      hayEventos = true;
    }
    if (esdeveniment2 != null) {
      esdeveniment2.mostrarEsdeveniment();
      hayEventos = true;
    }
    if (esdeveniment3 != null) {
      esdeveniment3.mostrarEsdeveniment();
      hayEventos = true;
    }

    if (!hayEventos) {
      System.out.println("No hay eventos registrados en la agenda.");
    }
  }
}
