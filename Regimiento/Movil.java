

public class Movil extends Activo
{
    protected static int idActual = 1;
    protected String motor;
    //protected Cobustible combustible;
    protected int nroRuedas;
        
    public Movil( String nombre,String descripcion,String motor,int nroRuedas){
        super(nombre,descripcion);
        this.id = idActual++;
        this.motor = motor;
        this.nroRuedas = nroRuedas;
    }
}
