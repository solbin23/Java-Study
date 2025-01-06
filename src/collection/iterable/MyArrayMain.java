package collection.iterable;

import java.util.Iterator;

public class MyArrayMain {

    public static void main(String[] args) {

        MyArray myArray = new MyArray(new int[]{1, 2, 3, 4});
        Iterator<Integer> iterator = myArray.iterator();
        System.out.println("iterator 사용");

        while(iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println("value = " + value);
        }

        //추가
        //for-each문으로 불리는 향상된 for문은 자료 구조를 순회하는 것이 목적
        //위의 while문과 같은 코드
        System.out.println("for-each 사용");
        for(int value : myArray){
            System.out.println("value = " + value);
        }
    }
}
