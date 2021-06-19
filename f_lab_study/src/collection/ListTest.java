package collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(20);
        list2.add(30);

        Integer[] intArray = list.toArray(new Integer[10]);
        System.out.println("inArray.length : " + intArray.length);
        for (Integer integer : intArray) {
            System.out.println(integer);
        }

        Object[] intArray2 = list2.toArray(intArray);
        System.out.println("inArray.length : " + intArray2.length);
        for (Object integer : intArray2) {
            System.out.println(integer);
        }
    }
}
