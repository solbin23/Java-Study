package generic.test.ex2;

public class PairTest {
    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<>();
        p1.setFirst(1);
        p1.setSecond("data");
        System.out.println(p1.getFirst());
        System.out.println(p1.getSecond());
        System.out.println("p1 = " + p1);

        Pair<String,String> p2 = new Pair<>();
        p2.setFirst("key");
        p2.setSecond("value");
        System.out.println(p2.getFirst());
        System.out.println(p2.getSecond());
        System.out.println("p2 = " + p2);
    }
}
