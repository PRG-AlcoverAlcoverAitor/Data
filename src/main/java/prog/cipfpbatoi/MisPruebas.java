package prog.cipfpbatoi;

public class MisPruebas {
    public static void main(String[] args) {
        Esdeveniment testEsdeveniment = new Esdeveniment("test", "test");
        testEsdeveniment.mostrarEsdeveniment();
        testEsdeveniment.substituirFecha(-4);
        testEsdeveniment.mostrarEsdeveniment();
    }
}
