package collection.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableMain {

    public static void main(String[] args) {
        //불변 리스트 생성
        List<Integer> list = List.of(1, 2, 3);

        //가변 리스트
        ArrayList<Integer> mutableList = new ArrayList<>(list);
        mutableList.add(4);
        System.out.println("mutableList: " + mutableList);
        System.out.println("mutable list class = " + mutableList.getClass());

        //불변 리스트
        List<Integer> unmodifiableList = Collections.unmodifiableList(mutableList);
        System.out.println("unmodifiableList class: " + unmodifiableList.getClass());

        //java.lang.UnsupportedOperationException 예외 발생
        //unmodifiableList.add(5);
    }
}
