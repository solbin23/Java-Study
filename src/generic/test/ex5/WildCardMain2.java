package generic.test.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildCardMain2 {
    public static void main(String[] args) {
        Box<Object> objectBox = new Box<>();
        Box<Animal> animalBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        // Animal 포함 상위 타입 전달 가능
        writeBox(objectBox);
        writeBox(animalBox);

//        writeBox(dogBox); //하한이 Animal
//        writeBox(catBox); //하한이 Animal

        Animal animal =animalBox.get();
        System.out.println("animal = " + animal);
    }

    static void writeBox(Box<? super Animal> box) { //하한을 Animal로 제한했기 때문에 Animal보다 상위만 들어갈 수 있다.
        box.set(new Dog("멍멍이", 100));
    }
}
