# PROGRAMACION - Refactoring

## Estudiantes
  * Alexander Mamani Yucra
  * Ariel Alcocer Rodriguez
  
## Bad Smell: Parallel Inheritance Hierarchies  

### Descripción
 Parallel inheritance hierarchies is really a special case of shotgun surgery. In this case, every time you make a 
 subclass of one class, you also have to make a subclass of another. You can recognize this smell because the prefixes 
 of the class names in one hierarchy are the same as the prefixes in another hierarchy. 
 
 ![Problema](src/main/resources/images/parallel-inheritance-hierarchies.png)

### Solución
The general strategy for eliminating the duplication is to make sure that instances of one hierarchy refer to instances 
of the other. If you use Move Method and Move Field, the hierarchy on the referring class disappears.

## Código fuente
### Problema identificado
* Ammunition.java
```java
package edu.bo.umss.programming.exercise1.domain;

public class Ammunition extends Arm {
    private Integer numberOfRounds;
    private String bulk;
}
```

## Código fuente
### Problema resuelto
* Ammunition.java
```java
package edu.bo.umss.programming.exercise1.domain;

public class Ammunition extends Arm {
    private Integer numberOfRounds;
    private String bulk;
}
```