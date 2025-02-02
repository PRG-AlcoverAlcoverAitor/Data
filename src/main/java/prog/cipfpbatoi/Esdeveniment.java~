package prog.cipfpbatoi;

public class Esdeveniment {

    // Atributos
    private String tipo;
    private String notaDescriptiva;
    private String ubicacion;
    private Data fechaEsdeviment;

    // Constructor principal
    public Esdeveniment(String tipo, String notaDescriptiva, String ubicacion, int diasRestantes) {
        this.tipo = tipo;
        this.notaDescriptiva = notaDescriptiva;
        this.ubicacion = ubicacion;
        this.fechaEsdeviment = new Data();

    }

    // Constructor alternativo "sin" ubicacion
    public Esdeveniment(String tipo, String notaDescriptiva) {
        this.tipo = tipo;
        this.notaDescriptiva = notaDescriptiva;
        this.ubicacion = null;
        this.fechaEsdeviment = new Data();
        this.fechaEsdeviment = this.fechaEsdeviment.afegir(30);
    }

    // Constructor alternativo sin ubicacion ni fecha
    public Esdeveniment(String tipo, String notaDescriptiva, String ubicacion) {
        this.tipo = tipo;
        this.notaDescriptiva = notaDescriptiva;
        this.ubicacion = ubicacion;
        this.fechaEsdeviment = new Data();
        this.fechaEsdeviment = this.fechaEsdeviment.afegir(30);
    }

    public void substituirFecha(int dias){
      this.fechaEsdeviment = new Data();
      this.fechaEsdeviment = this.fechaEsdeviment.afegir(dias);
      System.out.println("Se ha cambiado correctamente la fecha.");
    }
    public void mostrarEsdeveniment(){
      Data fechaActual = new Data();
      if (this.ubicacion != null) {
        if (fechaActual.esPosteriorA(this.fechaEsdeviment)) {
          System.out.printf("%s (%s) -> Ja ha tingut lloc el dia ", this.tipo, this.notaDescriptiva);
          this.fechaEsdeviment.mostrarEnFormatES();
        }else{
          System.out.printf("%s (%s) -> %s - Data: ", this.tipo, this.notaDescriptiva, this.ubicacion);
          this.fechaEsdeviment.mostrarEnFormatES();
        }
      }else{
        if (fechaActual.esPosteriorA(this.fechaEsdeviment)) {
          System.out.printf("%s (%s) -> Ja ha tingut lloc el dia ", this.tipo, this.notaDescriptiva);
          this.fechaEsdeviment.mostrarEnFormatES();
        }else{
          System.out.printf("%s (%s) -> Data: ", this.tipo, this.notaDescriptiva);
          this.fechaEsdeviment.mostrarEnFormatES();
        }
      }
    }

    public boolean isMesProxim(Data data, Esdeveniment esdeveniment){
      long diasDiferenciaSelfData = this.fechaEsdeviment.getDiesDeDiferencia(data);
      long diasDiferenciaData = esdeveniment.fechaEsdeviment.getDiesDeDiferencia(data);
      return diasDiferenciaSelfData < diasDiferenciaData;
    }
}
