package collection.set.test;

import java.util.HashSet;

public class RectangleTest {

    public static void main(String[] args) {
        //HashSet 은 반드시 HshCode(), equals()를 재정의 해야한다.
        HashSet<Rectangle> rectangleSet = new HashSet<>();
        rectangleSet.add(new Rectangle(10,10));
        rectangleSet.add(new Rectangle(20,20));
        rectangleSet.add(new Rectangle(20,20));

        for (Rectangle rectangle : rectangleSet) {
            System.out.println(rectangle);
        }
    }
}
