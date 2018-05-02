package bo.edu.umss.programming.examen1;

/**
 * @author ariel.alcocer
 */
public class PapaFrita extends Producto {

    @Override
    public void mostrar() {
        System.out.println("Papa Frita:\n" + toString());
    }

    public PapaFrita vender(Producto producto)    {
        if(producto instanceof PapaFrita)
            return (PapaFrita)producto;
        return null;
    }
}
