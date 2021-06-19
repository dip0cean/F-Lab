package inheritance;

import java.util.Arrays;
import java.util.List;

public class InheritanceTest {
    public static void main(String[] args) {
        // 강아지 생성
        Dog dog = new Dog();
        dog.move(); // 이동
//        dog.swim(); // 강아지는 swim() 메소드를 사용 할 수 없음
        dog.breeding(); // 번식
        dog.getElements();
        System.out.println();
        // 고래 생성
        Whale whale = new Whale();
        whale.move(); // 이동
        whale.swim(); // 헤엄
        whale.breeding(); // 번식
        whale.getElements();
        System.out.println();
        // 독수리 생성
        Eagle eagle = new Eagle();
        eagle.move(); // 이동
        eagle.fly(); // 비행
        eagle.breeding(); // 번식
        eagle.getElements();
        System.out.println();
        // 키위 생성
        Kiwi kiwi = new Kiwi();
        kiwi.move(); // 이동
        kiwi.fly(); // 비행
        kiwi.breeding(); // 번식
        kiwi.getElements();
        System.out.println();

        // Mammal 객체로 감썬 Whale 만들기
        Mammal mammal = new Whale();
//        mammal.swim(); protected로 선언된 swim() 메소드는 부모 객체로 Up Casting 해서 구현 했을 때, 사용 할 수 없음.
        List list = Arrays.asList("aa","bb","cc");
        List list2 = current(list);
        list2.forEach(l -> System.out.println(l));
    }

    public static List current(List list) {
        String a = "hello";
        list.add(a);
        return list;
    }
}
