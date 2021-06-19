package collection;

import java.util.ArrayList;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        list.forEach(System.out::println);


        Object[] strArray = list.toArray();
        for (Object s : strArray) {
            System.out.println(s.toString());
        }
        String[] strArray2 = list.toArray(new String[10]);
        for (String s : strArray2) {
            System.out.println(s);
        }
    }
}
