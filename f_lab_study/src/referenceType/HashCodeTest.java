package referenceType;

public class HashCodeTest {

    public String desc;

    public HashCodeTest(String desc) {
        this.desc = desc;
    }

    public static void main(String[] args) {
        HashCodeTest test0 = new HashCodeTest("Constant Pool");
        HashCodeTest test1 = new HashCodeTest(new String("Heap Memory"));
        HashCodeTest test2 = test1;

        System.out.println("test0.hashCode() = " + test0.hashCode());
        System.out.println("test1.hashCode() = " + test1.hashCode());
        System.out.println("test2.hashCode() = " + test2.hashCode());
    }
}
