import java.util.ArrayList;


public abstract class Site
{
    protected String location;
    protected ArrayList<Activo> activos;
    
    public Site(String location){
        this.location = location;
        this.activos = new ArrayList();
    }
    
    public void setLocation(String location){
        this.location = location;
    }
    
    public String getLocation(){
        return this.location;
    }
    
    @Override
    public String toString(){
        return this.location;
    }
}
