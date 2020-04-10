package bo.edu.umss.algorithms.others.intro;

/**
 * @author ariel.alcocer
 */
public class Ascensor {
    private int pesoMaximo;
    private int pesoActual;
    private int pisoActual;
    private int pisoDestino;

    public Ascensor(int pesoMaximo, int pesoActual, int pisoActual, int pisoDestino) {
        this.pesoMaximo = pesoMaximo;
        this.pesoActual = pesoActual;
        this.pisoActual = pisoActual;
        this.pisoDestino = pisoDestino;
    }

    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public int getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(int pesoActual) {
        this.pesoActual = pesoActual;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public void setPisoActual(int pisoActual) {
        this.pisoActual = pisoActual;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }

    public void setPisoDestino(int pisoDestino) {
        this.pisoDestino = pisoDestino;
    }

    public void cargarObjeto(int pesoObjeto){
        pesoActual = pesoActual + pesoObjeto;
    }

    public void descargarObjeto(int pesoObjeto){
        pesoActual = pesoActual - pesoObjeto;
    }

    public int estaSubiendo(){
        return pisoActual++;
    }
    public int estaBajando(){
        return pisoActual--;
    }

    public void mostrar()   {
        System.out.println("Peso Maximo:"+pesoMaximo+" \n"+
                "Peso Actual:"+pesoActual+" \n"+
                "Piso Actual:"+pisoActual+" \n"+
                "Piso Destino:"+ pisoDestino +" \n");
    }
}
