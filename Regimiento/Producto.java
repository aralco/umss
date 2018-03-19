
public class Producto extends Activo
{
private static int idActual = 1;
    private String fechaVenc;
    public Producto(String nombre, String descripcion, String fechaVenc){
        super(nombre, descripcion);
        this.id = idActual++;
        this.fechaVenc = fechaVenc;
    }
}
