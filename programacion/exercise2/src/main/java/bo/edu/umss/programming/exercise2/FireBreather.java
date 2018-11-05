package bo.edu.umss.programming.exercise2;

/**
 * @author ariel.alcocer
 */
public interface FireBreather extends Animal {
    default public String identifyMyself() {
        return "I am able to fire.";
    }
//    String identifyMyself();

}
