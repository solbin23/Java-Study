package generic.test.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV0 {

    public static void main(String[] args) {

        DogHospital dogHospital = new DogHospital();
        CatHospital catHospital = new CatHospital();

        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("고양이1", 300);
        // 개 병원
        dogHospital.set(dog);
        dogHospital.checkup();
        // 고양이 병원
        catHospital.set(cat);
        catHospital.checkup();

        // 문제 1: 개 병원에 고양이 전달
        //dogHospital.set(cat); //다른 타입을 입력: 컴파일 오류

        // 문제 2: 개 타입 반환
        dogHospital.set(dog);
        Dog biggerDog = dogHospital.bigger(new Dog("멍멍2",200));
        System.out.println("biggerDob = " + biggerDog);

        //결론
        // 코드 재사용 X : CatHospital과 DogHospital의 중복코드
        // 타입 안전성 O : 타입 안전성이 명확하게 지켜짐
    }
}
