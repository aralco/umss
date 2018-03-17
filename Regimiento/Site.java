
public abstract class Site
{
    protected String location;
    
    public Site(String location){
        this.location = location;
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
