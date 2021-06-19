package Basic;

public class Calculator {
    public void printDivide(double d1, double d2) throws Exception {
        if (d2 == 0) {
            throw new Exception("Second value can't be Zero");
        }
        double result = d1 / d2;
        System.out.println(result);

    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.intTest();
//        try {
//            calculator.printDivide(1, 2);
//            calculator.printDivide(1, 0);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

    public void intTest() {
        int a = 1;
        int b = (int) new Integer(1);

        System.out.println(a == b);
    }
}
