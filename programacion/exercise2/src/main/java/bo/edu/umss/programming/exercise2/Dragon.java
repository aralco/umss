package bo.edu.umss.programming.exercise2;

/**
 * @author ariel.alcocer
 */
public class Dragon implements FireBreather, EggLayer {
    public String identifyMyself() {
        System.out.println(FireBreather.super.identifyMyself());
        System.out.println(EggLayer.super.identifyMyself());
        return "I am able to ......";
    }

    public static void main (String... args) {
        Dragon myApp = new Dragon();
        System.out.println(myApp.identifyMyself());
    }
}
