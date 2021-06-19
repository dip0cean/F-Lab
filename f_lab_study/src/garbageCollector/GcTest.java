package garbageCollector;

public class GcTest {
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.gc();
        long end = System.nanoTime();

        System.out.println(start - end + "ns");
    }
}
