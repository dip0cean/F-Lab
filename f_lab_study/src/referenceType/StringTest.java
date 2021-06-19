package referenceType;

public class StringTest {

    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
//        stringTest.stringMemory();
        stringTest.stringInternMethod();
    }

    public void stringMemory() {
        String str0 = new String("abcd");
        String str1 = new String("abcd");
        String str2 = "abcd";
        String str3 = "abcd";

        System.out.println("str0.hashCode() = " + System.identityHashCode(str0));
        System.out.println("str1.hashCode() = " + System.identityHashCode(str1));
        System.out.println("str2.hashCode() = " + System.identityHashCode(str2));
        System.out.println("str3.hashCode() = " + System.identityHashCode(str3));
    }

    public void stringInternMethod() {
        String strA = new String("stringA");
        String strAa = new String("stringA");

        String strB = "stringA";
        String strBa = "stringA";
        String strBb = strB.intern();

        String strC = new String("stringB");
        String strCa = strC.intern();
        String strCb = strC.intern();

        System.out.println("strA = " + System.identityHashCode(strA));
        System.out.println("strAa = " + System.identityHashCode(strAa));

        System.out.println("strB = " + System.identityHashCode(strB));
        System.out.println("strBa = " + System.identityHashCode(strBa));
        System.out.println("strBb = " + System.identityHashCode(strBb));

        System.out.println("strC = " + System.identityHashCode(strC));
        System.out.println("strCa = " + System.identityHashCode(strCa));
        System.out.println("strCb = " + System.identityHashCode(strCb));
    }
}
