package thread;

public class ThreadLocalTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest test   = new ThreadLocalTest();
        ThreadLocals    locals = new ThreadLocals();
        for (int i = 0; i < 10; i++) {
            test.run(locals, i);
        }
    }

    public static class ThreadLocals implements Runnable {
        final static ThreadLocal<Integer> local = new ThreadLocal<>();

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                local.set(i);
                System.out.println(local.get());
            }
            try {
                Thread.sleep(2000);
            } catch (Exception e) {

            }
            System.out.println("------------------------------");
        }
    }

    public synchronized void run(ThreadLocals locals, int i) throws InterruptedException {
        Thread thread = new Thread(locals);
        System.out.println("Thread " + i + " Start!");
        thread.start();
        thread.join();
    }
}
