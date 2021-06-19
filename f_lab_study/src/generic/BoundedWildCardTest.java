package generic;

import java.util.ArrayList;
import java.util.List;

public class BoundedWildCardTest {

    public static void main(String[] args) {
        List<Parent> parents = new ArrayList<>();
        parents.add(new Parent(1));
        parents.add(new Parent(2));
        parents.add(new Child(3));

        List<Child> children = new ArrayList<>();
        children.add(new Child(1));
        children.add(new Child(2));
        children.add(new Child(3));

        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");

        BoundedWildCardTest test = new BoundedWildCardTest();
        test.boundedTest(parents);
        test.boundedTest(children);

        test.genericMethod(parents, new Parent(4));
        test.genericMethod(children, new Child(4));
        test.genericMethod(stringList, "abc");
    }

    public void boundedTest(List<? extends Parent> list) {
        System.out.println(list.getClass());

        for (Parent obj : list) {
            System.out.println(obj.toString());
        }
    }

    public <T> void genericMethod(List<T> list, T type) {
        System.out.println("리스트 타입 : " + list.getClass());
        System.out.println("T : " + type.getClass());

        list.add(type);

        for (Object obj : list) {
            System.out.println(obj.toString());
        }
    }
}
