

public class Municion extends Activo
{
    private static int idActual = 1;
    private String calibre;
    public Municion( String nombre,String descripcion, String calibre){
        super(nombre,descripcion);
        this.id = idActual++;
        this.calibre = calibre;
    }
}
