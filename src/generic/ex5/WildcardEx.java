package generic.ex5;

import generic.animal.Animal;

public class WildcardEx {

    //제네릭 메서드
    //Box<Dog> dogBox를 전달, 타입 추론에 의해 타입 T가 Dog가 됨
    static <T> void printGenericV1(Box<T> box) {
        System.out.println("T = " + box.get());
    }

    //제네릭 메서드가 아님, 일반적인 메서드
    // ? -> 아무거나 다 들어올 수 있다.
    //Box<Dog>, Box<Cat>, Box<Animal>
    static void printWildCardV1(Box<?> box) {
        System.out.println("? = " + box.get());
    }

    static <T extends Animal> void printGenericV2(Box<T> box) {
        T t = box.get();
        System.out.println("이름 = " + t.getName()); //출력
    }

    static void printWildCardV2(Box<? extends Animal> box) {
       Animal animal = box.get();
        System.out.println("animal = " + animal);
    }

    static <T extends Animal> T printAndReturnGeneric(Box<T> box) {
        T t = box.get();
        System.out.println("이름 = " + t.getName()); //출력
        return t; //반환
    }

    static Animal printAndReturnWildCard(Box<? extends Animal> box) {
        Animal animal = box.get();
        System.out.println("animal = " + animal);
        return animal;
    }
}
