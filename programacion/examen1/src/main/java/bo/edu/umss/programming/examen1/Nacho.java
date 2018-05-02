package bo.edu.umss.programming.examen1;

/**
 * @author ariel.alcocer
 */
public class Nacho extends Producto {

    @Override
    public void mostrar() {
        System.out.println("Nacho:\n" + toString());
    }

    public Nacho vender(Producto producto)    {
        if(producto instanceof Nacho)
            return (Nacho)producto;
        return null;
    }
}
