package Basic;

public class MainTestClass {
    private static String name = "심성헌";
    private static int    age  = 27;

    public static void testMethod(String userName, int userAge) {
        name = userName;
        age = userAge;
    }

    public static void main(String[] args) {
        MainTestClass.testMethod("심재희", 24);
        System.out.println(MainTestClass.name);
        System.out.println(MainTestClass.age);
    }
}
