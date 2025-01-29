/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.cipfpbatoi;
import java.util.Calendar;
import java.util.StringTokenizer;

/**
 *
 * @author batoi
 */
public class Data {
    
    private int dia;
    private int mes;
    private int any;
    private static final String GENER = "gener";
    private static final String FEBRER = "febrer";
    private static final String MARÇ = "març";
    private static final String ABRIL = "abril";
    private static final String MAIG = "maig";
    private static final String JUNY = "juny";
    private static final String JULIOL = "juliol";
    private static final String AGOST = "agost";
    private static final String SETEMBRE = "setembre";
    private static final String OCTUBRE = "octubre";
    private static final String NOVEMBRE = "novembre";
    private static final String DESEMBRE = "desembre";
    private static final int ANONOBISIESTO = 365;
    private static final int ANOBISIESTO = 366;
    private static final String DILLUNS = "dilluns";
    private static final String DIMARTS = "dimarts";
    private static final String DIMECRES = "dimecres";
    private static final String DIJOUS = "dijous";
    private static final String DIVENDRES = "divendres";
    private static final String DISSABTE = "dissabte";
    private static final String DIUMENGE = "diumenge";
    private static final int NDILLUNS = 1;
    private static final int NDIMARTS = 2;
    private static final int NDIMECRES = 3;
    private static final int NDIJOUS = 4;
    private static final int NDIVENDRES = 5;
    private static final int NDISSABTE = 6;
    private static final int NDIUMENGE = 7;

    /**
     *  Constructor por defecto
     *  Inicializa una fecha a la fecha del sistema
     */
    public Data() {
        Calendar rightNow = Calendar.getInstance();
        this.any = rightNow.get(Calendar.YEAR);
        this.dia = rightNow.get(Calendar.DAY_OF_MONTH);
        this.mes = rightNow.get(Calendar.MONTH) + 1;
    }

    /**
     *  Inicializa la fecha a partir de los parámetros recibidos
     * @param dia
     * @param mes
     * @param any
     */
    public Data(int dia, int mes, int any) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }

    /**
     * Inicializa la fecha a partir de otra pasada en formato String dd/mm/yyyy
     *
     * Deberemos trocearlas de forma que asignemos el día més y año a cada uno de los atributoe
     * @param fecha
     */
    public Data(String fecha) {
       StringTokenizer st = new StringTokenizer(fecha, "/");
        this.dia = Integer.parseInt(st.nextToken());
        this.mes = Integer.parseInt(st.nextToken());
        this.any = Integer.parseInt(st.nextToken());
    }

    /**
     * Modifica la fecha actual a partir de los datos pasados como argumento
     * @param dia
     * @param mes
     * @param any
     */
    public void set(int dia, int mes, int any) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
        
    }

    /**
     * Creará y devolverá un nuevo objeto de la clase Data iniciado
     * con los valores que representa el objeto actual, es decir creará un clon exacto del objeto
     * actual.
     * @return
     */
    public Data copy() {
        Data nuevaFecha = new Data(this.dia,this.mes,this.any);
        return nuevaFecha;
    }

    /**
     * (Ya implementado) Devuelve el día de la semana que representa por la Data actual
     * @return @dia
     */
    public int getDia() {
        return this.dia;
    }

    /**
     * (Ya implementado) Devuelve el mes que representa la Data actual
     * @return @mes
     */
    public int getMes(){
        return this.mes;
    }

    /**
     * (Ya implementado) Devuelve el año que representa la Data actual
     * @return @mes
     */
    public int getAny(){
        return this.any;
    }

    /**
     * Muestra por pantalla la fecha en formato español dd/mm/yyyy
     */
    public void mostrarEnFormatES()  {
        System.out.printf("%02d/%02d/%d \n", this.dia, this.mes, this.any);
        
    }

    /**
     * Muestra por pantalla la fecha en formato inglés yyyy-mm-dd
     */
    public void mostrarEnFormatGB() {
        System.out.printf("%d-%02d-%02d \n", this.any, this.mes, this.dia);
        
    }
    
    private String getMesText(int mes) {
        switch (mes) {
            case 1:
                return GENER;
            case 2:
                return FEBRER;
            case 3:
                return MARÇ;
            case 4:
                return ABRIL;
            case 5:
                return MAIG;
            case 6:
                return JUNY;
            case 7:
                return JULIOL;
            case 8:
                return AGOST;
            case 9:
                return SETEMBRE;
            case 10:
                return OCTUBRE;
            case 11:
                return NOVEMBRE;
            default:
                return DESEMBRE;
            }
        }

    /**
     * Muestra por pantalla la fecha en formato texto dd-mmmmm-yyyy
     */
    public void mostrarEnFormatText() {
        System.out.printf("%02d-%s-%d \n", this.dia, getMesText(this.mes), this.any); 
    }

    
    /**
     * Retorna un booleano indicando si la fecha del objeto es igual a la fecha pasada como
     * argumento
     *
     * @param fecha
     * @return boolean
     */
    public boolean isIgual(Data fecha) {
        if (this.dia == fecha.getDia() && this.mes == fecha.getMes() && this.any == fecha.getAny()){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Retorna el dia correspondiente de la semana en formato String
     * @return String
     */
    public String getDiaSetmana() {
        int diesTranscorreguts = getDiesTranscorregutsOrigen();
        int diaSetmana = diesTranscorreguts % 7;
        switch (diaSetmana) {
            case 0: return DIUMENGE;
            case 1: return DILLUNS;
            case 2: return DIMARTS;
            case 3: return DIMECRES;
            case 4: return DIJOUS;
            case 5: return DIVENDRES;
            default: return DISSABTE;
        }
    }
    
    private int getDiesTranscorregutsOrigen() {
        int dies = 0;
        // Sumar días de años completos desde el año 1 hasta el año anterior
        for (int i = 1; i < this.any; i++) {
            if (isBisiesto(i)){
                dies += 366;
            }else{
                dies += 365;
            }
        }
        for (int i = 1; i < this.mes; i++) {
            dies += getDiesMes(i, this.any);
        }

        // Sumar los días del mes actual
        dies += dia;

        return dies;
       }

    /**
     * Solo Festivo sábado o domingo
     * @return boolean
     */
    public boolean isFestiu() {
        if (getDiaSetmana() == DISSABTE || getDiaSetmana() == DIUMENGE){
            return true;
        }
        return false;
    }

    /**
     * Obtiene el número de la semana del año de la fecha actual
     * @return 
     */
    public int getNumeroSetmana() {
        int dies = 0;
        Data calcularPrimeraSemana = new Data(1,1,this.any);
        switch(calcularPrimeraSemana.getDiaSetmana()){
            case DIUMENGE: dies += NDIUMENGE;
            break;
            case DILLUNS: dies += NDILLUNS;
            break;
            case DIMARTS: dies += NDIMARTS;
            break;
            case DIMECRES: dies += NDIMECRES;
            break;
            case DIJOUS: dies += NDIJOUS;
            break;
            case DIVENDRES: dies += NDIVENDRES;
            break;
            default: dies += NDISSABTE;
        }
        System.out.println(dies);
        for (int i = 1; i < this.mes; i++) {
            dies += getDiesMes(i, this.any);
        }
        dies += this.dia;
        int semanas = (dies / 7);
        if (dies % 7 != 0){
            semanas++;
        }
        return semanas;
    }
    
    
    
    /**
     * Crea una nueva fecha con un número de días adicionales a la fecha actual
     *
     * @param numDias
     * @return
     */
   public Data afegir(long numDias) {
    int esteMes = this.mes;
    int diaInicial = this.dia;
    long esteDia = diaInicial + numDias;
    int esteAno = this.any;
    boolean finalizado = false;

    while (!finalizado) {
        int diasEnMes = getDiesMes(esteMes, esteAno);
        
        if (esteDia > diasEnMes) {
            esteDia -= diasEnMes;
            esteMes++; 
            if (esteMes > 12) { 
                    esteMes = 1;
                    esteAno++;
                }
        } else {
            finalizado = true;
            }
        }
    Data nuevaFecha = new Data((int) esteDia,esteMes,esteAno);
    return nuevaFecha;
   }

    // Devolvemos una nueva instancia de la clase Data con los valores calculados
   

    /**
     * Crea una nueva fecha con un número de días anteriores a la fecha actual
     * @param numDias
     * @return 
     */
    public Data restar(long numDias) {
        int esteMes = this.mes;
        int diaInicial = this.dia;
        long esteDia = diaInicial - numDias;
        int esteAno = this.any;
        boolean finalizado = false;

        while (!finalizado) {
            if (esteDia < 1) {
                esteMes--; 
                if (esteMes < 1) { 
                    esteMes = 12;
                    esteAno--;
                }
                esteDia += getDiesMes(esteMes, esteAno);
            } else {
                finalizado = true;
            }
        }
        Data nuevaFecha = new Data((int) esteDia, esteMes, esteAno);
        return nuevaFecha;
    }
    
    /**
     * Determina si una fecha está compuesta por datos correctos
     * @return 
     */

    public boolean isCorrecta(){
        if (this.mes > 13 || this.mes < 1){
            return false;
        }
        if (getDiesMes(this.mes, this.any) < this.dia || this.dia < 1){
            return false;
        }
        return true;
    }

    
    /** Devuelve el valor absoluto de la diferencia de dias entre la fecha actual y la proporcionada
     * 
     * @param data
     * @return 
     */
    public long getDiesDeDiferencia(Data data) {
        return Math.abs(getDiesTranscorregutsOrigen() - data.getDiesTranscorregutsOrigen());
    }
    
    /**
     * Determina si una fecha es posterior a la fecha proporcionada
     * @param data
     * @return 
     */
    public boolean esPosteriorA(Data data) {
        return getDiesTranscorregutsOrigen() > data.getDiesTranscorregutsOrigen();
    }

    /**
     * Indica si el año pasado como argumento es bisiesto
     * Un año es bisiesto si es divisible por 4 a su vez 100 por 400
     *
     * @param any
     * @return boolean
     */
    public static boolean isBisiesto(int any){
        if (any % 4 == 0) {
            if (any % 100 == 0) {
                return any % 400 == 0;
            }
            return true;
        }
        return false; 
    }

    /**
     *  Calcula el número de días que tiene el mes representado por la fecha actual
     *
     * @param mes
     * @param any
     *  @return int total dias mes en curso
     *
     */
    public static int getDiesMes(int mes, int any) {
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                if (isBisiesto(any)) {
                    return 29;
                } else {
                    return 28;
                }
            }
        }

    /**
     * Calcula el número total de dias que tiene el año pasado como argumento
     *
     * @param any
     * @return int total dias any en curso
     */
    public static int getDiesAny(int any){
        if (isBisiesto(any)){
            return ANOBISIESTO;
        }else{
            return ANONOBISIESTO;
        }
    }
}
