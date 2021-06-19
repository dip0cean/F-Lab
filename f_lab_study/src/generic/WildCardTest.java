package generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WildCardTest {
    public static void main(String[] args) {

        WildCardTest test = new WildCardTest();

        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        test.wildCardTest(arr);

        List<String> linked = new LinkedList<String>();
        linked.add("a");
        linked.add("b");
        linked.add("c");
        test.wildCardTest(linked);
    }

    public void wildCardTest(List<?> list) {
        System.out.println("현재 클래스 : " + list.getClass());
        for (Object obj : list) {
            System.out.println(obj.getClass());
        }
    }
}
