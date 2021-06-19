package memory;

public class StackMemoryTest {
    public static int changeStayus(int value) {
        int tmp    = value * 10;
        int result = tmp / 2;
        return result;
    }

    public static void main(String[] args) {
        int value = 10;
        value = changeStayus(value);
        System.out.println(value);
    }
}
