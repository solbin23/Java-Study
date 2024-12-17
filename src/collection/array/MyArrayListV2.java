package collection.array;

import java.util.Arrays;

public class MyArrayListV2 {

    private static final int DEFAULT_CAPACITY = 5; //기본 수용량

    private Object[] elementData;
    private int size = 0;

    public MyArrayListV2() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV2(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    public int size(){
        return size;
    }

    public void add(Object e) {

        //코드 추가
        if (size == elementData.length) { //size가 이미 length에 도달한 상황이라면
            grow();
        }
        elementData[size] = e;
        size++;
    }

    //코드 추가
    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2; //기존의 배열보다 2배 큰 새로운 배열
       //배열을 새로 만들고, 기존 배열을 새로운 배열에 복사
//        Object[] newArr = new Object[newCapacity];
//
//        for (int i = 0; i < elementData.length; i++) {
//            newArr[i] = elementData[i];
//        }

        elementData = Arrays.copyOf(elementData, newCapacity); //새로운 길이로 배열을 생성하고, 기존 배열의 값을 새로운 배열에 복사
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
