# PROGRAMACION - Herencia y Polimorfismo

## Estudiantes
  * Alexander Mamani Yucra
  * Ariel Alcocer Rodriguez
## Enunciado del problema
 Se tiene una determinada organización militar que con el objetivo de gestionar sus recursos de una manera más eficiente, 
 ha decidido implementar una solución de software que le permita llevar a cabo todas las tareas que este proceso conlleva. 
 En este sentido la solución de software debe tomar en cuenta el personal (militares), sitios que pueden ser: armerías, 
 estaciones de servicio (proveedores de combustible), entre otros. Asimismo debe administrar los activos de la organización, 
 como ser vehículos, armamentos (que pueden ser categorizados en armas y municiones), entre otros.
 
 ![Dominio del Problema](src/main/resources/images/picture1.png)

## Bosquejo y estrategia de solución
La solución de software pretende trabajar sobre la base del siguiente dominio del problema:
 
 ![Diagrama de Clases](src/main/resources/images/class_diagram.png)

## Código fuente
* Ammunition.java
```java
package edu.bo.umss.programming.exercise1.domain;

public class Ammunition extends Arm {
    private Integer numberOfRounds;
    private String bulk;


    public Ammunition(String name, String description, String serialNumber, String caliber, String weight, String manufacturer, Integer numberOfRounds, String bulk) {
        super(name, description, serialNumber, caliber, weight, manufacturer);
        this.numberOfRounds = numberOfRounds;
        this.bulk = bulk;
    }

    public Integer getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(Integer numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public String getBulk() {
        return bulk;
    }

    public void setBulk(String bulk) {
        this.bulk = bulk;
    }

    @Override
    public String toString() {
        return "Ammunition{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", serialNumber='" + getSerialNumber() + '\'' +
                ", caliber='" + getCaliber() + '\'' +
                ", weight='" + getWeight() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", numberOfRounds=" + numberOfRounds +
                ", bulk='" + bulk + '\'' +
                '}';
    }
}
```

* Arm.java
```java
package edu.bo.umss.programming.exercise1.domain;

public abstract class Arm extends Asset {
    private String serialNumber;
    private String caliber;
    private String weight;
    private String manufacturer;

    protected Arm(String name, String description, String serialNumber, String caliber, String weight, String manufacturer) {
        super(name, description);
        this.serialNumber = serialNumber;
        this.caliber = caliber;
        this.weight = weight;
        this.manufacturer = manufacturer;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
```

* Armory
```java
package edu.bo.umss.programming.exercise1.domain;

import java.util.List;

public class Armory extends Site {

    private List<Cabinet> cabinets;

    public Armory(String location, String name, String description, List<Cabinet> cabinets){
        super(location, name, description);
        this.cabinets = cabinets;
    }

    public List<Cabinet> getCabinets() {
        return cabinets;
    }

    public void setCabinets(List<Cabinet> cabinets) {
        this.cabinets = cabinets;
    }

    @Override
    public String toString() {
        return "Armory{" +
                "id='" + getId() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", cabinets=" + cabinets +
                '}';
    }
}
```

* Asset
```java
package edu.bo.umss.programming.exercise1.domain;

import java.util.UUID;

public abstract class Asset {
    private String id;
    private String name;
    private String description;

    public Asset() {
    }

    protected Asset(String name, String description) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
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

}
```

* Cabinet
```java
package edu.bo.umss.programming.exercise1.domain;

import java.util.UUID;

public class Cabinet {
    private String id;
    private Long slotsNumber;

    public Cabinet(Long slotsNumber) {
        this.id = UUID.randomUUID().toString();
        this.slotsNumber = slotsNumber;
    }

    public String getId() {
        return id;
    }

    public Long getSlotsNumber() {
        return slotsNumber;
    }

    public void setSlotsNumber(Long slotsNumber) {
        this.slotsNumber = slotsNumber;
    }

    @Override
    public String toString() {
        return "Cabinet{" +
                "id='" + id + '\'' +
                ", slotsNumber=" + slotsNumber +
                '}';
    }
}
```

* FuelDispenser
```java
package edu.bo.umss.programming.exercise1.domain;

import java.util.UUID;

public class FuelDispenser {

    private String id;
    private String type;
    private String capacity;

    public FuelDispenser(String type, String capacity) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "FuelDispenser{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}
```
* GasStation
```java
package edu.bo.umss.programming.exercise1.domain;

import java.util.List;

public class GasStation extends Site {
    private List<FuelDispenser> fuelDispensers;

    public GasStation(String location, String name, String description, List<FuelDispenser> fuelDispensers) {
        super(location, name, description);
        this.fuelDispensers = fuelDispensers;
    }

    public List<FuelDispenser> getFuelDispensers() {
        return fuelDispensers;
    }

    public void setFuelDispensers(List<FuelDispenser> fuelDispensers) {
        this.fuelDispensers = fuelDispensers;
    }

    @Override
    public String toString() {
        return "GasStation{" +
                "id='" + getId() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", fuelDispensers=" + fuelDispensers +
                '}';
    }
}
```

* Organization
```java
package edu.bo.umss.programming.exercise1.domain;

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
```
* Personnel
```java
package edu.bo.umss.programming.exercise1.domain;

import java.util.UUID;

public class Personnel {
    private String id;
    private String name;
    private String phoneNumber;

    public Personnel(String name, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
```

* Site
```java
package edu.bo.umss.programming.exercise1.domain;

import java.util.UUID;

public abstract class Site {
    private String id;
    private String location;
    private String name;
    private String description;

    public Site() {
    }

    protected Site(String location, String name, String description) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
}
```

* Vehicle
```java
package edu.bo.umss.programming.exercise1.domain;

public class Vehicle extends Asset {
    private String vin;
    private String licensePlate;
    private String brand;
    private Integer year;
    private String model;

    public Vehicle(String name, String description, String vin, String licensePlate, String brand, Integer year, String model) {
        super(name, description);
        this.vin = vin;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.year = year;
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", vin='" + vin + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                ", year='" + year + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
```

* Weapon
```java
package edu.bo.umss.programming.exercise1.domain;

public class Weapon extends Arm {
    private String type;
    private String model;
    private String mode;

    public Weapon(String name, String description, String serialNumber, String caliber, String weight, String manufacturer, String type, String model, String mode) {
        super(name, description, serialNumber, caliber, weight, manufacturer);
        this.type = type;
        this.model = model;
        this.mode = mode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", serialNumber='" + getSerialNumber() + '\'' +
                ", caliber='" + getCaliber() + '\'' +
                ", weight='" + getWeight() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", mode='" + mode + '\'' +
                '}';
    }
}
```
* Operation
```java
package edu.bo.umss.programming.exercise1.domain;

import java.util.List;

public interface Operation {
    void insertAsset(Asset asset);
    void deleteAsset(String id);
    void showAssets();
    Asset getAssetById(String id);
    List<Weapon> getWeapons();
}
```

* Admin
```java
package edu.bo.umss.programming.exercise1;

import edu.bo.umss.programming.exercise1.domain.*;

import java.util.ArrayList;
import java.util.List;

public class Admin {

    public static void main(String args[])  {
        //creando un ArrayList de Assets
        List<Asset> assets = new ArrayList<Asset>();

        // creando Weapon
        Asset weapon1 = new Weapon("Ametralladora","Ametralladora con culata de madera","123E","25","10kg","FFAA","Ametralladora","Ak-47","Automatica");
        Arm weapon2 = new Weapon("Fusil","fusil con culata de madera","456E","30","15kg","FFAA","Fusil","Mouser-95","Automatica");
        Weapon weapon3 = new Weapon("Pistola","Pistola de tamaño pequeño","896E","10","5kg","FFAA","Pistola","Pistol-23","Manual");
        assets.add(weapon1);
        assets.add(weapon2);
        assets.add(weapon3);
        System.out.println("********WEAPONS********");
        System.out.println(weapon1);
        System.out.println(weapon2);
        System.out.println(weapon3);


    	// creado Ammunition
        Asset ammunition1 = new Ammunition("Bala","Bala calibre 25 para AK-47","452B","25","50gr","FFAA",30,"2x4");
        Arm ammunition2 = new Ammunition("Bala","Bala calibre 30 para FAL","829B","30","60gr","FFAA",30,"2x5");
        Ammunition ammunition3 = new Ammunition("Bala","Bala calibre 10","613B","10","30gr","FFAA",30,"1x2");
        assets.add(ammunition1);
        assets.add(ammunition2);
        assets.add(ammunition3);
        System.out.println("********AMMUNITIONS********");
        System.out.println(ammunition1);
        System.out.println(ammunition2);
        System.out.println(ammunition3);

        // creando Vehicle
        Asset vehicle1 = new Vehicle("Camioneta","Camioneta Toyota 4X4","0009","123-ABC","Toyota",2000,"Toyota 4X4-2000");
        Asset vehicle2 = new Vehicle("Camion","Camion para transportar Armamento","0010","754-YTF","Suzuki",1996,"Suzuki CA-1996");
        assets.add(vehicle1);
        assets.add(vehicle2);
        System.out.println("********VEHICLE********");
        System.out.println(vehicle1);
        System.out.println(vehicle2);

        //creando un ArrayList de Personnels
        List<Personnel> personnels  = new ArrayList<Personnel>();

        // creando Personnel
        personnels.add(new Personnel("Alexander", "+591 68685411"));
        personnels.add(new Personnel("Ariel", "+591 70781486"));
        personnels.add(new Personnel("Karen", "+591 74782421"));

        // creando un ArrayList<FuelDispenser> para FuelDispenser
        List<FuelDispenser> fuelDispensers = new ArrayList<FuelDispenser>();

        // creando FuelDispenser
        fuelDispensers.add(new FuelDispenser("Diesel","500L"));
        fuelDispensers.add(new FuelDispenser("Gasolina","1000L"));
        fuelDispensers.add(new FuelDispenser("GNV","700L"));

        // creando GasStation
        GasStation estacion = new GasStation("Cochabamba","Estacion PM-23","Estacion de la Policia Militar-23 ",fuelDispensers);

        // creando un ArrayList<Cabinet> para Armory
        List<Cabinet> cabinets = new ArrayList<Cabinet>();

        // creando Cabinets
        cabinets.add(new Cabinet(new Long("1000")));
        cabinets.add(new Cabinet(new Long("100")));

        // creamos la armeria
        Armory armeria = new Armory("Cochabamba","Armeria PM-23","Armeria del la Policia Militar-23",cabinets);

        System.out.println("********SITES********");
        System.out.println(estacion);
        System.out.println(armeria);

        //creando un ArrayList de Sites
        List<Site> sites  = new ArrayList<Site>();
        sites.add(estacion);
        sites.add(armeria);

        // creando una instancia de Organization
        Organization organization = new Organization("PM", "Policia Militar");

        // dando valores a los atributos de organization
        organization.setAssets(assets);
        organization.setSites(sites);
        organization.setPersonnels(personnels);
        System.out.println("********ORGANIZATION********");
        System.out.println(organization);

        // bucamos el id del primer Weapons(ametralladora), en un lista de puros Weapons
        String idToSearch =organization.getWeapons().get(0).getId();

        // mostramos el id para despues corroborar que se elemino
        System.out.println(idToSearch+"\n");

        // mostramos el el objeto de aquel id
        System.out.println(organization.getAssetById(idToSearch)+"\n");

        // procedemos a eliminar la  ametralladora de la lista de Asset de la organizacion
        organization.deleteAsset(idToSearch);

        // recorremos la lista de weapons para ver que ya no existe
        for(Weapon w: organization.getWeapons()){
            System.out.println(w);
        }
    }
}
```