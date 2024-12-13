package generic.test.ex4;

public class GenericMethod {

    public static Object objectMethod(Object ogj) {
        System.out.println("ogj = " + ogj);
        return ogj;
    }

    public static<T> T genericMethod(T t) {
        System.out.println("generic = " + t);
        return t;
    }

    public static<T extends Number> T numberMethod(T ogj) {
        System.out.println("bound = " + ogj);
        return ogj;
    }
}
