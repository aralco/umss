
public class Arma extends Activo{
    private static int idActual = 1;
    
    public Arma( String descripcion){
        super(descripcion);
        this.id = idActual++;
    }

}
