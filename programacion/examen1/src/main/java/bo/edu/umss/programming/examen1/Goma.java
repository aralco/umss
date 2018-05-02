package bo.edu.umss.programming.examen1;

public class Goma extends Producto {

    @Override
    public void mostrar() {
        System.out.println("Goma:\n"+toString());
    }

    public Goma vender(Producto producto)    {
        if(producto instanceof Goma)
            return (Goma)producto;
        return null;
    }
}
