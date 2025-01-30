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
        this.fechaEsdeviment.afegir(30);
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
