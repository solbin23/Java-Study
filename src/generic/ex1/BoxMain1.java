package generic.ex1;

public class BoxMain1 {

    public static void main(String[] args) {
        IntegerBox integerBox = new IntegerBox(); //숫자를 보관하는 integerBox 생성
        integerBox.set(10); //숫자 10을 보관 //오토 박싱
        Integer integer = integerBox.get(); // 꺼냄
        System.out.println("integer = " + integer);

        StringBox stringBox = new StringBox(); // 문자를 보관하는 stringBox 생성
        stringBox.set("hello"); // 문자를 보관
        String str = stringBox.get(); // 꺼냄
        System.out.println("str = " + str);


        /*
        각각의 타입별로 IntegerBox, StringBox와 같은 클래스를 모두 정리
        코드 재사용 X
        타입 안정성 O
         */
    }
}
