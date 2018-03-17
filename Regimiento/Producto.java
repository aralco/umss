
public class Producto extends Activo
{
private static int idActual = 1;
    
    public Producto( String descripcion){
        super(descripcion);
        this.id = idActual++;
    }
}
