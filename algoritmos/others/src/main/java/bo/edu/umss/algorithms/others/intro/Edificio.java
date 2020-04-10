package bo.edu.umss.algorithms.others.intro;

/**
 * @author ariel.alcocer
 */
public class Edificio {
    private int numeroPisos;
    private int numeroDeAscensores;
    private Ascensor ascensor;

    public Edificio(int numeroPisos, int numeroDeAscensores, Ascensor ascensor) {
        this.numeroPisos = numeroPisos;
        this.numeroDeAscensores = numeroDeAscensores;
        this.ascensor = ascensor;
    }

    public int getNumeroPisos() {
        return numeroPisos;
    }

    public void setNumeroPisos(int numeroPisos) {
        this.numeroPisos = numeroPisos;
    }

    public int getNumeroDeAscensores() {
        return numeroDeAscensores;
    }

    public void setNumeroDeAscensores(int numeroDeAscensores) {
        this.numeroDeAscensores = numeroDeAscensores;
    }

    public Ascensor getAscensor() {
        return ascensor;
    }

    public void setAscensor(Ascensor ascensor) {
        this.ascensor = ascensor;
    }

    public void mostrar()   {
        ascensor.mostrar();
    }

    public static void main(String[] args)  {
        Ascensor ascensor = new Ascensor(500, 0, 0, 0);
        Edificio edificio = new Edificio(10, 1, ascensor);
        edificio.mostrar();
        System.out.println("Desde el piso 0 sube al piso 10 cargando una persona de 50kg");
        ascensor.cargarObjeto(50);
        ascensor.setPisoDestino(10);
        ascensor.setPisoActual(0);
        edificio.mostrar();

        System.out.println("Desde el piso 10 baja al piso 0 para descargar una persona de 50kg");
        ascensor.descargarObjeto(50);
        ascensor.setPisoDestino(0);
        ascensor.setPisoActual(0);
        edificio.mostrar();

    }
}
