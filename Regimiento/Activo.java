public abstract class Activo{
    
    protected int id;
    protected String nombre;
    protected String descripcion;
    //protected Provedo provedor;       // aqui podemos crear una clase proveedor o solamente dejarlo como String, ya que todo activo tiene 
                                        // tiene un proveedor
    
    public Activo(String nombre ,String descripcion ){
        this.nombre = nombre;        
        this.descripcion = descripcion;        
    }
    

    public int getId(){
        return this.id;
    }

    public void setDescipcion( String descripcion ){
        this.descripcion = descripcion;
    }

    public String getDescipcion(){
        return this.descripcion;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;        
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    @Override
    public String toString(){
        return ""+this.id;        
    }
}