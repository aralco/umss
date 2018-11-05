package bo.edu.umss.programming.exercise2;

/**
 * @author ariel.alcocer
 */
public interface EggLayer extends Animal {
    default public String identifyMyself() {
        return "I am able to lay eggs.";
    }
}
