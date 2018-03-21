# PROGRAMACION - Herencia y Polimorfismo

## Estudiantes
  * Alexander Mamani Yucra
  * Ariel Alcocer Rodriguez
## Enunciado del problema
 Se tiene una organización militar que gestiona la seguridad de un determinado país. Para llevar a cabo sus actividades de gestión la organización requiere de una solución de software que pueda beneficiar a la organización en una administración eficiente de sus recursos a todo nivel. La solución de software debe tomar en cuenta el personal (militares), sitios que pueden ser: armerias, estaciones de servicio (proveedores de combustible), entre otros. Asímismo debe gestionar los activos de la organización, como ser vehículos y armamentos (que pueden ser categorizados en armas y municiones).
 
 ![Dominio del Problema](src/main/resources/images/picture1.png)

## Bosquejo y estrategia de solución
La solución de software pretende trabajar sobre el siguiente dominio del problema:
 
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
