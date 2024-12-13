package generic.test.ex4;

import generic.animal.Animal;

public class ComplexBox<T extends Animal> {

    private T animal;

    public void set(T animal) {

        //클래스의 타입 매개변수 T이기 때문에 상한이 Animal이다.
        this.animal = animal;
        //animal.getName(); -> 호출 가능
    }

    public <Z> Z printAndReturn(Z z){
        //여기서 적용된 제네릭 메서드 타입 매개변수 T는 상한이 없다. 따라서 Object로 취급된다.
        //Object로 취급되기 때문에 t.getName()과 같은 Animal에 존재하는 메서드는 호출할 수 없다.
        System.out.println("animal.className:" + animal.getClass().getName());
        System.out.println("t.className: " +z.getClass().getName());
        return z;
    }

//    public <T> T printAndReturn(T t){
//        //여기서 적용된 제네릭 메서드 타입 매개변수 T는 상한이 없다. 따라서 Object로 취급된다.
//        //Object로 취급되기 때문에 t.getName()과 같은 Animal에 존재하는 메서드는 호출할 수 없다.
//        System.out.println("animal.className:" + animal.getClass().getName());
//        System.out.println("t.className: " +t.getClass().getName());
//        return t;
//    }
}
