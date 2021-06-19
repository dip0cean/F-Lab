package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add(100);
        list.add(200);
        list.add("300");

        String  index1 = (String) list.get(1);
        Integer index2 = (Integer) list.get(2);
        System.out.println("문자열 list[1] : " + index1);
        System.out.println("정수 list[2] : " + index2);
    }

    public void wildCardMethod(List<?> list) {
        for(Object l : list) {
            System.out.println(l.toString());
        }
    }
}
