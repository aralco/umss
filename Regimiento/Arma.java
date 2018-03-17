
public class Arma extends Activo{
    private static int idActual = 1;
    private Municion municion;
    public Arma(String nombre, String descripcion, Municion municion){
        super(nombre,descripcion);
        this.id = idActual++;
        this.municion = municion;
    }

}
