package generic.ex1;

public class BoxMain2 {

    public static void main(String[] args) {
        ObjectBox integerBox = new ObjectBox();
        integerBox.set(10);
        Integer integer = (Integer) integerBox.get(); //Object -> Integer 다운 캐스팅
        System.out.println("integer = " + integer);

        ObjectBox stringBox = new ObjectBox();
        stringBox.set("hello");
        String str = (String) stringBox.get(); //Object -> String 다운 캐스팅
        System.out.println("string = " + str);

        //잘못된 타입의 인수 전달시
        integerBox.set("문자100");
        Integer result = (Integer) integerBox.get(); // String -> Integer 캐스팅 예외
        System.out.println("result = " + result);

        //정리
        /*
          다형성을 활용하여 코드의 중복을 제거하고, 기존 코드를 재사용할 수 있게 되었다.
          하지만 입력할 때 실수로 원하지 않는 타입이 들어갈 수 있는 타입 안정성 문제가 발생한다.
          예를 들어서 integerBox에는 숫자만 넣어야 하고, stringBox에는 문자열만 입력할 수 있어햐하지만
          박스에 값을 보관하는 set()의 매개변수가 Object이기 때문에 다른 타입의 값을 입력할 수 있다.
          반환 시점에도 Object를 반환하기 때문에 원하는 타입을 정확하게 받을 수 없고, 다운캐스팅을 시도해야한다.
          결과적으로 이 방식은 타입 안전성이 떨어진다.

          ObjectBox를 사용해서 다형성으로 하나의 클래스만 정의
          코드 재사용 O
          타입 안전성 X
         */
    }
}
