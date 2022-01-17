public class Synchronization013 {

    public static Integer counter1 = 0;
    public static Integer counter2 = 0;

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void increment1(){
        synchronized (lock1) {
            counter1++; 
        }
    }
    public static void increment2(){
        synchronized (lock2) {
            counter2++;
        }
    }

    public static void process() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    increment1();
                    System.out.println("@@@ T1");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    increment2();
                    System.out.println("### T2");
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter1 is: " + counter1);
        System.out.println("Counter2 is: " + counter2);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        process();
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;
        System.out.println(sec + " seconds");
    }
}
