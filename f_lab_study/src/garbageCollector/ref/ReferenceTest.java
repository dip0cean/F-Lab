package garbageCollector.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ReferenceTest {
    public static void main(String[] args) {
        ReferenceTest test = new ReferenceTest();
        ReferenceTest.Test test2 = new ReferenceTest.Test();
        TestTest test3 = test.new TestTest();
        WeakReference<ReferenceTest> weak = new WeakReference<>(new ReferenceTest());
        ReferenceTest ref = weak.get();
        PhantomReference<ReferenceTest> phantom = new PhantomReference<>(new ReferenceTest(), new ReferenceQueue<>());
    }

    public static class Test {
        public static void test() {

        }
    }
    public class TestTest {

    }
}
