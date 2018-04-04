package bo.edu.umss.programming.exercise1.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Organization implements Operation {
    private String id;
    private String name;
    private String description;
    private List<Asset> assets;
    private List<Site> sites;
    private List<Personnel> personnels;

    public Organization(String name, String description) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        assets = new ArrayList<>(0);
        sites = new ArrayList<>(0);
        personnels = new ArrayList<>(0);

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }

    public List<Personnel> getPersonnels() {
        return personnels;
    }

    public void setPersonnels(List<Personnel> personnels) {
        this.personnels = personnels;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", assets=" + assets +
                ", sites=" + sites +
                ", personnels=" + personnels +
                '}';
    }

    @Override
    public void insertAsset(Asset asset) {
        this.assets.add(asset);
    }

    // esta mal hay que crear primero el id que se genera de forma automatica, terminar ultimo
    @Override
    public void deleteAsset(String id) {
        Asset as=null;
        for(Asset asset: this.assets){
            if( asset.getId().equals(id) ){
                System.out.println("se elimino : "+asset.getName()+"con id : "+asset.getId()+"\n");
                as = asset;
                break;
            }
        }
        this.assets.remove(as);
    }

    @Override
    public void showAssets() {
        for(Asset asset : this.assets){
            System.out.println("===========================================================");
            System.out.println("| id :             "+asset.getId());
            System.out.println("| name :           "+asset.getName());
            System.out.println("| description :    "+asset.getDescription());
            if(asset instanceof Vehicle ){
                        mostrarVehicle((Vehicle) asset);
                }else if (asset instanceof Ammunition) {
                mostrarAmmunition((Ammunition) asset);
                }else{
                mostrarWeapon((Weapon) asset);
                }
            }
    }

    @Override
    public Asset getAssetById(String id) {
        for(Asset asset: this.assets){
            if(asset.getId().equals(id)){
                return asset;
            }
        }
        return null;
    }

    @Override
    public List<Weapon> getWeapons() {
        List<Weapon> weapons = new ArrayList<Weapon>();
        for(Asset asset: this.assets )  {
            if(asset instanceof Weapon) {
                weapons.add( (Weapon)asset );
            }
        }
        return weapons;
    }

    private static void mostrarVehicle(Vehicle vehicle){
        System.out.println("| vin :            "+vehicle.getVin());
        System.out.println("| license plate :  "+vehicle.getLicensePlate());
        System.out.println("| brand :          "+vehicle.getBrand());
        System.out.println("| year :           "+vehicle.getYear());
        System.out.println("| model :          "+vehicle.getModel());
    }

    private static void mostrarAmmunition(Ammunition ammunition){
        System.out.println("| numberofRound :  "+ammunition.getNumberOfRounds());
        System.out.println("| bulk :           "+ammunition.getBulk());
    }

    private static void mostrarWeapon(Weapon weapon){
        System.out.println("| type :           "+weapon.getType());
        System.out.println("| model :          "+weapon.getModel());
        System.out.println("| mode :           "+weapon.getMode());
    }

}
