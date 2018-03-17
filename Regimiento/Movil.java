

public class Movil extends Activo
{
private static int idActual = 1;
    
    public Movil( String descripcion){
        super(descripcion);
        this.id = idActual++;
    }
}
