package prog.cipfpbatoi;

public class Esdeveniment {

    // Atributos
    private String tipo; // Tipus d'esdeveniment: Aniversari, Festiu, Especial, Altres
    private String notaDescriptiva; // Nota descriptiva de l'esdeveniment
    private String ubicacion; // Ubicació de l'esdeveniment (opcional)
    private Data fechaEsdeviment; // Data de l'esdeveniment (composició amb la classe Data)

    // Constructor principal
    public Esdeveniment(String tipo, String notaDescriptiva, String ubicacion, int diasRestantes) {
        this.tipo = tipo;
        this.notaDescriptiva = notaDescriptiva;
        this.ubicacion = ubicacion;
        this.fechaEsdeviment = new Data();
        
    }

    // Constructor alternativo "sin" ubicacion
    public Esdeveniment(String tipo, String notaDescriptiva) {
        
    }

    // Constructor alternativo sin ubicacion ni fecha
    public Esdeveniment(String tipo, String notaDescriptiva, String ubicacion) {
        this.tipo = tipo;
        this.notaDescriptiva = notaDescriptiva;
        this.ubicacion = ubicacion;
        this.fechaEsdeviment = new Data();
        this.fechaEsdeviment.afegir(30);
    }

}
