package collection.array;

import java.util.Arrays;

public class MyArrayListV1 {

    private static final int DEFAULT_CAPACITY = 5; //기본 수용량

    private Object[] elementData;
    private int size = 0;

    public MyArrayListV1() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV1(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    public int size(){
        return size;
    }

    public void add(Object e) {
        elementData[size] = e;
        size++;
    }

    public Object get(int index) {
        return elementData[index];
    }

    public Object set(int index, Object e) { //index의 값을 변경
        Object oldValue = get(index);
        elementData[index] = e;
        return oldValue;
    }

    public int indexOf(Object o) { //리스트 순차 탐색
        for (int i = 0; i < size; i++) {
            if(o.equals(elementData[i])){
                return i; //찾으면 i
            }
        }
        return -1; //없으면 -1
    }

    public String toString(){
//        [1,2,3,null,null] //size = 3
//        [1,2,3] //size = 3 길이만큼만 출력되는 toString 생성
        return Arrays.toString(Arrays.copyOf(elementData, size)) + "size=" + size + ", capacity =" + elementData.length;
    }
}
