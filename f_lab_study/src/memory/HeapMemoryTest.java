package memory;

public class HeapMemoryTest {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(System.identityHashCode(str));
        str = str + "world";
        System.out.println(System.identityHashCode(str));
        Integer integer = 2021;
        System.out.println("str = " + str);
        System.out.println("integer = " + integer);

        changeStatus(str, integer);

        System.out.println("str = " + str);
        System.out.println("integer = " + integer);
    }

    public static void changeStatus(String strParam, Integer intParam) {
        String tmpStr = strParam + " world!";
        Integer tmpInt = intParam + intParam;
        System.out.println("tmpStr = " + tmpStr);
        System.out.println("tmpInt = " + tmpInt);
    }
}
