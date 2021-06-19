package referenceType;

public class StringHashCodeTest {
    public static void main(String[] args) {
        String test0 = "abc";
        String test1 = "abc";
        String test2 = "가나다";

        System.out.println("test0.hashCode() = " + test0.hashCode());
        System.out.println("test1.hashCode() = " + test1.hashCode());
        System.out.println("test2.hashCode() = " + test2.hashCode());

        String test3 = new String("def");
        String test4 = new String("def");

        System.out.println("test3.hashCode() = " + test3.hashCode());
        System.out.println("test4.hashCode() = " + test4.hashCode());
    }
}
