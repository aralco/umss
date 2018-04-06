package bo.edu.umss.programming.exercise2.solution22.domain;

public class AssetFactory {

    public static Asset getAsset(Class clazz)   throws InstantiationException, IllegalAccessException {
        return (Asset) clazz.newInstance();
    }
}
