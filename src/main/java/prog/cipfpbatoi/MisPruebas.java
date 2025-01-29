package prog.cipfpbatoi;

public class MisPruebas {
    public static void main(String[] args) {
        Data fechaInicio = new Data(2, 3, 2022);
        fechaInicio = fechaInicio.restar(30);
        System.out.println(fechaInicio.getDia());
        System.out.println(fechaInicio.getMes());
        System.out.println(fechaInicio.getAny());        
    }
}
