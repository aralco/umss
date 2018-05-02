package bo.edu.umss.programming.examen1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

public class Expendedora {
    private List<Producto> productos = new ArrayList<>();

    public void cargarProducto(Producto p)  {
        productos.add(p);
    }

    public Producto venderProducto(Class clazz)    {
        for(Producto p : productos) {
            if(clazz.isInstance(p))    {
                productos.remove(p);
                return p;
            }
        }
        throw new NoSuchElementException(clazz.getSimpleName());
    }

    public Producto venderProducto(String clazz)    {
        for(Producto p : productos) {
            switch (clazz)  {
                case "PapaFrita":
                    if(p instanceof PapaFrita)  {
                        productos.remove(p);
                        return p;
                    }
                    break;
                case "Goma":
                    if(p instanceof Goma)   {
                        productos.remove(p);
                        return p;
                    }
                    break;
                case "Nacho":
                    if(p instanceof Nacho) {
                        productos.remove(p);
                        return p;
                    }
                break;
            }
        }
        throw new NoSuchElementException(clazz);
    }

    public Producto ventaProducto(String clazz)    {
        for(Producto p : productos) {
            p.vender(p);
        }
        return null;
    }


    public static void main(String args[])  {
        Expendedora expendedora = new Expendedora();
        //Papa Frita
        Producto papaFrita1 = new PapaFrita();
        papaFrita1.setNombre("p1");
        papaFrita1.setPrecio(1.99);
        papaFrita1.setFechaVenc(Calendar.getInstance().getTime());
        //Nacho
        Producto nacho1 = new Nacho();
        nacho1.setNombre("n1");
        nacho1.setPrecio(2.99);
        nacho1.setFechaVenc(Calendar.getInstance().getTime());
        //Goma
        Producto goma1 = new Goma();
        goma1.setNombre("g1");
        goma1.setPrecio(3.99);
        goma1.setFechaVenc(Calendar.getInstance().getTime());

        expendedora.cargarProducto(papaFrita1);
        expendedora.cargarProducto(nacho1);
        expendedora.cargarProducto(goma1);

        expendedora.venderProducto(PapaFrita.class).mostrar();
        expendedora.venderProducto(Nacho.class).mostrar();
        expendedora.venderProducto(Goma.class).mostrar();
        expendedora.venderProducto(Goma.class).mostrar();
    }
}
