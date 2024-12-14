package generic.test.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildCardMain1 {

    public static void main(String[] args) {
        Box<Object> objectBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();


        dogBox.set(new Dog("멍멍이" , 100));

        WildcardEx.printGenericV1(dogBox);//dog로 타입 추론이 됨
        WildcardEx.printWildCardV1(dogBox);

        WildcardEx.printGenericV2(dogBox);
        WildcardEx.printWildCardV2(dogBox);

        Dog dog = WildcardEx.printAndReturnGeneric(dogBox); //printAndReturnGeneric()은 전달한 타입을 명확하게 반환할 수 있다.

        catBox.set(new Cat("고양이", 200));
        Cat cat = WildcardEx.printAndReturnGeneric(catBox);

        Animal animal = WildcardEx.printAndReturnWildCard(dogBox); //printAndReturnWildCard()의 경우 전달한 타입을 명확하게 반환할 수 없다. Animal 타입으로 반환한다.


    }
}
