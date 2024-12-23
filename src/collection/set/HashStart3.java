package collection.set;

import java.util.Arrays;

public class HashStart3 {

    public static void main(String[] args) {

        //입력: {1,2,5,8,14,29}
        //[null, 1, 2, null, null, 5, null, null, 8, ...,14, ....,99] -> 데이터를 입력할 때 배열에 순서대로 입력하는 것이 아니라, 데이터의 값을 인덱스로 사용해서 저장
        Integer[] inputArray = new Integer[100];
        inputArray[1] = 1;
        inputArray[2] = 2;
        inputArray[5] = 5;
        inputArray[8] = 8;
        inputArray[14] = 14;
        inputArray[99] = 99;
        System.out.println("inputArray = " + Arrays.toString(inputArray));

        //데이터를 조회할 때 데이터의 값을 인덱스로 사용해서 조회
        int searchValue = 99;
        Integer result = inputArray[searchValue]; // O(1)
        System.out.println("result = " + result);

    }
}
