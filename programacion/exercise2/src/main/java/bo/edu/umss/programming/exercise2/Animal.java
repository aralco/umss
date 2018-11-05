package bo.edu.umss.programming.exercise2;

/**
 * @author ariel.alcocer
 */
public interface Animal {
    default public String identifyMyself() {
        return "I am an animal.";
    }
}
