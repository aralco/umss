public abstract class Activo{
    
    protected int id;

    protected String descripcion;
    //protected Provedo provedor;
    
    public Activo(String descripcion ){
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

    @Override
    public String toString(){
        return ""+this.id;        
    }
}