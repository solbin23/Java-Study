package collection.set;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyHashSetV0 {

    private int[] elementData = new int[10];
    private int size = 0;

    //O(n)
    public boolean add(int value){

        if(contains(value)){ //중복된 값이 있는지 체크
            return false; //있으면 false
        }
        elementData[size] = value;
        size++;
        return true; //없으면 true
    }

    //데이터를 찾을 때는 배열에 있는 모든 데이터를 찾고 비교해야 하기에 평균 -> O(n)
    public boolean contains(int value) { //set에 중복 값 체크
        for(int data: elementData){
            if(data == value){
                return true; // 값이 있으면 true
            }
        }
        return false; // 없으면 false
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return "MyHashSetV0{" +
                "elementData=" + Arrays.toString(Arrays.copyOf(elementData,size)) +
                ", size=" + size +
                '}';
    }
}
