package edu.bo.umss.programming.exercise1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ariel.alcocer
 */
public class Admin {

    public static void main(String args[])  {
        //creando un ArrayList de Assets
        List<Asset> assets = new ArrayList<Asset>();

        // creando Weapon
        assets.add(new Weapon("Ametralladora","Ametralladora con culata de madera","123E","25","10kg","FFAA","Ametralladora","Ak-47","Automatica"));
        assets.add(new Weapon("Fusil","fusil con culata de madera","456E","30","15kg","FFAA","Fusil","Mouser-95","Automatica"));
        assets.add(new Weapon("Pistola","Pistola de tamaño pequeño","896E","10","5kg","FFAA","Pistola","Pistol-23","Manual"));

    	// creado Ammunition
        assets.add(new Ammunition("Bala","Bala calibre 25 para AK-47","452B","25","50gr","FFAA",30,"2x4"));
        assets.add(new Ammunition("Bala","Bala calibre 30 para FAL","829B","30","60gr","FFAA",30,"2x5"));
        assets.add(new Ammunition("Bala","Bala calibre 10","613B","10","30gr","FFAA",30,"1x2"));

        // creando Vehicle
        assets.add(new Vehicle("Camioneta","Camioneta Toyota 4X4","0009","123-ABC","Toyota",2000,"Toyota 4X4-2000"));
        assets.add(new Vehicle("Camion","Camion para transportar Armamento","0010","754-YTF","Suzuki",1996,"Suzuki CA-1996"));

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

        System.out.println(organization);
    }


}
