package generic.test.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV3 {

    public static void main(String[] args) {

        AnimalHospitalV3<Dog> dogHospital = new AnimalHospitalV3<>();
        AnimalHospitalV3<Cat> catHospital = new AnimalHospitalV3<>();


        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("고양이1", 300);
        // 개 병원
        dogHospital.set(dog);
        dogHospital.checkup();
        // 고양이 병원
        catHospital.set(cat);
        catHospital.checkup();

        // 문제 1: 개 병원에 고양이 전달
        //dogHospital.set(cat); // 다른 타입을 입력 : 컴파일 오류

        // 문제 2: 개 타입 반환
        dogHospital.set(dog);
        Dog biggerDog =  dogHospital.bigger(new Dog("멍멍2",200));//다운 캐스팅을 하지 않아도 된다.
        System.out.println("biggerDob = " + biggerDog);


        /*기존 문제와 해결
            타입 안전성 문제
            개 병원에 고양이를 전달하는 문제가 발생 -> 해결
            Animal 타입을 반환하기 때문에 다운 캐스팅을 해야한다 -> 해결
            실수로 고양이를 입력했는데, 개를 반환하는 상황이라면 캐스팅 예외가 발생한다 -> 해결

            제네릭 도입 문제
            제네릭에서 타입 매개변수를 사용하면 어떤 타입이든 들어올 수 있다 -> 해결
            어떤 타입이든 수용할 수 있는 Object로 가정하고, Object의 기능만 사용할 수 있다 -> 해결
             => 여기서는 Animal을 상한으로 두어서 Animal의 기능을 사용할 수 있다.
        */


    }
}
