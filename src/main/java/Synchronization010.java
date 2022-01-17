public class Synchronization010 {

    public static Integer counter = 0;

    //we have to make sure this method is executed only by a single thread at a given time
    public static synchronized void increment(){
        counter++;
    }

    public static void process() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    increment();
                    System.out.println("@@@ T1");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    increment();
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
        System.out.println("The counter is: " + counter);
    }

    public static void main(String[] args) {
        process();
    }

}
