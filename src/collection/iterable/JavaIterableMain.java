package collection.iterable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JavaIterableMain {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        printAll(list.iterator());
        foreach(list);
       /* Iterator<Integer> listIter = list.iterator();
        while (listIter.hasNext()) {
            System.out.println(listIter.hasNext());
        }*/

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        printAll(set.iterator());
        foreach(set);
        /*Iterator<Integer> setIter = set.iterator();
        while (setIter.hasNext()) {
            System.out.println(setIter.hasNext());
        }*/
    }

    private static void foreach(Iterable<Integer> iterable){
        System.out.println("iterable = " + iterable.getClass());
        for(Integer i : iterable){
            System.out.println(i);
        }

    }
    private static void printAll(Iterator<Integer> iterator) {
        System.out.println("iterator = " + iterator.getClass());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
